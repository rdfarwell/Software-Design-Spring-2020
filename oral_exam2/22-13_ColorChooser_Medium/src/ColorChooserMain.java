import javax.swing.*;

public class ColorChooserMain {
        public static void main(String[] args) {
            ColorChooserGUI gui = new ColorChooserGUI();
            gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gui.setSize(1000,200);
            gui.setVisible(true);
        }
}
