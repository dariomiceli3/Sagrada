package it.polimi.se2018.server.controller;


import it.polimi.se2018.server.VirtualView;
import it.polimi.se2018.server.model.Components.Model;
import it.polimi.se2018.server.model.Components.Player;
import it.polimi.se2018.server.model.Events.MVPlayerNameEvent;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Game implements Observer {

    private Model model;
    private List<Player> playerListGame;
    // add timer

    public Game(Model model) {
        this.model = model;
        this.playerListGame = model.getPlayerList();
    }



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

        //model.getPlayerList()

        // TODO completare metodo controller per settare nome
    }

}