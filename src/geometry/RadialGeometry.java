package geometry;

import primitives.Material;

import java.awt.Color;

/**
 * abstrat class to represent all radial geometries- sphere, cylinder etc.
 */
public abstract class RadialGeometry  extends  Geometry{
    /**
     * radius of the geometry
     */
    protected  double radius;

    /**
     * get radius
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * cpy ctor
     * @param radial other radial geometry
     */
    public RadialGeometry(RadialGeometry radial) {
        this.radius = radial.radius;
    }

    /**
     * ctor
     * @param radius the radius
     */
    public RadialGeometry(double radius) {
        this.radius = radius;
    }

    /**
     * ctor with parameters
     * @param clr color
     * @param nMaterial new material
     * @param radius radius
     */
    public RadialGeometry(Color clr, Material nMaterial, double radius) {
        super(clr,nMaterial);
        this.radius = radius;
    }

    /**
     * ctor with color and radius
     * @param clr color
     * @param radius radius
     */
    public RadialGeometry(Color clr,  double radius) {
        super(clr);
        this.radius = radius;
    }
}
