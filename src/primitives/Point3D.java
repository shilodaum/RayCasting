package primitives;

import java.util.Objects;

import static java.lang.Math.sqrt;

/**
 * 3 dimentional point
 */
public class Point3D extends Point2D{
    /**
     * add the third coordinate
     */
    private Coordinate z;

    /**
     * ctor with parameters
     * @param x x value
     * @param y y value
     * @param z z value
     */
    public Point3D(double x, double y, double z) {
        setX(new Coordinate(x));
        setY(new Coordinate(y));
        setZ(new Coordinate(z));
    }
    /**
     * default ctor
     */
    public Point3D() {
        this.setZ(Coordinate.ZERO);
    }

    /**
     * cpy ctor
     * @param other other point
     */
    public Point3D(Point3D other) {
        super();
        this.setX(other.getX());
        this.setY(other.getY());
        this.setZ(other.getZ());
    }

    /**
     * ctor with 3 coordinates
     * @param x x coordinate
     * @param y y coordinate
     * @param z z coordinate
     */
    public Point3D(Coordinate x, Coordinate y, Coordinate z) {
        super(x, y);
        this.setZ(z);
    }

    /*********getters/setters*********/
    public Coordinate getZ() {
        return new Coordinate(z.get());
    }
    public void setZ(Coordinate z) {
        this.z = new Coordinate(z.get());
    }

    /**
     * compare to other object
     * @param o other object
     * @return true if equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Point3D)) return false;
        if (!super.equals(o)) return false;
        Point3D point3D = (Point3D) o;
        return getZ().equals(point3D.getZ());
    }

    /**
     * subtract two point
     * @param pt other oint
     * @return a new vecor for 2 points
     */
    public  Vector substract(Point3D pt)
    {
        return new Vector(pt,this);
    }

    /**
     * get a distance for two points
     * @param other other point
     * @return the distance
     */
    public double distance(Point3D other) {
        return sqrt(this.distanceSquare(other));
    }

    /**
     * squared distance
     * @param other other point
     * @return squared distance
     */
     public double distanceSquare(Point3D other) {
        double x1=Util.usubtract(other.getX().get(),getX().get());
        double xx= Util.uscale(x1,x1);
        double y1=Util.usubtract(other.getY().get(),getY().get());
        double yy= Util.uscale(y1,y1);
        double z1=Util.usubtract(other.getZ().get(),getZ().get());
        double zz= Util.uscale(z1,z1);
        return Util.uadd(zz,Util.uadd(xx,yy));
    }

    /**
     * add vector to point to append
     * @param v vector to append
     * @return new point with added value
     */
    public Point3D addVector(Vector v) {
        Point3D p_vec = v.getHead();

        Point3D result = new Point3D(
                this.getX().add(p_vec.getX()),
                this.getY().add(p_vec.getY()),
                this.getZ().add(p_vec.getZ()));
        return  result;
    }

    /**
     * convert to string
     * @return string of values
     */
    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + super.getX() +
                ", y=" + super.getY() +
                ", z=" + getZ() +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getZ());
    }




}
