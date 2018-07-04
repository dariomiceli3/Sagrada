package it.polimi.se2018.client.view.gui;

import it.polimi.se2018.server.model.Cards.PatternCard;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.util.logging.Logger;

public class PatternCardBox {

    private final Logger log = Logger.getLogger(PatternCardBox.class.getName());
    private static PatternCard patternCard;
    private InputStream fileStream;

    public static void setPatternCard(PatternCard patternCard) {
        PatternCardBox.patternCard = patternCard;
    }

    public void initialize() {

        loadPattern();

        for (int i = 0; i < patternCard.getPattern().size(); i++) {
            if (!patternCard.getPattern().get(i).isBoxEmpty()) {
                patternCard.getDice(i);
                try {
                    loadDice(i);
                } catch (IOException e) {
                    log.warning(e.getMessage());
                }
            }
        }
    }


    static void displayOtherPattern(String name) throws IOException {
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Pattern Card of : " + name);
        FXMLLoader loader = new FXMLLoader(PatternCardBox.class.getResource("/PatternOtherPlayer.fxml"));
        Parent root1 = loader.load();
        Scene scene = new Scene(root1);
        InputStream fileStream = PatternCardBox.class.getResourceAsStream("/images/icon" + ".png");
        Image image = new Image(fileStream);
        window.getIcons().add(image);
        window.setScene(scene);
        window.setResizable(false);
        Platform.runLater(window::showAndWait);
    }



    @FXML
    private ImageView pattern;
    @FXML
    private ImageView glassBox1;
    @FXML
    private ImageView glassBox2;
    @FXML
    private ImageView glassBox3;
    @FXML
    private ImageView glassBox4;
    @FXML
    private ImageView glassBox5;
    @FXML
    private ImageView glassBox6;
    @FXML
    private ImageView glassBox7;
    @FXML
    private ImageView glassBox8;
    @FXML
    private ImageView glassBox9;
    @FXML
    private ImageView glassBox10;
    @FXML
    private ImageView glassBox11;
    @FXML
    private ImageView glassBox12;
    @FXML
    private ImageView glassBox13;
    @FXML
    private ImageView glassBox14;
    @FXML
    private ImageView glassBox15;
    @FXML
    private ImageView glassBox16;
    @FXML
    private ImageView glassBox17;
    @FXML
    private ImageView glassBox18;
    @FXML
    private ImageView glassBox19;
    @FXML
    private ImageView glassBox20;




    private void loadPattern() {
        String fileName = patternCard.getName();

        if (patternCard.isCustom()) {
            pattern.setImage(CustomCard.rendering(patternCard));
            pattern.setLayoutX(123);
            pattern.setLayoutY(63);
            pattern.setRotate(360);
            pattern.setFitHeight(280);
            pattern.setFitWidth(366);
        } else {
            fileStream = BoardController.class.getResourceAsStream("/images/pattern/" + fileName + ".png");
            Image image = new Image(fileStream);
            pattern.setImage(image);
        }
    }


    private void loadDice(int indexPattern) throws IOException {

        String fileName = patternCard.getDice(indexPattern).toStringGui();
        fileStream = PatternCardBox.class.getResourceAsStream("/images/dice/" + fileName + ".png");

        try {
            Image image = new Image(fileStream);
            if (indexPattern == 0) {
                glassBox1.setImage(image);
            }
            if (indexPattern == 1) {
                glassBox2.setImage(image);
            }
            if (indexPattern == 2) {
                glassBox3.setImage(image);
            }
            if (indexPattern == 3) {
                glassBox4.setImage(image);
            }
            if (indexPattern == 4) {
                glassBox5.setImage(image);
            }
            if (indexPattern == 5) {
                glassBox6.setImage(image);
            }
            if (indexPattern == 6) {
                glassBox7.setImage(image);
            }
            if (indexPattern == 7) {
                glassBox8.setImage(image);
            }
            if (indexPattern == 8) {
                glassBox9.setImage(image);
            }
            if (indexPattern == 9) {
                glassBox10.setImage(image);
            }
            if (indexPattern == 10) {
                glassBox11.setImage(image);
            }
            if (indexPattern == 11) {
                glassBox12.setImage(image);
            }
            if (indexPattern == 12) {
                glassBox13.setImage(image);
            }
            if (indexPattern == 13) {
                glassBox14.setImage(image);
            }
            if (indexPattern == 14) {
                glassBox15.setImage(image);
            }
            if (indexPattern == 15) {
                glassBox16.setImage(image);
            }
            if (indexPattern == 16) {
                glassBox17.setImage(image);
            }
            if (indexPattern == 17) {
                glassBox18.setImage(image);
            }
            if (indexPattern == 18) {
                glassBox19.setImage(image);
            }
            if (indexPattern == 19) {
                glassBox20.setImage(image);
            }
        }
        finally {
            fileStream.close();
        }

    }
}
