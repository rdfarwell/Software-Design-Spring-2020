public class Basketball extends Scoreboard {
    public Basketball(String team1name, String team2Name) {
        super(team1name, team2Name, 4, "Quarter", 12, new String[] {"2-Point Basket", "3-Point Basket", "Free Throw"});
    }

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
