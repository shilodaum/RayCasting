package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.Color;
import java.util.Objects;

public class DirectionalLight extends Light{
    Vector _direction;

    public DirectionalLight(Vector _direction) {
        this._direction = _direction;
    }
    public DirectionalLight(){this._direction = new Vector(0,0,1);}
    public DirectionalLight(Vector _direction, Color _color) {
        super(_color);
        this._direction = _direction;
    }
    public DirectionalLight(Color _color,Vector _direction) {
        super(_color);
        this._direction = _direction;
    }

    public DirectionalLight(DirectionalLight DL) {
        super(DL._color);
        this._direction = DL._direction;
    }


    @Override
    public Color getIntensity(Point3D x) {
        return _color;
    }

    @Override
    public Vector getL(Point3D point) {
        return _direction;
    }

    public Vector get_direction() {
        return _direction;
    }

    public void set_direction(Vector _direction) {
        this._direction = new Vector(_direction);
    }

    @Override
    public String toString() {
        return "DirectionalLight{" +
                "_direction=" + _direction +
                ", _color=" + _color +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DirectionalLight)) return false;
        DirectionalLight that = (DirectionalLight) o;
        return Objects.equals(_direction, that._direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_direction);
    }
}
