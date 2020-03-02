import javax.swing.*;

public class ColorGuesser {
    public static void main(String[] args) {
        ColorGuesserGUI gui = new ColorGuesserGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(400, 200);
        gui.setVisible(true);
    }
}
