import java.util.LinkedList;
import java.util.List;

public class AdvancedRound {

   LinkedList matches;
   LinkedList contestants;
   public AdvancedRound(LinkedList<Match> matches, LinkedList<IContestant> contestants){
      this.matches = matches;
      this.contestants = contestants;
   }

   public LinkedList getMatchWinners(){
      //returns all of the contestants that won each match in each round
   }

   public int getNumWinners(){
      //returns number of winners in round
   }
}
