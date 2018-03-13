package draws.flatfigures.polygons.triangles;

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

}