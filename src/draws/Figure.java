package draws;

import java.awt.*;
import java.util.ArrayList;

public abstract class Figure{


    public ArrayList<Point> getArrayOfPoints() {
        return arrayOfPoints;
    }

    protected ArrayList<Point> arrayOfPoints = new ArrayList<>();
    public Figure() {
    }

    private Point theCenter;

    private Color penColor = Color.black;

    private int penWidth = 1;

    public abstract void draw(Graphics2D g2d);

    public abstract void move(Point endPoint);

    public Point getLocation() {
        return theCenter;
    }

    public Point getTheCenter() {
        return theCenter;
    }

    public void setTheCenter(Point theCenter) {
        this.theCenter = theCenter;
    }

    public Color getPenColor() {
        return penColor;
    }

    public void setPenColor(Color penColor) {
        this.penColor = penColor;
    }

    public int getPenWidth() {
        return penWidth;
    }

    public  void setPenWidth(int penWidth) {
        this.penWidth = penWidth;
    }

}