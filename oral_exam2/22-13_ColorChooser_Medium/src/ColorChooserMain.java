import javax.swing.*;

/**
 * Class that creates a JFrame object and adds a JPanel from ColorChooserGUI to display and change the RGB values of
 * a rectangle.
 *
 * @author Dean Farwell
 */
public class ColorChooserMain {

    /**
     * Main method to run the entire program
     * @param args String of arguments necessary for Java
     */
        public static void main(String[] args) {
            JFrame frame = new JFrame("Color Chooser");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ColorChooserGUI gui = new ColorChooserGUI();
            frame.add(gui);
            frame.setSize(900,400);
            frame.setVisible(true);
        }
}
