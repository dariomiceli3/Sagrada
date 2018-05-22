package it.polimi.se2018.model.Components;

import it.polimi.se2018.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.model.Events.MVMove;
import it.polimi.se2018.model.Events.MVRound;
import it.polimi.se2018.utils.Observable;
import it.polimi.se2018.utils.Observer;

import java.util.ArrayList;
import java.util.List;

public class Model implements Observable<MVMove>  {

    private ArrayList<Observer<T>> observerList;
    private RoundTracker roundTracker;
    private DraftPool draftPool;
    private DiceBag diceBag;
    private Player player;
    private PublicObjectiveCard publicObjectiveCard;
    private List<Player> playerList;

    public RoundTracker getRoundTracker()
    {
        return roundTracker;
    }

    public DraftPool getDraftPool()
    {
        return draftPool;
    }

    public Player getPlayer()
    {
        return player;
    }

    public PublicObjectiveCard getPublicObjectiveCard()
    {
        return publicObjectiveCard;
    }

    public List<Player> getPlayerList()
    {
        return playerList;
    }

    public DiceBag getDiceBag()
    {
        return diceBag;
    }

    public void register(Observer<T> observer){
        synchronized (observerList){
            observerList.add(observer);
        }
    }

    public void deregister(Observer<T> observer){
        synchronized (observerList) {
            observerList.remove(observer);
        }
    }

    // maybe this method should be protected
    public void notify(T message) {
        synchronized (observerList) {
            for(Observer<T> observer: observerList) {
                observer.update(message);
            }
        }
    }

    //TODO add some methods to performe move, and then send a notification to the view and uodate UML (dicebag instance)
}
