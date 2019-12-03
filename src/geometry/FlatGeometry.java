package geometry;

import primitives.Material;

import java.awt.Color;

/**
 * all flat geometry objects, abstract calss
 */
public abstract class FlatGeometry extends Geometry{
    /**
     * default ctor
     */
    public FlatGeometry() {
    }

    /**
     * ctor with color emission for object and material of geometry
     * @param emission the emission color
     * @param _material the material of the geometry
     */
    public FlatGeometry(Color emission, Material _material) {
        super(emission, _material);
    }

    /**
     * ctor with emission color
     * @param emission emission color
     */
    public FlatGeometry(Color emission) {
        super(emission);
    }
}
