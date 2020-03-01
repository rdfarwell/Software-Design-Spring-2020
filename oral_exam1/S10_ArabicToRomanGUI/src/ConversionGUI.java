import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ConversionGUI extends JFrame {
    private final JTextField arabicEntry;
    private final JTextField romanEntry;

    public ConversionGUI() {
        super("Roman and Arabic Numeral Conversion");
        setLayout(new FlowLayout());

        JLabel a = new JLabel("Please enter an integer between 1 and 3999");
        add(a);

        arabicEntry = new JTextField(10);
        add(arabicEntry);

        JLabel r = new JLabel("Please enter a Valid Roman numeral");
        add(r);

        romanEntry = new JTextField(10);
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
                    romanEntry.setText("N");
                }
                if (!ArabicToRoman.arabicCheck(out)) {
                    romanEntry.setText("N");
                }
                else {
                    romanEntry.setText(ArabicToRoman.aToR(out));
                }
            }
            else if (event.getSource() == romanEntry) {
                if (RomanToArabic.romanCheck(romanEntry.getText())) {
                    arabicEntry.setText("N");
                }
                else {
                    arabicEntry.setText(Integer.toString(RomanToArabic.rToA(romanEntry.getText())));
                }
            }
        }
    }
}
