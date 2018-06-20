package it.polimi.se2018.client.view.gui;

import it.polimi.se2018.server.model.Components.Player;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;


public class EndGameScene {

    @FXML
    private TextField winnerText;

    @FXML
    private TextArea rankText1;

    @FXML
    private TextArea rankText2;

    @FXML
    private TextArea rankText3;

    @FXML
    private TextArea rankText4;


    private static List<Player> playerList;

    protected static void setPlayerList(List<Player> playerList){

        EndGameScene.playerList = playerList;
    }


    public static void display() throws IOException {
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("GAME OVER");
        FXMLLoader loader = new FXMLLoader(RoundTrackerBox.class.getResource("/EndGame.fxml"));
        Parent root1 = (Parent) loader.load();
        Scene scene = new Scene(root1);
        window.setScene(scene);
        window.setResizable(false);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                window.showAndWait();
            }
        });
    }

    public void initialize(){

        winnerText.setText("Winner: " + playerList.get(0).getPlayerName() + "     Score : " + playerList.get(0).getFinalPoints());

        for (Player player : playerList) {
            int i = 0;
            if(i == 0) {
                rankText1.setText(player.toStringPoints() + "\n");
            }
            if(i == 1) {
                rankText2.setText(player.toStringPoints() + "\n");
            }
            if(i == 2) {
                rankText3.setText(player.toStringPoints() + "\n");
            }
            if(i == 3) {
                rankText4.setText(player.toStringPoints() + "\n");
            }
            i++;

        }
    }
}
