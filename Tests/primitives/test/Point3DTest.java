package primitives.test;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

class Point3DTest {

    @Test
    void getZ() {
    }

    @Test
    void setZ() {
    }

    @Test
    void equals() {
    }

    @Test
    void substract() {
        Point3D p1=new Point3D(1.1,2.2,3.3);
        Point3D p2=new Point3D(0,1.1,2.2);
        assertEquals(new Vector(1.1,1.1,1.1),p1.substract(p2));
    }

    @Test
    void distance() {
    }

    @Test
    void addVector() {
        Point3D p1=new Point3D(1.1,2.2,3.3);
        Vector p2=new Vector(0,1.1,2.2);
        assertEquals(new Vector(1.1,3.3,5.5),p1.addVector(p2));
    }

    @Test
    void toString2() {
    }

    @Test
    void hashCode2() {
    }
}