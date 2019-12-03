package primitives.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import primitives.Coordinate;
import primitives.Point2D;

import static org.junit.jupiter.api.Assertions.*;

class Point2DTest {

    @Test
    void getX() {
        Point2D p=new Point2D(3.5,4.1);
        Assertions.assertEquals(new Coordinate(3.5),p.getX());
    }

    @Test
    void getY() {
        Point2D p=new Point2D(3.5,4.1);
        assertEquals(new Coordinate(4.1),p.getY());
    }

    @Test
    void setX() {
        Point2D p=new Point2D();
        p.setX(new Coordinate(4.1));
        assertEquals(new Coordinate(4.1),p.getX());
    }

    @Test
    void setY() {
        Point2D p=new Point2D();
        p.setY(new Coordinate(4.1));
        assertEquals(new Coordinate(4.1),p.getY());
    }

    @Test
    void equals() {
    }

    @Test
    void hashCode2() {
    }

    @Test
    void distance() {
    }

    @Test
    void toString2() {
    }
}