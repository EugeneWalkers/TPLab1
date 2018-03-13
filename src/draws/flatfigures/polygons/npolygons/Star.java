package draws.flatfigures.polygons.npolygons;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Star extends RegularNPolygon{

    int N;
    public Star(Point p1, Point p2, int n){

        super(Star.getStarPoints(p1,p2,n));
        setTheCenter(p1);

    }

    private static ArrayList<Point> getCentralStarPoints(ArrayList<Point>outPoints, int sideNum){
        ArrayList<Point>res=new ArrayList<>();
        //res.add(outPoints.get(0));
        for(int i=0;i<sideNum;i++){
            res.add(outPoints.get(i+1));
            double a20=outPoints.get(i+2).x-outPoints.get(i).x;
            double a31=outPoints.get(i+3).x-outPoints.get(i+1).x;
            double b20=outPoints.get(i+2).y-outPoints.get(i).y;
            double b31=outPoints.get(i+3).y-outPoints.get(i+1).y;
            double xi=outPoints.get(i).x;
            double xi1=outPoints.get(i+1).x;
            double yi=outPoints.get(i).y;
            double yi1=outPoints.get(i+1).y;
            double y;
            double x;
            if(b20==0){
                x = (xi * b20 * a31 - xi1 * b31 * a20 + (yi1 - yi) * a20 * a31) / (b20 * a31 - b31 * a20);
                y = x * b20 / a20 - yi * b20 / a20 + yi;
            }
            else {
                y = (yi * a20 * b31 - yi1 * a31 * b20 + (xi1 - xi) * b20 * b31) / (a20 * b31 - a31 * b20);
                x = y * a20 / b20 - yi * a20 / b20 + xi;
            }
            res.add(new Point((int)Math.round(x),(int)Math.round(y)));
        }
        return res;
    }
    private static ArrayList<Point> getStarPoints(Point theCenter, Point pointOnCircle, int sideNum) {
        ArrayList<Point> points = new ArrayList<>(sideNum + 1);

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
        points.add(points.get(0));
        points.add(points.get(1));
        points.add(points.get(2));
        //points.add(points.get(3));
        System.out.println(points);
        return getCentralStarPoints(points,sideNum);
    }
    @Override
    public void draw(Graphics2D g2d) {
        super.draw(g2d);

    }

    @Override
    public void move(Point endPoint){
        super.move(endPoint);
    }

}
