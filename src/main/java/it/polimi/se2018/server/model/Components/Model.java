package it.polimi.se2018.server.model.Components;

import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;

import java.util.ArrayList;
import java.util.List;

/**
 * class that store reference to the model components and getter/setter methods for them
 * @author adrianomundo
 */

public class Model extends java.util.Observable {

    private RoundTracker roundTracker;
    private DraftPool draftPool;
    private DiceBag diceBag;
    private Player player;
    private List<PublicObjectiveCard> publicList;
    private List<Player> playerList;
    private int numberPlayer;

    public Model(){
        this.roundTracker = new RoundTracker();
        this.draftPool = new DraftPool();
        this.diceBag = new DiceBag();
        this.playerList = new ArrayList<>();
    }

    public int getNumberPlayer(){
        return numberPlayer;
    }

    public void setNumberPlayer(int n){
        this.numberPlayer = n;
    }

    public RoundTracker getRoundTracker() {
        return roundTracker;
    }

    public DraftPool getDraftPool() {
        return draftPool;
    }

    public Player getPlayer() {
        return player;
    }

    public List<PublicObjectiveCard> getPublicList() {
        return publicList;
    }

    public void setPublicList(List<PublicObjectiveCard> publicList){
        this.publicList = publicList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList){
        this.playerList = playerList;
    }



    public DiceBag getDiceBag() {
        return diceBag;
    }


    //TODO add some methods to performe move, and then send a notification to the view and uodate UML (dicebag instance)
}
