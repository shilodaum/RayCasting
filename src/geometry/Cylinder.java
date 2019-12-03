package geometry;

import primitives.Point3D;
import primitives.Ray;
import primitives.Util;
import primitives.Vector;

import java.util.List;

import static java.lang.StrictMath.sqrt;



public class Cylinder extends RadialGeometry {

    protected Point3D center;
    protected Vector direction;

    public Cylinder(){
        super(0.0);
        center= new Point3D();
        direction= new Vector();
    }


    public Cylinder(double radius, Point3D center, Vector direction) {
        super(radius);
        this.center = new Point3D(center);
        this.direction = new Vector(direction);
    }

    public Cylinder(Cylinder o){
        super(o.getRadius());
        this.center=new Point3D(o.getCenter());
        this.direction=new Vector(o.getDirection());
    }

    public Point3D getCenter() {
        return center;
    }

    public void setCenter(Point3D center) {
        this.center = center;
    }

    public Vector getDirection() {
        return direction;
    }

    public void setDirection(Vector direction) {
        this.direction = direction;
    }

    @Override
    public Vector getNormal(Point3D point) {
        Vector c = new Vector(point,center);
        double c_size=c.length();
        double a = sqrt(
                Util.usubtract(
                        Util.uscale(c_size,c_size),
                        Util.uscale(radius,radius)
                )
        );
        direction.normalize();
        Vector ds= new Vector(direction.scale(a));
        Point3D n = new Point3D();

        return null;

    }

    @Override
    public List<Point3D> findIntersections(Ray r) {
        return null; //ToDo
    }
}
