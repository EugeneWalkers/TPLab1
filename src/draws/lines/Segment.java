package draws.lines;

import drawer.Options;
import draws.Figure;

import java.awt.*;

public class Segment extends Figure {

    protected Point finishPoint;

    public Segment() {
        setPenColor(Options.getPen().getBackground());
        setPenWidth(Options.getPenWidth());
    }

    public Segment(Point p1, Point p2) {
        this();
        setTheCenter(new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2));
        arrayOfPoints.add(p1);
        arrayOfPoints.add(p2);
        finishPoint = p2;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(getPenWidth()));
        g2d.setColor(getPenColor());
        g2d.drawLine(arrayOfPoints.get(0).x, arrayOfPoints.get(0).y, arrayOfPoints.get(1).x, arrayOfPoints.get(1).y);
        g2d.setColor(Color.black);
        g2d.setStroke(new BasicStroke(1));
        g2d.drawOval(getTheCenter().x - 3, getTheCenter().y - 3, 6, 6);
        g2d.setColor(Color.red);
        g2d.fillOval(getTheCenter().x - 3, getTheCenter().y - 3, 6, 6);
        g2d.setColor(Color.black);
        g2d.drawOval(arrayOfPoints.get(0).x - 2, arrayOfPoints.get(0).y - 2, 4, 4);
        g2d.drawOval(arrayOfPoints.get(1).x - 2, arrayOfPoints.get(1).y - 2, 4, 4);
        g2d.setColor(Color.blue);
        g2d.fillOval(arrayOfPoints.get(0).x - 2, arrayOfPoints.get(0).y - 2, 4, 4);
        g2d.fillOval(arrayOfPoints.get(1).x - 2, arrayOfPoints.get(1).y - 2, 4, 4);
    }

    @Override
    public void move(Point endPoint) {
        Point oldCenter = getTheCenter();
        int dx = endPoint.x - oldCenter.x;
        int dy = endPoint.y - oldCenter.y;
        for (int i = 0; i < getArrayOfPoints().size(); i++) {
            getArrayOfPoints().get(i).x += dx;
            getArrayOfPoints().get(i).y += dy;
        }
        setTheCenter(endPoint);
    }


    public Point getFinishPoint() {
        return finishPoint;
    }

    public void setFinishPoint(Point finishPoint) {
        this.finishPoint = finishPoint;
    }

}