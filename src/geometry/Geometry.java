package geometry;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.awt.Color;
import java.util.List;
import java.util.Objects;

public abstract class Geometry {
    Color Emission;
    Material _material;



    public Geometry() {
        this.Emission = new Color(67, 21, 77);
        this._material =new Material(0.5,0.5,0.5);
    }

    public Geometry(Color emission, Material _material) {
        Emission = emission;
        this._material = _material;
    }

    public Geometry(Color emission) {
        Emission = emission;
        this._material =new Material(0.5,0.5,2);
    }

    public  abstract Vector getNormal(Point3D point);
    public  abstract List<Point3D> findIntersections(Ray r);

    public Color getEmission() {
        return Emission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Geometry)) return false;
        Geometry geometry = (Geometry) o;
        return Objects.equals(Emission, geometry.Emission) &&
                Objects.equals(_material, geometry._material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Emission, _material);
    }

    public void setEmission(Color emission) {
        Emission = emission;
    }

    public Material get_material() {
        return _material;
    }

    public void set_material(Material _material) {
        this._material = _material;
    }

    @Override
    public String toString() {
        return "Geometry{" +
                "Emission=" + Emission +
                ", _material=" + _material +
                '}';
    }

    public void setMaterial(Material m) {
        set_material(m);
    }
}
