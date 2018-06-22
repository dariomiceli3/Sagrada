package it.polimi.se2018.TestComponents;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Components.DiceColor;
import it.polimi.se2018.server.model.Components.Player;
import it.polimi.se2018.server.model.Components.PlayerColour;
import  org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TestPlayer {
    @Test
    public void testConstructor() {
        String ID = "Buonasera";
        Player player = new Player(ID, PlayerColour.BLUE);
        assertEquals("Buonasera", player.getPlayerName());
        assertEquals(PlayerColour.BLUE, player.getColour());
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
        try {

            ArrayList<PatternCard> patternList = pattern.loadPatternList();
            pattern = patternList.get(4);
        } catch (FileNotFoundException e) {
            fail();
        }
        player.setPattern(pattern);
        player.setPrivate(privateCard);
        player.setTokensNumber(tokens);
        player.setFinalPoints(finalPoints);
        player.setPrivatePoints(privatePoints);
        player.setPlayerID(2);
        player.setPlayerName("Dario");
        player.setPlayerColor(PlayerColour.RED);
        player.setOff(true);
        player.setPatterChooseList(patternCards);


        assertEquals(pattern, player.getPattern());
        assertEquals(privateCard, player.getPrivate());
        assertEquals(6, player.getTokensNumber());
        assertEquals(finalPoints, player.getFinalPoints());
        assertEquals(privatePoints, player.getPrivatePoints());
        assertEquals(2, player.getPlayerID());
        assertEquals("Dario", player.getPlayerName());
        assertEquals("RED", player.getColour().toString());
        assertEquals("Player Tokens6",player.toStringTokens());
        assertEquals(patternCards, player.getPatterChooseList());
        assertEquals(false, player.isOff());
    }

    @Test
    public void testNewConstructor() {
        String string = "Dario";
        //PlayerColour playerColour = PlayerColour.BLUE;
        int ID = 1;

        Player player = new Player(string);
        Player player1 = new Player(ID);
        Player player2 = new Player(player1);


        assertEquals("Dario", player.getPlayerName());
        assertEquals(1, player1.getPlayerID());
        assertEquals(1,player2.getPlayerID());
        assertEquals(0,player2.getTokensNumber());
        assertEquals(0,player2.getFinalPoints());
        assertEquals(0,player2.getPrivatePoints());
        assertNull(player2.getPrivate());

    }

    @Test
    public void testRunningP() {
        Player player = new Player();
        player.setRunningP(true);
        assertTrue(player.isRunningP());
    }

    @Test
    public void testToString(){

        String string = "Dario";
        //PlayerColour playerColour = PlayerColour.BLUE;
        int ID = 1;

        Player player1 = new Player(string, PlayerColour.BLUE);
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