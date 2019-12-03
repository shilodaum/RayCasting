package elements;

import primitives.Point3D;
import primitives.Util;
import primitives.Vector;

import java.awt.*;
import java.util.Objects;

/**
 * represtes a spot light source with an origin point and direction
 */
public class SpotLight extends PointLight {
    /**
     * direction vector
     */
    Vector _direction;

    /**
     * ctor with all values except the direction, does not initialize the vector
     * @param _color the color
     * @param _position the point
     * @param _kc constant(a) light decrease for distance
     * @param _kl linear(ax) light decrease for distance
     * @param _kq quad(ax^2) light decrease for distance
     */
    public SpotLight(Color _color, Point3D _position, double _kc, double _kl, double _kq) {
        super(_color, _position, _kc, _kl, _kq);
    }

    /**
     * ctor with all values
     * @param _color the color of the light source
     * @param _position the point
     * @param _kc constant(a) light decrease for distance
     * @param _kl linear(ax) light decrease for distance
     * @param _kq quad(ax^2) light decrease for distance
     * @param _direction the direction vector
     */
    public SpotLight(Color _color, Point3D _position, double _kc, double _kl, double _kq,Vector _direction) {
        super(_color, _position, _kc, _kl, _kq);
        this._direction=_direction;
    }

    /**
     * ctor with only point and decreasing constants, does not initialize others
     * @param _position the point
     * @param _kc constant(a) light decrease for distance
     * @param _kl linear(ax) light decrease for distance
     * @param _kq quad(ax^2) light decrease for distance
     */
    public SpotLight(Point3D _position, double _kc, double _kl, double _kq) {
        super(_position, _kc, _kl, _kq);
    }

    /**
     * ctor with only point and direction vector, does not initialize others
     * @param _position the point
     * @param _direction the direction vector
     */
    public SpotLight(Point3D _position, Vector _direction) {
        super(_position);
        this._direction = _direction;
    }

    /**
     * ctor with only a point
     * @param _position the point
     */
    public SpotLight(Point3D _position) {
        super(_position);
        this._direction = new Vector(0,0,1);
    }

    /**
     * cpy ctor
     * @param SP other spot light
     */
    public SpotLight(SpotLight SP) {
        super(SP);
        this._direction = new Vector(SP._direction);
    }

    /**
     * get intensity of this light in a point
     * @param x the point
     * @return the color that reflects the affection of this light source in a point
     */
    @Override
    public Color getIntensity(Point3D x) {
        Color c= super.getIntensity(x);
        Vector L=new Vector(_position,x);
        L.normalize();
        double factor=_direction.dotProduct(L);
        return colorScale(c, factor);
    }

    /**
     * get the vector from this light source to a point
     * @param point the point
     * @return the vector from the light to the pint
     */
    @Override
    public Vector getL(Point3D point) {
        return super.getL(point);
    }

    /**
     * get the direction vector
     * @return
     */
    public Vector get_direction() {
        return _direction;
    }

    /**
     * set the direction vector
     * @param _direction the new direction vector
     */
    public void set_direction(Vector _direction) {
        this._direction = _direction;
    }

    /**
     * compare to other object
     * @param o other object
     * @return true if equals
     */
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

    /**
     * convert to string
     * @return string of values
     */
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
