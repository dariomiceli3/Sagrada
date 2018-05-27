package it.polimi.se2018.server.controller;


import it.polimi.se2018.server.VirtualView;
import it.polimi.se2018.server.model.Components.Model;
import it.polimi.se2018.server.model.Events.MVPlayerNameEvent;

import java.util.Observable;
import java.util.Observer;

public class Game implements Observer {

    private Model model;

    protected Model getModel(){
        return model;
    }

    @Override
    public void update(Observable o, Object arg){

        VirtualView virtualView = (VirtualView) o;

        if (arg instanceof MVPlayerNameEvent) {

        }

    }

    protected void setPlayerID(VirtualView virtualView, String name) {

        //model.getPlayer()

    }

}