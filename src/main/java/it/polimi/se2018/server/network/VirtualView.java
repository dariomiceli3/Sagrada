package it.polimi.se2018.server.network;

import it.polimi.se2018.server.model.Components.Model;
import it.polimi.se2018.events.Event;

import java.util.Observable;
import java.util.Observer;

/**
 * Class VirtualView: abstract class that represents the view in the server, implements the Observer and extends the
 * Observable as a normal view. The class receive the notification from the model and send them to client across the
 * network, independently from the connection type and send the user input received from the client directly to the
 * controller
 * @see java.util.Observable
 * @see java.util.Observer
 * @author fadda-miceli-mundo
 */
public abstract class VirtualView extends Observable implements Observer {

    protected String name;
    protected Model model;
    protected int playerID;

    /**
     * Class constructor to create a virtual view associated with a unique id
     * @param playerID id of the player
     */
    public VirtualView(int playerID) {
       this.playerID = playerID;
    }

    /**
     * method that provide to the caller the name associated with the virtual view
     * @return String type of the name of the virtual view
     */
    public String getName() {
        return name;
    }

    /**
     * method that provide to the caller the model associated with the virtual view
     * @return the model
     */
    public Model getModel() {
        return model;
    }

    /**
     * method that provide to the caller the id associated with the virtual view
     * @return the id of the virtual view
     */
    public int getPlayerID() {
        return playerID;
    }

    /**
     * method that allow the caller to set the name of the virtual view
     * @param name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method that allow the caller to set the model of the virtual view
     * @param model to set
     */
    public void setModel(Model model) {
        this.model = model;
    }

    /**
     * method that allow the caller to set the unique id of the virtual view
     * @param playerID to set
     */
    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }


    /**
     * abstract method used to send the event to the client across the network independently from the technology
     * used for the communication, the subclasses will be responsible for the specific implementation of the method
     * to effectively send the event with a communication technology
     * @param event to send to the client
     */
    public abstract void sendEvent(Event event);













}
