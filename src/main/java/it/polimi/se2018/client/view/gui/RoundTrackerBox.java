package it.polimi.se2018.client.view.gui;

import it.polimi.se2018.server.model.Components.RoundTracker;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RoundTrackerBox {

    private static BoardController board;

    private static int round;

    private int selectedDice;

    FileInputStream fileStream;

    public static void setMainController(BoardController board){
        RoundTrackerBox.board = board;
    }

    public static void setBoxRound(int round){
        RoundTrackerBox.round = round;
    }

    public static void display()  throws IOException {

        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Dice of the round: " + round);
        FXMLLoader loader = new FXMLLoader(RoundTrackerBox.class.getResource("/RoundTracker.fxml"));
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
    void selectMethod(MouseEvent event) {

        System.out.println(selectedDice);

    }

    @FXML
    void selectedDice(MouseEvent event) {

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

                    if (event.getButton().equals(MouseButton.PRIMARY)) {
                        button1.setBlendMode(BlendMode.COLOR_BURN);
                        button2.setBlendMode(BlendMode.SRC_OVER);
                        button3.setBlendMode(BlendMode.SRC_OVER);
                        button4.setBlendMode(BlendMode.SRC_OVER);
                        button5.setBlendMode(BlendMode.SRC_OVER);
                        button6.setBlendMode(BlendMode.SRC_OVER);
                        button7.setBlendMode(BlendMode.SRC_OVER);
                        button8.setBlendMode(BlendMode.SRC_OVER);
                        button9.setBlendMode(BlendMode.SRC_OVER);
                        selectedDice = 0;
                    }
                }
                if (buttonGroup.getSelectedToggle().equals(button2)) {
                    if (event.getButton().equals(MouseButton.PRIMARY)) {
                        button1.setBlendMode(BlendMode.SRC_OVER);
                        button2.setBlendMode(BlendMode.COLOR_BURN);
                        button3.setBlendMode(BlendMode.SRC_OVER);
                        button4.setBlendMode(BlendMode.SRC_OVER);
                        button5.setBlendMode(BlendMode.SRC_OVER);
                        button6.setBlendMode(BlendMode.SRC_OVER);
                        button7.setBlendMode(BlendMode.SRC_OVER);
                        button8.setBlendMode(BlendMode.SRC_OVER);
                        button9.setBlendMode(BlendMode.SRC_OVER);
                        selectedDice = 1;
                    }
                }
                if (buttonGroup.getSelectedToggle().equals(button3)) {
                    if (event.getButton().equals(MouseButton.PRIMARY)) {
                        button1.setBlendMode(BlendMode.SRC_OVER);
                        button2.setBlendMode(BlendMode.SRC_OVER);
                        button3.setBlendMode(BlendMode.COLOR_BURN);
                        button4.setBlendMode(BlendMode.SRC_OVER);
                        button5.setBlendMode(BlendMode.SRC_OVER);
                        button6.setBlendMode(BlendMode.SRC_OVER);
                        button7.setBlendMode(BlendMode.SRC_OVER);
                        button8.setBlendMode(BlendMode.SRC_OVER);
                        button9.setBlendMode(BlendMode.SRC_OVER);
                        selectedDice = 2;
                    }
                }
                if (buttonGroup.getSelectedToggle().equals(button4)) {
                    if (event.getButton().equals(MouseButton.PRIMARY)) {
                        button1.setBlendMode(BlendMode.SRC_OVER);
                        button2.setBlendMode(BlendMode.SRC_OVER);
                        button3.setBlendMode(BlendMode.SRC_OVER);
                        button4.setBlendMode(BlendMode.COLOR_BURN);
                        button5.setBlendMode(BlendMode.SRC_OVER);
                        button6.setBlendMode(BlendMode.SRC_OVER);
                        button7.setBlendMode(BlendMode.SRC_OVER);
                        button8.setBlendMode(BlendMode.SRC_OVER);
                        button9.setBlendMode(BlendMode.SRC_OVER);
                        selectedDice = 3;
                    }
                }
                if (buttonGroup.getSelectedToggle().equals(button5)) {
                    if (event.getButton().equals(MouseButton.PRIMARY)) {
                        button1.setBlendMode(BlendMode.SRC_OVER);
                        button2.setBlendMode(BlendMode.SRC_OVER);
                        button3.setBlendMode(BlendMode.SRC_OVER);
                        button4.setBlendMode(BlendMode.SRC_OVER);
                        button5.setBlendMode(BlendMode.COLOR_BURN);
                        button6.setBlendMode(BlendMode.SRC_OVER);
                        button7.setBlendMode(BlendMode.SRC_OVER);
                        button8.setBlendMode(BlendMode.SRC_OVER);
                        button9.setBlendMode(BlendMode.SRC_OVER);
                        selectedDice = 4;
                    }
                }
                if (buttonGroup.getSelectedToggle().equals(button6)) {
                    if (event.getButton().equals(MouseButton.PRIMARY)) {
                        button1.setBlendMode(BlendMode.SRC_OVER);
                        button2.setBlendMode(BlendMode.SRC_OVER);
                        button3.setBlendMode(BlendMode.SRC_OVER);
                        button4.setBlendMode(BlendMode.SRC_OVER);
                        button5.setBlendMode(BlendMode.SRC_OVER);
                        button6.setBlendMode(BlendMode.COLOR_BURN);
                        button7.setBlendMode(BlendMode.SRC_OVER);
                        button8.setBlendMode(BlendMode.SRC_OVER);
                        button9.setBlendMode(BlendMode.SRC_OVER);
                        selectedDice = 5;
                    }
                }
                if (buttonGroup.getSelectedToggle().equals(button7)) {
                    if (event.getButton().equals(MouseButton.PRIMARY)) {
                        button1.setBlendMode(BlendMode.SRC_OVER);
                        button2.setBlendMode(BlendMode.SRC_OVER);
                        button3.setBlendMode(BlendMode.SRC_OVER);
                        button4.setBlendMode(BlendMode.SRC_OVER);
                        button5.setBlendMode(BlendMode.SRC_OVER);
                        button6.setBlendMode(BlendMode.SRC_OVER);
                        button7.setBlendMode(BlendMode.COLOR_BURN);
                        button8.setBlendMode(BlendMode.SRC_OVER);
                        button9.setBlendMode(BlendMode.SRC_OVER);
                        selectedDice = 6;
                    }
                }
                if (buttonGroup.getSelectedToggle().equals(button8)) {
                    if (event.getButton().equals(MouseButton.PRIMARY)) {
                        button1.setBlendMode(BlendMode.SRC_OVER);
                        button2.setBlendMode(BlendMode.SRC_OVER);
                        button3.setBlendMode(BlendMode.SRC_OVER);
                        button4.setBlendMode(BlendMode.SRC_OVER);
                        button5.setBlendMode(BlendMode.SRC_OVER);
                        button6.setBlendMode(BlendMode.SRC_OVER);
                        button7.setBlendMode(BlendMode.SRC_OVER);
                        button8.setBlendMode(BlendMode.COLOR_BURN);
                        button9.setBlendMode(BlendMode.SRC_OVER);
                        selectedDice = 7;
                    }
                }
                if (buttonGroup.getSelectedToggle().equals(button9)) {
                    if (event.getButton().equals(MouseButton.PRIMARY)) {

                        button1.setBlendMode(BlendMode.SRC_OVER);
                        button2.setBlendMode(BlendMode.SRC_OVER);
                        button3.setBlendMode(BlendMode.SRC_OVER);
                        button4.setBlendMode(BlendMode.SRC_OVER);
                        button5.setBlendMode(BlendMode.SRC_OVER);
                        button6.setBlendMode(BlendMode.SRC_OVER);
                        button7.setBlendMode(BlendMode.SRC_OVER);
                        button8.setBlendMode(BlendMode.SRC_OVER);
                        button9.setBlendMode(BlendMode.COLOR_BURN);
                        selectedDice = 8;
                    }
                }
            }
        }catch(NullPointerException e){
        }

    }

    public void initialize() throws IOException {


        loadDice();

        selectButton.disableProperty().bind(Bindings.isNull(buttonGroup.selectedToggleProperty()));

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
        button6.blendModeProperty().addListener(new ChangeListener<BlendMode>() {
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
        button1.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

            }

        });
        button1.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

            }

        });
        button2.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

            }

        });
        button3.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

            }

        });
        button4.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

            }

        });
        button5.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

            }

        });
        button6.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

            }

        });
        button7.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

            }

        });
        button8.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

            }

        });
        button9.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

            }

        });



    }

    private void loadDice() throws IOException {

        for (int i = 0; i < board.getRoundTracker().getRoundDice(round).size(); i++) {

            File file = new File("./");
            String fileName = board.getRoundTracker().getRoundDice(round).get(i).toStringGui();
            String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/dice");

            try {
                System.out.println("consegna dadi round tracker numero " + round);
                fileStream = new FileInputStream(filePath + "/" + fileName + ".png");
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
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                fileStream.close();
            }

        }
    }


}
