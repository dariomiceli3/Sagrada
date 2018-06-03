package it.polimi.se2018.server.model.Components;

import com.sun.xml.internal.bind.v2.model.core.ID;
import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.server.model.Events.EventsObservable;
import it.polimi.se2018.server.model.Events.ServerClient.ModelView.*;

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
        this.diceBag = new DiceBag();
        this.draftPool = new DraftPool(diceBag);
        this.playerList = new ArrayList<>();
        this.event = new EventsObservable();
        this.numberPlayer = 0;

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

        numberPlayer++;
        getPlayerFromID(ID).setPlayerName(name);
        setChanged();
        // todo nell'evento prendere le cose da mandare dal MODEL, non i parametri ingresso
        notifyObservers(new PlayerNameUpdateEvent(getPlayerFromID(ID).getPlayerName(), ID));

    }

    public void setPrivateAndNotify(int ID, PrivateObjectiveCard privateCard){

        getPlayerFromID(ID).setPrivate(privateCard);
        setChanged();
        notifyObservers(new PlayerPrivateUpdateEvent(getPlayerFromID(ID).getPlayerID(), privateCard));
    }


    public void setPublicAndNotify(List<PublicObjectiveCard> publicList){

        this.setPublicList(publicList);
        setChanged();
        notifyObservers(new PublicDrawEvent(this.publicList));
    }

    public void setPatternAndNotify(int ID, PatternCard pattern){
        numberPlayer++;
        getPlayerFromID(ID).setPattern(pattern);
        setChanged();
        notifyObservers(new PlayerPatternUpdateEvent(ID, getPlayerFromID(ID).getPattern()));
    }

    public void setTokenAndNotify(int ID) {

        Player player = getPlayerFromID(ID);
        player.setTokensNumber(player.getPattern().getDifficulty());
        setChanged();
        notifyObservers(new PlayerTokensUpdateEvent(ID, getPlayerFromID(ID).getTokensNumber()));
    }

    public void setDraftPoolAndNotify(){

        this.draftPool.setNumber(playerList.size());
        this.draftPool.createListDice();
        setChanged();
        notifyObservers(new PlayerDraftPoolUpdateEvent(draftPool));
    }

    public void setMoveAndNotify(int ID, int indexPool, int indexPattern) throws InvalidMoveException {

        getPlayerFromID(ID).getPattern().putDiceOnPattern(draftPool.removeDice(indexPool), indexPattern, getPlayerFromID(ID).getPattern());
        setChanged();
        notifyObservers(new PatternUpdateEvent(getPlayerFromID(ID).getPlayerID(), getPlayerFromID(ID).getPattern(), getPlayerFromID(ID).getPlayerName()));
        setChanged();
        notifyObservers(new PlayerDraftPoolUpdateEvent(draftPool));
        setChanged();
        notifyObservers(new PlayerTokensUpdateEvent(getPlayerFromID(ID).getPlayerID(), getPlayerFromID(ID).getTokensNumber()));
    }

    public void setEndRoundAndNotify(){

        roundTracker.setTracker(draftPool.cleanListDice());
        setChanged();
        notifyObservers(new RoundTrackerUpdateEvent(this.getRoundTracker()));
        setChanged();
        notifyObservers(new PlayerDraftPoolUpdateEvent(draftPool));

    }

    public void setFinalPointsAndNotify(List<Player> playerList){

        setPlayerList(playerList);
        setChanged();
        notifyObservers(new PlayerPointsUpdateEvent(this.getPlayerList()));
    }


    //TODO add some methods to performe move, and then send a notification to the view and uodate UML (dicebag instance)
}
