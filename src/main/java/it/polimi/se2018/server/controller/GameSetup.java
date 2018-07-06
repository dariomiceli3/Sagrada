package it.polimi.se2018.server.controller;


import it.polimi.se2018.server.model.Cards.ToolCard;
import it.polimi.se2018.server.network.VirtualView;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.*;
import it.polimi.se2018.server.model.Components.DiceColor;
import it.polimi.se2018.events.serverclient.controllerview.StartPatternEvent;


import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Class GameSetup: representation of the first part of the game. It handles to load, to shuffle
 * and to deliver all the cards to the selected virtual view
 */
class GameSetup {

    private static final int VALUE = 12;
    private GameController gameController;
    private List<PrivateObjectiveCard> listPrivateCard;
    private List<PublicObjectiveCard> listPublicCard;
    private List<PatternCard> listPattern;
    private boolean[] control;

    /**
     * Class constructor: create the final step of a game delivering all the cards(publics, private, tool card)
     * @param gameController game linked to the setup
     */
    GameSetup(GameController gameController) {
        this.gameController = gameController;
        this.listPrivateCard = this.loadPrivate();
        this.listPublicCard = this.loadPublic();
        this.listPattern = this.loadPatternCard();
        this.control = new boolean[VALUE];
        Arrays.fill(control, Boolean.FALSE);
    }


    /**
     * method that delivers one private card to the virtual view if the mode is multi player,
     * otherwise the method delivers three private cards
     * @param view the virtual view corresponding to the client
     */
    void setPrivateCardModel(VirtualView view) {

        if (gameController.isSinglePlayer()){
            List<PrivateObjectiveCard> listPrivate = new ArrayList<>();
            listPrivate.add(listPrivateCard.remove(0));
            listPrivate.add(listPrivateCard.remove(0));
            gameController.getModel().setPrivateSinglePlayerAndNotify(listPrivate);
        }else {
            gameController.getModel().setPrivateAndNotify((view.getPlayerID()), listPrivateCard.remove(0));
        }
    }

    /**
     * method that delivers three public cards if the mode is multi player,
     * otherwise the method delivers two public cards
     */
    void setPublicCardModel() {

        List<PublicObjectiveCard> listPublic1 = new ArrayList<>();
        listPublic1.add(listPublicCard.remove(0));
        listPublic1.add(listPublicCard.remove(0));
        if(!gameController.isSinglePlayer()) {
            listPublic1.add(listPublicCard.remove(0));
        }
        gameController.getModel().setPublicAndNotify(listPublic1);
    }

    /**
     * method that delivers three tool cards if the mode is multi player,
     * otherwise the method delivers tool cards as much as the difficulty chosen by the player
     * @return list of the tool cards delivered
     */
    List<ToolCard> setToolCard() {

        List<ToolCard> toolCardList = this.loadToolCard();
        List<ToolCard> toolCardList1 = new ArrayList<>();
        if(!gameController.isSinglePlayer()) {

            toolCardList1.add(toolCardList.remove(0));
            toolCardList1.add(toolCardList.remove(0));
            toolCardList1.add(toolCardList.remove(0));
        }else {

            for(int i = 0; i < gameController.getSinglePlayerDifficulty(); i++) {
                toolCardList1.add(toolCardList.remove(0));
            }
        }
        return toolCardList1;
    }

    /**
     * method that delivers to the virtual view four pattern cards
     * @param view the virtual view corresponding to the client
     */
    void startPatternCard(VirtualView view) {

        List<PatternCard> patternList = new ArrayList<>();
        Random random = new Random();
        int a;
        for (int i = 0; i < 2; i++) {

            a = ricorsiveMethod(random.nextInt(VALUE));
            patternList.add(listPattern.get(a));
            patternList.add(listPattern.get(a + VALUE));
        }
        gameController.getModel().getPlayerFromID(view.getPlayerID()).setPatterChooseList(patternList);

        view.sendEvent(new StartPatternEvent(view.getPlayerID(), patternList));
    }

    //todo adriano
    private int ricorsiveMethod(int a) {
        Random random = new Random();
        if (!control[a]) {
            control[a] = true;
            return a;
        } else return ricorsiveMethod(random.nextInt(VALUE));
    }

    //todo adriano
    void changeBagger() {
        do {
            gameController.getModel().getPlayerList().add(gameController.getModel().getPlayerList().remove(0));
        }
        while (gameController.getModel().getPlayerList().get(0).isDisconnect());
    }

    /**
     * method that loads and shuffles all the private cards
     * @return list of the private cards
     */
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

    /**
     * method that loads and shuffles all the public cards
     * @return list of public cards
     */
    private List<PublicObjectiveCard> loadPublic() {

        List<PublicObjectiveCard> list = new ArrayList<>();
        list.add(new PublicObjectiveCard(new DeepShades(), "Deep Shades"));
        list.add(new PublicObjectiveCard(new DiagonalColor(), "Color Diagonals"));
        list.add(new PublicObjectiveCard(new ColumnColorVariety(), "Column Color Variety"));
        list.add(new PublicObjectiveCard(new RowColorVariety(), "Row Color Variety"));
        list.add(new PublicObjectiveCard(new ShadeVariety(), "Shade Variety"));
        list.add(new PublicObjectiveCard(new RowShadeVariety(), "Row Shade Variety"));
        list.add(new PublicObjectiveCard(new ColumnShadeVariety(), "Column Shade Variety"));
        list.add(new PublicObjectiveCard(new LightShades(), "Light Shades"));
        list.add(new PublicObjectiveCard(new MediumShades(), "Medium Shades"));
        list.add(new PublicObjectiveCard(new ColorVariety(), "Color Variety"));
        Collections.shuffle(list);
        return list;
    }

    /**
     * method that loads all the 24 pattern cards
     * @return list of pattern cards
     */
    List<PatternCard> loadPatternCard() {
        PatternCard pattern = new PatternCard();
        listPattern = pattern.loadPatternList();
        return listPattern;
    }

    /**
     * method that loads and shuffles all the tool cards
     * @return list of tool cards
     */
    private List<ToolCard> loadToolCard() {
        List<ToolCard> list = new ArrayList<>();

        list.add(new ToolCard("Grozing Pliers", DiceColor.PURPLE, 1));
        list.add(new ToolCard("Eglomise Brush", DiceColor.BLUE, 2));
        list.add(new ToolCard("Copper Foil Burnisher", DiceColor.RED, 3));
        list.add(new ToolCard("Lathekin", DiceColor.YELLOW, 4));
        list.add(new ToolCard("Lens Cutter", DiceColor.GREEN, 5));
        //list.add(new ToolCard("Flux Brush", DiceColor.PURPLE, 6));
        //list.add(new ToolCard("Glazing Hammer", DiceColor.BLUE, 7));
        if(!gameController.isSinglePlayer()) {
            list.add(new ToolCard("Running Pliers", DiceColor.RED, 8));
        }
        //list.add(new ToolCard("Cork-backed Straightedge", DiceColor.YELLOW, 9));
        //list.add(new ToolCard("Grinding Stone", DiceColor.GREEN, 10));
        //list.add(new ToolCard("Flux Remover", DiceColor.PURPLE, 11));
        //list.add(new ToolCard("Tap Wheel", DiceColor.BLUE, 12));


        Collections.shuffle(list);
        return list;

    }

}














