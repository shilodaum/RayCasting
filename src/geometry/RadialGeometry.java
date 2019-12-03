package geometry;

import primitives.Material;

import java.awt.Color;

public abstract class RadialGeometry  extends  Geometry{
    protected  double radius;

    public double getRadius() {
        return radius;
    }

    public RadialGeometry(RadialGeometry radial) {
        this.radius = radial.radius;
    }
    public RadialGeometry(double radius) {
        this.radius = radius;
    }

    public RadialGeometry(Color clr, Material nMaterial, double radius) {
        super(clr,nMaterial);
        this.radius = radius;
    }
    public RadialGeometry(Color clr,  double radius) {
        super(clr);
        this.radius = radius;
    }
    //get normal is ab
}
