import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String team1, team2, choice = "0";
        Scoreboard scoreboard;
        int x, choiceNum = 0;
        boolean valid = true;

        Scanner scnr = new Scanner(System.in);

        while (choice.equals("0")) {
            System.out.println("Please select a game type:");
            System.out.println("1. Football");
            System.out.println("2. Basketball");
            System.out.println("3. Soccer");
            System.out.println("4. Hockey");
            System.out.println("Enter Choice:");
            choice = scnr.nextLine().trim();

            if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4")) {
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

        while (!scoreboard.gameOver()) {
            System.out.println(scoreboard.getPeriodName() + ": " + scoreboard.getCurrentPeriod());
            System.out.println(scoreboard.getTeam1() + " - " + scoreboard.getTeam1Score());
            System.out.println(scoreboard.getTeam2() + " - " + scoreboard.getTeam2Score());
            x = 1;
            System.out.println("Menu:");
            for (String scoringMethod : scoreboard.getScoringMethods()) {
                System.out.println(x + ": " + scoreboard.getTeam1() + " " + scoringMethod);
                x++;
            }
            for (String scoringMethod : scoreboard.getScoringMethods()) {
                System.out.println(x + ": " + scoreboard.getTeam2() + " " + scoringMethod);
                x++;
            }
            System.out.println(x + ": End " + scoreboard.getPeriodName());
            choice = scnr.nextLine().trim();

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

                if (scoreboard.gameOver()) {
                    System.out.println("Game Over!");

                    if (scoreboard.getTeam1Score() > scoreboard.getTeam2Score()) {
                        System.out.println(scoreboard.getTeam1() + " wins!");
                    }
                    else if (scoreboard.getTeam1Score() < scoreboard.getTeam2Score()) {
                        System.out.println(scoreboard.getTeam2() + " wins!");
                    }
                    else {
                        System.out.println("It's a tie!");
                    }

                    System.out.println(scoreboard.getTeam1() + " - " + scoreboard.getTeam1Score());
                    System.out.println(scoreboard.getTeam2() + " - " + scoreboard.getTeam2Score());
                }
            }
            else {
                System.out.println("Invalid Entry");
            }



        }



    }
}
