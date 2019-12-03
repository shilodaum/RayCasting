package elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.Objects;

/**
 * the camera object to simulate the beginning of the rays
 */
public class Camera {
    /**
     * vencter point
     * 3 directional vectors
     */
    Point3D center;
    Vector vU;
    Vector vT;
    Vector vR;


    /**
     * default ctor
     */
    public Camera(){
        center=new Point3D(0,0,0);
        vU=new Vector(0,1,0);
        vT=new Vector(0,0,-1);
        vR=new Vector(1,0,0);
    }

    /**
     * cpy ctor
     * @param c other camera
     */
    public Camera(Camera c){
        center=new Point3D(c.center);
        vU=new Vector(c.vU);
        vT=new Vector(c.vT);
        vR=new Vector(c.vR);
    }

    /**
     * ctor with values
     * @param p point
     * @param v1 1st vector
     * @param v2 2nd vector
     * @param v3 3rd vector
     */
    public Camera(Point3D p,Vector v1,Vector v2,Vector v3) {
        center = new Point3D(p);
        vU = new Vector(v1);
        vT = new Vector(v2);
        vR = new Vector(v3);
    }

    /**
     * ctor with only vector, default point is 0,0,0
     * @param v1 1st vector
     * @param v2 2nd vector
     * @param v3 3rd vector
     */
    public Camera(Vector v1,Vector v2,Vector v3){
        center=new Point3D(0,0,0);
        vU=new Vector(v1);
        vT=new Vector(v2);
        vR=new Vector(v3);
    }

    /**
     * vtor with only 2 vector, the third onw will be the cross product of the others
     * @param v1 1st vector
     * @param v2 2nd vector
     */
    public Camera(Vector v1,Vector v2){
        center=new Point3D(0,0,0);
        vU=new Vector(v1);
        vT=new Vector(v2);
        vR=new Vector(v2.crossProduct(v1));
    }

    /**
     * center point
     * @return center point
     */
    public Point3D getCenter() {
        return center;
    }

    /**
     * get 1st vector
     * @return the 1st vector
     */
    public Vector getvU() {
        return vU;
    }
    /**
     * get 2nd vector
     * @return the 2nd vector
     */
    public Vector getvT() {
        return vT;
    }
    /**
     * get 3rd vector
     * @return the 3rd vector
     */
    public Vector getvR() {
        return vR;
    }

    /**
     * set center point
     * @param center new center point
     */
    public void setCenter(Point3D center) {
        this.center = new Point3D(center);
    }

    /**
     * set 1st vector
     * @param vU new vector
     */
    public void setvU(Vector vU) {
        this.vU =new Vector(vU);
    }
    /**
     * set 2nd vector
     * @param vT new vector
     */
    public void setvT(Vector vT) {
        this.vT =new Vector(vT);
    }
    /**
     * set 3rd vector
     * @param vR new vector
     */
    public void setvR(Vector vR) {
        this.vR = new Vector(vR);
    }

    /**
     * get string of values
     * @return string of the values of the Camera
     */
    @Override
    public String toString() {
        return "Camera{" +
                "center=" + center +
                ", vU=" + vU +
                ", vT=" + vT +
                ", vR=" + vR +
                '}';
    }

    /**
     * compare to other object
     * @param o other object
     * @return true if equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Camera camera = (Camera) o;
        return center.equals(camera.center) &&
                vU.equals(camera.vU) &&
                vT.equals(camera.vT) &&
                vR.equals(camera.vR);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, vU, vT, vR);
    }

    /**
     * the function that shots the rays from the camera
     * @param Nx number of pixels in x axis
     * @param Ny number of pixels in y axis
     * @param x the x value of the point
     * @param y the y value of the point
     * @param screenDist the distance of the camera from the screen
     * @param screenWidth the screen's width
     * @param screenHeight the screen's height
     * @return the ray direction of the constructed ray through the point
     */
    public Ray constructRayThroughPixel
            (int Nx, int Ny, double x, double y, double screenDist, double screenWidth, double screenHeight){
        Point3D Pc=center.addVector(vT.scale(screenDist));
        double Rx=screenWidth/Nx;
        double Ry=screenHeight/Ny;
        double r=((x-(Nx/2.0))*Rx+(Rx/2.0));
        double u=((y-(Ny/2.0))*Ry+(Ry/2.0));
        Vector vr=vR.scale(r);
        Vector vu=vU.scale(u);
        Point3D p= new Point3D(Pc.addVector(vr.sub(vu)));
        return new Ray(p,new Vector(center,p));
    }
}
