package primitives.test;

import org.junit.jupiter.api.Test;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    @Test
    void getHead() {
    }

    @Test
    void setHead() {
    }

    @Test
    void scale() {
        Vector v= new Vector(5, 3.4, 6.7);
        assertEquals(new Vector(15, 10.2, 20.1), v.scale(3));
    }

    @Test
    void dotProduct() {
        Vector v1= new Vector(5, 3.4, 6.7);
        Vector v2= new Vector(3, 6, 7);
        assertEquals(82.3, v2.dotProduct(v1));
    }

    @Test
    void crossProduct() {
        Vector v1= new Vector(5, 3.4, 6.7);
        Vector v2= new Vector(3, 6, 7);
        assertEquals(new Vector(16.4, 14.9, -19.8), v2.crossProduct(v1));
    }

    @Test
    void equals() {
    }

    @Test
    void add() {
        Vector v1= new Vector(2, 3, 4);
        Vector v2= new Vector(3.4, 5.3, 2.1);
        assertEquals(new Vector(5.4, 8.3, 6.1), v1.add(v2));
    }

    @Test
    void sub() {
        Vector v1= new Vector(2, 3.2, 4);
        Vector v2= new Vector(3.4, 5.3, 2.1);
        assertEquals(new Vector(1.4, 2.1, -1.9), v2.sub(v1));
    }

    @Test
    void normalize() {
        Vector v= new Vector(5, 5, 5);
        v.normalize();
        assertEquals(new Vector(0.5773, 0.5773, 0.5773), v);
    }

    @Test
    void length() {
        Vector v= new Vector(3.6, 5.4, 5.6);
        assertEquals(8.5720, v.length());
    }
}