import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean ended = false;
        String team1, team2, choice;
        Scoreboard scoreboard;

        Scanner scnr = new Scanner(System.in);

        System.out.println("Please select a game type:");
        System.out.println("1. Football");
        System.out.println("2. Baseball");
        System.out.println("3. Soccer");
        System.out.println("4. Hockey");
        System.out.println("Enter Choice:");
        choice = scnr.nextLine();

        System.out.println("Enter Team 1: ");
        team1 = scnr.nextLine();
        System.out.println("Enter Team 2: ");
        team2 = scnr.nextLine();

        if (choice.equals("1")) {
            scoreboard = new Football(team1, team2);
        }

        while (!ended) {
            System.out.println("Menu:");


            ended = true;

        }



    }
}
