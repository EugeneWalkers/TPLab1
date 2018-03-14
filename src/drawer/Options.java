package drawer;

import javax.swing.*;
import java.awt.*;

public class Options extends JPanel {
    public static JRadioButton dr = new JRadioButton("Draw");
    public static JRadioButton mov = new JRadioButton("Move");

    public static JButton getPen() {
        return pen;
    }

    public static void setPen(JButton pen) {
        Options.pen = pen;
    }

    public static JButton getFill() {
        return fill;
    }

    public static void setFill(JButton fill) {
        Options.fill = fill;
    }

    static private JButton pen = new JButton();
    static private JButton fill = new JButton();

    static final private Integer[] widths = {1, 2, 3, 4, 5};

    public static int getPenWidth() {
        return widths[width.getSelectedIndex()];
    }

    static private JComboBox<Integer> width;

    public static JButton getClear() {
        return clear;
    }

    private static JButton clear = new JButton("Clear");
    public Options(){
        super();
        ButtonGroup whatToDo = new ButtonGroup();
        whatToDo.add(dr);
        whatToDo.add(mov);
        dr.setSelected(true);
        setButtons();
        addComponents();
        setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2), Color.black));
    }

    public void addComponents(){
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 10, 5, 0);
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.2;
        c.weighty = 0.5;
        add(dr, c);
        c.gridy = 1;
        add(mov, c);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(10, 5, 5, 10);
        c.weightx = 0.2;
        c.gridx = 1;
        c.gridy = 0;
        add(pen, c);
        c.insets = new Insets(5, 5, 10, 10);
        c.gridy = 1;
        add(fill, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 5, 5, 10);
        c.weightx = 0.6;
        c.gridx = 2;
        c.gridy = 0;
        add(clear, c);
        c.gridy = 1;
        c.insets = new Insets(5, 5, 10, 10);
        add(width, c);
    }

    public void setButtons(){
        pen.setBackground(Color.black);
        pen.addActionListener(e ->{
            pen.setBackground(JColorChooser.showDialog(null, "choose pen color", Color.black));
        } );
        fill.setBackground(Color.white);
        fill.addActionListener(e -> {
            fill.setBackground(JColorChooser.showDialog(null, "choose fill color", Color.white));
        });
        width = new JComboBox<>(widths);
    }

}
