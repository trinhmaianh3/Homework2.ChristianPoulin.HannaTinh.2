import static org.junit.Assert.*;
import org.junit.Test;


public class Examples {
    public Examples() {}


        SoccerTeam soccer1 = new SoccerTeam("WPI", "Crimson Gray", false, 6, 4);
        SoccerTeam soccer2 = new SoccerTeam("MIT", "Red", false, 9, 1);
        SoccerResult soccerResult1 = new SoccerResult(soccer1, soccer2, 150, 160);
        SoccerResult soccerResult2 = new SoccerResult(soccer1, soccer2, 149, 147);
        SoccerResult soccerResult3 = new SoccerResult(soccer1, soccer2, 180, 165);
        SoccerResult soccerResult4 = new SoccerResult(soccer1, soccer2, 120, 130);

        LegoRobotTeam legoRobotTeam1 = new LegoRobotTeam("WPI", "Goats", 8);
        LegoRobotTeam legoRobotTeam2 = new LegoRobotTeam("MIT", "Beaver", 10);
        LegoRobotResult lrResult1 = new LegoRobotResult(legoRobotTeam1, legoRobotTeam2, 16.0, 7,
                true, 15.0, 7, true);
        LegoRobotResult lrResult2 = new LegoRobotResult(legoRobotTeam1, legoRobotTeam2, 8.0, 17,
                false, 8.0, 18, false);
        LegoRobotResult lrResult3 = new LegoRobotResult(legoRobotTeam1, legoRobotTeam2, 7.1, 18,
                true, 7.0, 1, true);
        LegoRobotResult lrResult4 = new LegoRobotResult(legoRobotTeam1, legoRobotTeam2, 5, 15,
                true, 9, 12, true);
        LegoRobotResult lrResult5 = new LegoRobotResult(legoRobotTeam1, legoRobotTeam2, 5.6, 3,
                true, 12.5, 3, true);

        //test isValid()
        @Test
        public void testIsValid(){
            //Edgecases:
            assertTrue(soccerResult2.isValid());
            assertFalse(soccerResult1.isValid());

            assertTrue(lrResult1.isValid());
            assertFalse(lrResult2.isValid());

            //Normal Test cases:
            assertFalse(soccerResult3.isValid());
            assertTrue(soccerResult4.isValid());

            assertFalse(lrResult3.isValid()); //Tests false case for teampoints
            assertFalse(lrResult4.isValid()); //Tests false case for teamtasks
            assertTrue(lrResult5.isValid());
        }

        //test getScore()

    @Test
    public void getScore() {
        assertEquals(lrResult1.getScore(lrResult1.team1points, lrResult1.team1tasks, lrResult1.team1fell),
                18.9, .01);

        assertEquals(lrResult2.getScore(lrResult2.team2points, lrResult2.team2tasks, lrResult2.team2fell),
                25.0, .01);
    }

    //test getWinner()
    @Test
    public void testGetWinner(){ //try this
        assertEquals(soccerResult1.getWinner(), soccer2);
        assertEquals(soccerResult2.getWinner(), soccer1);
        assertEquals(soccerResult3.getWinner(), soccer1);
        assertEquals(soccerResult4.getWinner(), soccer2);


        assertEquals(lrResult1.getWinner(), legoRobotTeam1);
        assertEquals(lrResult2.getWinner(), legoRobotTeam2);
        assertEquals(lrResult3.getWinner(), legoRobotTeam1);
        assertEquals(lrResult4.getWinner(), legoRobotTeam2);
        assertEquals(lrResult5.getWinner(), legoRobotTeam2);

    }

    //test winner()

    Match sMatch1 = new Match(soccer1, soccer2, soccerResult1);
    Match sMatch2 = new Match(soccer1, soccer2, soccerResult2);
    Match sMatch3 = new Match(soccer1, soccer2, soccerResult4);

    Match lrMatch2 = new Match(legoRobotTeam1, legoRobotTeam2, lrResult1);
    Match lrMatch1 = new Match(legoRobotTeam1, legoRobotTeam2, lrResult2);
    Match lrMatch3 = new Match(legoRobotTeam1, legoRobotTeam2, lrResult5);

    @Test
    public void testWinner(){
        assertEquals(sMatch1.winner(), null);
        assertEquals(sMatch2.winner(), soccer1);
        assertEquals(sMatch3.winner(), soccer2);


        assertEquals(lrMatch1.winner(), null);
        assertEquals(lrMatch2.winner(), legoRobotTeam1);
        assertEquals(lrMatch3.winner(), legoRobotTeam2);
    }

    //test expectToBeat()
    SoccerTeam soccer3 = new SoccerTeam("Penn State", "Yellow", true, 10, 2);
    SoccerTeam soccer4 = new SoccerTeam("UCLA", "Blue", false, 5, 7);
    SoccerTeam soccer5 = new SoccerTeam("Lowell", "Red", true, 11, 1);

    @Test
    public void testExpectToBeat(){
        //Edgecases:
        assertTrue(legoRobotTeam2.expectToBeat(legoRobotTeam1)); //legoTeam1 wins
        assertFalse(soccer1.expectToBeat(soccer2)); //soccer2 wins

        assertTrue(soccer3.expectToBeat(soccer4)); //Compares Ritual
        assertFalse(soccer3.expectToBeat(soccer5)); //Compares Ritual

        assertFalse(legoRobotTeam1.expectToBeat(legoRobotTeam2));

    }


}