package geometry.test;

import geometry.Sphere;
import org.junit.jupiter.api.Test;
import primitives.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.*;

class SphereTest {

    @Test
    void equals() {
    }

    @Test
    void getNormal() {
        Vector answer = new Vector(0.7071067811865475, 0.7071067811865475, 0.0);

        Point3D p1 = new Point3D(0, 0, -400);
        Point3D p2 = new Point3D(1,1, -400);

        Sphere sphere = new Sphere(200, p1);

        Vector vector = sphere.getNormal(p2);
        assertTrue(answer.equals(vector));
    }

    @Test
    void getCenter() {
    }

    @Test
    void setCenter() {
    }

    @Test
    public void testSphereIntersections() {


        // creating the expected values
        List<Point3D> answerList1 = new ArrayList<Point3D>();
        List<Point3D> answerList2 = new ArrayList<Point3D>();

        Point3D answerPoint1 = new Point3D(200/sqrt(2), 200/sqrt(2), 0);
        Point3D answerPoint2 = new Point3D(0, 0, 200);

        answerList1.add(answerPoint1);
        answerList2.add(answerPoint2);


        // building the spheres

        Point3D p1 = new Point3D(0, 0, 0);
        Point3D p2 = new Point3D(p1);
        Point3D centerPoint = new Point3D(0,0,0);

        Vector direction1 = new Vector(1, 1, 0);
        Vector direction2 = new Vector(0, 0, 1);
        Sphere sphere1 = new Sphere(200, p1);
        Sphere sphere2 = new Sphere( 200, p2);

        // building the ray that will intersect the spheres

        Ray ray1 = new Ray(centerPoint, direction1);
        Ray ray2 = new Ray(centerPoint, direction2);

        // testing the findIntersection functions
        List<Point3D> list1 = new ArrayList<Point3D>();
        list1 = sphere1.findIntersections(ray1);
        assertEquals(answerList1, list1);

        List<Point3D> list2 = new ArrayList<Point3D>();
        list2 = sphere2.findIntersections(ray2);
        assertEquals(answerList2, list2);
    }
}