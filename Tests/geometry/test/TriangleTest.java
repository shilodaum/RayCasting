package geometry.test;

import geometry.Triangle;
import org.junit.jupiter.api.Test;
import primitives.*;
import geometry.Plane;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void getP1() {
    }

    @Test
    void setP1() {
    }

    @Test
    void getP2() {
    }

    @Test
    void setP2() {
    }

    @Test
    void getP3() {
    }

    @Test
    void setP3() {
    }

    @Test
    void equals() {
    }
    @Test
    public void testTriangleNormal() {
        Vector answer = new Vector(0,0, -1);
        Point3D directionPoint = new Point3D(0, 0, -1);
        Point3D planePoint = new Point3D(0, 100, -200);
        Point3D normalPoint = new Point3D(1, 1, -200);

        Vector direction = new Vector(directionPoint);

        Plane plane = new Plane(planePoint, direction);

        Vector vector = plane.getNormal(normalPoint);
        assertEquals(answer, vector);

    }
    @Test
    public void testTriangleIntersections() {//we haven't checked enough thingies

        // creating the expected values

        List<Point3D> answerList = new ArrayList<Point3D>();
        Point3D answerPoint = new Point3D(0, 0, -200);
        answerList.add(answerPoint);

        // building the triangle

        Point3D p1 = new Point3D(0, 100, -200);
        Point3D p2 = new Point3D(100, -100, -200);
        Point3D p3 = new Point3D(-100, -100, -200);

        Triangle t1 = new Triangle(p1, p2, p3);
        Triangle t2 = new Triangle(t1);

        // building the ray that will intersect the triangle

        Point3D centerPoint = new Point3D(0,0,0);
        Vector vector = new Vector(0, 0, -5);
        Ray ray = new Ray(centerPoint, vector);

        // testing the findIntersection function

        List<Point3D> list = new ArrayList<Point3D>();
        list = t2.findIntersections(ray);
        assertEquals(answerList, list);
    }

}