import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorGuesserGUI extends JFrame {
    private final JTextField guess;
    private RandomNumber randomNumber = new RandomNumber();

    public ColorGuesserGUI() {
        super("Color Guesser");
        setLayout(new FlowLayout());

        JLabel prompt = new JLabel("Please enter a number between 1 and 1000");
        add(prompt);

        guess = new JTextField(5);
        add(guess);

        TextHandler handler = new TextHandler();
        guess.addActionListener(handler);
    }

    private class TextHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            String outcome = "";

            if (event.getSource() == guess) {
                outcome = randomNumber.guess(guess.getText());
                if (outcome.equals("warm")) {
                    getContentPane().setBackground(Color.red);
                }
                else if (outcome.equals("cold")) {
                    getContentPane().setBackground(Color.blue);
                }
                else if (outcome.equals("equal")) {
                    getContentPane().setBackground(Color.green);
                    guess.setEditable(false);
                }
            }
        }
    }
}
