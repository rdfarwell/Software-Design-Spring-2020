import javax.swing.*;

/**
 * Main class of GuessNumber. This class creates a GUI object and displays it.
 *
 * @author Dean Farwell
 */
public class GuessNumber {

    /**
     * Main method that calls the GuessNumberGUI and sets its parameters
     * @param args Standard for all main java methods
     */
    public static void main(String[] args) {
        GuessNumberGUI gui = new GuessNumberGUI(); // creates a new GuessNumberGUI object
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(400, 200);
        gui.setVisible(true);
    }
}
