package drawer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Tools extends JPanel {


    static ArrayList<JRadioButtons> buttons = new ArrayList<>();

    public Tools(){
        super();
        buttons.add(new JRadioButtons("Line", 2));
        buttons.add(new JRadioButtons("Ray", 2));
        buttons.add(new JRadioButtons("Segment", 2));
        buttons.add(new JRadioButtons("Star", 2));
        buttons.add(new JRadioButtons("Regular Polygon", 2));
        buttons.add(new JRadioButtons("Rectangle", 3));
        buttons.add(new JRadioButtons("Diamond", 3));
        buttons.add(new JRadioButtons("Ellipse", 3));
        buttons.add(new JRadioButtons("Circle", 2));
        buttons.add(new JRadioButtons("Polygon", 3));
        buttons.add(new JRadioButtons("Parallelogramm", 3));
        buttons.add(new JRadioButtons("Isosceless Triangle", 3));
        buttons.add(new JRadioButtons("Rectangular Triangle", 3));
        buttons.add(new JRadioButtons("Isosceless Rectangular Triangle", 3));
        buttons.add(new JRadioButtons("Broken Line", 3));
        addComponents();
        setClicks();
        setBorder(BorderFactory.createLineBorder(Color.BLUE));
    }

    public void addComponents(){
        setLayout(new GridLayout(0, 1));
        ButtonGroup bg = new ButtonGroup();
        buttons.get(0).getButton().setSelected(true);
        for (int i =0; i < buttons.size(); i++){
            bg.add(buttons.get(i).getButton());
            add(buttons.get(i).getButton());
        }
    }

    public void setClicks(){
        ClickerListener listener = new ClickerListener();
        for(int i=0; i<buttons.size(); i++){
            buttons.get(i).getButton().addActionListener(listener);
        }
    }
}
