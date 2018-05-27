package it.polimi.se2018.server.model.Events;

public class MVPlayerNameEvent implements Event {

    //private static final long serialversionuid

    private final String name;

    public MVPlayerNameEvent(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
