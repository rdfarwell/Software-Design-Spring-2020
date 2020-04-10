/**
 * Extension of Scoreboard for Football that sets the proper parameters and overrides addScore
 *
 * @author Dean Farwell
 * @see Scoreboard
 */
public class Football extends Scoreboard{

    /**
     * Constructor that initializes the proper variables of Scoreboard for a game of Football
     * @param team1name Name of team 1
     * @param team2Name Name of team 2
     */
    public Football(String team1name, String team2Name) {
        super(team1name, team2Name, 4, "Quarter", 15, new String[] {"Touchdown", "Extra Point", "Two-Point Conversion", "Field Goal", "Safety"});
    }

    /**
     * Overrides addScore of Scoreboard to give the correct amount of points based on scoring method
     * @param points Number of points to add
     * @param team Which team gets the points
     * @param scoreMethod What scoring method gave them said score (to determine points)
     */
    @Override
    public void addScore(int points, String team, String scoreMethod) {
        if (scoreMethod.equals("Touchdown")) {
            points = 6;
        }
        else if (scoreMethod.equals("Extra Point")) {
            points = 1;
        }
        else if (scoreMethod.equals("Field Goal")) {
            points = 3;
        }
        else {
            points = 2;
        }

        super.addScore(points, team, scoreMethod);
    }
}
