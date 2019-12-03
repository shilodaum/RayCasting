package geometry;

import primitives.Point3D;
import primitives.Ray;
import primitives.Util;
import primitives.Vector;

import java.util.List;

import static java.lang.StrictMath.sqrt;


/**
 * represnts an infinite cylinder
 */
public class Cylinder extends RadialGeometry {
    /**
     * a center point and a direction vector
     */
    protected Point3D center;
    protected Vector direction;

    /**
     * default ctor
     */
    public Cylinder(){
        super(0.0);
        center= new Point3D();
        direction= new Vector();
    }

    /**
     * ctor with a radius a point and a direction
     * @param radius radius for radial geometry
     * @param center center point
     * @param direction direction vector
     */
    public Cylinder(double radius, Point3D center, Vector direction) {
        super(radius);
        this.center = new Point3D(center);
        this.direction = new Vector(direction);
    }

    /**
     * cpy ctor
     * @param o other cylinder
     */
    public Cylinder(Cylinder o){
        super(o.getRadius());
        this.center=new Point3D(o.getCenter());
        this.direction=new Vector(o.getDirection());
    }

    public Point3D getCenter() {
        return center;
    }

    /**
     * set center point
     * @param center center point
     */
    public void setCenter(Point3D center) {
        this.center = center;
    }

    /**
     * get the direction vector
     * @return direction vector
     */
    public Vector getDirection() {
        return direction;
    }

    /**
     * set direction vector
     * @param direction new vector
     */
    public void setDirection(Vector direction) {
        this.direction = direction;
    }

    /**
     * get the normal vector for a point on cylinder
     * @param point point on cylinder
     * @return the normal vector to this point
     */
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
        //ToDO
        return ds;

    }

    /**
     * find intersection points with a given Ray
     * @param r the ray
     * @return all intersection points with the ray r
     */
    @Override
    public List<Point3D> findIntersections(Ray r) {
        return null; //ToDo
    }
}
