public class SoccerResult implements IResult{

    SoccerTeam team1;
    SoccerTeam team2;
    double team1points;
    double team2points;
    SoccerResult(SoccerTeam team1, SoccerTeam team2, double team1points, double team2point) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1points = team1points;
        this.team2points = team2point;
    }


    public boolean isValid(){
        if((this.team1points < 150) && (this.team2points < 150))
            return true;
        else
            return false;
    }

    public SoccerTeam getWinner() {
            if (this.team1points > team2points)
               return this.team1;
            else
                return this.team2;

    }

}
