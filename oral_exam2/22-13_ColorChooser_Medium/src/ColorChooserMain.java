import javax.swing.*;

public class ColorChooserMain {
        public static void main(String[] args) {
            JFrame frame = new JFrame("Color Chooser");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ColorChooserGUI gui = new ColorChooserGUI();
            frame.add(gui);
            frame.setSize(900,400);
            frame.setVisible(true);
        }
}
