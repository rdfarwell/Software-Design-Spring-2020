import java.util.Scanner;


/**
 * This program controls a scoreboard interface for a user to select a game type and run a scoreboard for that game.
 *
 * @author Dean Farwell
 */
public class Main {

    /**
     * Main method for the class
     * @param args String of arguments needed by Java
     */
    public static void main(String[] args) {

        String team1, team2, choice = "0"; // team names and users choice
        Scoreboard scoreboard;
        int x, choiceNum = 0; // x is used for output of the scoreboard options, choiceNum is user input converted to int
        boolean valid; // if user input is valid

        Scanner scnr = new Scanner(System.in);

        while (choice.equals("0")) { // 0 is an assigned value when the user's choice is not valid
            System.out.println("Please select a game type:");
            System.out.println("1. Football");
            System.out.println("2. Basketball");
            System.out.println("3. Soccer");
            System.out.println("4. Hockey");
            System.out.println("Enter Choice:");
            choice = scnr.nextLine().trim();

            if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4")) { // checks if choice is invalid
                choice = "0";
                System.out.println("Invalid Entry");
            }
        }

        System.out.println("Enter Team 1:");
        team1 = scnr.nextLine().trim();
        System.out.println("Enter Team 2:");
        team2 = scnr.nextLine().trim();

        if (choice.equals("1")) {
            scoreboard = new Football(team1, team2);
        }
        else if (choice.equals("2")) {
            scoreboard = new Basketball(team1,team2);
        }
        else if (choice.equals("3")) {
            scoreboard = new Soccer(team1, team2);
        }
        else {
            scoreboard = new Hockey(team1, team2);
        }

        scoreboard.startGame();

        while (!scoreboard.gameOver()) { // checks when the game is over to signal the end of the scoreboard
            System.out.println(scoreboard.getPeriodName() + ": " + scoreboard.getCurrentPeriod()); // output current game-specific period
            System.out.println(scoreboard.getTeam1() + " - " + scoreboard.getTeam1Score()); // output teams and scores
            System.out.println(scoreboard.getTeam2() + " - " + scoreboard.getTeam2Score());

            x = 1;
            System.out.println("Menu:");

            for (String scoringMethod : scoreboard.getScoringMethods()) { // gives an option for each scoring method for team 1
                System.out.println(x + ": " + scoreboard.getTeam1() + " " + scoringMethod);
                x++;
            }
            for (String scoringMethod : scoreboard.getScoringMethods()) {  // gives an option for each scoring method for team 2
                System.out.println(x + ": " + scoreboard.getTeam2() + " " + scoringMethod);
                x++;
            }

            System.out.println(x + ": End " + scoreboard.getPeriodName()); // gives option to end period
            choice = scnr.nextLine().trim(); // gets user input

            // check for valid input
            try {
                choiceNum = Integer.parseInt(choice);
                valid = (choiceNum >= 1 && choiceNum <= x);
            }
            catch (NumberFormatException notANum) {
                valid = false;
            }


            if (valid) {
                if (choiceNum <= ((x-1)/2)) { // team1
                    scoreboard.addScore(0, "1", scoreboard.getScoringMethods()[choiceNum-1]);
                }
                else if (choiceNum > ((x-1)/2) && choiceNum != x) { // team2
                    scoreboard.addScore(0, "2", scoreboard.getScoringMethods()[choiceNum-((x-1)/2)-1]);
                }
                else {
                    scoreboard.endPeriod();
                }

                if (scoreboard.gameOver()) { // Game Over message
                    System.out.println("Game Over!");

                    if (scoreboard.getTeam1Score() == scoreboard.getTeam2Score()) { // check for tie
                        System.out.println("It's a tie!");
                    }
                    else { // give winning team
                        System.out.println(scoreboard.winningTeam() + " wins!");
                    }

                    // final score
                    System.out.println(scoreboard.getTeam1() + " - " + scoreboard.getTeam1Score());
                    System.out.println(scoreboard.getTeam2() + " - " + scoreboard.getTeam2Score());
                }
            }
            else { // user notice of invalid entry
                System.out.println("Invalid Entry");
            }

        }



    }
}
