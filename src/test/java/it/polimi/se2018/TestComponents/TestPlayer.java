package it.polimi.se2018.TestComponents;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Components.DiceColor;
import it.polimi.se2018.server.model.Components.Player;
import  org.junit.Test;


import java.util.ArrayList;

public class TestPlayer {
    @Test
    public void testConstructor() {
        Player player = new Player();
        //assertEquals("Buonasera", player.getPlayerName());
    }

    @Test
    public void testSet() {
        Player player = new Player();
        PrivateObjectiveCard privateCard = new PrivateObjectiveCard(DiceColor.BLUE);
        int tokens = 6;
        int finalPoints = 110;
        int privatePoints = 34;
        PatternCard pattern = new PatternCard();
        ArrayList<PatternCard> patternCards = new ArrayList<>();
        patternCards.add(pattern);
        //try {

            ArrayList<PatternCard> patternList = pattern.loadPatternList();
            pattern = patternList.get(4);
        /*} catch (FileNotFoundException e) {
            fail();
        }*/
        player.setPattern(pattern);
        player.setPrivate(privateCard);
        player.setTokensNumber(tokens);
        player.setFinalPoints(finalPoints);
        player.setPrivatePoints(privatePoints);
        player.setPlayerID(2);
        player.setPlayerName("Dario");
        player.setDisconnect(true);
        player.setPatterChooseList(patternCards);


        assertEquals(pattern, player.getPattern());
        assertEquals(privateCard, player.getPrivate());
        assertEquals(6, player.getTokensNumber());
        assertEquals(finalPoints, player.getFinalPoints());
        assertEquals(privatePoints, player.getPrivatePoints());
        assertEquals(2, player.getPlayerID());
        assertEquals("Dario", player.getPlayerName());
        assertEquals(patternCards, player.getPatterChooseList());
        assertEquals(true, player.isDisconnect());
    }



    @Test
    public void testRunningP() {
        Player player = new Player();
        player.setRunningP(true);
        assertTrue(player.isRunningP());
    }

    @Test
    public void testToString(){


        int ID = 1;

        Player player1 = new Player();
        player1.setPlayerID(ID);
        player1.setPrivate(new PrivateObjectiveCard(DiceColor.RED));
        player1.setTokensNumber(6);
        //player1.setFinalPoints(61);
        System.out.println(player1.toString());
    }

    @Test
    public void testToStringPoints() {
        Player player = new Player();
        player.setPlayerName("ciao");
        player.setFinalPoints(32);

        System.out.println(player.toStringPoints());
    }
}

