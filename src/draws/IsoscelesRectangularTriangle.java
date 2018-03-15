package draws;

import java.awt.*;

public class IsoscelesRectangularTriangle extends RectangularTriangle {

    public IsoscelesRectangularTriangle(Point p1, Point p2, Point p3) {
        super(p1, p2, p3);
        setTheCenter(p2);
    }

    @Override
    public void draw(Graphics2D g2d) {
        super.draw(g2d);
    }

    @Override
    public void move(Point endPoint) {
        super.move(endPoint);
    }

    public static IsoscelesRectangularTriangle createIsoscelesRectangularTriangle(Point p1, Point p2, Point p3){
        double b21 = p2.y - p1.y;
        double a21 = p2.x - p1.x;
        double x1;
        double y1;
        if (p1.x != p2.x) {
            x1 = -p3.y * b21 / a21 + p2.y * b21 / a21 + p2.x;
            y1 = p3.y;
        } else {
            y1 = -p3.x * a21 / b21 + p2.y * a21 / b21 + p2.y;
            x1 = p3.y;
        }
        double a12 = p1.x - p2.x;
        double a32 = x1 - p2.x;
        double b12 = p1.y - p2.y;
        double b32 = y1 - p2.y;
        x1 = a32 * Math.sqrt((a12 * a12 + b12 * b12) / (a32 * a32 + b32 * b32)) + (double) p2.x;
        y1 = b32 * Math.sqrt((a12 * a12 + b12 * b12) / (a32 * a32 + b32 * b32)) + (double) p2.y;
        return new IsoscelesRectangularTriangle(p1, p2, new Point((int) Math.round(x1), (int) Math.round(y1)));
    }

}