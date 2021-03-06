/**
 * Extension of Scoreboard for Soccer that sets the proper parameters and overrides addScore
 *
 * @author Dean Farwell
 * @see Scoreboard
 */
public class Soccer extends Scoreboard{

    /**
     * Constructor that initializes the proper variables of Scoreboard for a game of Soccer
     * @param team1name Name of team 1
     * @param team2Name Name of team 2
     */
    public Soccer(String team1name, String team2Name) {
        super(team1name, team2Name, 2, "Half", 45, new String[] {"Goal"});
    }

    /**
     * Overrides addScore of Scoreboard to give the correct amount of points based on scoring method
     * @param points Number of points to add
     * @param team Which team gets the points
     * @param scoreMethod What scoring method gave them said score (to determine points)
     */
    @Override
    public void addScore(int points, String team, String scoreMethod) {
        points = 1;

        super.addScore(points, team, scoreMethod);
    }
}
