import javax.swing.*;

public class SoccerTeam implements IContestant {

    String school;
    String color;
    boolean ritual;
    int wins;
    int losses;
    IContestant contestant;

    public SoccerTeam (String school, String color, boolean ritual, int wins, int losses){
        this.school = school;
        this.color = color;
        this.ritual = ritual;
        this.wins = wins;
        this.losses = losses;
    }

    public boolean expectToBeat(SoccerTeam contestant) {

            if ((this.ritual && contestant.ritual) || (!this.ritual && !contestant.ritual)){
                if((this.wins - this.losses) > (contestant.wins - contestant.losses))
                    return true;//the team has a bigger difference of W:L so they are to win
                else
                    return false;//the team has a smaller difference or the same so they are to lose
            }
            else
                if(this.ritual)//the team is expected to win if they are the ones with the ritual
                    return true;
                else //the team is expected to lose if the passed in team has a ritual
                    return false;
    }
}
