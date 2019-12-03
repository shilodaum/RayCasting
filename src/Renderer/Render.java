package Renderer;

import Scene.*;
import elements.Light;
import geometry.FlatGeometry;
import geometry.Geometry;
import primitives.Point3D;
import primitives.Ray;
import primitives.Util;
import primitives.Vector;

import java.awt.*;
import java.util.*;
import java.util.List;

import static elements.Light.colorAdd;
import static elements.Light.colorScale;
import static java.lang.Math.pow;
import static primitives.Util.uscale;

/**
 * the class that renders the image
 */
public class Render {
    /**
     * scene and an image writer
     */
    Scene _s;
    ImageWriter _iw;

    /**
     * ctor with values
     * @param _s
     * @param _iw
     */
    public Render(Scene _s, ImageWriter _iw) {
        this._s = _s;
        this._iw = _iw;
    }

    /**
     * cpy ctor
     * @param r other renderer
     */
    public Render(Render r) {
        this._s = new Scene(r._s);
        this._iw = new ImageWriter(r._iw);
    }
/************getters/setters************/
    public Scene get_s() {
        return _s;
    }

    public void set_s(Scene _s) {
        this._s = _s;
    }

    public ImageWriter get_iw() {
        return _iw;
    }

    public void set_iw(ImageWriter _iw) {
        this._iw = _iw;
    }

    /**
     * print grid lines to image
     * @param interval determines how many lines to print
     */
    public void printGrid(int interval) {
        int _w = _iw.getWidth();
        int _h = _iw.getHeight();
        for (int i = 0; i < _w; ++i) {
            for (int j = 0; j < _h; ++j) {
                if (i % interval == 0 || j % interval == 0 || i == (_iw.getWidth() - 1) || j == (_iw.getHeight() - 1)) {
                    _iw.writePixel(i, j, new Color(255, 255, 255));
                }
            }
        }
    }

    /**
     * take care of the whole rendering process
     */
    public void renderImage() {
        int _w = _iw.getWidth();
        int _h = _iw.getHeight();
        int _Nx = _iw.getNx();
        int _Ny = _iw.getNy();
        double _dis = _s.getDis();

        //for each point
        for (int i = 0; i < _w; ++i) {
            for (int j = 0; j < _h; ++j) {
                //build a ray
                Ray ray = _s.getCamera().constructRayThroughPixel(_Nx, _Ny, j, i, _dis, _w, _h);
                //get all intersection

                Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(ray);
                if (intersectionPoints.isEmpty())
                    _iw.writePixel(j, i, _s.getBg());
                else {
                    Map<Geometry, Point3D> pointGeometry = getClosestPoint(intersectionPoints);
                    Point3D closestPoint;
                    for (Map.Entry<Geometry, Point3D> entry : pointGeometry.entrySet()) {
                        closestPoint = entry.getValue();
                        //calc color for each point
                        _iw.writePixel(j, i, calcColor(entry.getKey(), entry.getValue()));
                    }
                }
            }
        }
    }

    /**
     * get all intersections
     * @param ray the ray
     * @return all intersection points with the relevant geometries
     */
    private Map<Geometry, List<Point3D>> getSceneRayIntersections(Ray ray) {
        Iterator<Geometry> geometries = _s.getGeometriesIterator();
        Map<Geometry, List<Point3D>> intersectionPoints = new HashMap<Geometry, List<Point3D>>();
        //iterate all geometries
        while (geometries.hasNext()) {
            Geometry geometry = geometries.next();
            //get intersection points
            List<Point3D> geometryIntersectionPoints = geometry.findIntersections(ray);
            if (!(geometryIntersectionPoints.isEmpty())) {
                intersectionPoints.put(geometry, geometryIntersectionPoints);
            }
        }
        return intersectionPoints;

    }

    /**
     * find the closet point from a list
     * @param intersectionGeometries the map of all intersection points
     * @return the closest point
     */
    private Map<Geometry, Point3D> getClosestPoint(Map<Geometry, List<Point3D>> intersectionGeometries) {
        double distance = Double.MAX_VALUE;
        Point3D P0 = _s.getCamera().getCenter();
        Map<Geometry, Point3D> minDistanceGeometry = new HashMap<Geometry, Point3D>();

        for (Map.Entry<Geometry, List<Point3D>> entry : intersectionGeometries.entrySet()) {
            for (Point3D point : entry.getValue()) {
                if (P0.distance(point) < distance) {
                    //iterate all points
                    minDistanceGeometry.clear();
                    minDistanceGeometry.put(entry.getKey(), new Point3D(point));
                    //find the closest
                    distance = P0.distance(point);
                }
            }
        }
        return minDistanceGeometry;
    }

    /**
     * calc the color of one point
     * @param _g the geometry of the point
     * @param point the point
     * @return the color of the point
     */
    private Color calcColor(Geometry _g, Point3D point) {
        Color AL = _s.getAl().getIntensity(point);
        Color EL = _g.getEmission();
        Iterator<Light> lightSources = _s.GetLightIterator();
        Color diff = new Color(0, 0, 0);
        Color nDiff;
        Color spec = new Color(0, 0, 0);
        Color nSpec;
        //all types of color
        while (lightSources.hasNext()) {
            Light currentLight = lightSources.next();
            //iterate all light sources
            if (!occluded(currentLight, point, _g)) {
                nDiff = calcDiffuseComp(_g.get_material().get_kd(), _g.getNormal(point), currentLight.getL(point),
                        currentLight.getIntensity(point));
                //calculate all color components
                diff = colorAdd(diff, nDiff);
                nSpec = calcSpecularComp(_g.get_material().get_ks(), new Vector(_s.getCamera().getCenter(), point),
                        _g.getNormal(point), currentLight.getL(point), _g.get_material().getnShininess(), currentLight.getIntensity(point));
                spec = colorAdd(spec, nSpec);

            }
        }
        //add all the values
        return colorAdd(colorAdd(AL, EL), colorAdd(diff, spec));
    }

    /**
     * calculate the diffuse component of the color
     * @param kd diffuse factor
     * @param normal the normal vector for point
     * @param vecL the vector from the light source
     * @param intensity the color from the light source
     * @return the color of the diffuse component of a light source
     */
    private Color calcDiffuseComp(double kd, Vector normal, Vector vecL, Color intensity) {
        vecL.normalize();
        normal.normalize();
        double factor = uscale(kd, normal.dotProduct(vecL));
        if (factor < 0) factor = Util.uscale(factor, -1);
        return (colorScale(intensity, factor));
    }

    /**
     * calculate the specular component of a light source
     * @param ks specular factor
     * @param V the vector from the light source
     * @param normal the normal vector
     * @param D the direction vector of the light
     * @param shininess shininess factor
     * @param intensity color intensity in point
     * @return the color of the specular vomponemt
     */
    private Color calcSpecularComp(double ks, Vector V, Vector normal, Vector D, double shininess, Color intensity) {
        V.normalize();
        normal.normalize();
        D.normalize();
        double tmpD1 = Util.uscale(2, (D.dotProduct(normal)));
        Vector R = D.sub(normal.scale(tmpD1));
        double tmpFactor = Util.uscale(ks, pow((V.dotProduct(R)), shininess));
        if (tmpFactor <= 0) return Color.BLACK;
        return colorScale(intensity, tmpFactor);
    }

    /**
     * check if a point is occluded
     * @param light the light source
     * @param point the point
     * @param geometry the geometry of the point
     * @return true if point is occluded
     */
    private boolean occluded(Light light, Point3D point, Geometry geometry) {

        //get point a little above surface
        Point3D geometryPoint = new Point3D(point);
        Vector tNormal = new Vector(geometry.getNormal(point));
        tNormal=tNormal.scale(0.01);
        geometryPoint=geometryPoint.addVector(tNormal);

        Vector direction = (light.getL(geometryPoint));
        direction.normalize();
        direction=direction.scale(-1);

        // get all intersection point in the same ray
        Ray lightRay = new Ray(geometryPoint, direction);
        Map<Geometry, List<Point3D>> intersectionPoints = this.getSceneRayIntersections(lightRay);
        Map<Geometry, List<Point3D>> intersectionPoints2=new HashMap<>();
        for(Map.Entry<Geometry,List<Point3D>> entry:intersectionPoints.entrySet()){
            //check if there's a closer point to camera
            if(!entry.getKey().equals(geometry)&& !(geometry instanceof FlatGeometry))
                intersectionPoints2.put(entry.getKey(),entry.getValue());
        }
        //if there are point
        return !intersectionPoints2.isEmpty();
    }

}


