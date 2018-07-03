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

    private static boolean singlePlayer;
    private static boolean winnerSingle;
    private static int playerPoints;
    private static int gameThreshold;
    private static boolean finish;
    private static List<Player> playerList;

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

    //------Single Player instance variables and observer method-----------


    public static void setSinglePlayer(boolean singlePlayer) {
        EndGameScene.singlePlayer = singlePlayer;
    }
    static void setWinnerSingle(boolean winnerSingle) {
        EndGameScene.winnerSingle = winnerSingle;
    }
    static void setPlayerPoints(int playerPoints) {
        EndGameScene.playerPoints = playerPoints;
    }
    static void setGameThreshold(int gameThreshold) {
        EndGameScene.gameThreshold = gameThreshold;
    }
    static void setFinish(boolean finish) {
        EndGameScene.finish = finish;
    }
    protected static void setPlayerList(List<Player> playerList) {
        EndGameScene.playerList = playerList;
    }


    public static void display() throws IOException {
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("GAME OVER");
        FXMLLoader loader = new FXMLLoader(EndGameScene.class.getResource("/EndGame.fxml"));
        Parent root1 = loader.load();
        Scene scene = new Scene(root1);
        window.setScene(scene);
        window.setResizable(false);
        Platform.runLater(window::showAndWait);
    }

    public void initialize() {

        if (finish) {
            if (singlePlayer) {

                if (winnerSingle) {

                    winnerText.setText("You Win!" + "   Score : " + playerPoints);
                    rankText2.setVisible(true);
                    rankText2.setText("Threshold : " + gameThreshold);

                } else {

                    winnerText.setText("You Lose!" + "  Score : " + playerPoints);
                    rankText2.setVisible(true);
                    rankText2.setText("Threshold : " + gameThreshold);
                }
            }
            else {

                winnerText.setText("Winner: " + playerList.get(0).getPlayerName() + "     Score : " + playerList.get(0).getFinalPoints());

                for (int i = 0; i < playerList.size(); i++) {
                    if (i == 0) {
                        rankText1.setVisible(true);
                        rankText1.setText(playerList.get(i).toStringPoints());
                    }
                    if (i == 1) {
                        rankText2.setVisible(true);
                        rankText2.setText(playerList.get(i).toStringPoints());
                    }
                    if (i == 2) {
                        rankText3.setVisible(true);
                        rankText3.setText(playerList.get(i).toStringPoints());
                    }
                    if (i == 3) {
                        rankText4.setVisible(true);
                        rankText4.setText(playerList.get(i).toStringPoints());
                    }
                }
            }
        }
        else {
            winnerText.setText("Game never played");
        }
    }
}
