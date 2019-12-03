package geometry;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * represents an infinite plane
 */
public class Plane  extends FlatGeometry{
    /**
     * a random point on plane
     * a normal vector to plane
     */
    protected Point3D p;
    protected Vector N;

    /**
     * ctor with 3 point on plane
     * @param p1 1st point
     * @param p2 2nd point
     * @param p3 3rd point
     */
    public Plane(Point3D p1, Point3D p2, Point3D p3) {
        Vector U = new Vector (p1, p2);
        Vector V = new Vector (p1, p3);
        Vector n = new Vector (U.crossProduct(V));
        n.normalize();
        setP(p1);
        setN(n);
    }

    /**
     * ctor with parameters
     * @param clr the color
     * @param nMaterial the new material
     * @param p1 1st point
     * @param p2 2nd point
     * @param p3 3rd point
     */
    public Plane(Color clr,Material nMaterial ,Point3D p1, Point3D p2, Point3D p3) {
        super(clr,nMaterial);
        Vector U = new Vector (p1, p2);
        Vector V = new Vector (p1, p3);
        Vector n = new Vector (U.crossProduct(V));
        n.normalize();
        setP(p1);
        setN(n);
    }

    /**
     * ctor without material
     * @param clr color
     * @param p1 1st point
     * @param p2 2nd point
     * @param p3 3rd point
     */
    public Plane(Color clr ,Point3D p1, Point3D p2, Point3D p3) {
        super(clr);
        Vector U = new Vector (p1, p2);
        Vector V = new Vector (p1, p3);
        Vector n = new Vector (U.crossProduct(V));
        n.normalize();
        setP(p1);
        setN(n);
    }

    /**
     * compare to other object
     * @param o other object
     * @return true if equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;
        if(o == null)return false;
        Plane plane = (Plane) o;
        return getP().equals(plane.getP()) &&
                getNormal(null).equals(plane.getNormal(null));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getP(), getNormal(null));
    }

    /**
     * ctor with point and vector
     * @param p1 point
     * @param n vector
     */
    public Plane(Point3D p1, Vector n) {
        this.setP(p1);
        this.setN(n);
    }

    /**
     * ctor with parameters
     * @param emission the emission color
     * @param _material the new material
     * @param p the point
     * @param n the vector
     */
    public Plane(Color emission, Material _material, Point3D p, Vector n) {
        super(emission, _material);
        this.p = p;
        N = n;
    }

    /**
     * get normal vector
     * @param point the point
     * @return the normal vector for point on plane
     */
    @Override
    public Vector getNormal(Point3D point) {
        return new Vector(N);
    }

    /**
     * find all intersection of ray with a plane
     * @param r the ray
     * @return the intersection point with a ray
     */
    @Override
    public ArrayList<Point3D> findIntersections(Ray r) {
        Vector dir=new Vector(r.getDirection());
        if(dir.dotProduct(N)==0)
            return new ArrayList<Point3D>();

        double t=(N.dotProduct(new Vector(r.getPOO(),p)));//was -
        t=t/(N.dotProduct(dir));
        Point3D flag= new Point3D(r.getPOO().addVector(dir.scale(t)));
        ArrayList<Point3D> arr=new ArrayList<Point3D>();
        arr.add(flag);
        return arr;
    }

    /**
     * get point
     * @return a copied point
     */
    public Point3D getP() {
        return new Point3D(p);
    }

    /**
     * set new point
     * @param p new point
     */
    public void setP(Point3D p) {
        this.p = new Point3D(p);
    }

    /**
     * set normal vector
     * @param n new normal vector
     */
    public void setN(Vector n) {
        N =  new Vector(n);
    }
}
