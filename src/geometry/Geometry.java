package geometry;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.awt.Color;
import java.util.List;
import java.util.Objects;

/**
 * abstract class to represent all geometries
 */
public abstract class Geometry {
    /**
     * emission color
     * material of geometry
     */
    Color Emission;
    Material _material;


    /**
     * default ctor with random values
     */
    public Geometry() {
        this.Emission = new Color(67, 21, 77);
        this._material =new Material(0.5,0.5,0.5);
    }

    /**
     * ctor with parameters
     * @param emission emission color
     * @param _material material of geometry
     */
    public Geometry(Color emission, Material _material) {
        Emission = emission;
        this._material = _material;
    }

    /**
     * ctor with emission color, random material
     * @param emission emission color
     */
    public Geometry(Color emission) {
        Emission = emission;
        this._material =new Material(0.5,0.5,2);
    }

    /**
     * method to be overridden by sons , get normal vector from a point
     * @param point the point
     * @return a normal vector
     */
    public  abstract Vector getNormal(Point3D point);

    /**
     * to be overridden by sons, find all intersection points with ray
     * @param r the ray
     * @return a list of points
     */
    public  abstract List<Point3D> findIntersections(Ray r);

    /**
     * get emission color
     * @return emission color
     */
    public Color getEmission() {
        return Emission;
    }

    /**
     * compare to other object
     * @param o other object
     * @return true if equals
     */
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

    /**
     * set emission colors
     * @param emission emission color
     */
    public void setEmission(Color emission) {
        Emission = emission;
    }

    /**
     * get geometry's material
     * @return the material
     */
    public Material get_material() {
        return _material;
    }

    /**
     * set the material
     * @param _material new material
     */
    public void set_material(Material _material) {
        this._material = _material;
    }

    /**
     * convert to string
     * @return string of values
     */
    @Override
    public String toString() {
        return "Geometry{" +
                "Emission=" + Emission +
                ", _material=" + _material +
                '}';
    }

    /**
     * set material
     * @param m new material
     */
    public void setMaterial(Material m) {
        set_material(m);
    }
}
