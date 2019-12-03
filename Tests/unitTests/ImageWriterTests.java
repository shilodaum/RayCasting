package unitTests;

import Renderer.ImageWriter;
import Renderer.Render;
import Scene.Scene;
import elements.DirectionalLight;
import elements.PointLight;
import elements.SpotLight;
import geometry.FlatGeometry;
import geometry.Geometry;
import geometry.Sphere;
import geometry.Triangle;
import org.junit.jupiter.api.Test;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;

import java.awt.Color;

public class ImageWriterTests {

    @Test
    public void basicRendering2() {
        Scene scene = new Scene();
        ImageWriter imageWriter = new ImageWriter("Grid", 500, 500, 500, 500);
        Render R = new Render(scene, imageWriter);

        scene.addGeometry(new Sphere(Color.blue, 50, new Point3D(0.0, 0.0, -150)));
        Triangle triangle = new Triangle(Color.red,new Point3D( 100, 0, -149),
                new Point3D(  0, 100, -149),
                new Point3D( 100, 100, -149));
        scene.addGeometry(triangle);


        R.renderImage();
        R.printGrid(50);
        imageWriter.writeToimage();
    }

    @Test
    public void basicRendering(){

        Scene scene = new Scene();

//        scene.addGeometry(new Sphere(Color.blue, 50, new Point3D(0.0, 0.0, -150)));
//
//        Triangle triangle = new Triangle(Color.red,new Point3D( 100, 0, -149),
//                new Point3D(  0, 100, -149),
//                new Point3D( 100, 100, -149));
//
//        Triangle triangle2 = new Triangle(Color.green,new Point3D( 100, 0, -149),
//                new Point3D(  0, -100, -149),
//                new Point3D( 100,-100, -149));
//
        Triangle triangle3 = new Triangle(Color.white,new Point3D(-100, 0, -149),
                new Point3D(  0,  -100, -149),
                new Point3D(-100, -100, -149));

        Triangle triangle4 = new Triangle(Color.white,new Point3D(-100, 0, -149),
                new Point3D(  0,  -100, -149),
                new Point3D(0, 0, -149));

//        scene.addGeometry(triangle);
//        scene.addGeometry(triangle2);
          scene.addGeometry(triangle3);
          scene.addGeometry(triangle4);

//        scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(-200, -200, -100),//-200, -200, -100),
//                0, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Render test", 500, 500, 500, 500);

        Render Render = new Render(scene, imageWriter);

        Render.renderImage();
        Render.printGrid(50);
        imageWriter.writeToimage();


    }
    @Test
    public void ourTest() {

        Scene scene = new Scene();


        Triangle triangle1 = new Triangle(Color.blue, new Point3D(80, 100, -148),
                new Point3D(100, 80, -148),
                new Point3D(-80, -100, -148));

        Triangle triangle2 = new Triangle(Color.blue, new Point3D(80, 100, -148),
                new Point3D(-100, -80, -148),
                new Point3D(-80, -100, -148));

        scene.addGeometry(new Sphere(Color.blue, 15, new Point3D(80, 100, -150)));
        scene.addGeometry(new Sphere(Color.blue, 15, new Point3D(100, 80, -150)));
        scene.addGeometry(new Sphere(Color.blue, 15, new Point3D(-80, -100, -150)));
        scene.addGeometry(new Sphere(Color.blue, 15, new Point3D(-100, -80, -150)));


        Triangle triangle3 = new Triangle(Color.red, new Point3D(-80, 100, -147),
                new Point3D(-100, 80, -147),
                new Point3D(100, -80, -147));

        Triangle triangle4 = new Triangle(Color.red, new Point3D(-100, 80, -147),
                new Point3D(80, -100, -147),
                new Point3D(100, -80, -147));

        scene.addGeometry(new Sphere(Color.red, 15, new Point3D(-80, 100, -150)));
        scene.addGeometry(new Sphere(Color.red, 15, new Point3D(-100, 80, -150)));
        scene.addGeometry(new Sphere(Color.red, 15, new Point3D(80, -100, -150)));
        scene.addGeometry(new Sphere(Color.red, 15, new Point3D(100, -80, -150)));

        Triangle triangle5 = new Triangle(Color.yellow, new Point3D(-50, 0, -149),
                new Point3D(-50, -100, -149),
                new Point3D(50, -100, -149));

        Triangle triangle6 = new Triangle(Color.yellow, new Point3D(50, 0, -149),
                new Point3D(-50, 0, -149),
                new Point3D(50, -100, -149));
        scene.addGeometry(new Sphere(Color.yellow, 80, new Point3D(0, 30, -150)));


        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);
        scene.addGeometry(triangle5);
        scene.addGeometry(triangle6);


        ImageWriter imageWriter = new ImageWriter("Our test", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        render.printGrid(50);
        imageWriter.writeToimage();


    }


    @Test
    public void testAddingLightSources() {

        PointLight pl = new PointLight(new PointLight(new Color(255, 100, 100), new Point3D(-200, -200, -100),
                0, 0.000001, 0.0000005));
        SpotLight sl = new SpotLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -100),
                0.0, 0.00001, 0.000005, new Vector()));
        DirectionalLight dl = new DirectionalLight(new Color(255, 100, 100), new Vector());

    }


    @Test
    public void pointLightTest1() {

        Scene scene = new Scene();
        scene.setDis(100);
        Sphere sphere = new Sphere(new Color(0, 0, 100), 800, new Point3D(0, 0, -1000));
        Material m = new Material();
        m.setnShininess(20);
        sphere.set_material(m);
        scene.addGeometry(sphere);
        scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(-200, -200, -100),//-200, -200, -100),
                0, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Point Test1", 500, 500, 500, 500);

        Render r = new Render(scene, imageWriter);

        r.renderImage();
        r.printGrid(50);
        imageWriter.writeToimage();

    }

    @Test
    public void pointLightTest2() {
        Scene scene = new Scene();
        scene.setDis(100);
        Sphere sphere = new Sphere(new Color(0, 0, 100), 800, new Point3D(0, 0, -1000));
        Material m = new Material();
        m.setnShininess(20);
        sphere.set_material(m);


        Triangle triangle = new Triangle(new Color(0, 0, 0), new Point3D(3500, 3500, -2000),
                new Point3D(-3500, -3500, -1000), new Point3D(3500, -3500, -2000));
        Triangle triangle2 = new Triangle(new Color(0, 0, 0), new Point3D(3500, 3500, -2000),
                new Point3D(-3500, 3500, -1000), new Point3D(-3500, -3500, -1000));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(-200, 200, -100),
                0, 0.000001, 0.0000005));


        ImageWriter imageWriter = new ImageWriter("Point Test2", 500, 500, 500, 500);
        Render Render = new Render(scene, imageWriter);

        Render.renderImage();
        Render.printGrid(50);
        imageWriter.writeToimage();
    }

    @Test
    public void spotLightTest1(){

        Scene scene = new Scene();
        scene.setScreenDistance(100);
        Sphere sphere = new Sphere (new Color(0,0,100),800, new Point3D(0,0, -1000));


        Material m=new Material();
        m.setNShininess(20);
        sphere.setMaterial(m);
        scene.addGeometry(sphere);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -100),
                0, 0.00001, 0.000005,   new Vector(2, 2, -3)));

        ImageWriter imageWriter = new ImageWriter("Spot Test1", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        render.printGrid(50);
        imageWriter.writeToimage();
    }

    @Test
    public void spotLightTest2(){

        Scene scene = new Scene();
        scene.setScreenDistance(200);

        Sphere sphere = new Sphere (new Color(0,0,100),500, new Point3D(0,0,-1000));

        Material m=new Material();
        m.setNShininess(20);
        sphere.setMaterial(m);
        scene.addGeometry(sphere);

        Triangle triangle = new Triangle(new Color (0, 0, 100),
                new Point3D(-100, -200, -260),
                new Point3D(-200, -100, -260),
                new Point3D(-100, -100, -270)
        );

        Material m1=new Material();
        m1.setNShininess(4);
        triangle.setMaterial(m);
        scene.addGeometry(triangle);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),
                0.1, 0.00001, 0.000005,   new Vector(2, 2, -3)));

        ImageWriter imageWriter = new ImageWriter("Spot Test2", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        render.printGrid(50);
        imageWriter.writeToimage();
    }

    @Test
    public void spotLightTest3(){


        Scene scene = new Scene();
        scene.setScreenDistance(100);

        Triangle triangle = new Triangle(new Color(0,0,0),
                new Point3D(  3500,  3500, -2000),
                new Point3D( -3500, -3500, -1000),
                new Point3D(  3500, -3500, -2000)
        );



        Triangle triangle2 = new Triangle(new Color(0,0,0),
                new Point3D(  3500,  3500, -2000),
                new Point3D( -3500,  3500, -1000),
                new Point3D( -3500, -3500, -1000)
        );

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                0, 0.000001, 0.0000005, new Vector(-2, -2, -3)));


        ImageWriter imageWriter = new ImageWriter("Spot Test3", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        //	render.printGrid(50);
        imageWriter.writeToimage();

    }


    @Test
    public void testShadow(){

        Scene scene = new Scene();
        scene.setScreenDistance(200);

        Sphere sphere = new Sphere (new Color(0,0,100),500, new Point3D(0,0,-1000));

        Material m=new Material();
        m.setNShininess(20);
        sphere.setMaterial(m);
        scene.addGeometry(sphere);

        Triangle triangle = new Triangle(new Color (0, 0, 100),
                new Point3D(-125, -225, -260),
                new Point3D(-225, -125, -260),
                new Point3D(-225, -225, -270)
        );

        Material m1=new Material();
        m1.setNShininess(4);
        triangle.setMaterial(m);
        scene.addGeometry(triangle);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),
                0.1, 0.00001, 0.000005,   new Vector(2, 2, -3)));


        ImageWriter imageWriter = new ImageWriter("Shadow Test", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        render.printGrid(50);
        imageWriter.writeToimage();
    }

}
