package it.polimi.se2018.server.controller;


import it.polimi.se2018.server.VirtualView;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.*;
import it.polimi.se2018.server.model.Components.DiceColor;
import it.polimi.se2018.server.model.Events.ServerClient.ControllerView.StartPatternEvent;

import java.util.Random;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameSetup {
    private static final int VALUE = 12;
    private Game game;
    private List<PrivateObjectiveCard> listPrivateCard;
    private List<PublicObjectiveCard> listPublicCard;
    private List<PatternCard> listPattern;
    private boolean[] control;

    protected GameSetup(Game game) {
        this.game = game;
        this.listPrivateCard = this.loadPrivate();
        this.listPublicCard = this.loadPublic();
        this.listPattern = this.loadPatternCard();
        this.control = new boolean[VALUE];
        Arrays.fill(control, Boolean.FALSE);
    }


    private List<PrivateObjectiveCard> loadPrivate() {
        List<PrivateObjectiveCard> list = new ArrayList<>();
        list.add(new PrivateObjectiveCard(DiceColor.BLUE));
        list.add(new PrivateObjectiveCard(DiceColor.RED));
        list.add(new PrivateObjectiveCard(DiceColor.GREEN));
        list.add(new PrivateObjectiveCard(DiceColor.PURPLE));
        list.add(new PrivateObjectiveCard(DiceColor.YELLOW));
        Collections.shuffle(list);
        return list;

    }

    private List<PublicObjectiveCard> loadPublic() {
        List<PublicObjectiveCard> list = new ArrayList<>();
        list.add(new PublicObjectiveCard(new DarkShade()));
        list.add(new PublicObjectiveCard(new DiagonalColor()));
        list.add(new PublicObjectiveCard(new DifferentColorColumn()));
        list.add(new PublicObjectiveCard(new DifferentColorRow()));
        list.add(new PublicObjectiveCard(new DifferentShade()));
        list.add(new PublicObjectiveCard(new DifferentShadeRow()));
        list.add(new PublicObjectiveCard(new DifferentShadeColumn()));
        list.add(new PublicObjectiveCard(new LightShade()));
        list.add(new PublicObjectiveCard(new MediumShade()));
        list.add(new PublicObjectiveCard(new VarietyColor()));
        Collections.shuffle(list);
        return list;
    }

    protected void setPrivateCardModel(VirtualView view) {

        game.getModel().setPrivateAndNotify((view.getPlayerID()), listPrivateCard.remove(0));


    }

    protected void setPublicCardModel() {

        List<PublicObjectiveCard> listPublic1 = new ArrayList<>();
        listPublic1.add(listPublicCard.remove(0));
        listPublic1.add(listPublicCard.remove(0));
        listPublic1.add(listPublicCard.remove(0));


        game.getModel().setPublicAndNotify(listPublic1);


    }

    private List<PatternCard> loadPatternCard() {
        PatternCard pattern = new PatternCard();
        try {
            listPattern = pattern.loadPatternList();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listPattern;
    }

    protected void startPatternCard(VirtualView view) {

        List<PatternCard> patternList = new ArrayList<>();
        Random random = new Random();
        int a;
        for (int i = 0; i < 2; i++) {

            a = ricorsiveMethod(random.nextInt(VALUE));
            patternList.add(listPattern.get(a));
            patternList.add(listPattern.get(a + VALUE));
        }


        view.sendEvent(new StartPatternEvent(view.getPlayerID(), patternList));
    }

    private int ricorsiveMethod(int a) {
        Random random = new Random();
        if (!control[a]) {
            control[a] = true;
            return a;
        } else return ricorsiveMethod(random.nextInt(VALUE));
    }

    /*protected int calculatePlayerTurn(int turn, int numberOfPlayers){
        if(turn > (numberOfPlayers-1) && turn < ((numberOfPlayers*2)-1)){
            return (turn - ((2*(turn-numberOfPlayers-1))-1));
        }else if(turn == ((numberOfPlayers*2)-1)){
            return 0;
        }else {
            return turn;
        }
    }*/

    protected int calculatePlayerTurn(int turn, int numberOfPlayers) {
        if (turn < numberOfPlayers) {
            return turn;
        } else if (turn == numberOfPlayers) {
            return numberOfPlayers - 1;
        } else {
            return (2 * numberOfPlayers) - (turn + 1);
        }
    }

    protected void changeBagger() {

        game.getModel().getPlayerList().add(game.getModel().getPlayerList().remove(0));
    }

    private List<ToolCard> loadToolCard() {
        List<ToolCard> list = new ArrayList<>();

       // list.add(new ToolCard("Grozing Pliers", DiceColor.PURPLE, 1));
        //list.add(new ToolCard("Eglomise Brush", DiceColor.BLUE, 2));
        list.add(new ToolCard("Copper Foil Burnisher", DiceColor.RED, 3));
        list.add(new ToolCard("Lathekin", DiceColor.YELLOW, 4));
        list.add(new ToolCard("Lens Cutter", DiceColor.GREEN, 5));
        //list.add(new ToolCard("Flux Brush", DiceColor.PURPLE, 6));
        //list.add(new ToolCard("Glazing Hammer", DiceColor.BLUE, 7));
        //list.add(new ToolCard("Running Pliers", DiceColor.RED, 8));
        //list.add(new ToolCard("Cork-backed Straightedge", DiceColor.YELLOW, 9));
        //list.add(new ToolCard("Grinding Stone", DiceColor.GREEN, 10));
        //list.add(new ToolCard("Flux Remover", DiceColor.PURPLE, 11));
        //list.add(new ToolCard("Tap Wheel", DiceColor.BLUE, 12));


        Collections.shuffle(list);
        return list;

    }

    protected List<ToolCard> setToolCard() {

        List<ToolCard> toolCardList = this.loadToolCard();
        List<ToolCard> toolCardList1 = new ArrayList<>();
        toolCardList1.add(toolCardList.remove(0));
        toolCardList1.add(toolCardList.remove(0));
        toolCardList1.add(toolCardList.remove(0));
        return toolCardList1;
    }
}














