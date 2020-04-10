public class Hockey extends Scoreboard {
    public Hockey(String team1name, String team2Name) {
        super(team1name, team2Name, 3, "Period", 20, new String[] {"Goal"});
    }

    @Override
    public void addScore(int points, String team, String scoreMethod) {
        points = 1;

        super.addScore(points, team, scoreMethod);
    }
}
