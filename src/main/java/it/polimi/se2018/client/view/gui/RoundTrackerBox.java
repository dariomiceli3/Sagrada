package it.polimi.se2018.client.view.gui;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.*;
import java.util.logging.Logger;

public class RoundTrackerBox {

    private final Logger log = Logger.getLogger(RoundTrackerBox.class.getName());
    private static final String logMsg = "Null pointer catch";
    private static BoardController board;
    private static int round;
    private int selectedDice;
    private static Stage window;
    private InputStream fileStream;

    static void setMainController(BoardController board){
        RoundTrackerBox.board = board;
    }
    static void setBoxRound(int round){
        RoundTrackerBox.round = round;
    }

    public void initialize() throws IOException {
        loadDice();
    }

    public static void display()  throws IOException {
        window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Dice of the round: " + round);
        FXMLLoader loader = new FXMLLoader(RoundTrackerBox.class.getResource("/RoundTracker.fxml"));
        Parent root1 = loader.load();
        Scene scene = new Scene(root1);
        InputStream stream = CustomCard.class.getResourceAsStream("/images/icon" + ".png");
        Image image = new Image(stream);
        window.getIcons().add(image);
        window.setScene(scene);
        window.setResizable(false);
        Platform.runLater(() -> window.showAndWait());
    }

    @FXML
    private ToggleButton button1;
    @FXML
    private ImageView dice1;
    @FXML
    private Button selectButton;
    @FXML
    private ToggleButton button2;
    @FXML
    private ImageView dice2;
    @FXML
    private ToggleButton button3;
    @FXML
    private ImageView dice3;
    @FXML
    private ToggleButton button4;
    @FXML
    private ImageView dice4;
    @FXML
    private ToggleButton button5;
    @FXML
    private ImageView dice5;
    @FXML
    private ToggleButton button6;
    @FXML
    private ImageView dice6;
    @FXML
    private ToggleButton button7;
    @FXML
    private ImageView dice7;
    @FXML
    private ToggleButton button8;
    @FXML
    private ImageView dice8;
    @FXML
    private ToggleButton button9;
    @FXML
    private ImageView dice9;
    @FXML
    private ToggleGroup buttonGroup;


    @FXML
    void selectMethod() {
        window.close();
    }

    @FXML
    void selectedDice() {

        try {
            if (buttonGroup.selectedToggleProperty().isNull().get()) {
                button1.setBlendMode(BlendMode.SRC_OVER);
                button2.setBlendMode(BlendMode.SRC_OVER);
                button3.setBlendMode(BlendMode.SRC_OVER);
                button4.setBlendMode(BlendMode.SRC_OVER);
                button5.setBlendMode(BlendMode.SRC_OVER);
                button6.setBlendMode(BlendMode.SRC_OVER);
                button7.setBlendMode(BlendMode.SRC_OVER);
                button8.setBlendMode(BlendMode.SRC_OVER);
                button9.setBlendMode(BlendMode.SRC_OVER);
            } else {
                if (buttonGroup.getSelectedToggle().equals(button1)) {

                        button1.setBlendMode(BlendMode.COLOR_BURN);
                        button2.setBlendMode(BlendMode.SRC_OVER);
                        button3.setBlendMode(BlendMode.SRC_OVER);
                        button4.setBlendMode(BlendMode.SRC_OVER);
                        button5.setBlendMode(BlendMode.SRC_OVER);
                        button6.setBlendMode(BlendMode.SRC_OVER);
                        button7.setBlendMode(BlendMode.SRC_OVER);
                        button8.setBlendMode(BlendMode.SRC_OVER);
                        button9.setBlendMode(BlendMode.SRC_OVER);
                        board.setIndexPosition(0);
                }
                if (buttonGroup.getSelectedToggle().equals(button2)) {

                        button1.setBlendMode(BlendMode.SRC_OVER);
                        button2.setBlendMode(BlendMode.COLOR_BURN);
                        button3.setBlendMode(BlendMode.SRC_OVER);
                        button4.setBlendMode(BlendMode.SRC_OVER);
                        button5.setBlendMode(BlendMode.SRC_OVER);
                        button6.setBlendMode(BlendMode.SRC_OVER);
                        button7.setBlendMode(BlendMode.SRC_OVER);
                        button8.setBlendMode(BlendMode.SRC_OVER);
                        button9.setBlendMode(BlendMode.SRC_OVER);
                        board.setIndexPosition(1);

                }
                if (buttonGroup.getSelectedToggle().equals(button3)) {

                        button1.setBlendMode(BlendMode.SRC_OVER);
                        button2.setBlendMode(BlendMode.SRC_OVER);
                        button3.setBlendMode(BlendMode.COLOR_BURN);
                        button4.setBlendMode(BlendMode.SRC_OVER);
                        button5.setBlendMode(BlendMode.SRC_OVER);
                        button6.setBlendMode(BlendMode.SRC_OVER);
                        button7.setBlendMode(BlendMode.SRC_OVER);
                        button8.setBlendMode(BlendMode.SRC_OVER);
                        button9.setBlendMode(BlendMode.SRC_OVER);
                        board.setIndexPosition(2);

                }
                if (buttonGroup.getSelectedToggle().equals(button4)) {

                        button1.setBlendMode(BlendMode.SRC_OVER);
                        button2.setBlendMode(BlendMode.SRC_OVER);
                        button3.setBlendMode(BlendMode.SRC_OVER);
                        button4.setBlendMode(BlendMode.COLOR_BURN);
                        button5.setBlendMode(BlendMode.SRC_OVER);
                        button6.setBlendMode(BlendMode.SRC_OVER);
                        button7.setBlendMode(BlendMode.SRC_OVER);
                        button8.setBlendMode(BlendMode.SRC_OVER);
                        button9.setBlendMode(BlendMode.SRC_OVER);
                        board.setIndexPosition(3);

                }
                if (buttonGroup.getSelectedToggle().equals(button5)) {

                        button1.setBlendMode(BlendMode.SRC_OVER);
                        button2.setBlendMode(BlendMode.SRC_OVER);
                        button3.setBlendMode(BlendMode.SRC_OVER);
                        button4.setBlendMode(BlendMode.SRC_OVER);
                        button5.setBlendMode(BlendMode.COLOR_BURN);
                        button6.setBlendMode(BlendMode.SRC_OVER);
                        button7.setBlendMode(BlendMode.SRC_OVER);
                        button8.setBlendMode(BlendMode.SRC_OVER);
                        button9.setBlendMode(BlendMode.SRC_OVER);
                        board.setIndexPosition(4);

                }
                if (buttonGroup.getSelectedToggle().equals(button6)) {

                        button1.setBlendMode(BlendMode.SRC_OVER);
                        button2.setBlendMode(BlendMode.SRC_OVER);
                        button3.setBlendMode(BlendMode.SRC_OVER);
                        button4.setBlendMode(BlendMode.SRC_OVER);
                        button5.setBlendMode(BlendMode.SRC_OVER);
                        button6.setBlendMode(BlendMode.COLOR_BURN);
                        button7.setBlendMode(BlendMode.SRC_OVER);
                        button8.setBlendMode(BlendMode.SRC_OVER);
                        button9.setBlendMode(BlendMode.SRC_OVER);
                        board.setIndexPosition(5);
                }
                if (buttonGroup.getSelectedToggle().equals(button7)) {

                        button1.setBlendMode(BlendMode.SRC_OVER);
                        button2.setBlendMode(BlendMode.SRC_OVER);
                        button3.setBlendMode(BlendMode.SRC_OVER);
                        button4.setBlendMode(BlendMode.SRC_OVER);
                        button5.setBlendMode(BlendMode.SRC_OVER);
                        button6.setBlendMode(BlendMode.SRC_OVER);
                        button7.setBlendMode(BlendMode.COLOR_BURN);
                        button8.setBlendMode(BlendMode.SRC_OVER);
                        button9.setBlendMode(BlendMode.SRC_OVER);
                        board.setIndexPosition(6);

                }
                if (buttonGroup.getSelectedToggle().equals(button8)) {

                        button1.setBlendMode(BlendMode.SRC_OVER);
                        button2.setBlendMode(BlendMode.SRC_OVER);
                        button3.setBlendMode(BlendMode.SRC_OVER);
                        button4.setBlendMode(BlendMode.SRC_OVER);
                        button5.setBlendMode(BlendMode.SRC_OVER);
                        button6.setBlendMode(BlendMode.SRC_OVER);
                        button7.setBlendMode(BlendMode.SRC_OVER);
                        button8.setBlendMode(BlendMode.COLOR_BURN);
                        button9.setBlendMode(BlendMode.SRC_OVER);
                        board.setIndexPosition(7);
                }
                if (buttonGroup.getSelectedToggle().equals(button9)) {

                        button1.setBlendMode(BlendMode.SRC_OVER);
                        button2.setBlendMode(BlendMode.SRC_OVER);
                        button3.setBlendMode(BlendMode.SRC_OVER);
                        button4.setBlendMode(BlendMode.SRC_OVER);
                        button5.setBlendMode(BlendMode.SRC_OVER);
                        button6.setBlendMode(BlendMode.SRC_OVER);
                        button7.setBlendMode(BlendMode.SRC_OVER);
                        button8.setBlendMode(BlendMode.SRC_OVER);
                        button9.setBlendMode(BlendMode.COLOR_BURN);
                        board.setIndexPosition(8);
                }
            }
        }
        catch(NullPointerException e){
            log.info(logMsg);
            log.warning(e.getMessage());
        }

    }


    private void loadDice() throws IOException {

        for (int i = 0; i < board.getRoundTracker().getRoundDice(round).size(); i++) {

            String fileName = board.getRoundTracker().getRoundDice(round).get(i).toStringGui();

            try {
                log.info("dice on the round tracker in round: " + round);
                fileStream = RoundTrackerBox.class.getResourceAsStream("/images/dice/" + fileName + ".png");
                Image image = new Image(fileStream);
                if (i == 0) {
                    dice1.setImage(image);
                    button1.setVisible(true);
                }
                if (i == 1) {
                    dice2.setImage(image);
                    button2.setVisible(true);
                }
                if (i == 2) {
                    dice3.setImage(image);
                    button3.setVisible(true);
                }
                if (i == 3) {
                    dice4.setImage(image);
                    button4.setVisible(true);
                }
                if (i == 4) {
                    dice5.setImage(image);
                    button5.setVisible(true);
                }
                if (i == 5) {
                    dice6.setImage(image);
                    button6.setVisible(true);
                }
                if (i == 6) {
                    dice7.setImage(image);
                    button7.setVisible(true);
                }
                if (i == 7) {
                    dice8.setImage(image);
                    button8.setVisible(true);
                }
                if (i == 8) {
                    dice9.setImage(image);
                    button9.setVisible(true);
                }
            }
            finally {
                fileStream.close();
            }

        }
    }
}
