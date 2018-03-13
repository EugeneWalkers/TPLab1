package draws.lines;

import drawer.Options;
import draws.Figure;

import java.awt.*;

public class Ray extends Segment {

    public Ray(Point p1, Point p2) {
        super(p1, p2);
        setTheCenter(p1);
        arrayOfPoints.add(p1);
        finishPoint = p2;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(getPenColor());
        g2d.setStroke(new BasicStroke(getPenWidth()));
        int x1 = getTheCenter().x;
        int y1 = getTheCenter().y;
        int x2 = finishPoint.x;
        int y2 = finishPoint.y;
        int endX = 687;
        int endY = 635;
        int xResult = 0;
        int yResult = 0;
        Point resultPoint;
        if (x1 == x2){
            resultPoint = new Point(x1, endY);
        }
        else if (y1 == y2){
            resultPoint = new Point(endX, y1);
        }
        else{
            if (x2 > x1){
                if (y2 > y1){
                    xResult = (x1-x2)*(endY-y2)/(y1-y2)+x2;
                    yResult = (endX-x2)*(y1-y2)/(x1-x2)+y2;
                    if (xResult <= endX){
                        resultPoint = new Point(xResult, endY);
                    }
                    else{
                        resultPoint = new Point(endX, yResult);
                    }
                }
                else{
                    xResult = y2*(x2-x1)/(y1-y2)+x2;
                    yResult = (endX - x2)*(y1-y2)/(x1-x2)+y2;
                    if (xResult <= endX){
                        resultPoint = new Point(xResult, 0);
                    }
                    else{
                        resultPoint = new Point(endX, yResult);
                    }
                }
            }
            else{
                if (y2 > y1){
                    xResult = (x1-x2)*(endY-y2)/(y1-y2)+x2;
                    yResult = (y2-y1)*x2/(x1-x2)+y2;
                    if (xResult >= 0){
                        resultPoint = new Point(xResult, endY);
                    }
                    else{
                        resultPoint = new Point(0, yResult);
                    }
                }
                else{
                    xResult = (x2-x1)*y2/(y1-y2)+x2;
                    yResult = (y2-y1)*x2/(x1-x2)+y2;
                    if (xResult >= 0){
                        resultPoint = new Point(xResult, 0);
                    }
                    else{
                        resultPoint = new Point(0, yResult);
                    }
                }
            }
        }
        arrayOfPoints.add(resultPoint);
        g2d.drawLine(x1, y1, resultPoint.x, resultPoint.y);
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.red);
        g2d.fillOval(getTheCenter().x-3, getTheCenter().y-3, 6, 6);
        g2d.setColor(Color.black);
        g2d.drawOval(getTheCenter().x-3, getTheCenter().y-3, 6, 6);
    }

    @Override
    public void move(Point endPoint) {
        super.move(endPoint);
    }

}