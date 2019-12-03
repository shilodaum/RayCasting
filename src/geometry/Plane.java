package geometry;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Plane  extends FlatGeometry{
    protected Point3D p;
    protected Vector N;

    public Plane(Point3D p1, Point3D p2, Point3D p3) {
        Vector U = new Vector (p1, p2);
        Vector V = new Vector (p1, p3);
        Vector n = new Vector (U.crossProduct(V));

        n.normalize();
        //n.scale(-1);

        setP(p1);
        setN(n);
    }

    public Plane(Color clr,Material nMaterial ,Point3D p1, Point3D p2, Point3D p3) {
        super(clr,nMaterial);
        Vector U = new Vector (p1, p2);
        Vector V = new Vector (p1, p3);
        Vector n = new Vector (U.crossProduct(V));

        n.normalize();
        //n.scale(-1);

        setP(p1);
        setN(n);
    }
    public Plane(Color clr ,Point3D p1, Point3D p2, Point3D p3) {
        super(clr);
        Vector U = new Vector (p1, p2);
        Vector V = new Vector (p1, p3);
        Vector n = new Vector (U.crossProduct(V));

        n.normalize();
        //n.scale(-1);

        setP(p1);
        setN(n);
    }

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

    public Plane(Point3D p1, Vector n) {
        this.setP(p1);
        this.setN(n);
    }

    public Plane(Color emission, Material _material, Point3D p, Vector n) {
        super(emission, _material);
        this.p = p;
        N = n;
    }

    @Override
    public Vector getNormal(Point3D point) {
        return new Vector(N);
    }//maybe -N

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

    public Point3D getP() {
        return new Point3D(p);
    }

    public void setP(Point3D p) {
        this.p = new Point3D(p);
    }

    public void setN(Vector n) {
        N =  new Vector(n);
    }
}
