package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.Color;
import java.util.Objects;

/**
 * a directional infinite light source
 */
public class DirectionalLight extends Light{
    /**
     * the direction of the light
     */
    Vector _direction;

    /**
     * ctor with values
     * @param _direction a direction vector
     */
    public DirectionalLight(Vector _direction) {
        this._direction = _direction;
    }

    /**
     * default ctor
     */
    public DirectionalLight(){this._direction = new Vector(0,0,1);}

    /**
     * ctor with direction and color
     * @param _direction the vector direction
     * @param _color the color for the light source
     */
    public DirectionalLight(Vector _direction, Color _color) {
        super(_color);
        this._direction = _direction;
    }

    /**
     * ctor with direction and color, parameters inverted to match other cases
     * @param _color the color for the light source
     * @param _direction the vector direction
     */
    public DirectionalLight(Color _color,Vector _direction) {
        super(_color);
        this._direction = _direction;
    }

    /**
     * cpy ctor
     * @param DL the other directional light source
     */
    public DirectionalLight(DirectionalLight DL) {
        super(DL._color);
        this._direction = DL._direction;
    }

    /**
     * get the affection this light has on a point
     * @param x the point
     * @return the color of the relative affection
     */
    @Override
    public Color getIntensity(Point3D x) {
        return _color;
    }

    /**
     * get a vector from this light source to a point
     * @param point the point
     * @return a vector
     */
    @Override
    public Vector getL(Point3D point) {
        return _direction;
    }

    /**
     * get the light's direction
     * @return the direction vector
     */
    public Vector get_direction() {
        return _direction;
    }

    /**
     * set the direction vector
     * @param _direction new direction vector
     */
    public void set_direction(Vector _direction) {
        this._direction = new Vector(_direction);
    }

    /**
     * converts a directional light to a string
     * @return a string of values
     */
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
