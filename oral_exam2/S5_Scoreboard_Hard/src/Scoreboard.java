public abstract class Scoreboard {

    private Team team1;
    private Team team2;
    private int periods;
    private String[] scoringMethods;


    public Scoreboard(String team1Name, String team2Name, int periods) {
        team1 = new Team(team1Name);
        team2 = new Team(team2Name);
        this.periods = periods;
    }

    public void addScore(int points, String team) {
        if (team.equals("1")) {
            team1.addScore(points);
        }
        else {
            team2.addScore(points);
        }
    }

    public String getTeam1() {
        return team1.getName();
    }

    public String getTeam2() {
        return team2.getName();
    }

    public int getTeam1Score() {
        return team1.getScore();
    }

    public int getTeam2Score() {
        return team2.getScore();
    }
}
