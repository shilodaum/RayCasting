package elements;

import primitives.Point3D;
import primitives.Util;
import primitives.Vector;

import java.awt.Color;
import java.util.Objects;

public abstract class Light {
    Color _color;

    public Light(Color _color) {
        this._color = _color;
    }
    public Light() {
        this._color = Color.WHITE;
    }
    public abstract Color getIntensity(Point3D x);
    public abstract Vector getL(Point3D point);

    public Color get_color() {
        return _color;
    }

    public void set_color(Color _color) {
        this._color = _color;
    }

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

    @Override
    public String toString() {
        return "Light{" +
                "_color=" + _color +
                '}';
    }

    public static Color colorScale(Color c, double scale) {
        if(scale<0)scale=Util.uscale(scale,-1);
        int r = Math.min(255, (int) Util.uscale(c.getRed() , scale));
        int g = Math.min(255, (int) Util.uscale(c.getGreen() , scale));
        int b = Math.min(255, (int) Util.uscale(c.getBlue() , scale));

        return new Color(r,g,b);
    }

    public static Color colorAdd(Color c, Color t) {
        int r = Math.min(255, (int) Util.uadd(c.getRed(), t.getRed()));
        int g = Math.min(255, (int) Util.uadd(c.getGreen(), t.getGreen()));
        int b = Math.min(255, (int) Util.uadd(c.getBlue(), t.getBlue()));
        return new Color(r, g, b);
    }

}
