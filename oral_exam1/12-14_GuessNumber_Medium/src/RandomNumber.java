import java.util.Random;

/**
 * Class that generates a random number and handles the guesses against it. Also saves relative information regarding
 * the most recent guess against the random number
 *
 * @author Dean Farwell
 */
public class RandomNumber {

    /**
     * A random number generated during construction
     */
    private int ranNum;

    /**
     * Saves the most recent difference between the guess and the random number (positive or negative)
     */
    private int previousDifference;

    /**
     * Saves the most recent distance between the guess and the random number (positive)
     */
    private int previousDistance;

    /**
     * Constructor that generates a new random integer between 1 and 1000 upon creation
     */
    public RandomNumber() {
        ranNum = new Random().nextInt(1000) + 1; // generates a number between 1 and 1000
    }

    /**
     * Getter for ranNum
     * @return Private integer ranNum
     */
    public int getRanNum() {
        return ranNum;
    }

    /**
     * Getter for previousDifference
     * @return Private integer previousDifference
     */
    public int getPreviousDifference() {
        return previousDifference;
    }

    /**
     * Setter for previousDifference
     * @param diff Difference between a guess and randomNum (+/-)
     */
    public void setPreviousDifference(int diff) {
        previousDifference = diff;
    }

    /**
     * Getter for previousDistance
     * @return Private integer previousDistance
     */
    public int getPreviousDistance() {
        return previousDistance;
    }

    /**
     * Setter for previousDistance
     * @param dist Distance between a guess and randomNum (+)
     */
    public void setPreviousDistance(int dist) {
        previousDistance = dist;
    }

    /**
     * Takes a guess from the user and updates the guesses' distance and difference from the random number
     * @param input Guess from the user
     * @return A string that is a comparison between a new difference and the most previous one (warm, cold, equal)
     */
    public String guess(String input) {

        int guessNum = 0, guessDifference, guessDistance; // temporary containers
        String output; // output String

        // Tries to convert the input String into an integer
        try {
            guessNum = Integer.parseInt(input);
        }
        catch (NumberFormatException notInt) { // Non-integer entry, returns empty string (handled by GuessNumberGUI
            return "";
        }

        guessDifference = guessNum - getRanNum(); // finds the difference and distance from the guess
        guessDistance = guessDifference;

        if (guessDistance < 0) { // distance is treated as always positive, this converts it if necessary
            guessDistance = guessDistance * -1;
        }

        if (guessDistance <= getPreviousDistance()) { // if new guess is closer than last, warmer
            output = "warm";
        }
        else { // else colder
            output = "cold";
        }

        if (guessNum == getRanNum()) {
            output = "equal";
        }

        //System.out.println(getRanNum()); // used to speed up debugging

        setPreviousDifference(guessDifference); // saves the current guess differences for use next time around
        setPreviousDistance(guessDistance);

        return output;
    }
}
