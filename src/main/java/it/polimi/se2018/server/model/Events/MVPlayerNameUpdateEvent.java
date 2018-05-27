package it.polimi.se2018.server.model.Events;

public class MVPlayerNameUpdateEvent {



    private final String name;

    public MVPlayerNameUpdateEvent(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
