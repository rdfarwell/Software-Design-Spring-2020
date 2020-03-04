import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class controls the main components of the GUI and is an extension of JFrame
 *
 * @author Dean Farwell
 * @see JFrame
 */
public class GuessNumberGUI extends JFrame {

    /**
     * A textfield that takes in the input from the user
     */
    private final JTextField guess;

    /**
     * A button that resets the guesser and random number when pressed
     */
    private final JButton button;

    /**
     * A label that changes based on input (Too high, Too low, Correct)
     */
    private final JLabel clue;

    /**
     * A RandomNumber object that generates a random number upon construction and is used to compare the guess input against
     */
    private RandomNumber randomNumber = new RandomNumber();

    /**
     * Constructor that takes in no inputs and gives the premises for a GUI created in GuessNumber
     */
    public GuessNumberGUI() {
        super("Color Guesser");
        setLayout(new FlowLayout());

        JLabel prompt = new JLabel("Please enter a number between 1 and 1000");
        add(prompt);

        guess = new JTextField(5);
        add(guess);

        button = new JButton("Restart");
        add(button);

        clue = new JLabel("");
        add(clue);

        ActionHandler handler = new ActionHandler(); //creates a handler object and adds them to the two action objects
        guess.addActionListener(handler);
        button.addActionListener(handler);
    }

    /**
     * Class that implements an action listener that takes in the guess input and checks it, and changes the background
     * based on randomNumber guess return
     */
    private class ActionHandler implements ActionListener {

        /**
         * Method that listens for actions from the guess textfield and button button and changes background color
         * depending on inputs
         * @param event Reports when an action is performed on a GUI object
         */
        @Override
        public void actionPerformed(ActionEvent event) {

            String outcome = "";

            if (event.getSource() == guess) {

                outcome = randomNumber.guess(guess.getText()); // checks the guess against the randomNumber

                if (randomNumber.getPreviousDifference() < 0) { // checks if the guess is too high or too low
                    clue.setText("Too low");
                }
                else {
                    clue.setText("Too High");
                }

                if (outcome.equals("warm")) { // checks the output of RandomNumber.guess to see if the guess is warmer or colder
                    getContentPane().setBackground(Color.red);
                }
                else if (outcome.equals("cold")) {
                    getContentPane().setBackground(Color.blue);
                }
                else if (outcome.equals("equal")) { // game is done
                    getContentPane().setBackground(Color.green);
                    clue.setText("Correct!");
                    guess.setEditable(false);
                }
                else { // Non-expected entry
                    guess.setText("");
                    clue.setText("Invalid Entry");
                    getContentPane().setBackground(Color.yellow);
                }
            }
            else if (event.getSource() == button) { // resets the game if the button is pressed
                getContentPane().setBackground(Color.white);
                guess.setEditable(true);
                guess.setText("");
                clue.setText("");
                randomNumber = new RandomNumber();
            }
        }
    }
}
