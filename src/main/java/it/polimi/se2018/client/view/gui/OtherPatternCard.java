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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class OtherPatternCard {

    private static PatternCard patternCard;
    private FileInputStream fileStream;

    public static void setPatternCard(PatternCard patternCard) {
        OtherPatternCard.patternCard = patternCard;
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


    public static void displayOtherPattern(String name) throws IOException {
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Pattern Card of : "/* + name*/);
        FXMLLoader loader = new FXMLLoader(OtherPatternCard.class.getResource("/PatternOtherPlayer.fxml"));
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


    public void initialize() {

        loadPattern();

        for (int i = 0; i < patternCard.getPattern().size(); i++) {
            if (!patternCard.getPattern().get(i).isBoxEmpty()) {
                patternCard.getDice(i);
                try {
                    loadDice(i);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void loadPattern() {
        File file = new File("./");
        String fileName = patternCard.getName();
        String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/pattern");

        try {
            System.out.println("consegna pattern");
            fileStream = new FileInputStream(filePath + "/" + fileName + ".jpg");
            Image image = new Image(fileStream);
            pattern.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadDice(int indexPattern) throws IOException {

        File file = new File("./");
        String fileName = patternCard.getDice(indexPattern).toStringGui();
        String filePath = file.getAbsolutePath().replace(".", "src/main/resources/images/dice");

        try {
            fileStream = new FileInputStream(filePath + "/" + fileName + ".png");
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            fileStream.close();
        }

    }




}
