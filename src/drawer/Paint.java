package drawer;

import draws.Figure;
import draws.Circle;
import draws.Ellipse;
import draws.Polygon;
import draws.RegularNPolygon;
import draws.Star;
import draws.Diamond;
import draws.Parallelogram;
import draws.Rectangle;
import draws.IsoscelesRectangularTriangle;
import draws.IsoscelesTriangle;
import draws.RectangularTriangle;
import draws.BrokenLine;
import draws.Line;
import draws.Ray;
import draws.Segment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;

public class Paint extends JLabel {

    static int counter = -1;
    int k = -1;
    static ArrayList<Point> points = new ArrayList<>();
    int ourFigure;
    boolean isMovingRightNow = false;
    int N = 3;

    public Paint() {
        super();
        Options.getClear().addActionListener(e -> {
            Window.getFigures().clear();
            Paint.points.clear();
            repaint();
        });
        setOpaque(true);
        setBackground(Color.white);
        setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2), Color.black));
        addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (Options.dr.isSelected()) {
                    if (k == 9 || k == 14) {
                        counter = N;
                    }
                    points.add(new Point(e.getX(), e.getY()));
                    if (points.size() == counter) {
                        Point p1 = points.get(0);
                        Point p2 = points.get(1);
                        Point p3 = new Point();
                        if (Tools.buttons.get(k).getCountOfClicks() > 2) {
                            p3 = points.get(2);
                        }
                        switch (k) {
                            case 0:
                                Window.getFigures().add(new Line(p1, p2));
                                break;
                            case 1:
                                Window.getFigures().add(new Ray(p1, p2));
                                break;
                            case 2:
                                Window.getFigures().add(new Segment(p1, p2));
                                break;
                            case 3:
                                String temp = JOptionPane.showInputDialog(null, "Введите количество углов:");
                                if ("".equals(temp)) {
                                    N = 3;
                                } else {
                                    N = Math.max(3, Integer.parseInt(temp));
                                }
                                Window.getFigures().add(new Star(p1, p2, N));
                                break;
                            case 4:
                                temp = JOptionPane.showInputDialog(null, "Введите количество углов:");
                                if ("".equals(temp)) {
                                    N = 3;
                                } else {
                                    N = Math.max(3, Integer.parseInt(temp));
                                }
                                Window.getFigures().add(new RegularNPolygon(p1, p2, N));
                                break;
                            case 5:
                                Window.getFigures().add(Rectangle.createRectangle(p1,p2,p3));
                                break;
                            case 6:

                                Window.getFigures().add(Diamond.createDiamond(p1,p2,p3));
                                break;
                            case 7:
                                Window.getFigures().add(new Ellipse(p1, p2, p3));
                                break;
                            case 8:
                                Window.getFigures().add(new Circle(p1, p2));
                                break;
                            case 9:
                                Window.getFigures().add(new Polygon(new ArrayList<>(points)));
                                break;
                            case 10:
                                Window.getFigures().add(new Parallelogram(p1, p2, p3));
                                break;
                            case 11:
                                Window.getFigures().add(IsoscelesTriangle.createIsoscelesTriangle(p1, p2, p3));
                                break;
                            case 12:
                                Window.getFigures().add(RectangularTriangle.createRetangulaTriangle(p1,p2,p3));
                                break;
                            case 13:
                                Window.getFigures().add(IsoscelesRectangularTriangle.createIsoscelesRectangularTriangle(p1, p2, p3));
                                break;
                            case 14:
                                Window.getFigures().add(new BrokenLine(new ArrayList<>(points)));
                                break;
                            default:
                                break;
                        }
                        points.clear();
                        repaint();
                        counter = Tools.buttons.get(k).getCountOfClicks();
                    }
                } else if (Options.mov.isSelected()) {
                    Point p = new Point(e.getX(), e.getY());
                    for (int i = 0; i < Window.getFigures().size(); i++) {
                        if (getDistance(p, Window.getFigures().get(i).getTheCenter()) <= 4) {
                            ourFigure = i;
                            isMovingRightNow = true;
                            break;
                        }
                    }
                }
            }

            private double getDistance(Point p1, Point p2) {
                return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (Options.dr.isSelected()) {

                } else if (Options.mov.isSelected()) {
                    if (isMovingRightNow) {
                        Point newCenter = new Point(e.getX(), e.getY());
                        Window.getFigures().get(ourFigure).move(newCenter);
                        ourFigure = -1;
                        isMovingRightNow = false;
                        repaint();
                    }

                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (Options.dr.isSelected()) {
                    setCursor(Cursor.getPredefinedCursor(1));
                    k = -1;
                    for (int i = 0; i < Tools.buttons.size(); i++) {
                        if (Tools.buttons.get(i).getButton().isSelected()) {
                            k = i;
                            break;
                        }
                    }
                    if (k == 9 || k == 14) {
                        String numb = JOptionPane.showInputDialog(null, "Введите количество углов:");
                        if (numb != null) {
                            if ("".equals(numb)) {
                                counter = N = 3;
                            } else {
                                counter = N = Math.max(3, Integer.parseInt(numb));
                            }
                        } else {
                            counter = -1;
                        }
                    } else {
                        counter = Tools.buttons.get(k).getCountOfClicks();
                    }
                } else if (Options.mov.isSelected()) {
                    setCursor(Cursor.getDefaultCursor());
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                k = -1;
                for (int i = 0; i < Tools.buttons.size(); i++) {
                    if (Tools.buttons.get(i).getButton().isSelected()) {
                        k = i;
                        break;
                    }
                }
                if (k == 9) {
                    counter = N;
                } else {
                    counter = Tools.buttons.get(k).getCountOfClicks();
                }
            }

        });

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        LinkedList<Figure> figures = Window.getFigures();
        for (int i = 0; i < figures.size(); i++) {
            figures.get(i).draw(g2d);
        }

    }

}