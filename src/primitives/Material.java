package primitives;

import java.util.Objects;

/**
 * represents a material of geometry
 */
public class Material {
    private double _kd;//diffuse
    private double _ks;//specular
    private double nShininess;//refraction

    /**
     * ctor with parameters
     * @param _kd diffuse
     * @param _ks specular
     * @param nShininess //shininess
     */
    public Material(double _kd, double _ks, double nShininess) {
        this._kd = _kd;
        this._ks = _ks;
        this.nShininess = nShininess;
    }

    /**
     * default ctor with random values
     */
    public Material() {
        this._kd = 0.7;
        this._ks = 0.4;
        this.nShininess = 10;
    }
/*********getters/setters*********/
    public double get_kd() {
        return _kd;
    }

    public void set_kd(double _kd) {
        this._kd = _kd;
    }

    public double get_ks() {
        return _ks;
    }

    public void set_ks(double _ks) {
        this._ks = _ks;
    }

    public double getnShininess() {
        return nShininess;
    }

    public void setnShininess(double nShininess) {
        this.nShininess = nShininess;
    }

    public void setNShininess(int i) {
        setnShininess(i);
    }

    /**
     * compare to other object
     * @param o other object
     * @return true if equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Material)) return false;
        Material material = (Material) o;
        return Double.compare(material._kd, _kd) == 0 &&
                Double.compare(material._ks, _ks) == 0 &&
                Double.compare(material.nShininess, nShininess) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_kd, _ks, nShininess);
    }

    /**
     * convert to string to show values
     * @return string of values
     */
    @Override
    public String toString() {
        return "Material{" +
                "_kd=" + _kd +
                ", _ks=" + _ks +
                ", nShininess=" + nShininess +
                '}';
    }
}
