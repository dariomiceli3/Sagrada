package it.polimi.se2018.TestComponents;

import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.DiagonalColor;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.ColumnColorVariety;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.server.model.Cards.ToolCard;
import it.polimi.se2018.server.model.Components.*;
import org.junit.Test;


import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestModel {

    @Test
    public void testConstructor() {
        Model model = new Model();

        assertEquals(0, model.getNumberPlayer());

    }

    @Test
    public void testUpdate() {
        Model model = new Model();

        ArrayList<Player> playerArrayList = new ArrayList<>();
        Player player = new Player();

        Player player1  = new Player();
        player.setPlayerID(0);
        player.setPlayerID(1);
        playerArrayList.add(player);
        playerArrayList.add(player1);
        model.getPlayerFromID(0);
        model.setPlayerList(playerArrayList);
        model.getPlayerFromID(1);
        model.setNumberPlayer(5);
        model.updateBoardAndNotify();
        model.updateTokenAndNotify(1);
        model.updatePatternAndNotify(0);
        model.updatePoolAndNotify();
    }

    @Test
    public void testGetter(){
        Model model = new Model();


        model.getDraftPool();
        model.getRoundTracker();
        model.getPlayerList();
        model.getNumberPlayer();
        model.getDiceBag();
        model.getPublicList();
        model.getPlayerFromID(0);
        ArrayList<Player> playerArrayList = new ArrayList<>();
        Player player = new Player();
        Player player1  = new Player();
        player.setPlayerID(0);
        player.setPlayerID(1);
        playerArrayList.add(player);
        playerArrayList.add(player1);
        model.getPlayerFromID(0);
        model.setPlayerList(playerArrayList);
        model.getPlayerFromID(1);

        ArrayList<PublicObjectiveCard> publicObjectiveCards = new ArrayList<>();
        PublicObjectiveCard publicObjectiveCard = new PublicObjectiveCard(new DiagonalColor(), "Color Diagonals");
        PublicObjectiveCard publicObjectiveCard1 = new PublicObjectiveCard(new ColumnColorVariety(), "Column Color Variety");
        publicObjectiveCards.add(publicObjectiveCard);
        publicObjectiveCards.add(publicObjectiveCard1);

        model.setPublicAndNotify(publicObjectiveCards);
        model.getPublicList();

    }

    @Test
    public void testNotify()  {
        Model model = new Model();
        ArrayList<Player> playerArrayList = new ArrayList<>();
        Player player = new Player();
        Player player1  = new Player();

        PrivateObjectiveCard privateObjectiveCard = new PrivateObjectiveCard(DiceColor.RED);
        PrivateObjectiveCard privateObjectiveCard1 = new PrivateObjectiveCard(DiceColor.RED);
        ArrayList<PrivateObjectiveCard> privateObjectiveCardArrayList = new ArrayList<>();
        privateObjectiveCardArrayList.add(privateObjectiveCard);
        privateObjectiveCardArrayList.add(privateObjectiveCard1);

        PatternCard patternCard = new PatternCard();
        patternCard = patternCard.loadPatternList().get(0);

        Dice dice = new Dice(3, DiceColor.YELLOW);
        Dice dice1 = new Dice(3, DiceColor.YELLOW);
        player1.setPattern(patternCard);

        ArrayList<Dice> diceArrayList = new ArrayList<>();
        diceArrayList.add(dice);
        diceArrayList.add(dice1);




        player.setPlayerID(0);
        player1.setPlayerID(1);
        playerArrayList.add(player);
        playerArrayList.add(player1);
        model.setPlayerList(playerArrayList);


        model.setPlayerAndNotify(1, "ciao");
        model.setPrivateAndNotify(1, privateObjectiveCard);
        model.setTokenAndNotify(1);
        model.setEndRoundAndNotify();


        model.setFinalPointsAndNotify(playerArrayList, false);
        model.setPrivateSinglePlayerAndNotify(privateObjectiveCardArrayList);


    }

    @Test
    public void testSetPatternAndMoveNotify() throws  InvalidMoveException {
        ArrayList<Player> playerArrayList = new ArrayList<>();
        Player player = new Player();
        Player player1  = new Player();
        playerArrayList.add(player);
        playerArrayList.add(player1);
        player.setPlayerID(0);
        PatternCard patternCard = new PatternCard();
        ArrayList<PatternCard> patternCards = patternCard.loadPatternList();

        player.setPatterChooseList(patternCards);

        Model model = new Model();
        model.setPlayerList(playerArrayList);
        model.setPatternAndNotify(0, 1);




        ArrayList<Dice> diceArrayList = new ArrayList<>();
        Dice dice = new Dice(4, DiceColor.YELLOW);
        diceArrayList.add(dice);


        model.getDraftPool().setDraftPool(diceArrayList);

        model.setMoveAndNotify(0,0,0);
        PatternCard patternCard1 = patternCards.get(0);
        model.setCustomPatternAndNotify(0, patternCard1);

    }

    @Test
    public void testTool() {
        Model model = new Model();

        ArrayList<ToolCard> toolCards = new ArrayList<>();
        ToolCard toolCard = new ToolCard("name", DiceColor.RED, 1);
        toolCards.add(toolCard);

        model.setToolCardList(toolCards);
        assertEquals("name", model.getTool(1).getName());
    }

    @Test
    public void testTokensFactor() {
        Model model = new Model();

        ArrayList<ToolCard> toolCards = new ArrayList<>();
        ToolCard toolCard = new ToolCard("name", DiceColor.RED, 1);
        toolCards.add(toolCard);

        model.setToolCardList(toolCards);

        ArrayList<Player> playerArrayList = new ArrayList<>();
        Player player = new Player();

        Player player1  = new Player();

        player.setPlayerID(0);
        player1.setPlayerID(1);
        playerArrayList.add(player);
        playerArrayList.add(player1);
        model.setPlayerList(playerArrayList);

        model.tokenRefactor(false, 0, 1);
        model.getTool(1).setUsage(1);
        model.tokenRefactor(false, 0, 1);

        Dice dice = new Dice(3,DiceColor.RED);
        model.setDraftPoolAndNotify(false);
        model.exchangePoolBag(0,1, dice);

    }

    @Test(expected = InvalidMoveException.class)
    public void testPutFirstDice() throws InvalidMoveException {
        Model model = new Model();

        ArrayList<ToolCard> toolCards = new ArrayList<>();
        ToolCard toolCard = new ToolCard("name", DiceColor.RED, 1);
        toolCards.add(toolCard);

        model.setToolCardList(toolCards);

        ArrayList<Player> playerArrayList = new ArrayList<>();
        Player player = new Player();

        Player player1  = new Player();

        player.setPlayerID(0);
        player1.setPlayerID(1);
        playerArrayList.add(player);
        playerArrayList.add(player1);
        model.setPlayerList(playerArrayList);

        PatternCard patternCard = new PatternCard();
        patternCard = patternCard.loadPatternForTesting();
        player.setPattern(patternCard);

        model.setDraftPoolAndNotify(false);
        model.putDiceToolCard(0, 3, 4, 9);

        Dice dice = new Dice(4, DiceColor.YELLOW);
        patternCard.putDice(dice,0);
        player1.setPattern(patternCard);

        model.putDiceToolCard(1, 0, 0, 9);

    }

    @Test(expected = InvalidMoveException.class)
    public void testPutFirstDice8() throws InvalidMoveException {
        Model model = new Model();

        ArrayList<ToolCard> toolCards = new ArrayList<>();
        ToolCard toolCard = new ToolCard("name", DiceColor.RED, 1);
        toolCards.add(toolCard);

        model.setToolCardList(toolCards);

        ArrayList<Player> playerArrayList = new ArrayList<>();
        Player player = new Player();

        Player player1  = new Player();

        player.setPlayerID(0);
        player1.setPlayerID(1);
        playerArrayList.add(player);
        playerArrayList.add(player1);
        model.setPlayerList(playerArrayList);

        PatternCard patternCard = new PatternCard();
        patternCard = patternCard.loadPatternForTesting();
        player.setPattern(patternCard);

        model.setDraftPoolAndNotify(false);

        Dice dice = new Dice(4, DiceColor.YELLOW);
        patternCard.putDice(dice,0);
        player1.setPattern(patternCard);

        model.putDiceToolCard(0, 0, 0, 8);

    }
}
