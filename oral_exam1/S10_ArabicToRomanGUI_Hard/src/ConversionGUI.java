import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Class that controls the GUI and contains two text boxes
 *
 * @author Dean Farwell
 */
public class ConversionGUI extends JFrame {

    /**
     * Text field that takes in an arabic numeral for conversion or displays a converted roman numeral
     */
    private final JTextField arabicEntry;

    /**
     * Text field that takes in a roman numeral for conversion or displays a converted arabic numeral
     */
    private final JTextField romanEntry;

    /**
     * Constructor for the GUI object that creates labels and two text fields
     */
    public ConversionGUI() {
        super("Roman and Arabic Numeral Conversion");
        setLayout(new FlowLayout());

        JLabel inst = new JLabel("<html>Please enter an Arabic Numeral between 1 and 3999.<br>Please enter a valid Roman Numeral.<br>Invalid Entries will turn text boxes red and no output will display</html>");
        add(inst);

        JLabel a = new JLabel("Arabic Numeral");
        add(a);

        arabicEntry = new JTextField(17);
        add(arabicEntry);

        JLabel r = new JLabel("Roman Numeral");
        add(r);

        romanEntry = new JTextField(17);
        add(romanEntry);

        TextHandler handler = new TextHandler(); // add key listener to the two text boxes
        arabicEntry.addKeyListener(handler);
        romanEntry.addKeyListener(handler);
    }

    /**
     * Class within the GUI that listens for key movements and updates relevant information after each event
     */
    private class TextHandler implements KeyListener {
        /**
         * Necessary for class to not be abstract, unused
         * @param event A key is typed within the GUI
         */
        @Override
        public void keyTyped(KeyEvent event) {

        }

        /**
         * Necessary for class to not be abstract, unused
         * @param event A key is pressed within the GUI
         */
        @Override
        public void keyPressed(KeyEvent event) {

        }

        /**
         * Handles when a key is released and updates the arabic and roman text field upon each event.
         * Invalid entries make the boxes turn red and erase their converted text
         * @param event A key is released within the GUI
         */
        @Override
        public void keyReleased(KeyEvent event) {
            int out = 0;
            if (event.getSource() == arabicEntry) {
                try { // makes sure entry in arabic is an integer
                    out = Integer.parseInt(arabicEntry.getText());
                } catch (NumberFormatException formatIssue) { // any invalid entries turn text boxes red and erase conversion text
                    romanEntry.setText("");
                    arabicEntry.setBackground(Color.red);
                    romanEntry.setBackground(Color.red);
                }
                if (!ArabicToRoman.arabicCheck(out)) { // invalid entry, integer out of range
                    romanEntry.setText("");
                    arabicEntry.setBackground(Color.red);
                    romanEntry.setBackground(Color.red);
                }
                else { // displays converted arabic numeral roman entry box
                    romanEntry.setText(ArabicToRoman.aToR(out));
                    arabicEntry.setBackground(Color.white);
                    romanEntry.setBackground(Color.white);
                }
            }
            else if (event.getSource() == romanEntry) {
                if (!RomanToArabic.romanCheck(romanEntry.getText())) { // invalid entry, invalid roman numeral
                    arabicEntry.setText("");
                    arabicEntry.setBackground(Color.red);
                    romanEntry.setBackground(Color.red);
                }
                else { // displays converted Roman numeral in arabic entry box
                    arabicEntry.setText(Integer.toString(RomanToArabic.rToA(romanEntry.getText())));
                    arabicEntry.setBackground(Color.white);
                    romanEntry.setBackground(Color.white);
                }
            }
        }
    }
}
