package it.polimi.se2018.model.Events;

import java.util.Observable;

public class EventsObservable extends Observable {

    private Event event;

    public EventsObservable() {
        this.event = null;
    }

    public EventsObservable(Event event){
        this.event = event;
    }

    public Event getEvent(){
        return event;
    }

    public void setEvent(Event event){
        this.event = event;
        // TODO ricontrollare questo setchanged e notifyObservers
        setChanged();
        notifyObservers();
    }

    public void cleanEvent(){
        this.event = null;
    }


}
