import javax.swing.*;

public class ArabicRomanConversion {
    static final int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static final String[] letters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    static final char[] romanLetters = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};

    public static void main(String[] args) {

        ConversionGUI gui = new ConversionGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(400, 150);
        gui.setVisible(true);

    }

}
