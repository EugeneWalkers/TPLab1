package draws.flatfigures.circles;

import java.awt.*;

public class Circle extends Ellipse {

    public Circle(Point center, Point second) {

        super(center, new Point(center.x+(int)Math.round(Math.sqrt((second.y-center.y)*(second.y-center.y) + (second.x-center.x)*(second.x-center.x))),center.y), new Point(center.x,center.y+(int)Math.round(Math.sqrt((second.y-center.y)*(second.y-center.y) + (second.x-center.x)*(second.x-center.x)))));

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