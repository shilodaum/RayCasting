package elements;

import primitives.Point3D;
import primitives.Util;
import primitives.Vector;

import java.awt.Color;
import java.util.Objects;

/**
 * an environmental light
 */
public class AmbientLight extends Light{
    /**
     * the scale factor
     */
    double _ka;

    /**
     * default ctor
     */
    public AmbientLight(){
        super(Color.WHITE);
        this._ka = 0.1;
    }

    /**
     * ctor with a color and a factor
     * @param _color the color
     * @param _ka the scalar
     */
    public AmbientLight(Color _color, double _ka) {
        super(_color);
        this._ka = _ka;
    }

    /**
     * set with (r,b,g) values
     * @param r red coefficient
     * @param g green coefficient
     * @param b blue coefficient
     */
    public AmbientLight(int r,int g,int b) {
        this._color = new Color(r,g,b);
        this._ka = 0.1;
    }

    /**
     * cpy ctor
     * @param a other color
     */
    public AmbientLight(AmbientLight a) {
        super(a._color);
        this._ka = a._ka;
    }

    /**
     * get intensity
     * @return the color factor
     */
    public double get_ka() {
        return _ka;
    }

    /**
     * set a new factor
     * @param _ka new factor
     */
    public void set_ka(double _ka) {
        this._ka = _ka;
    }

    /**
     * compare to other object
     * @param o other object
     * @return true if equlas
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AmbientLight that = (AmbientLight) o;
        return Double.compare(that._ka, _ka) == 0 &&
                Objects.equals(_color, that._color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_color, _ka);
    }

    /**
     * converts to string
     * @return AmbientLight values as strings
     */
    @Override
    public String toString() {
        return "AmbientLight{" +
                "_color=" + _color +
                ", _ka=" + _ka +
                '}';
    }

    /**
     * get light intensity in point
     * @param x the point
     * @return the color multiplied by the intensity
     */
    @Override
    public Color getIntensity(Point3D x)
    {
        double r = Util.uscale(_color.getRed(),_ka);
        double g = Util.uscale(_color.getGreen(),_ka);
        double b = Util.uscale(_color.getBlue(),_ka);
        return new Color((int)r,(int)g,(int)b);
    }

    /**
     * the vector to a point
     * @param point the point
     * @return the vector
     */
    @Override
    public Vector getL(Point3D point){
        return new Vector(0,0,0);
    }

}
