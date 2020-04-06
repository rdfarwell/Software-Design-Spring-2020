import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String team1, team2, choice = "0";
        Scoreboard scoreboard;
        int x;

        Scanner scnr = new Scanner(System.in);

        while (choice.equals("0")) {
            System.out.println("Please select a game type:");
            System.out.println("1. Football");
            System.out.println("2. Baseball");
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

//        if (choice.equals("1")) {
            scoreboard = new Football(team1, team2);
//        }
//        else if (choice.equals("2")) {
//            scoreboard = new Basketball(team1,team2);
//        }
//        else if (choice.equals("3")) {
//            scoreboard = new Soccer(team1, team2);
//        }
//        else {
//            scoreboard = new Hockey(team1, team2);
//        }

        while (!scoreboard.gameOver()) {
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
            if (choice.equals(Integer.toString(x))) {
                scoreboard.endPeriod();

            }



        }



    }
}
