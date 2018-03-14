package draws.flatfigures.polygons.quadrilaterals;

import java.awt.*;

public class Diamond extends Parallelogram {

    public Diamond(Point p1, Point p2, Point p3) {
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

    public static Diamond createDiamond(Point p1, Point p2, Point p3){
        double a12 = p1.x - p2.x;
        double a32 = p3.x - p2.x;
        double b12 = p1.y - p2.y;
        double b32 = p3.y - p2.y;
        double x = a32 * Math.sqrt((a12 * a12 + b12 * b12) / (a32 * a32 + b32 * b32)) + (double) p2.x;
        double y = b32 * Math.sqrt((a12 * a12 + b12 * b12) / (a32 * a32 + b32 * b32)) + (double) p2.y;
        return new Diamond(p1, p2, new Point((int) Math.round(x), (int) Math.round(y)));
    }

}