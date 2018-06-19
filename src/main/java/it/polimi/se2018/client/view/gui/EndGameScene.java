package it.polimi.se2018.client.view.gui;

import it.polimi.se2018.server.model.Components.Player;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.List;


public class EndGameScene {

    @FXML
    private TextField winnerText;

    @FXML
    private TextArea rankText;

    private static List<Player> playerList;

    private static void setPlayerList(List<Player> playerList){

        EndGameScene.playerList = playerList;
    }

    public void inizialize(){

        winnerText.setText("Winner: " + playerList.get(0).getPlayerName() + "     Score : " + playerList.get(0).getFinalPoints());

        for (Player player : playerList) {
            rankText.setText(player.toStringPoints() + "\n");
        }
    }
}
