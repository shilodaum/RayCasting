package primitives;

/**
 * represents a ray
 */
public class Ray {

    // Point of origin
    private Point3D _POO;

    // Ray direction
    private Vector _direction;


    /**
     * default ctor
     */
    public Ray(){
        this._POO = new Point3D();
        this._direction = new Vector();
    }

    /**
     * cpy ctor
     * @param ray ray to copy
     */
    public Ray(Ray ray){
        this._POO = ray.getPOO();
        this._direction = ray.getDirection();
    }

    /**
     * ctor with parameters
     * @param poo point of origin
     * @param direction direction vector
     */
    public Ray(Point3D poo, Vector direction){
        this._POO = new Point3D(poo);
        this._direction = new Vector (direction);
        this._direction.normalize();
    }

    /***************** Getters/Setters **********************/

    public void setDirection(Vector _direction) { this._direction = new Vector(_direction);	}

    public void setPOO(Point3D _POO)            { this._POO = new Point3D(_POO);            }

    public Vector  getDirection() { return new Vector(_direction); }

    public Point3D getPOO()       { return new Point3D(_POO);	   }

    public Point3D getPoo() {
        return new Point3D(_POO);
    }
}
