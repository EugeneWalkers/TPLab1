package draws.flatfigures.polygons;

import drawer.Options;
import draws.Figure;
import draws.flatfigures.FlatFigure;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Polygon extends FlatFigure {

    public Polygon(Point[] p) {
        this();
        arrayOfPoints = new ArrayList(Arrays.asList(p));
        arrayOfPoints.add(arrayOfPoints.get(0));
    }
    public Polygon(ArrayList<Point>pp){
        this();
        arrayOfPoints = pp;
        arrayOfPoints.add(arrayOfPoints.get(0));
    }

    public Polygon(){
        super();
    }

    public  ArrayList<Point> getArrayOfPoints() {
        return arrayOfPoints;
    }

    private ArrayList<Point> arrayOfPoints;

    public Polygon(Point p1, Point p2, Point... p) {
        this();
        arrayOfPoints = new ArrayList(Arrays.asList(p));
        arrayOfPoints.add(0, p2);
        arrayOfPoints.add(0, p1);
        arrayOfPoints.add(p1);
        setTheCenter(p1);
    }

    @Override
    public void draw(Graphics2D g2d) {
        int nPoints = arrayOfPoints.size();
        int[] xPoints = new int[nPoints];
        int[] yPoints = new int[nPoints];
        for (int i=0; i<arrayOfPoints.size(); i++){
            xPoints[i]=arrayOfPoints.get(i).x;
            yPoints[i]=arrayOfPoints.get(i).y;
        }
        g2d.setColor(getFillColor());
        g2d.fillPolygon(xPoints, yPoints, nPoints);
        g2d.setStroke(new BasicStroke(getPenWidth()));
        g2d.setColor(getPenColor());
        g2d.drawPolygon(xPoints, yPoints, nPoints);
        g2d.setStroke(new BasicStroke(1));
        for (int i=0; i<arrayOfPoints.size(); i++){
            g2d.setColor(Color.black);
            g2d.setStroke(new BasicStroke(1));
            g2d.drawOval(arrayOfPoints.get(i).x-2, arrayOfPoints.get(i).y-2,4, 4);
            g2d.setColor(Color.blue);
            g2d.fillOval(arrayOfPoints.get(i).x-2, arrayOfPoints.get(i).y-2,4, 4);
        }
        g2d.setColor(Color.black);
        g2d.drawOval(this.getTheCenter().x - 3, this.getTheCenter().y - 3, 6, 6);
        g2d.setColor(Color.red);
        g2d.fillOval(this.getTheCenter().x - 3, this.getTheCenter().y - 3, 6, 6);
    }

    @Override
    public void move() {
        // TODO implement here
    }

}