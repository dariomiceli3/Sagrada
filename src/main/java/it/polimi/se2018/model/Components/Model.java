package it.polimi.se2018.model.Components;

import it.polimi.se2018.model.Cards.PublicObjectiveCard.PublicObjectiveCard;

import java.util.ArrayList;
import java.util.List;

public class Model extends java.util.Observable {

    private RoundTracker roundTracker;
    private DraftPool draftPool;
    private DiceBag diceBag;
    private Player player;
    private PublicObjectiveCard publicObjectiveCard;
    private List<Player> playerList;
    private int numberPlayer;

    public Model(){
        this. roundTracker = RoundTracker.getIstanceRT();
        this.draftPool = DraftPool.getIstanceDP();
        this.diceBag = DiceBag.getIstanceDB();
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

    public PublicObjectiveCard getPublicObjectiveCard() {
        return publicObjectiveCard;
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
