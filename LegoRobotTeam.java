public class LegoRobotTeam implements IContestant {

    String school;
    String name;
    int previousScore;
    IContestant contestant;

    public LegoRobotTeam (String school, String name, int previousScore){
        this.school = school;
        this.name = name;
        this.previousScore = previousScore;
    }

    public boolean expectToBeat(LegoRobotTeam contestant) {

        if (this.previousScore < contestant.previousScore)
            return false;//the team is expected to lose against passed in team
        else
            return true;//the team is expected to win against the passed in team

    }

}

