package it.polimi.se2018.TestComponents;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

import it.polimi.se2018.model.Cards.PatternCard;
import it.polimi.se2018.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.model.Components.DiceColor;
import it.polimi.se2018.model.Components.Player;
import it.polimi.se2018.model.Components.PlayerColour;
import  org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TestPlayer {
    @Test
    public void testConstructor() {
        String ID = "Buonasera";
        Player player = new Player(ID, PlayerColour.BLUE);
        assertEquals("Buonasera", player.getPlayerID());
        assertEquals(PlayerColour.BLUE, player.getColour());
    }

    @Test
    public void testSet() {
        Player player = new Player();
        PrivateObjectiveCard privateCard = new PrivateObjectiveCard(DiceColor.BLUE);
        int tokens = 4;
        int finalPoints = 110;
        int privatePoints = 34;
        PatternCard pattern = new PatternCard();
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

        assertEquals(pattern, player.getPattern());
        assertEquals(privateCard, player.getPrivate());
        assertEquals(tokens, player.getTokensNumber());
        assertEquals(finalPoints, player.getFinalPoints());
        assertEquals(privatePoints, player.getPrivatePoints());
    }
}