package draws.flatfigures.polygons.quadrilaterals;

import draws.flatfigures.polygons.Polygon;

import java.awt.*;

public class Parallelogram extends Polygon {

    public Parallelogram(Point p1, Point p2, Point p3) {
        super(p1, p2, p3, new Point(p1.x + p3.x - p2.x, p1.y + p3.y - p2.y));
        setTheCenter(new Point((p1.x+p3.x)/2, (p1.y+p3.y)/2));
        setFillPoint(getTheCenter());
    }

    @Override
    public void draw(Graphics2D g2d) {
        super.draw(g2d);
    }

    @Override
    public void move(Point endPoint) {
        super.move(endPoint);
    }

}