public abstract class Scoreboard {

    private Team team1;
    private Team team2;
    private int periods;
    private int currentPeriod = 1;
    private String[] scoringMethods;
    private String periodName;
    private int periodLength;


    public Scoreboard(String team1Name, String team2Name, int periods, String periodName, int periodLength, String[] scoringMethods) {
        team1 = new Team(team1Name);
        team2 = new Team(team2Name);
        this.periods = periods;
        this.periodName = periodName;
        this.periodLength = periodLength;
        this.scoringMethods = scoringMethods;
    }

    public void addScore(int points, String team, String scoreMethod) {
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

    public String[] getScoringMethods() {
        return scoringMethods;
    }

    public int getPeriodLength() {
        return periodLength;
    }

    public void endPeriod() {
        currentPeriod++;
    }

    public int getCurrentPeriod() {
        return currentPeriod;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void startGame() {
        currentPeriod = 1;
    }

    public boolean gameOver() {
        return currentPeriod > periods;
    }

    public String winningTeam() {
        if (team1.getScore() > team2.getScore()) {
            return team1.getName();
        }
        else {
            return team2.getName();
        }
    }
}
