import java.util.Random;

public class RandomNumber {
    private int ranNum;
    private int previousDifference;

    public RandomNumber() {
        ranNum = new Random().nextInt(1000) + 1; // generates a number between 1 and 1000
    }

    public String guess(String input) {
        int guessNum = 0, guessDifference;
        String output;
        try {
            guessNum = Integer.parseInt(input);
        }
        catch (NumberFormatException notInt) {

        }

        guessDifference = guessNum - ranNum;

        if (guessDifference < 0) {
            guessDifference = guessDifference * -1;
        }

        if (guessDifference <= previousDifference) { // check for going past for changing maybe?
            output = "warm";
        }
        else {
            output = "cold";
        }

        if (guessNum == ranNum) {
            output = "equal";
        }

        System.out.println(ranNum);

        previousDifference = guessDifference;
        return output;
    }
}
