package Scene;

import elements.AmbientLight;
import elements.Camera;
import elements.Light;
import geometry.Geometry;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//check aliasing
public class Scene {
    String sceneName;
    Color bg;//background color
    AmbientLight al;
    ArrayList<Geometry> gl;// geometry list
    Camera camera;
    double dis;//screen distance
    List<Light> lightSources;


    public Scene(String sceneName, Color bg, AmbientLight al, ArrayList<Geometry> gl, Camera camera, double dis,List<Light> _lightSources) {
        this.sceneName = sceneName;
        this.bg = bg;
        this.al = al;
        this.gl = gl;
        this.camera = camera;
        this.dis = dis;
        this.lightSources=_lightSources;
    }

    public Scene(Scene s) {
        this.sceneName = s.sceneName;
        this.bg =s.bg;
        this.al = new AmbientLight(al);
        this.gl = new ArrayList<Geometry>(s.gl);
        this.camera =new Camera(s.camera);
        this.dis = s.dis;
        this.lightSources=new ArrayList<Light>(s.lightSources);
    }

    public Scene() {
        this.sceneName = "scene";
        this.bg = new Color(0,0,0);
        this.gl = new ArrayList<Geometry>();
        this.camera =new Camera();
        this.dis = 150.0;
        this.al=new AmbientLight();
        this.lightSources=new ArrayList<Light>( );
    }

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    public Color getBg() {
        return bg;
    }

    public void setBg(Color bg) {
        this.bg = bg;
    }

    public ArrayList<Geometry> getGl() {
        return gl;
    }

    public void setGl(ArrayList<Geometry> gl) {
        this.gl = gl;
    }

    public Camera getCamera() {
        return new Camera(camera);
    }

    public void setCamera(Camera camera) {
        this.camera =new Camera(camera);
    }

    public double getDis() {
        return dis;
    }

    public void setDis(double dis) {
        this.dis = dis;
    }

    public void addGeometry(Geometry g){
        gl.add(g);
    }

    public AmbientLight getAl() {
        return new AmbientLight(al);
    }

    public void setAl(AmbientLight al) {
        this.al = new AmbientLight(al);
    }

    public Iterator<Geometry> getGeometriesIterator()
    {
        return gl.iterator();

    }
    public void addLight(Light _l){
        lightSources.add(_l);
    }
    public Iterator<Light> GetLightItarator(){
        return lightSources.iterator();
    }

    public void setScreenDistance(int i) {
        setDis(i);
    }
}