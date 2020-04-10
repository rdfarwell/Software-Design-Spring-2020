/**
 * Class that creates a polymorhpic scoreboard object to control the backend of a scoreboard system
 *
 * @author Dean Farwell
 */
public abstract class Scoreboard {

    /**
     * Team 1
     */
    private Team team1;

    /**
     * Team 2
     */
    private Team team2;

    /**
     * Number of periods in the game
     */
    private int periods;

    /**
     * Current period of the game
     */
    private int currentPeriod = 1;

    /**
     * String Array of scoring methods for the game
     */
    private String[] scoringMethods;

    /**
     * Name of game specific period
     */
    private String periodName;

    /**
     * Length in minutes of the period
     */
    private int periodLength;

    /**
     * Constructor for Scoreboard to initialize names, number of periods, name of the period, length of the period,
     * and the scoring methods
     * @param team1Name Name of team 1
     * @param team2Name Name of team 2
     * @param periods Number of periods in the game
     * @param periodName Name of the period for the game
     * @param periodLength Length (in minutes) of the period
     * @param scoringMethods String Array of scoring methods for the game
     */
    public Scoreboard(String team1Name, String team2Name, int periods, String periodName, int periodLength, String[] scoringMethods) {
        team1 = new Team(team1Name);
        team2 = new Team(team2Name);
        this.periods = periods;
        this.periodName = periodName;
        this.periodLength = periodLength;
        this.scoringMethods = scoringMethods;
    }

    /**
     * Adds points to the corresponding team depending on scoring method given
     * @param points Number of points to add
     * @param team Which team gets the points
     * @param scoreMethod What scoring method gave them said score (to determine points)
     */
    public void addScore(int points, String team, String scoreMethod) {
        if (team.equals("1")) {
            team1.addScore(points);
        }
        else {
            team2.addScore(points);
        }
    }

    /**
     * Getter for team 1's name
     * @return Name of team 1
     */
    public String getTeam1() {
        return team1.getName();
    }

    /**
     * Getter for team 2's name
     * @return Name of team 2
     */
    public String getTeam2() {
        return team2.getName();
    }

    /**
     * Getter for team 1's score
     * @return Current score of team 1
     */
    public int getTeam1Score() {
        return team1.getScore();
    }

    /**
     * Getter for team 2's score
     * @return Current score of team 2
     */
    public int getTeam2Score() {
        return team2.getScore();
    }

    /**
     * Getter for scoring method of the current game
     * @return String array of scoring methods for the current game
     */
    public String[] getScoringMethods() {
        return scoringMethods;
    }

    /**
     * Getter for the length of the period in minutes
     * @return Length of period in minutes
     */
    public int getPeriodLength() {
        return periodLength;
    }

    /**
     * Ends the period by incrementing the current period by 1
     */
    public void endPeriod() {
        currentPeriod++;
    }

    /**
     * Getter for current period of the game
     * @return Current period
     */
    public int getCurrentPeriod() {
        return currentPeriod;
    }

    /**
     * Getter for the name of the period
     * @return Name of the period
     */
    public String getPeriodName() {
        return periodName;
    }

    /**
     * Starts the game by setting the current period to 1
     */
    public void startGame() {
        currentPeriod = 1;
    }

    /**
     * Checks if the game is over
     * @return Boolean if the game is over (true = game over)
     */
    public boolean gameOver() {
        return currentPeriod > periods;
    }

    /**
     * Gets the winning teams name
     * @return Name of the winning team
     */
    public String winningTeam() {
        if (team1.getScore() > team2.getScore()) {
            return team1.getName();
        }
        else {
            return team2.getName();
        }
    }
}
