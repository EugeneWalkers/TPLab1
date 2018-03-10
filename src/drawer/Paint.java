package drawer;

import draws.Figure;
import draws.flatfigures.circles.Circle;
import draws.flatfigures.circles.Ellipse;
import draws.flatfigures.polygons.npolygons.RegularNPolygon;
import draws.flatfigures.polygons.npolygons.Star;
import draws.flatfigures.polygons.quadrilaterals.Diamond;
import draws.flatfigures.polygons.quadrilaterals.Parallelogram;
import draws.flatfigures.polygons.quadrilaterals.Rectangle;
import draws.flatfigures.polygons.triangles.IsoscelesRectangularTriangle;
import draws.flatfigures.polygons.triangles.IsoscelesTriangle;
import draws.flatfigures.polygons.triangles.RectangularTriangle;
import draws.lines.Line;
import draws.lines.Ray;
import draws.lines.Segment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;

public class Paint extends JLabel {

    int counter = -1;
    int k = -1;
    ArrayList<Point> points = new ArrayList<>();

    public Paint(){
        super();
        setOpaque(true);
        setCursor(Cursor.getPredefinedCursor(1));
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.out.println(2);
                points.add(new Point(e.getX(), e.getY()));
                //points.add(e.getPoint());
                System.out.println(counter);
                if (points.size() == counter){
                    switch(k){
                        case 0:
                            new Line(points.get(0), points.get(1));
                            break;
                        case 1:
                            new Ray(points.get(0), points.get(1));
                            break;
                        case 2:
                            new Segment(points.get(0), points.get(1));
                            break;
                        case 3:
                            new Star(points.get(0), points.get(1));
                            break;
                        case 4:
                            new Parallelogram(points.get(0), points.get(1), points.get(2));
                            break;
                        case 5:
                            new Rectangle(points.get(0), points.get(1), points.get(2));
                            break;
                        case 6:
                            Point p1 = points.get(0), p2 = points.get(1), p3 = points.get(2);
//                            if((p1.x-p3.x)*(p1.x-p3.x)+(p1.y-p3.y)*(p1.y-p3.y)<(p2.x-p3.x)*(p2.x-p3.x)+(p2.y-p3.y)*(p2.y-p3.y)){
//                                Point temp=p1;
//                                p1=p2;
//                                p2=temp;
//                            }
//                            if((p3.y-p2.y)*(p2.y-p1.y)+(p2.x-p1.x)*(p3.x-p2.x) == 0){
//                                Point temp = p2;
//                                p2=p3;
//                                p3=temp;
//                            }
//                            int a32 = p3.x - p2.x;
//                            int a21square = p2.x*p2.x - p1.x*p1.x;
//                            int b21square = p2.y*p2.y-p1.y*p1.y;
//                            int b21 = p2.y-p1.y;
//                            int b32 = p3.y-p2.y;
//                            int a21 = p2.x-p1.x;
//                            int x3 = Math.round((a32*a21square + a32*b21square + 2*p2.x*b32*b21-2*p2.y*b21*a32)/(2*(b32*b21+a21*a32)));
//                            int y3=Math.round((x3*b32/a32-p2.x*b32)/a32+p2.y);
//                            Point p32 = new Point(x3, y3);

//                            int a = p1.x-p2.x;
//                            int b = p1.x+p2.x-2*p3.x;
//                            int c = p1.y-p2.y;
//                            p3.y = (a*b)/(2*c);
                            int a11 = p2.x-p1.x;
                            int a12 = p2.y-p1.y;
                            int c1 = (-a11*(p2.x+p1.x) - a12*(p2.y+p1.y))/2;
                            int c2 = p3.y*a11 - p3.x*a12;
                            int x = (c2*a12 + c1*a11)/(-a12*a12 - a11*a11);
                            int y = (c2*a11-c1*a12)/(a12*a12-a11*a11);
                            Window.getFigures().add(new Diamond(p1, p2, new Point(x, y)));
                            break;
                        case 7:
                            new Ellipse(points.get(0), points.get(1), points.get(2));
                            break;
                        case 8:
                            new Circle(points.get(0), points.get(1));
                            break;
                        case 9:
                            new Polygon();
                            break;
                        case 10:
                            new RegularNPolygon();
                            break;
                        case 11:
                            new IsoscelesTriangle();
                            break;
                        case 12:
                            //new RectangularTriangle();
                            break;
                        case 13:
                            //new IsoscelesRectangularTriangle();
                            break;
                        default: break;
                    }
                    points.clear();
                    repaint();
                    if (k > 3){
                        counter = 3;
                    }
                    else {
                        counter = 2;
                    }

//
//                    buttons.add(new JRadioButton("Circle"));
//                    buttons.add(new JRadioButton("Polygon"));
//                    buttons.add(new JRadioButton("Regular Polygon"));
//                    buttons.add(new JRadioButton("Isosceless Triangle"));
//                    buttons.add(new JRadioButton("Rectangular Triangle"));
//                    buttons.add(new JRadioButton("Isosceless Rectangular Triangle"));
                }
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                System.out.println(3);
            }

            @Override
            public void mouseDragged(MouseEvent e){
                super.mouseDragged(e);
                System.out.println(e.getPoint());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                System.out.println(4);
                k = -1;
                for (int i=0; i<Tools.buttons.size(); i++){
                    if (Tools.buttons.get(i).isSelected()){
                        k = i;
                        break;
                    }
                }
                if (k > 3){
                    counter = 3;
                }
                else {
                    counter = 2;
                }

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                System.out.println(5);
            }

        });
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        LinkedList<Figure> figures = Window.getFigures();
        for (int i=0; i<figures.size(); i++){
            figures.get(i).draw(g2d);
        }
    }

}
