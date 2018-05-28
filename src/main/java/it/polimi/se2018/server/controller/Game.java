package it.polimi.se2018.server.controller;


import it.polimi.se2018.server.VirtualView;
import it.polimi.se2018.server.model.Components.Model;
import it.polimi.se2018.server.model.Components.Player;
import it.polimi.se2018.server.model.Events.ClientServer.PlayerNameEvent;

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


    // ogni metodo che modifica il model deve essere gestito da update (unico metodo pubblico), e chiamare il metodo
    // protected relativo al cambiamento

    protected Model getModel(){
        return model;
    }

    @Override
    public void update(Observable o, Object arg){

        VirtualView virtualView = (VirtualView) o;

        if (arg instanceof PlayerNameEvent) {
            setPlayerModelName(virtualView, ((PlayerNameEvent) arg).getName());

        }

    }

    protected void setPlayerModelName(VirtualView view, String name) {

        //model.getPlayerFromID(view.getPlayerID()).setPlayerName(name);
        model.setPlayerAndNotify((view.getPlayerID()), name);
    }

}