package it.polimi.se2018.server;

import it.polimi.se2018.server.controller.Game;
import it.polimi.se2018.server.model.Components.Model;
import it.polimi.se2018.server.model.Components.Player;

import java.util.ArrayList;
import java.util.List;

public class GameServer {

    private final Model model;
    private List<VirtualView> viewList;
    private final Game controller;
    private List<Player> playerList;

    public GameServer(List<VirtualView> viewList) {

        // creazione arraylist di view e player correnti
        // decidere per ordine, se casuale oppure fare la domanda della cattedrale

        this.viewList = new ArrayList<>();
        this.viewList = viewList;
        this.playerList = new ArrayList<>();

        this.model = new Model();

        for(VirtualView view : viewList) {
            Player player = new Player(view.getName());
            playerList.add(player);
        }

        model.setPlayerList(playerList);

        this.controller = new Game(model);

        for(VirtualView view : viewList) {

            view.addObserver(controller);
            view.setModel(model);
            model.addObserver(view);
        }

        //TODO fare start del game su controller





    }
}
