package draws.flatfigures;

import draws.Figure;

import java.awt.*;

public abstract class FlatFigure extends Figure {

    public FlatFigure() {}

    private Color fillColor;

    private Point leftCornerPoint;

    private int width;

    private int height;

    @Override
    public void draw(Graphics2D g2d) {
        // TODO implement here
    }

    @Override
    public void move() {
        // TODO implement here
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public Point getLeftCornerPoint() {
        return leftCornerPoint;
    }

    public void setLeftCornerPoint(Point leftCornerPoint) {
        this.leftCornerPoint = leftCornerPoint;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}