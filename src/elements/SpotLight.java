package elements;

import primitives.Point3D;
import primitives.Util;
import primitives.Vector;

import java.awt.*;
import java.util.Objects;

public class SpotLight extends PointLight {
    Vector _direction;

    public SpotLight(Color _color, Point3D _position, double _kc, double _kl, double _kq) {
        super(_color, _position, _kc, _kl, _kq);
    }
    public SpotLight(Color _color, Point3D _position, double _kc, double _kl, double _kq,Vector _direction) {
        super(_color, _position, _kc, _kl, _kq);
        this._direction=_direction;
    }

    public SpotLight(Point3D _position, double _kc, double _kl, double _kq) {
        super(_position, _kc, _kl, _kq);
    }

    public SpotLight(Point3D _position, Vector _direction) {
        super(_position);
        this._direction = _direction;
    }
    public SpotLight(Point3D _position) {
        super(_position);
        this._direction = new Vector(0,0,1);
    }

    public SpotLight(SpotLight SP) {
        super(SP);
        this._direction = new Vector(SP._direction);
    }

    @Override
    public Color getIntensity(Point3D x) {
        Color c= super.getIntensity(x);
        Vector L=new Vector(_position,x);
        L.normalize();
        double factor=_direction.dotProduct(L);
        return colorScale(c, factor);
    }

    @Override
    public Vector getL(Point3D point) {
        return super.getL(point);
    }

    public Vector get_direction() {
        return _direction;
    }

    public void set_direction(Vector _direction) {
        this._direction = _direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpotLight)) return false;
        if (!super.equals(o)) return false;
        SpotLight spotLight = (SpotLight) o;
        return Objects.equals(_direction, spotLight._direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), _direction);
    }

    @Override
    public String toString() {
        return "SpotLight{" +
                "_direction=" + _direction +
                ", _position=" + _position +
                ", _kc=" + _kc +
                ", _kl=" + _kl +
                ", _kq=" + _kq +
                ", _color=" + _color +
                '}';
    }
}
