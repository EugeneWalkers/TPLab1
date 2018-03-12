package draws.flatfigures.polygons.npolygons;

import draws.flatfigures.polygons.Polygon;

import java.awt.*;
import java.util.ArrayList;

public class RegularNPolygon extends Polygon {

    protected int N;

    public RegularNPolygon(Point... p) {
        super(p);
    }

    public RegularNPolygon(Point center, Point p1, int n) {
        super(RegularNPolygon.getPolygonPoints(center, p1, n));
        setTheCenter(center);
        N = n;
    }

    private static java.util.ArrayList<Point> getPolygonPoints(Point theCenter, Point pointOnCircle, int sideNum) {
        ArrayList<Point> points = new ArrayList<>();

        double radius = Math.sqrt(Math.pow((pointOnCircle.x) - theCenter.x, 2) + Math.pow(pointOnCircle.y - theCenter.y, 2));
        double z;
        double angle = 360.0 / sideNum;

        if (sideNum % 2 != 0)
            z = 90;
        else
            z = 90 - angle / 2;

        for (int i = 0; i < sideNum; i++) {
            points.add(new Point(theCenter.x + (int) (Math.cos(z / 180 * Math.PI) * radius),
                    theCenter.y - (int) (Math.sin(z / 180 * Math.PI) * radius)));
            z = z + angle;
        }
        return points;
    }

    @Override

    public void draw(Graphics2D g2d) {
        super.draw(g2d);
    }

    @Override
    public void move() {
// TODO implement here
    }

}