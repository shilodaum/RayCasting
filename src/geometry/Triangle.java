package geometry;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Objects;

public class Triangle extends Plane {
    private Point3D p1;
    private Point3D p2;
    private  Point3D p3;


    //get set
    public Point3D getP1() {
        return p1;
    }
    public void setP1(Point3D p1) {
        this.p1 = p1;
    }

    public Point3D getP2() {
        return p2;
    }
    public void setP2(Point3D p2) {
        this.p2 = p2;
    }

    public Point3D getP3() {
        return p3;
    }
    public void setP3(Point3D p3) {
        this.p3 = p3;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return getP1().equals(triangle.getP1()) &&
                getP2().equals(triangle.getP2()) &&
                getP3().equals(triangle.getP3());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getP1(), getP2(), getP3());
    }




    @Override
    public String toString() {
        return "Triangle{" +
                "p1=" + getP1() +
                ", p2=" + getP2() +
                ", p3=" + getP3() +
                '}';
    }

    public Triangle(Point3D p1, Point3D p2, Point3D p3) {
        super(p1,p2,p3);
        this.setP1(p1);
        this.setP2(p2);
        this.setP3(p3);
    }

    public Triangle(Color clr, Material nMaterial, Point3D p1, Point3D p2, Point3D p3) {
        super(clr,nMaterial, p1,p2,p3);
        this.setP1(p1);
        this.setP2(p2);
        this.setP3(p3);
    }

    public Triangle(Color clr, Point3D p1, Point3D p2, Point3D p3) {
        super(clr, p1,p2,p3);
        this.setP1(p1);
        this.setP2(p2);
        this.setP3(p3);
    }

    public Triangle(Triangle t) {
        super(t.p1,t.p2,t.p3);
        this.setP1(t.p1);
        this.setP2(t.p2);
        this.setP3(t.p3);
    }
    @Override
    public ArrayList<Point3D> findIntersections(Ray r){
        if (super.findIntersections(r).isEmpty())
            return super.findIntersections(r);

        Vector v1= new Vector(r.getPOO(), p1);
        Vector v2= new Vector(r.getPOO(), p2);
        Vector v3= new Vector(r.getPOO(), p3);

        Vector N1= new Vector(v2.crossProduct(v1));
        N1.normalize();
        Vector N2= new Vector(v1.crossProduct(v3));
        N2.normalize();
        Vector N3= new Vector(v3.crossProduct(v2));
        N3.normalize();

        ArrayList<Point3D> arr1 =super.findIntersections(r);
        Point3D iP= new Point3D(arr1.get(0));
        Vector vv=new Vector(r.getPOO(),iP);
        if ((vv.dotProduct(N1)>0 && vv.dotProduct(N2)>0 && vv.dotProduct(N3)>0)
            || (vv.dotProduct(N1)<0 && vv.dotProduct(N2)<0 && vv.dotProduct(N3)<0)){
            return arr1;
        }
        else return new ArrayList<Point3D>();



    }

}
