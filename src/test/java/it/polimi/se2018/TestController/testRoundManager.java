package it.polimi.se2018.TestController;

import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.DarkShade;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.DiagonalColor;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicEffects;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.server.model.Components.DiceColor;
import it.polimi.se2018.server.model.Components.Player;
import it.polimi.se2018.server.controller.RoundManager;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class testRoundManager {

    @Test
    public void testCalculatePrivate() throws FileNotFoundException, InvalidMoveException {
        Player player = new Player();
        Player player1 = new Player();
        PrivateObjectiveCard privateObjectiveCard = new PrivateObjectiveCard(DiceColor.YELLOW);
        PrivateObjectiveCard privateObjectiveCard1 = new PrivateObjectiveCard(DiceColor.GREEN);
        player.setPrivate(privateObjectiveCard);
        player1.setPrivate(privateObjectiveCard1);
        PatternCard patternCard = new PatternCard();
        PatternCard patternCard1;
        PatternCard patternCard2;
        ArrayList<PatternCard> patternCardArrayList = patternCard.loadPatternList();
        patternCard1 = patternCardArrayList.get(0);
        patternCard2 = patternCardArrayList.get(1);
        Dice dice = new Dice(3, DiceColor.YELLOW);
        Dice dice1 = new Dice(4, DiceColor.GREEN);
        Dice dice2 = new Dice(5, DiceColor.BLUE);


        patternCard1.putDiceOnPattern(dice, 0, patternCard1);
        patternCard1.putDiceOnPattern(dice2, 1, patternCard1);
        patternCard1.putDiceOnPattern(dice1, 5, patternCard1);
        patternCard2.putDiceOnPattern(dice1, 4, patternCard2);
        patternCard2.putDiceOnPattern(dice1, 8, patternCard2);
        patternCard2.putDiceOnPattern(dice1, 12, patternCard2);

        player.setPattern(patternCard1);
        player1.setPattern(patternCard2);

        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
        players.add(player1);

        ArrayList<Integer> result;
        RoundManager roundManager = new RoundManager();
        result = roundManager.calculatePrivate(players);

        assertEquals(3, player.getPrivatePoints());
        assertEquals(3, result.get(0).intValue());
        assertEquals(12, player1.getPrivatePoints());
        assertEquals(12, result.get(1).intValue());


    }

    @Test
    public void testCalculateTokens() {
        Player player = new Player();
        Player player1 = new Player();

        player.setTokensNumber(3);
        player1.setTokensNumber(1);

        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
        players.add(player1);

        RoundManager roundManager = new RoundManager();
        ArrayList<Integer> result;
        result = roundManager.calculateTokens(players);

        assertEquals(3, result.get(0).intValue());
        assertEquals(1, result.get(1).intValue());
    }

    @Test
    public void testCalculatePublic() throws FileNotFoundException, InvalidMoveException {
        Player player = new Player();
        Player player1 = new Player();
        PrivateObjectiveCard privateObjectiveCard = new PrivateObjectiveCard(DiceColor.YELLOW);
        PrivateObjectiveCard privateObjectiveCard1 = new PrivateObjectiveCard(DiceColor.GREEN);
        player.setPrivate(privateObjectiveCard);
        player1.setPrivate(privateObjectiveCard1);
        PatternCard patternCard = new PatternCard();
        PatternCard patternCard1;
        PatternCard patternCard2;
        ArrayList<PatternCard> patternCardArrayList = patternCard.loadPatternList();
        patternCard1 = patternCardArrayList.get(0);
        patternCard2 = patternCardArrayList.get(1);
        Dice dice = new Dice(3, DiceColor.YELLOW);
        Dice dice1 = new Dice(4, DiceColor.GREEN);
        Dice dice2 = new Dice(5, DiceColor.BLUE);


        patternCard1.putDiceOnPattern(dice, 0, patternCard1);
        patternCard1.putDiceOnPattern(dice2, 1, patternCard1);
        patternCard1.putDiceOnPattern(dice1, 5, patternCard1);
        patternCard2.putDiceOnPattern(dice1, 4, patternCard2);
        patternCard2.putDiceOnPattern(dice1, 8, patternCard2);
        patternCard2.putDiceOnPattern(dice1, 12, patternCard2);

        player.setPattern(patternCard1);
        player1.setPattern(patternCard2);

        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
        players.add(player1);

        ArrayList<PublicObjectiveCard> publicObjectiveCards = new ArrayList<>();
        PublicObjectiveCard publicObjectiveCard = new PublicObjectiveCard(new DiagonalColor());
        PublicObjectiveCard publicObjectiveCard1 = new PublicObjectiveCard(new DarkShade());

        publicObjectiveCards.add(publicObjectiveCard);
        publicObjectiveCards.add(publicObjectiveCard1);

        ArrayList<Integer> result;
        RoundManager roundManager = new RoundManager();
        result = roundManager.calculatePublic(players, publicObjectiveCards);

        assertEquals(0, result.get(0).intValue());
        assertEquals(3, result.get(1).intValue());


    }
}
