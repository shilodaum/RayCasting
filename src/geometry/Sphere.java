package geometry;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Math.sqrt;

public class Sphere  extends RadialGeometry{

    private Point3D center;

    public Sphere(){
        super(0.0);
        setCenter(new Point3D());
    }

    public Sphere (Sphere sphere){
        super(sphere.getRadius());
        setCenter(sphere.getCenter());
    }



    public Sphere(double radius, Point3D center){
        super(radius);
        setCenter(center);
    }


    public Sphere(Color clr, Material nMaterial, double radius, Point3D center){
        super(clr,nMaterial, radius);
        setCenter(center);
    }
    public Sphere(Color clr,  double radius, Point3D center){
        super(clr, radius);
        setCenter(center);
    }


    public Sphere(Point3D center, double radius) {
        this(radius, center);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sphere)) return false;
        if (o == null) return false;
        Sphere sphere = (Sphere) o;
        return getCenter().equals(sphere.getCenter());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCenter());
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "center=" + getCenter() +
                '}';
    }
  @Override
    public Vector getNormal(Point3D point) {
        Vector N = new Vector(center, point);
        N.normalize();
        return N;
    }

    @Override
    public List<Point3D> findIntersections(Ray r) {
        Vector L= new Vector(r.getPOO(), center);
        double tm= L.dotProduct(r.getDirection());
        double d= sqrt(L.length()*L.length()-tm*tm);

        if(d>radius)
            return new ArrayList<Point3D>();

        double th= sqrt(radius*radius-d*d);
        double t1= tm-th;
        double t2= tm+th;
        Point3D P1= r.getPOO().addVector(r.getDirection().scale(t1));
        Point3D P2= r.getPOO().addVector(r.getDirection().scale(t2));
        ArrayList<Point3D> arr= new ArrayList<Point3D>();
        if(t1>=0) arr.add(P1);
        if((t2>=0)&& !P2.equals(P1)) arr.add(P2);

        return arr;

    }

    public Point3D getCenter() {
        return new Point3D(center);
    }

    public void setCenter(Point3D center) {
        this.center = new Point3D(center);
    }
}
