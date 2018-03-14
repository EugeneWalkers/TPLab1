package draws.flatfigures.polygons.quadrilaterals;

import java.awt.*;

public class Rectangle extends Parallelogram {

    public Rectangle(Point p1, Point p2, Point p3) {
        super(p1, p2, p3);
    }

    @Override
    public void draw(Graphics2D g2d) {
        super.draw(g2d);
    }

    @Override
    public void move(Point endPoint) {
        super.move(endPoint);
    }

    public static Rectangle createRectangle(Point p1, Point p2, Point p3){

        double b21 = p2.y - p1.y;
        double a21 = p2.x - p1.x;
        double x1=0;
        double y1=0;
        if (p1.x != p2.x) {
            x1 = -p3.y * b21 / a21 + p2.y * b21 / a21 + p2.x;
            y1 = p3.y;
        } else {
            y1 = -p3.x * a21 / b21 + p2.y * a21 / b21 + p2.y;
            x1 = p3.y;
        }
        return new Rectangle(p1, p2, new Point((int) Math.round(x1), (int) Math.round(y1)));
    }
}