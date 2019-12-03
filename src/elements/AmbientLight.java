package elements;

import primitives.Point3D;
import primitives.Util;
import primitives.Vector;

import java.awt.Color;
import java.util.Objects;

public class AmbientLight extends Light{
    double _ka;

    public AmbientLight(){
        super(Color.WHITE);
        this._ka = 0.1;
    }

    public AmbientLight(Color _color, double _ka) {
        super(_color);
        this._ka = _ka;
    }

    public AmbientLight(int r,int g,int b) {
        this._color = new Color(r,g,b);
        this._ka = 0.1;
    }

    public AmbientLight(AmbientLight a) {
        super(a._color);
        this._ka = a._ka;
    }

    public double get_ka() {
        return _ka;
    }

    public void set_ka(double _ka) {
        this._ka = _ka;
    }

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

    @Override
    public String toString() {
        return "AmbientLight{" +
                "_color=" + _color +
                ", _ka=" + _ka +
                '}';
    }

    @Override
    public Color getIntensity(Point3D x)
    {
        double r = Util.uscale(_color.getRed(),_ka);
        double g = Util.uscale(_color.getGreen(),_ka);
        double b = Util.uscale(_color.getBlue(),_ka);
        return new Color((int)r,(int)g,(int)b);
    }

    @Override
    public Vector getL(Point3D point){
        return new Vector(0,0,0);
    }

}
