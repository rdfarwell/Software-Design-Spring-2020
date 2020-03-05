import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ConversionGUI extends JFrame {
    private final JTextField arabicEntry;
    private final JTextField romanEntry;

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

        TextHandler handler = new TextHandler();
        arabicEntry.addKeyListener(handler);
        romanEntry.addKeyListener(handler);
    }

    private class TextHandler implements KeyListener {
        @Override
        public void keyTyped(KeyEvent event) {

        }

        @Override
        public void keyPressed(KeyEvent event) {

        }

        @Override
        public void keyReleased(KeyEvent event) {
            String output = "";
            int out = 0;
            if (event.getSource() == arabicEntry) {
                try {
                    out = Integer.parseInt(arabicEntry.getText());
                } catch (NumberFormatException formatIssue) {
                    romanEntry.setText("");
                    arabicEntry.setBackground(Color.red);
                    romanEntry.setBackground(Color.red);
                }
                if (!ArabicToRoman.arabicCheck(out)) {
                    romanEntry.setText("");
                    arabicEntry.setBackground(Color.red);
                    romanEntry.setBackground(Color.red);
                }
                else {
                    romanEntry.setText(ArabicToRoman.aToR(out));
                    arabicEntry.setBackground(Color.white);
                    romanEntry.setBackground(Color.white);
                }
            }
            else if (event.getSource() == romanEntry) {
                if (!RomanToArabic.romanCheck(romanEntry.getText())) {
                    arabicEntry.setText("");
                    arabicEntry.setBackground(Color.red);
                    romanEntry.setBackground(Color.red);
                }
                else {
                    arabicEntry.setText(Integer.toString(RomanToArabic.rToA(romanEntry.getText())));
                    arabicEntry.setBackground(Color.white);
                    romanEntry.setBackground(Color.white);
                }
            }
        }
    }
}
