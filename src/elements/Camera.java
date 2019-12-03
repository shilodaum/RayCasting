package elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.Objects;

public class Camera {
    Point3D center;
    Vector vU;
    Vector vT;
    Vector vR;


    public Camera(){
        center=new Point3D(0,0,0);
        vU=new Vector(0,1,0);
        vT=new Vector(0,0,-1);
        vR=new Vector(1,0,0);
    }

    public Camera(Camera c){
        center=new Point3D(c.center);
        vU=new Vector(c.vU);
        vT=new Vector(c.vT);
        vR=new Vector(c.vR);
    }
    public Camera(Point3D p,Vector v1,Vector v2,Vector v3){
        center=new Point3D(p);
        vU=new Vector(v1);
        vT=new Vector(v2);
        vR=new Vector(v3);
    }
    public Camera(Vector v1,Vector v2,Vector v3){
        center=new Point3D(0,0,0);
        vU=new Vector(v1);
        vT=new Vector(v2);
        vR=new Vector(v3);
    }
    public Camera(Vector v1,Vector v2){
        center=new Point3D(0,0,0);
        vU=new Vector(v1);
        vT=new Vector(v2);
        vR=new Vector(v2.crossProduct(v1));
    }

    public Point3D getCenter() {
        return center;
    }

    public Vector getvU() {
        return vU;
    }

    public Vector getvT() {
        return vT;
    }

    public Vector getvR() {
        return vR;
    }

    public void setCenter(Point3D center) {
        this.center = new Point3D(center);
    }

    public void setvU(Vector vU) {
        this.vU =new Vector(vU);
    }

    public void setvT(Vector vT) {
        this.vT =new Vector(vT);
    }

    public void setvR(Vector vR) {
        this.vR = new Vector(vR);
    }

    @Override
    public String toString() {
        return "Camera{" +
                "center=" + center +
                ", vU=" + vU +
                ", vT=" + vT +
                ", vR=" + vR +
                '}';
    }

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
