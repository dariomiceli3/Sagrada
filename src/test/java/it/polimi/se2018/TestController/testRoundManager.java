package it.polimi.se2018.TestController;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.server.model.Components.DiceColor;
import it.polimi.se2018.server.model.Components.Player;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class testRoundManager {

    @Test
    public void testCalculatePrivate() throws FileNotFoundException {
        Player player = new Player();
        Player player1 = new Player();
        PrivateObjectiveCard privateObjectiveCard = new PrivateObjectiveCard(DiceColor.YELLOW);
        PrivateObjectiveCard privateObjectiveCard1 = new PrivateObjectiveCard(DiceColor.GREEN);
        player.setPrivate(privateObjectiveCard);
        player1.setPrivate(privateObjectiveCard1);
        PatternCard patternCard = new PatternCard();
        PatternCard patternCard1 = new PatternCard();
        PatternCard patternCard2 = new PatternCard();
        ArrayList<PatternCard> patternCardArrayList = patternCard.loadPatternList();
        patternCard1 = patternCardArrayList.get(0);
        patternCard2 = patternCardArrayList.get(1);
        Dice dice = new Dice(3, DiceColor.YELLOW);
        Dice dice1 = new Dice(3, DiceColor.GREEN);
        Dice dice2 = new Dice(4, DiceColor.BLUE);


        //patternCard1.putDiceOnPattern(dice, 0);

        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
        players.add(player1);


    }
}
