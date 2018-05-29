package it.polimi.se2018.server.controller;


import it.polimi.se2018.server.VirtualView;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.*;
import it.polimi.se2018.server.model.Components.DiceColor;
import it.polimi.se2018.server.model.Components.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameSetup {
    private Game game;
    private List<PrivateObjectiveCard> listPrivateCard;
    private List<PublicObjectiveCard> listPublicCard;

    protected GameSetup(Game game){
        this.game = game;
        this.listPrivateCard = this.loadPrivate();
        this.listPublicCard = this.loadPublic();
    }


    private ArrayList<PrivateObjectiveCard> loadPrivate(){
        ArrayList<PrivateObjectiveCard> list = new ArrayList<>();
        list.add(new PrivateObjectiveCard(DiceColor.BLUE));
        list.add(new PrivateObjectiveCard(DiceColor.RED));
        list.add(new PrivateObjectiveCard(DiceColor.GREEN));
        list.add(new PrivateObjectiveCard(DiceColor.PURPLE));
        list.add(new PrivateObjectiveCard(DiceColor.YELLOW));
        Collections.shuffle(list);
        return list;

    }

    private ArrayList<PublicObjectiveCard> loadPublic(){
        ArrayList<PublicObjectiveCard> list = new ArrayList<>();
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

    protected void setPrivateCardModel(VirtualView view){

        game.getModel().setPrivateAndNotify( (view.getPlayerID()), listPrivateCard.remove(0) ) ;


        //game.getModel().setPrivateAndNotify(view.getPlayerID(), listPrivateCard.remove(0));

    }

    protected void setPublicCard(List<VirtualView> listView){

        List<PublicObjectiveCard> listPublic1 = new ArrayList<>();
        listPublic1.add(listPublicCard.remove(0));
        listPublic1.add(listPublicCard.remove(0));
        listPublic1.add(listPublicCard.remove(0));


        game.getModel().setPublicAndNotify(listPublic1);


    }









}
