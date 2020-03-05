import javax.swing.*;

/**
 * Main class for the Arabic and Roman Conversion Interface. Creates the GUI object
 *
 * @author Dean Farwell
 */
public class ArabicRomanConversion {

    /**
     * Array of each arabic number that has a specific Roman numeral tied to it
     */
    static final int[] NUMS = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    /**
     * Array of each Roman numeral that has a specific arabic numeral tied to it
     */
    static final String[] LETTERS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    /**
     * Every Roman Numeral
     */
    static final char[] ROMAN_LETTERS = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};

    /**
     * Main method of the Arabic and Roman conversion. creates a gui object and displays it
     * @param args Standard for all main methods
     */
    public static void main(String[] args) {

        ConversionGUI gui = new ConversionGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(400, 150);
        gui.setVisible(true);

    }

}
