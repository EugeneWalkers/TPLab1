package draws;

import java.awt.*;
import java.util.ArrayList;

public class Ellipse extends FlatFigure {

    /*int x;
    int y;*/
    int width;

    //@Override
    /*public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }*/

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    int height;
    public Ellipse(Point p1, Point p2, Point p3) {
        super();
        setTheCenter(p1);
        //y=p1.y;
        width=Math.abs(p2.x-p1.x);
        height=Math.abs(p3.y-p1.y);
        setTheCenter(new Point (p1.x/*+width/2*/, p1.y/*+height/2)*/));
        arrayOfPoints=new ArrayList<>();
        arrayOfPoints.add(new Point (p1.x/*+width/2*/, p1.y/*+height/2*/));
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(getFillColor());
        g2d.fillOval(getTheCenter().x-width,getTheCenter().y-height,width*2,height*2);
        g2d.setColor(getPenColor());
        g2d.setStroke(new BasicStroke(getPenWidth()));
        g2d.drawOval(getTheCenter().x-width,getTheCenter().y-height,width*2,height*2);
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.black);
        g2d.drawOval(this.getTheCenter().x - 3, this.getTheCenter().y - 3, 6, 6);
        g2d.setColor(Color.red);
        g2d.fillOval(this.getTheCenter().x - 3, this.getTheCenter().y - 3, 6, 6);
    }

    @Override
    public void move(Point endPoint) {
        super.move(endPoint);
    }

}