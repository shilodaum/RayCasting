package elements;

import primitives.Point3D;
import primitives.Util;
import primitives.Vector;

import java.awt.Color;
import java.util.Objects;


/**
 * repesents all light sources
 */
public abstract class Light {
    Color _color;

    /**
     * ctor with color
     * @param _color the light's color
     */
    public Light(Color _color) {
        this._color = _color;
    }

    /**
     * default ctor
     */
    public Light() {
        this._color = Color.WHITE;
    }

    /**
     * get light intensity
     * @param x the point
     * @return the light's intensity in the point x
     */
    public abstract Color getIntensity(Point3D x);

    /**
     * get the vector to a point in order to
     * calculate the affection of the specular and diffuse color components
     * @param point the point
     * @return the vector to a point
     */
    public abstract Vector getL(Point3D point);

    /**
     * get the color
     * @return light's color
     */
    public Color get_color() {
        return _color;
    }

    /**
     * set the color of a light source
     * @param _color the color you want to change to
     */
    public void set_color(Color _color) {
        this._color = _color;
    }

    /**
     * compare to other object
     * @param o other object
     * @return true if equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Light)) return false;
        Light light = (Light) o;
        return Objects.equals(_color, light._color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_color);
    }

    /**
     * convert to string to print or show details
     * @return string of light's data
     */
    @Override
    public String toString() {
        return "Light{" +
                "_color=" + _color +
                '}';
    }

    /**
     * scale a color by a scalar value
     * @param c the color to scale
     * @param scale the scalar
     * @return a scaled color
     */
    public static Color colorScale(Color c, double scale) {
        if(scale<0)scale=Util.uscale(scale,-1);
        int r = Math.min(255, (int) Util.uscale(c.getRed() , scale));
        int g = Math.min(255, (int) Util.uscale(c.getGreen() , scale));
        int b = Math.min(255, (int) Util.uscale(c.getBlue() , scale));

        return new Color(r,g,b);
    }

    /**
     * add twho colors
     * @param c first color
     * @param t second color
     * @return a new added color
     */
    public static Color colorAdd(Color c, Color t) {
        int r = Math.min(255, (int) Util.uadd(c.getRed(), t.getRed()));
        int g = Math.min(255, (int) Util.uadd(c.getGreen(), t.getGreen()));
        int b = Math.min(255, (int) Util.uadd(c.getBlue(), t.getBlue()));
        return new Color(r, g, b);
    }

}
