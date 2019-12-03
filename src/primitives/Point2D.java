package primitives;

import java.util.Objects;

import static java.lang.StrictMath.sqrt;

public class Point2D {
    protected Coordinate x;
    protected Coordinate y;

    //ctors
    public Point2D() {
        setX(Coordinate.ZERO);
        setY(Coordinate.ZERO);
    }
    public Point2D(Coordinate x, Coordinate y) {
        this.setX(x);
        this.setY(y);
    }
    public Point2D(double x, double y){
        this.setX(new Coordinate(x));
        this.setY(new Coordinate(y));}
    public Point2D(Point2D other) {
        this.setX(other.getX());
        this.setY(other.getY());
    }

    //get
    public Coordinate getX() {
        return new Coordinate(x.get());
    }
    public Coordinate getY() {
        return new Coordinate(y.get());
    }
    //set
    public void setX(Coordinate x) {
        this.x = new Coordinate(x.get());
    }
    public void setY(Coordinate y) {
        this.y = new Coordinate(y.get());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o== null) return false;
        if (!(o instanceof Point2D)) return false;
        Point2D point2D = (Point2D) o;
        return getX().equals(point2D.getX()) &&
                getY().equals(point2D.getY());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    public double distance(Point2D other)
    {
        double xx = Util.uscale(
                Util.usubtract(other.getX().get(), getX().get()),
                Util.usubtract(other.getX().get(), getX().get()));
        double yy = Util.uscale(
                Util.usubtract(other.getY().get(), getY().get()),
                Util.usubtract(other.getY().get(), getY().get()));

        return  sqrt(xx+yy);
    }

    @Override
    public String toString() {
        //return "(" + _x.getX() + " , " + _y.getY() + ")" ;
        return "Point2D{" +
                "x=" + getX() +
                ", y=" + getY() +
                '}';
    }



}
