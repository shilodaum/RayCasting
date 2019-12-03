package geometry.test;

import org.junit.jupiter.api.Test;
import primitives.*;
import geometry.Plane;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {

    @Test
    void equals() {
    }

    @Test
    void getNormal() {
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
    void getP() {
    }

    @Test
    void setP() {
    }

    @Test
    void setN() {
    }

    @Test
    public void testPlaneIntersections() {

        // creating the expected values

        List<Point3D> answerList = new ArrayList<Point3D>();
//        Point3D answerPoint = new Point3D(0, 0, -200);
//        answerList.add(answerPoint);

        // building the plane

        Point3D directionPoint = new Point3D(0, 0, -1);
        Point3D planePoint = new Point3D(0, 100, -200);


        Vector direction = new Vector(directionPoint);

        Plane plane = new Plane(planePoint, direction);

        // building the ray that will intersect the plane

        Point3D centerPoint = new Point3D(0,0,0);
        Vector vector = new Vector(1, 0, 0);
        Ray ray = new Ray(centerPoint, vector);

        // testing the findIntersection function

        List<Point3D> list = new ArrayList<Point3D>();
        list = plane.findIntersections(ray);
        assertEquals(answerList, list);
    }
}