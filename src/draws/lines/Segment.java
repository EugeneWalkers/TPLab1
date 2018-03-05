package draws.lines;

import draws.Figure;

import java.awt.*;

public class Segment extends Figure {

    private Point finishPoint;

    public Segment(Point p1, Point p2) {
        setTheCenter(new Point((p1.x + p2.x)/2,(p1.y+p2.y)/2));
        finishPoint = p2;
    }

    @Override
    public void draw(Graphics2D g2d) {

    }

    public void move() {
        // TODO implement here
    }



    public Point getFinishPoint() {
        return finishPoint;
    }

    public void setFinishPoint(Point finishPoint) {
        this.finishPoint = finishPoint;
    }

}