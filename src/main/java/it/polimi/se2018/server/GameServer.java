package it.polimi.se2018.server;

import it.polimi.se2018.server.controller.Game;
import it.polimi.se2018.server.model.Components.Model;
import it.polimi.se2018.server.model.Components.Player;

import java.util.ArrayList;
import java.util.List;

public class GameServer {

    private Model model;
    private List<VirtualView> viewGame;
    private Game controller;
    private List<Player> playerList;

    public GameServer(List<VirtualView> viewList) {

        // creazione arraylist di view e player correnti
        // decidere per ordine, se casuale oppure fare la domanda della cattedrale

        this.model = new Model();

        this.viewGame = new ArrayList<>(viewList);
        //this.viewList.addAll(viewList);
        this.playerList = new ArrayList<>();

        for(VirtualView view : viewGame) {
            Player player = new Player(view.getPlayerID());
            System.out.println("Player id in Game server"+ player.getPlayerID());
            playerList.add(player);
        }

        model.setPlayerList(playerList);

        this.controller = new Game(model, this.viewGame);

        for(VirtualView view : viewGame) {

            view.addObserver(controller);
            view.setModel(model);
            model.addObserver(view);
        }

        //TODO fare start del game su controller


    }

}
