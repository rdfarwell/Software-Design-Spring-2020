import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class controls the main components of the gui by extension of a JPanel so we can
 * draw a rectangle.
 *
 * @author Dean Farwell
 * @see JPanel
 */
public class ColorChooserGUI extends JPanel {

    /**
     * A textfield for the user to set or read red's value
     */
    private final JTextField red;

    /**
     * A textfield for the user to set or read green's value
     */
    private final JTextField green;

    /**
     * A textfield for the user to set or read blue's value
     */
    private final JTextField blue;

    /**
     * A Slider for the user to set or read red's value
     */
    private final JSlider redSlide;

    /**
     * A Slider for the user to set or read green's value
     */
    private final JSlider greenSlide;

    /**
     * A Slider for the user to set or read blue's value
     */
    private final JSlider blueSlide;

    /**
     * An int that stores the value of red set by the user
     */
    private int r;

    /**
     * An int that stores the value of green set by the user
     */
    private int g;

    /**
     * An int that stores the value of blue set by the user
     */
    private int b;

    /**
     * A color object that stores the color of the rectangle and sets it
     */
    private Color customColor = new Color(255, 0, 0);

    /**
     * Paint method of JPanel overridden to draw a rectangle, uses customColor
     * @param g Graphics object that is passively passed
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(customColor);
        g.fillRect(100, 100, 600, 200);
    }

    /**
     * Constructor that creates the GUI that the user interacts with to change RGB values of a rectangle
     */
    public ColorChooserGUI() {
        JLabel redLabel = new JLabel("Red");
        add(redLabel);

        red = new JTextField(3);
        red.setText("255");
        add(red);

        redSlide = new JSlider(JSlider.HORIZONTAL, 0, 255, 255);
        add(redSlide);

        JLabel greenLabel = new JLabel("Green");
        add(greenLabel);

        green = new JTextField(3);
        green.setText("0");
        add(green);

        greenSlide = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        add(greenSlide);

        JLabel blueLabel = new JLabel("Blue");
        add(blueLabel);

        blue = new JTextField(3);
        blue.setText("0");
        add(blue);

        blueSlide = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        add(blueSlide);

        // ActionHandler looks for entries to the text boxes
        ActionHandler handler = new ActionHandler();
        red.addActionListener(handler);
        green.addActionListener(handler);
        blue.addActionListener(handler);

        // ChangeHandler looks for movement of the slider
        ChangeHandler change = new ChangeHandler();
        redSlide.addChangeListener(change);
        greenSlide.addChangeListener(change);
        blueSlide.addChangeListener(change);

    }

    /**
     * Class that implements ActionListener to look for entries in the text box, it will then update the slider and
     * color values of the rectangle.
     */
    private class ActionHandler implements ActionListener {

        /**
         * When an action is performed on a text box, the actionPerformed will update the value of the corresponding
         * slider and RBG value
         * @param event ActionEvent that has occurred in a specific place (Enter in a text box)
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == red) {
                redSlide.setValue(Integer.parseInt(red.getText().trim()));
                r = Integer.parseInt(red.getText().trim());
            }
            else if (event.getSource() == green) {
                greenSlide.setValue(Integer.parseInt(green.getText().trim()));
                g = Integer.parseInt(green.getText().trim());
            }
            else if (event.getSource() == blue) {
                blueSlide.setValue(Integer.parseInt(blue.getText().trim()));
                b = Integer.parseInt(blue.getText().trim());
            }

            customColor = new Color(r, g, b); // updates the Color object with new color values
            ColorChooserGUI.super.repaint(); // calls repaint to change color of rectangle
        }
    }

    /**
     * Class that implements ChangeListener to look for updates to the slider, it will then update the text box and
     * color values of the rectangle.
     */
    private class ChangeHandler implements ChangeListener {

        /**
         * When a change is detected on a slider, the stateChanged will update the value of the corresponding
         * text box and RBG value
         * @param event ChangeEvent that has occurred in a specific place (Slider moved)
         */
        @Override
        public void stateChanged(ChangeEvent event) {
            if (event.getSource() == redSlide) {
                red.setText(Integer.toString(redSlide.getValue()));
                r = redSlide.getValue();
            }
            else if (event.getSource() == greenSlide) {
                green.setText(Integer.toString(greenSlide.getValue()));
                g = greenSlide.getValue();
            }
            else if (event.getSource() == blueSlide) {
                blue.setText(Integer.toString(blueSlide.getValue()));
                b = blueSlide.getValue();
            }

            customColor = new Color(r, g, b); // updates the Color object with new color values
            ColorChooserGUI.super.repaint(); // calls repaint to change color of rectangle
        }
    }
}
