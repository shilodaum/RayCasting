package elements;

import primitives.Point3D;
import primitives.Util;
import primitives.Vector;

import java.awt.*;
import java.util.Objects;

public class PointLight extends Light {
    Point3D _position;
    double _kc,_kl,_kq;

    public PointLight(Color _color, Point3D _position, double _kc, double _kl, double _kq) {
        super(_color);
        this._position = _position;
        this._kc = _kc;
        this._kl = _kl;
        this._kq = _kq;
    }
    public PointLight(PointLight PL) {
        super(PL._color);
        this._position = PL._position;
        this._kc = PL._kc;
        this._kl = PL._kl;
        this._kq = PL._kq;
    }

    public PointLight(Point3D _position, double _kc, double _kl, double _kq) {
        this._position = _position;
        this._kc = _kc;
        this._kl = _kl;
        this._kq = _kq;
    }
    public PointLight(Point3D _position) {
        this._position = _position;
        this._kc = 0.1;
        this._kl = 0.1;
        this._kq = 0.1;
    }

    @Override
    public Color getIntensity(Point3D x) {
        double d =x.distance(_position);
    double factor=_kc+ Util.uscale(_kl,d)+Util.uscale(Util.uscale(_kq,d),d);
    return colorScale(_color,(double)1/factor);
    }

    @Override
    public Vector getL(Point3D point) {
        Vector tv= new Vector(_position,point);
        tv.normalize();
        return(tv);
    }

    public Point3D get_position() {
        return _position;
    }

    public void set_position(Point3D _position) {
        this._position = _position;
    }

    public double get_kc() {
        return _kc;
    }

    public void set_kc(double _kc) {
        this._kc = _kc;
    }

    public double get_kl() {
        return _kl;
    }

    public void set_kl(double _kl) {
        this._kl = _kl;
    }

    public double get_kq() {
        return _kq;
    }

    public void set_kq(double _kq) {
        this._kq = _kq;
    }

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
