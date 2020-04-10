/**
 * Class Team that creates an object that has a name and score tied to it
 *
 * @author Dean Farwell
 */
public class Team {

    /**
     * Name of the team
     */
    private String name;

    /**
     * Score of the team
     */
    private int score;

    /**
     * Constructor for Team that sets the name as given and score to 0.
     * @param name String that is the name of the team
     */
    public Team(String name) {
        this.name = name;
        score = 0;
    }

    /**
     * Adds passed points to the teams total
     * @param points Integer value of points scored
     */
    public void addScore(int points) {
        score += points;
    }

    /**
     * Getter for the score
     * @return Integer score of the team
     */
    public int getScore() {
        return score;
    }

    /**
     * Getter for the name
     * @return String name of the team
     */
    public String getName() {
        return name;
    }
}
