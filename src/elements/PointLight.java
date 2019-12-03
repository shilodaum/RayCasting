package elements;

import primitives.Point3D;
import primitives.Util;
import primitives.Vector;

import java.awt.*;
import java.util.Objects;

/**
 * a point light source with equal affection to all direction,
 * affection decreases as you get further from this light source
 */
public class PointLight extends Light {
    /**
     * the position point of this light source
     * _kc constant(a) light decrease for distance
     * _kl linear(ax) light decrease for distance
     * _kq quad(ax^2) light decrease for distance
     */
    Point3D _position;
    double _kc,_kl,_kq;

    /**
     * ctor with all parameters
     * @param _color the color of the light source
     * @param _position the position point
     * @param _kc constant(a) light decrease for distance
     * @param _kl linear(ax) light decrease for distance
     * @param _kq quad(ax^2) light decrease for distance
     */
    public PointLight(Color _color, Point3D _position, double _kc, double _kl, double _kq) {
        super(_color);
        this._position = _position;
        this._kc = _kc;
        this._kl = _kl;
        this._kq = _kq;
    }

    /**
     * cpy ctor
     * @param PL other point light
     */
    public PointLight(PointLight PL) {
        super(PL._color);
        this._position = PL._position;
        this._kc = PL._kc;
        this._kl = PL._kl;
        this._kq = PL._kq;
    }

    /**
     * ctor without color
     * @param _position position point
     * @param _kc constant(a) light decrease for distance
     * @param _kl linear(ax) light decrease for distance
     * @param _kq quad(ax^2) light decrease for distance
     */
    public PointLight(Point3D _position, double _kc, double _kl, double _kq) {
        this._position = _position;
        this._kc = _kc;
        this._kl = _kl;
        this._kq = _kq;
    }

    /**
     * ctor with a point
     * @param _position the position posion
     */
    public PointLight(Point3D _position) {
        this._position = _position;
        this._kc = 0.1;
        this._kl = 0.1;
        this._kq = 0.1;
    }

    /**
     * get intensity of this light in a point
     * @param x the point
     * @return the color that reflects the affection of this light source in a point
     */
    @Override
    public Color getIntensity(Point3D x) {
        double d =x.distance(_position);
    double factor=_kc+ Util.uscale(_kl,d)+Util.uscale(Util.uscale(_kq,d),d);
    return colorScale(_color,(double)1/factor);
    }

    /**
     * get the vector from this light source to a point
     * @param point the point
     * @return the vector from the light to the pint
     */
    @Override
    public Vector getL(Point3D point) {
        Vector tv= new Vector(_position,point);
        tv.normalize();
        return(tv);
    }

    /**
     * get the position point
     * @return the position point
     */
    public Point3D get_position() {
        return _position;
    }

    /**
     * set the position point
     * @param _position new point
     */
    public void set_position(Point3D _position) {
        this._position = _position;
    }

    /**
     * get constant coefficient
     * @return the constant coefficient
     */
    public double get_kc() {
        return _kc;
    }



    /** get linear coefficient
     * @return the linear coefficient
     */
    public double get_kl() {
        return _kl;
    }

    /**
     * get quad coefficient
     * @return the quad coefficient
     */
    public double get_kq() {
        return _kq;
    }

    /**
     * set the constant coefficient
     * @param _kc new coefficient
     */
    public void set_kc(double _kc) {
        this._kc = _kc;
    }
    /**
     * set the linear coefficient
     * @param _kl new coefficient
     */
    public void set_kl(double _kl) {
        this._kl = _kl;
    }


    /**
     * set the quad coefficient
     * @param _kq new coefficient
     */
    public void set_kq(double _kq) {
        this._kq = _kq;
    }

    /**
     * compare to other object
     * @param o other object
     * @return true if equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PointLight)) return false;
        PointLight that = (PointLight) o;
        return Double.compare(that._kc, _kc) == 0 &&
                Double.compare(that._kl, _kl) == 0 &&
                Double.compare(that._kq, _kq) == 0 &&
                Objects.equals(_position, that._position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_position, _kc, _kl, _kq);
    }

    /**
     * convert to string
     * @return string of values
     */
    @Override
    public String toString() {
        return "PointLight{" +
                "_position=" + _position +
                ", _kc=" + _kc +
                ", _kl=" + _kl +
                ", _kq=" + _kq +
                ", _color=" + _color +
                '}';
    }
}
