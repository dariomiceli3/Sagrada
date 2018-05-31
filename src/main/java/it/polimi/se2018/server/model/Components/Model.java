package it.polimi.se2018.server.model.Components;

import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.server.model.Events.EventsObservable;
import it.polimi.se2018.server.model.Events.ServerClient.ModelView.PlayerNameUpdateEvent;
import it.polimi.se2018.server.model.Events.ServerClient.ModelView.PlayerPrivateUpdateEvent;
import it.polimi.se2018.server.model.Events.ServerClient.ModelView.PublicDrawEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * class that store reference to the model components and getter/setter methods for them
 * @author adrianomundo
 */

public class Model extends Observable {

    private RoundTracker roundTracker;
    private DraftPool draftPool;
    private DiceBag diceBag;
    private Player player;
    private List<PublicObjectiveCard> publicList;
    private List<Player> playerList;
    private int numberPlayer;
    private EventsObservable event;

    public Model() {
        this.roundTracker = new RoundTracker();
        this.draftPool = new DraftPool();
        this.diceBag = new DiceBag();
        this.playerList = new ArrayList<>();
        this.event = new EventsObservable();

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


    public Player getPlayerFromID(int ID) {

        for (Player player : playerList)
        {
            if (player.getPlayerID() == ID) {
                return player;
            }
        }
        return null;
    }

    public void setPlayerAndNotify(int ID, String name) {

        getPlayerFromID(ID).setPlayerName(name);
        //System.out.println("prima di notify view id mandato"+ ID + "id settato" + getPlayerFromID(ID).getPlayerID());
        setChanged();
        // todo nell'evento prendere le cose da mandare dal MODEL, non i parametri ingresso
        notifyObservers(new PlayerNameUpdateEvent(getPlayerFromID(ID).getPlayerName(), ID));
        //System.out.println("Name in model" + getPlayerFromID(ID).getPlayerName());

    }

    public void setPrivateAndNotify(int ID, PrivateObjectiveCard privateCard){

        getPlayerFromID(ID).setPrivate(privateCard);
        setChanged();
        notifyObservers(new PlayerPrivateUpdateEvent(getPlayerFromID(ID).getPlayerID(), privateCard));
    }//TODO network/cli


    public void setPublicAndNotify(List<PublicObjectiveCard> publicList){
        this.publicList = publicList;
        setChanged();
        notifyObservers(new PublicDrawEvent(this.publicList));
    }//TODO network/cli


    //TODO add some methods to performe move, and then send a notification to the view and uodate UML (dicebag instance)
}
