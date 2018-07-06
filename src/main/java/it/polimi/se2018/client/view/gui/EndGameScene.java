package it.polimi.se2018.client.view.gui;

import it.polimi.se2018.server.model.Components.Player;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Class EndGameScene: class that handles to rank the final points of the players at the end of the game
 * @author fadda-miceli-mundo
 */
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


    private static boolean singlePlayer;
    private static boolean winnerSingle;
    private static int playerPoints;
    private static int gameThreshold;
    private static boolean finish;
    private static List<Player> playerList;

    /**
     *  method that allows to set the modality of the game
     * @param singlePlayer boolean that indicates if the mode is single player
     */
    public static void setSinglePlayer(boolean singlePlayer) {
        EndGameScene.singlePlayer = singlePlayer;
    }

    /**
     * method that allows to set if the player won or not
     * @param winnerSingle boolean that indicates if the player won
     */
    static void setWinnerSingle(boolean winnerSingle) {
        EndGameScene.winnerSingle = winnerSingle;
    }

    /**
     * method that allows to set the total points of the player
     * @param playerPoints points of the player
     */
    static void setPlayerPoints(int playerPoints) {
        EndGameScene.playerPoints = playerPoints;
    }

    /**
     * method that allows to set the threshold for the single player mode
     * @param gameThreshold threshold of the game
     */
    static void setGameThreshold(int gameThreshold) {
        EndGameScene.gameThreshold = gameThreshold;
    }

    /**
     * method that allows to set if the game is finished or not
     * @param finish boolean that indicates if the game is finished
     */
    static void setFinish(boolean finish) {
        EndGameScene.finish = finish;
    }

    /**
     * method that allows to set the list of all players
     * @param playerList list of all players
     */
    protected static void setPlayerList(List<Player> playerList) {
        EndGameScene.playerList = playerList;
    }

    /**
     * method that initializes the scene of the final rank
     */
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
            winnerText.setText("GameController never played");
        }
    }

    /**
     * method that display the end of the game
     * @throws IOException if something goes wrong
     */
    public static void display() throws IOException {
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("GAME OVER");
        FXMLLoader loader = new FXMLLoader(EndGameScene.class.getResource("/EndGame.fxml"));
        Parent root1 = loader.load();
        Scene scene = new Scene(root1);
        InputStream fileStream = EndGameScene.class.getResourceAsStream("/images/icon" + ".png");
        Image image = new Image(fileStream);
        window.getIcons().add(image);
        window.setScene(scene);
        window.setResizable(false);
        Platform.runLater(window::showAndWait);
    }


}
