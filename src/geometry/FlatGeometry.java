package geometry;

import primitives.Material;

import java.awt.Color;

public abstract class FlatGeometry extends Geometry{

    public FlatGeometry() {
    }

    public FlatGeometry(Color emission, Material _material) {
        super(emission, _material);
    }

    public FlatGeometry(Color emission) {
        super(emission);
    }
}
