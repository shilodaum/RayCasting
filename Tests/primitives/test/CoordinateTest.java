package primitives.test;

import org.junit.jupiter.api.Test;
import primitives.Coordinate;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    @Test
    void get() {
        Coordinate c = new Coordinate(5);
        assertEquals(5.0,c.get());
    }

    @Test
    void set_coord() {
        Coordinate c= new Coordinate();
        c.set_coord(5.6);
        assertEquals(5.6,c.get());
    }

    @Test
    void equals() {
    }

    @Test
    void toString2() {
    }

    @Test
    void subtract() {
        Coordinate c1= new Coordinate(4.3);
        Coordinate c2= new Coordinate(7.8);
        Coordinate c3= c1.subtract(c2);
        assertEquals(-3.5,c3.get());
    }

    @Test
    void add() {
        Coordinate c1= new Coordinate(4.3);
        Coordinate c2= new Coordinate(7.8);
        Coordinate c3= c1.add(c2);
        assertEquals(12.1,c3.get());
    }

    @Test
    void scale() {
        Coordinate c1= new Coordinate(7.8);
        Coordinate c2= c1.scale(5);
        assertEquals(39,c2.get());
    }

    @Test
    void multiply() {
        Coordinate c1= new Coordinate(4.3);
        Coordinate c2= new Coordinate(7.8);
        Coordinate c3= c1.multiply(c2);
        assertEquals(4.3*7.8,c3.get());
    }
}