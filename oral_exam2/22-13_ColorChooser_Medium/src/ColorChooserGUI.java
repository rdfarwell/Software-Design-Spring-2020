import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChooserGUI extends JFrame {

    private final JTextField red;
    private final JTextField green;
    private final JTextField blue;
    private final JSlider redSlide;
    private final JSlider greenSlide;
    private final JSlider blueSlide;
    // private final JPanel color;

    public ColorChooserGUI() {
        super("Color Chooser");
        setLayout(new FlowLayout());

        JLabel redLabel = new JLabel("Red");
        add(redLabel);

        red = new JTextField(3);
        add(red);

        redSlide = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        add(redSlide);

        JLabel greenLabel = new JLabel("Green");
        add(greenLabel);

        green = new JTextField(3);
        add(green);

        greenSlide = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        add(greenSlide);

        JLabel blueLabel = new JLabel("Blue");
        add(blueLabel);

        blue = new JTextField(3);
        add(blue);

        blueSlide = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        add(blueSlide);

        ActionHandler handler = new ActionHandler();
        red.addActionListener(handler);
        green.addActionListener(handler);
        blue.addActionListener(handler);

        ChangeHandler change = new ChangeHandler();
        redSlide.addChangeListener(change);
        greenSlide.addChangeListener(change);
        blueSlide.addChangeListener(change);

//        color = new JPanel();
//        color.paintComponents(color.getGraphics());
//        color.getGraphics().setColor(Color.red);
//        color.getGraphics().fillRect(100, 100, 200, 100);
//        add(color);

    }

    private class ActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == red) {
                redSlide.setValue(Integer.parseInt(red.getText().trim()));
            }
            else if (event.getSource() == green) {
                greenSlide.setValue(Integer.parseInt(green.getText().trim()));
            }
            else if (event.getSource() == blue) {
                blueSlide.setValue(Integer.parseInt(blue.getText().trim()));
            }
        }
    }

    private class ChangeHandler implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent event) {
            if (event.getSource() == redSlide) {
                red.setText(Integer.toString(redSlide.getValue()));
            }
            else if (event.getSource() == greenSlide) {
                green.setText(Integer.toString(greenSlide.getValue()));
            }
            else if (event.getSource() == blueSlide) {
                blue.setText(Integer.toString(blueSlide.getValue()));
            }
        }
    }

//    public class Rectangle extends JPanel {
//
//        public void paintComponent(Graphics g) { //, int red, int blue, int green
//            super.paintComponent(g);
//
//            g.setColor(Color.red); //red, green, blue
//            g.fillRect(100, 100, 90, 60);
//        }
//    }


}
