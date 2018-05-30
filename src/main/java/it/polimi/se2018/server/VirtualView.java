package it.polimi.se2018.server;

import it.polimi.se2018.server.model.Components.Model;
import it.polimi.se2018.server.model.Events.Event;

import java.util.Observable;
import java.util.Observer;

public abstract class VirtualView extends Observable implements Observer {

    protected String name;
    protected Model model;
    protected int playerID;

    public VirtualView(int playerID) {
       this.playerID = playerID;
    }

    /*public VirtualView(String name, Server server, int ID) {
        this.name = name;
        this.server = server;
        this.playerID = ID;

    }*/

    // metodo che manda al client la richiesta di eventi aggiornati, va a prenderle dal model
    // eventi che non passano dal controller
    public void sendUpdate (Event eventUpdate) {

        //if (eventUpdate instanceof )

    }

    public abstract void sendEvent(Event event);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int ID) {
        this.playerID = ID;
    }







}
