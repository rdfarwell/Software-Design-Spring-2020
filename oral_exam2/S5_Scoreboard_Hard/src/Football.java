public class Football extends Scoreboard{
    public Football(String team1name, String team2Name) {
        super(team1name, team2Name, 4, "Quarter", 15, new String[] {"Touchdown", "Extra Point", "Two-Point Conversion", "Field Goal", "Safety"});
    }

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
