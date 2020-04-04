public class Team {

    private String name;
    private int score;

    public Team(String name) {
        this.name = name;
        score = 0;
    }

    public void addScore(int points) {
        score += points;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}
