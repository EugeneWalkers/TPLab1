package draws;

import java.awt.*;
import java.util.ArrayList;

public class BrokenLine extends Segment {

    public BrokenLine(ArrayList<Point> pp) {
        super();
        arrayOfPoints = pp;
        setTheCenter(arrayOfPoints.get(0));
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(getPenWidth()));
        for (int i = 0; i < arrayOfPoints.size() - 1; i++) {
            g2d.setColor(getPenColor());
            g2d.drawLine(arrayOfPoints.get(i).x, arrayOfPoints.get(i).y, arrayOfPoints.get(i + 1).x, arrayOfPoints.get(i + 1).y);
            g2d.setColor(Color.black);
            g2d.drawOval(arrayOfPoints.get(i).x - 2, arrayOfPoints.get(i).y - 2, 4, 4);
            g2d.drawOval(arrayOfPoints.get(i + 1).x - 2, arrayOfPoints.get(i + 1).y - 2, 4, 4);
            g2d.setColor(Color.blue);
            g2d.fillOval(arrayOfPoints.get(i).x - 2, arrayOfPoints.get(i).y - 2, 4, 4);
            g2d.fillOval(arrayOfPoints.get(i + 1).x - 2, arrayOfPoints.get(i + 1).y - 2, 4, 4);
        }
        g2d.setColor(Color.black);
        g2d.setStroke(new BasicStroke(1));
        g2d.drawOval(getTheCenter().x - 3, getTheCenter().y - 3, 6, 6);
        g2d.setColor(Color.red);
        g2d.fillOval(getTheCenter().x - 3, getTheCenter().y - 3, 6, 6);
    }

    @Override
    public void move(Point endPoint) {
        super.move(endPoint);
    }
}