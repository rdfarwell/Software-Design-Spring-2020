/**
 * Extension of Scoreboard for Basketball that sets the proper parameters and overrides addScore
 *
 * @author Dean Farwell
 * @see Scoreboard
 */
public class Basketball extends Scoreboard {

    /**
     * Constructor that initializes the proper variables of Scoreboard for a game of Basketball
     * @param team1name Name of team 1
     * @param team2Name Name of team 2
     */
    public Basketball(String team1name, String team2Name) {
        super(team1name, team2Name, 4, "Quarter", 12, new String[] {"2-Point Basket", "3-Point Basket", "Free Throw"});
    }

    /**
     * Overrides addScore of Scoreboard to give the correct amount of points based on scoring method
     * @param points Number of points to add
     * @param team Which team gets the points
     * @param scoreMethod What scoring method gave them said score (to determine points)
     */
    @Override
    public void addScore(int points, String team, String scoreMethod) {
        if (scoreMethod.equals("2-Point Basket")) {
            points = 2;
        }
        else if (scoreMethod.equals("3-Point Basket")) {
            points = 3;
        }
        else {
            points = 1;
        }

        super.addScore(points, team, scoreMethod);
    }
}
