package draws.lines;

import java.awt.*;

public class Ray extends Segment {

    public Ray(Point p1, Point p2) {
        super(p1, p2);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawOval(getTheCenter().x-3, getTheCenter().y-3, 6, 6);
        g2d.setColor(Color.red);
        g2d.fillOval(getTheCenter().x-3, getTheCenter().y-3, 6, 6);
        g2d.setColor(Color.black);
        int x1 = getTheCenter().x;
        int y1 = getTheCenter().y;
        int x2 = finishPoint.x;
        int y2 = finishPoint.y;
        int endX = 687;
        int endY = 635;
        int xResult = 0;
        int yResult = 0;
        if (x1 == x2){
            g2d.drawLine(x1, y1, x1, endY);
        }
        else if (y1 == y2){
            g2d.drawLine(x1, y1, endX, y1);
        }
        else{
            if (x2 > x1){
                if (y2 > y1){
                    xResult = (x1-x2)*(endY-y2)/(y1-y2)+x2;
                    yResult = (endX-x2)*(y1-y2)/(x1-x2)+y2;
                    if (xResult <= endX){
                        g2d.drawLine(x1, y1, xResult, endY);
                    }
                    else{
                        g2d.drawLine(x1, y1, endX, yResult);
                    }
                }
                else{
                    xResult = y2*(x2-x1)/(y1-y2)+x2;
                    yResult = (endX - x2)*(y1-y2)/(x1-x2)+y2;
                    if (xResult <= endX){
                        g2d.drawLine(x1, y1, xResult, 0);
                    }
                    else{
                        g2d.drawLine(x1, y1, endX, yResult);
                    }
                }
            }
            else{
                if (y2 > y1){
                    xResult = (x1-x2)*(endY-y2)/(y1-y2)+x2;
                    yResult = (y2-y1)*x2/(x1-x2)+y2;
                    if (xResult >= 0){
                        g2d.drawLine(x1, y1, xResult, endY);
                    }
                    else{
                        g2d.drawLine(x1, y1, 0, yResult);
                    }
                }
                else{
                    xResult = (x2-x1)*y2/(y1-y2)+x2;
                    yResult = (y2-y1)*x2/(x1-x2)+y2;
                    if (xResult >= 0){
                        g2d.drawLine(x1, y1, xResult, 0);
                    }
                    else{
                        g2d.drawLine(x1, y1, 0, yResult);
                    }
                }
            }
        }

    }

    @Override
    public void move() {
        // TODO implement here
    }

}