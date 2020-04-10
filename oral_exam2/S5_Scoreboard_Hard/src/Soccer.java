public class Soccer extends Scoreboard{
    public Soccer(String team1name, String team2Name) {
        super(team1name, team2Name, 2, "Half", 45, new String[] {"Goal"});
    }

    @Override
    public void addScore(int points, String team, String scoreMethod) {
        points = 1;

        super.addScore(points, team, scoreMethod);
    }
}
