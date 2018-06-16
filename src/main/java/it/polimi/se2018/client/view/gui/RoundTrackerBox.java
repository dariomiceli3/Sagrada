package it.polimi.se2018.client.view.gui;

import it.polimi.se2018.server.model.Components.RoundTracker;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RoundTrackerBox {

    private static GuiController mainController;

    private static int round;

    FileInputStream fileStream;

    public static void setMainController(GuiController mainController){
        RoundTrackerBox.mainController = mainController;
    }

    public static void setBoxRound(int round){
        RoundTrackerBox.round = round;
    }

    public static void display()  throws IOException {

        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Dice of the round: " + round);
        FXMLLoader loader = new FXMLLoader(RoundTrackerBox.class.getResource("/RoundTracker"));
        Parent root1 = (Parent) loader.load();
        Scene scene = new Scene(root1);
        window.setScene(scene);
        window.setResizable(false);
        window.showAndWait();
    }

    @FXML
    private Button button1;

    @FXML
    private ImageView dice1;

    @FXML
    private Button selectButton;

    @FXML
    private Button button2;

    @FXML
    private ImageView dice2;

    @FXML
    private Button button3;

    @FXML
    private ImageView dice3;

    @FXML
    private Button button4;

    @FXML
    private ImageView dice4;

    @FXML
    private Button button5;

    @FXML
    private ImageView dice5;

    @FXML
    private Button buton6;

    @FXML
    private ImageView dice6;

    @FXML
    private Button button7;

    @FXML
    private ImageView dice7;

    @FXML
    private Button button8;

    @FXML
    private ImageView dice8;

    @FXML
    private Button button9;

    @FXML
    private ImageView dice9;

    @FXML
    void selectMethod(MouseEvent event) {

    }

    @FXML
    void selectedDice(MouseEvent event) {
        if(button1.)
    }

    public void inizialize() throws IOException {
        loadDice();

        button1.blendModeProperty().addListener(new ChangeListener<BlendMode>() {
            @Override
            public void changed(ObservableValue<? extends BlendMode> observable, BlendMode oldValue, BlendMode newValue) {

            }

        });
        button2.blendModeProperty().addListener(new ChangeListener<BlendMode>() {
            @Override
            public void changed(ObservableValue<? extends BlendMode> observable, BlendMode oldValue, BlendMode newValue) {

            }

        });
        button3.blendModeProperty().addListener(new ChangeListener<BlendMode>() {
            @Override
            public void changed(ObservableValue<? extends BlendMode> observable, BlendMode oldValue, BlendMode newValue) {

            }

        });
        button4.blendModeProperty().addListener(new ChangeListener<BlendMode>() {
            @Override
            public void changed(ObservableValue<? extends BlendMode> observable, BlendMode oldValue, BlendMode newValue) {

            }

        });
        button5.blendModeProperty().addListener(new ChangeListener<BlendMode>() {
            @Override
            public void changed(ObservableValue<? extends BlendMode> observable, BlendMode oldValue, BlendMode newValue) {

            }

        });
        buton6.blendModeProperty().addListener(new ChangeListener<BlendMode>() {
            @Override
            public void changed(ObservableValue<? extends BlendMode> observable, BlendMode oldValue, BlendMode newValue) {

            }

        });
        button7.blendModeProperty().addListener(new ChangeListener<BlendMode>() {
            @Override
            public void changed(ObservableValue<? extends BlendMode> observable, BlendMode oldValue, BlendMode newValue) {

            }

        });
        button8.blendModeProperty().addListener(new ChangeListener<BlendMode>() {
            @Override
            public void changed(ObservableValue<? extends BlendMode> observable, BlendMode oldValue, BlendMode newValue) {

            }

        });
        button9.blendModeProperty().addListener(new ChangeListener<BlendMode>() {
            @Override
            public void changed(ObservableValue<? extends BlendMode> observable, BlendMode oldValue, BlendMode newValue) {

            }

        });

    }

    private void loadDice() throws IOException {
        for (int i = 0; i < mainController.getRoundTarcker().getRoundDice(round).size(); i++) {

            File file = new File("./");
            String fileName = mainController.getRoundTarcker().getRoundDice(round).get(i).toStringGui();
            String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/dice");

            try {
                System.out.println("consegna dadi round tracker numero " + round);
                fileStream = new FileInputStream(filePath + "/" + fileName + ".png");
                Image image = new Image(fileStream);
                if (i == 0) {
                    dice1.setImage(image);
                }
                if (i == 1) {
                    dice2.setImage(image);
                }
                if (i == 2) {
                    dice3.setImage(image);
                }
                if (i == 3) {
                    dice4.setImage(image);
                }
                if (i == 4) {
                    dice5.setImage(image);
                }
                if (i == 5) {
                    dice6.setImage(image);
                }
                if (i == 6) {
                    dice7.setImage(image);
                }
                if (i == 7) {
                    dice8.setImage(image);
                }
                if (i == 8) {
                    dice9.setImage(image);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                fileStream.close();
            }

        }
    }


}
