package draws.flatfigures;

import drawer.Options;
import draws.Figure;

import java.awt.*;

public abstract class FlatFigure extends Figure {

    public FlatFigure() {
        setPenColor(Options.getPen().getBackground());
        setFillColor(Options.getFill().getBackground());
        setPenWidth(Options.getPenWidth());  }

    private Color fillColor = Color.white;

    private Point leftCornerPoint;

    private Point fillPoint;

    private int width;

    private int height;

    @Override
    public void draw(Graphics2D g2d) {
        // TODO implement here
    }

    @Override
    public void move(Point endPoint) {
        Point oldCenter = getTheCenter();
        int dx = endPoint.x - oldCenter.x;
        int dy = endPoint.y - oldCenter.y;
        for (int i = 0; i < getArrayOfPoints().size() - 1; i++) {
            getArrayOfPoints().get(i).x += dx;
            getArrayOfPoints().get(i).y += dy;
        }
        setTheCenter(endPoint);
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color _fillColor) {
        fillColor = _fillColor;
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

    public Point getFillPoint() {
        return fillPoint;
    }

    public void setFillPoint(Point fillPoint) {
        this.fillPoint = fillPoint;
    }
}