package primitives;

import java.util.Objects;

import static java.lang.StrictMath.sqrt;

/**
 * vector class
 */
public class Vector {
    /**
     * the vector head point
     */
    private Point3D head;

    /**
     * ctor with parameter
     * @param head the point value
     */
    public Vector(Point3D head) {
        this.setHead(head);
    }

    /**
     * cto for 2 points
     * @param pt1 first point
     * @param pt2 second point
     */
    public Vector(Point3D pt1, Point3D pt2) {

         setHead(new Point3D(
                pt2.getX().subtract(pt1.getX()),
                pt2.getY().subtract(pt1.getY()),
                pt2.getZ().subtract(pt1.getZ())));
    }

    /**
     * cpy ctor
     * @param direction other vector
     */
    public Vector(Vector direction) {
        setHead(direction.getHead());
    }

    /**
     * ctor with coordinats values
     * @param x x value
     * @param y y value
     * @param z z value
     */
    public Vector(double x, double y, double z) {
        setHead(new Point3D(x,y,z));
    }

    /**
     * default ctor
     */
    public Vector() {
        this.setHead(new Point3D());
    }

    /**********getters/setters**********/
    public Point3D getHead() {
        return new Point3D(head);
    }
    public void setHead(Point3D head) {
        this.head = new Point3D(head);
    }


    /**
     * scale a vector
     * @param scalingFactor the scaling factor
     * @return a new scaled vector
     */
    public Vector scale(double scalingFactor){
        Vector ans=new Vector(this);
        ans.head.setX(new Coordinate(
                ans.head.getX().scale(scalingFactor)));

        ans.head.setY(new Coordinate(
                ans.head.getY().scale(scalingFactor)));

        ans.head.setZ(new Coordinate(
                ans.head.getZ().scale(scalingFactor)));

        return ans;
    }

    /**
     * dot product of two vectors
     * @param vector other vector
     * @return the value of the dot product
     */
    public double dotProduct (Vector vector) {

        double x1 = this.getHead().getX().get();
        double y1 = this.getHead().getY().get();
        double z1 = this.getHead().getZ().get();

        double x2 = vector.getHead().getX().get();
        double y2 = vector.getHead().getY().get();
        double z2 = vector.getHead().getZ().get();

        return Util.uadd(Util.uscale(x1,x2),Util.uadd(Util.uscale(y1,y2),Util.uscale(z1,z2)));
    }

    /**
     * cross product of two vectors
     * @param vector other vector
     * @return new vector
     */
    public Vector crossProduct (Vector vector) {

        double x1 = this.getHead().getX().get();
        double y1 = this.getHead().getY().get();
        double z1 = this.getHead().getZ().get();

        double x2 = vector.getHead().getX().get();
        double y2 = vector.getHead().getY().get();
        double z2 = vector.getHead().getZ().get();

        return new Vector(new Point3D(
                new Coordinate(Util.usubtract(Util.uscale(y1, z2), Util.uscale(z1, y2))),
                new Coordinate(Util.usubtract(Util.uscale(z1, x2), Util.uscale(x1, z2))),
                new Coordinate(Util.usubtract(Util.uscale(x1, y2), Util.uscale(y1, x2)))));
    }

    /**
     * compare to other object
     * @param o other object
     * @return true if equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector)) return false;
        Vector vector = (Vector) o;
        return getHead().equals(vector.getHead());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHead());
    }

    /**
     * add two vectors
     * @param vector other vector
     * @return new added vector
     */
    public Vector add(Vector vector){
        double x1 = this.getHead().getX().get();
        double y1 = this.getHead().getY().get();
        double z1 = this.getHead().getZ().get();

        double x2 = vector.getHead().getX().get();
        double y2 = vector.getHead().getY().get();
        double z2 = vector.getHead().getZ().get();

        return new Vector(Util.uadd(x1,x2),Util.uadd(y1,y2),Util.uadd(z1,z2));
    }

    /**
     * subtract two vectors
     * @param vector other vector
     * @return new subtracted vector
     */
    public Vector sub(Vector vector){
        Vector vector2 = new Vector(vector);
        return(this.add(vector2.scale(-1)));
    }

    /**
     * convert to string
     * @return string of values
     */
    @Override
    public String toString() {
        return "Vector{" +
                "head=" + getHead().toString() +
                '}';
    }

    /**
     * normalize original vector
     */
    public void normalize() {double x = this.getHead().getX().get();
        double y = this.getHead().getY().get();
        double z = this.getHead().getZ().get();

        double length = this.length();

        if (length == 0)
            throw new ArithmeticException();

        this.setHead(new Point3D(
                new Coordinate(x/length),
                new Coordinate(y/length),
                new Coordinate(z/length)));
    }

    /**
     * get vector length
     * @return vector length
     */
    public double length() {
        double x = this.getHead().getX().get();
        double y = this.getHead().getY().get();
        double z = this.getHead().getZ().get();

        return sqrt(
                Util.uadd(
                    Util.uadd(
                        Util.uscale(x,x),
                        Util.uscale(y,y)),
                    Util.uscale(z,z)));

    }
}
