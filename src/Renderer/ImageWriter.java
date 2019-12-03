package Renderer;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageWriter {

    private int _imageWidth;
    private int _imageHeight;

    private int _Ny, _Nx;

    final String PROJECT_PATH = System.getProperty("user.dir");

    private BufferedImage _image;

    private String _imageName;

    /**
     * ctor with values
     * @param imageName the image's name
     * @param width the image's width
     * @param height the image's height
     * @param Ny number of pixels in x
     * @param Nx number of pixels in t
     */
    public ImageWriter(String imageName, int width, int height, int Ny, int Nx) {

        _Nx = Nx;
        _Ny = Ny;

        _imageWidth = width;
        _imageHeight = height;

        _imageName = imageName;

        _image = new BufferedImage(
                _imageWidth, _imageHeight, BufferedImage.TYPE_INT_RGB);
        ;
    }

    /**
     * cpy ctor
     * @param imageWriter other image writer
     */
    public ImageWriter(ImageWriter imageWriter) {
        _Nx = imageWriter._Nx;
        _Ny = imageWriter._Ny;

        _imageWidth = imageWriter.getWidth();
        _imageHeight = imageWriter.getHeight();

        _imageName = imageWriter._imageName;

        _image = new BufferedImage(
                _imageWidth, _imageHeight, BufferedImage.TYPE_INT_RGB);
        ;
    }

    /***************** Getters/Setters **********************/
    public int getWidth() {
        return _imageWidth;
    }

    public int getHeight() {
        return _imageHeight;
    }

    public int getNy() {
        return _Ny;
    }

    public int getNx() {
        return _Nx;
    }

    public void setNy(int _Ny) {
        this._Ny = _Ny;
    }

    public void setNx(int _Nx) {
        this._Nx = _Nx;
    }

    /**
     * write data to image
     */
    public void writeToimage() {

        File ouFile = new File(PROJECT_PATH + "/" + _imageName + ".jpg");

        try {
            ImageIO.write(_image, "jpg", ouFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * write a single pixel into the buffered image
     * @param xIndex the x index
     * @param yIndex the y index
     * @param r red value
     * @param g green value
     * @param b blue value
     */
    public void writePixel(int xIndex, int yIndex, int r, int g, int b) {

        int rgb = new Color(r, g, b).getRGB();
        _image.setRGB(xIndex, yIndex, rgb);

    }

    /**
     * write a single pixel into the buffered image
     * @param xIndex the x index
     * @param yIndex the y index
     * @param rgbArray r,g,b values
     */
    public void writePixel(int xIndex, int yIndex, int[] rgbArray) {

        int rgb = new Color(rgbArray[0], rgbArray[1], rgbArray[2]).getRGB();
        _image.setRGB(xIndex, yIndex, rgb);

    }

    /**
     * write a single pixel into the buffered image
     * @param xIndex the x index
     * @param yIndex the y index
     * @param color the color
     */
    public void writePixel(int xIndex, int yIndex, Color color) {
        _image.setRGB(xIndex, yIndex, color.getRGB());
    }
}