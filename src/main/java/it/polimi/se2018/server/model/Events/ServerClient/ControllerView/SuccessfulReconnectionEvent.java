package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.controller.ToolCard;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.server.model.Components.Player;
import it.polimi.se2018.server.model.Events.Event;

import java.util.List;

public class SuccessfulReconnectionEvent implements Event {

    private static final long serialVersionUID = 374843743897L;

    private Player currPlayer;
    private boolean singlePlayer;
    private boolean gameStarted;
    //private boolean maxPlayers;
    private List<ToolCard> toolList;
    private List<PublicObjectiveCard>  publicCardList;
    private List <Player> playerList;

    public SuccessfulReconnectionEvent(Player currPlayer, boolean singlePlayer, boolean gameStarted, List<ToolCard> toolList, List<PublicObjectiveCard> publicCardList, List<Player> playerList) {


        this.currPlayer = currPlayer;
        this.singlePlayer = singlePlayer;
        this.gameStarted = gameStarted;
        this.toolList = toolList;
        this.publicCardList = publicCardList;
        this.playerList = playerList;

    }
    public boolean isGameStarted() {
        return gameStarted;
    }

    public List<ToolCard> getToolList() {
        return toolList;
    }

    public List<PublicObjectiveCard> getPublicCardList() {
        return publicCardList;
    }

    public Player getCurrPlayer() {
        return currPlayer;
    }

    public List<Player> getPlayerList() {

        return playerList;
    }

    public boolean isSinglePlayer() {
        return singlePlayer;
    }
}

