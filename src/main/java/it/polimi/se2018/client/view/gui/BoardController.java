package it.polimi.se2018.client.view.gui;

import it.polimi.se2018.server.model.Cards.PatternCard;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class BoardController {



    @FXML
    private ImageView panelWindow;

    @FXML
    private ImageView patternPlayer2;

    @FXML
    private ImageView patternPlayer3;

    @FXML
    private ImageView patternPlayer4;

    @FXML
    private ImageView privateCard;

    @FXML
    private ImageView patternCard;

    @FXML
    private Text tokensNumber;

    @FXML
    private ImageView roundTracker;

    @FXML
    private ImageView toolCard1;

    @FXML
    private ImageView toolCard2;

    @FXML
    private ImageView toolCard3;

    @FXML
    private ImageView publicCard1;

    @FXML
    private ImageView publicCard2;

    @FXML
    private ImageView publicCard3;

    @FXML
    private TextField textGame;

    @FXML
    private Button next;

    @FXML
    private Button skip;

    @FXML
    private Button exit;

    @FXML
    private ToggleGroup patternToggleGroup;

    @FXML
    private ToggleButton cell1;

    @FXML
    private ImageView imageCell1;

    @FXML
    private ToggleButton cell2;

    @FXML
    private ImageView imageCell2;

    @FXML
    private ToggleButton cell3;

    @FXML
    private ImageView imageCell3;

    @FXML
    private ToggleButton cell4;

    @FXML
    private ImageView imageCell4;

    @FXML
    private ToggleButton cell5;

    @FXML
    private ImageView imageCell5;

    @FXML
    private ToggleButton cell6;

    @FXML
    private ImageView imageCell6;

    @FXML
    private ToggleButton cell7;

    @FXML
    private ImageView imageCell7;

    @FXML
    private ToggleButton cell8;

    @FXML
    private ImageView imageCell8;

    @FXML
    private ToggleButton cell9;

    @FXML
    private ImageView imageCell9;

    @FXML
    private ToggleButton cell10;

    @FXML
    private ImageView imageCell10;

    @FXML
    private ToggleButton cell11;

    @FXML
    private ImageView imageCell11;

    @FXML
    private ToggleButton cell12;

    @FXML
    private ImageView imageCell12;

    @FXML
    private ToggleButton cell13;

    @FXML
    private ImageView imageCell13;

    @FXML
    private ToggleButton cell14;

    @FXML
    private ImageView imageCell14;

    @FXML
    private ToggleButton cell15;

    @FXML
    private ImageView imageCell15;

    @FXML
    private ToggleButton cell16;

    @FXML
    private ImageView imageCell16;

    @FXML
    private ToggleButton cell17;

    @FXML
    private ImageView imageCell17;

    @FXML
    private ToggleButton cell18;

    @FXML
    private ImageView imageCell18;

    @FXML
    private ToggleButton cell19;

    @FXML
    private ImageView imageCell19;

    @FXML
    private ToggleButton cell20;

    @FXML
    private ImageView imageCell20;

    @FXML
    private ToggleGroup roundToggleGroup;

    @FXML
    private ToggleButton round1;

    @FXML
    private ToggleButton round2;

    @FXML
    private ToggleButton round3;

    @FXML
    private ToggleButton round4;

    @FXML
    private ToggleButton round5;

    @FXML
    private ToggleButton round6;

    @FXML
    private ToggleButton round7;

    @FXML
    private ToggleButton round8;

    @FXML
    private ToggleButton round9;

    @FXML
    private ToggleGroup poolToggleGroup;

    @FXML
    private ToggleButton dice1;

    @FXML
    private ImageView imageDice1;

    @FXML
    private ToggleButton dice2;

    @FXML
    private ImageView imageDice2;

    @FXML
    private ToggleButton dice3;

    @FXML
    private ImageView imageDice3;

    @FXML
    private ToggleButton dice4;

    @FXML
    private ImageView imageDice4;

    @FXML
    private ToggleButton dice5;

    @FXML
    private ImageView imageDice5;

    @FXML
    private ToggleButton dice6;

    @FXML
    private ImageView imageDice6;

    @FXML
    private ToggleButton dice7;

    @FXML
    private ImageView imageDice7;

    @FXML
    private ToggleButton dice8;

    @FXML
    private ImageView imageDice8;

    @FXML
    private ToggleButton dice9;

    @FXML
    private ImageView imageDice9;

    @FXML
    private ImageView privateCardZoom;

    @FXML
    private ImageView publicCardZoom1;

    @FXML
    private ImageView publicCardZoom2;

    @FXML
    private ImageView publicCardZoom3;

    @FXML
    private ImageView toolCardZoom1;

    @FXML
    private ImageView toolCardZoom2;

    @FXML
    private ImageView toolCardZoom3;


    @FXML
    void handleCellEvent(ActionEvent event) {

    }

    @FXML
    void handleDicePool(ActionEvent event) {

    }

    @FXML
    void handlePrivateUnzoom(MouseEvent event) {
        privateCardZoom.setVisible(false);

    }

    @FXML
    void handlePrivateZoom(MouseEvent event) {
        privateCardZoom.setVisible(true);

    }

    @FXML
    void handleRoundButton(ActionEvent event) {

    }

    @FXML
    void handleTool1(MouseEvent event) {

        if (event.getButton().equals(MouseButton.PRIMARY)) {
            toolCardZoom1.setVisible(true);
        }
        if (event.getButton().equals(MouseButton.SECONDARY)) {
            System.out.println("usa tool card");
        }

        }

    @FXML
    void handleTool2(MouseEvent event) {

        if (event.getButton().equals(MouseButton.PRIMARY)) {
            toolCardZoom2.setVisible(true);
        }
        if (event.getButton().equals(MouseButton.SECONDARY)) {
            System.out.println("usa tool card");
        }


    }

    @FXML
    void handleTool3(MouseEvent event) {

        if (event.getButton().equals(MouseButton.PRIMARY)) {
            toolCardZoom3.setVisible(true);
        }
        if (event.getButton().equals(MouseButton.SECONDARY)) {
            System.out.println("usa tool card");
        }

    }

    @FXML
    void handleZoomPublic1(MouseEvent event) {
        publicCardZoom1.setVisible(true);

    }

    @FXML
    void handleZoomPublic2(MouseEvent event) {
        publicCardZoom2.setVisible(true);
    }

    @FXML
    void handleZoomPublic3(MouseEvent event) {
        publicCardZoom3.setVisible(true);

    }

    @FXML
    void handleUnzoomPublic1(MouseEvent event) {
        publicCardZoom1.setVisible(false);

    }

    @FXML
    void handleUnzoomPublic2(MouseEvent event) {
        publicCardZoom2.setVisible(false);

    }

    @FXML
    void handleUnzoomPublic3(MouseEvent event) {
        publicCardZoom3.setVisible(false);

    }

    @FXML
    void handleUnzoomTool1(MouseEvent event) {
        toolCardZoom1.setVisible(false);
    }

    @FXML
    void handleUnzoomTool2(MouseEvent event) {
        toolCardZoom2.setVisible(false);

    }

    @FXML
    void handleUnzoomTool3(MouseEvent event) {
        toolCardZoom3.setVisible(false);

    }

    @FXML
    void handleUpdatePattern2(MouseEvent event) {

    }

    @FXML
    void handleUpdatePattern3(MouseEvent event) {

    }

    @FXML
    void handleUpdatePattern4(MouseEvent event) {

    }



    @FXML
    void nextButtonSelected(ActionEvent event) {

    }

    @FXML
    void skipButtonSelected(ActionEvent event) {

    }

    @FXML
    void exitButtonSelected(ActionEvent event) {

    }

    private static GuiController mainController;
    private FileInputStream fileStream;

    public static void setMainController(GuiController mainController){
        BoardController.mainController = mainController;
    }

    public void initialize() throws IOException {

        loadPanel();

        loadPattern();
        loadTokensNumber();

        loadPrivate();

        loadPublicCard();

        loadToolCard();

        loadOtherPattern();

        privateCardZoom.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });

        publicCardZoom1.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });

        publicCardZoom2.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });

        publicCardZoom3.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });

        toolCardZoom1.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });

        toolCardZoom2.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });

        toolCardZoom3.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });
    }



    private void loadPanel() throws IOException {

        File file = new File("./");
        String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/panel");

        try {
            System.out.println("consegna panel");
            if ((mainController.getPlayerID() == 0)) {
                fileStream = new FileInputStream(filePath + "/BluePanel" + ".png");
                Image imagePlayerOne = new Image(fileStream);
                panelWindow.setImage(imagePlayerOne);
            }
            if ((mainController.getPlayerID() == 1)) {
                fileStream = new FileInputStream(filePath + "/GreenPanel" + ".png");
                Image imagePlayerTwo = new Image(fileStream);
                panelWindow.setImage(imagePlayerTwo);
            }
            if ((mainController.getPlayerID() == 2)) {
                fileStream = new FileInputStream(filePath + "/PurplePanel" + ".png");
                Image imagePlayerThree = new Image(fileStream);
                panelWindow.setImage(imagePlayerThree);
            }

            if ((mainController.getPlayerID() == 3)) {
                fileStream = new FileInputStream(filePath + "/RedPanel" + ".png");
                Image imagePlayerFour = new Image(fileStream);
                panelWindow.setImage(imagePlayerFour);
            }
        } finally {
            fileStream.close();
        }

    }

    private void loadPrivate() throws IOException {

        File file = new File("./");
        String fileColor = mainController.getPrivateCard().getColour().toString();
        String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/private");

        try {
            System.out.println("private board");
            fileStream = new FileInputStream(filePath + "/" + fileColor + ".png");
            Image image = new Image(fileStream);
            privateCard.setImage(image);
            privateCardZoom.setImage(image);
        }
        finally {
            fileStream.close();
        }
    }


    private void loadPattern() throws IOException {

        File file = new File("./");
        String filePattern = mainController.getPatternCurrent().getName();
        String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/pattern");

        try {
            System.out.println("consegna singola pattern");
            fileStream = new FileInputStream(filePath + "/" + filePattern + ".jpg");
            Image image = new Image(fileStream);
            patternCard.setImage(image);
        }
        finally {
            fileStream.close();
        }

    }


    private void loadPublicCard() throws IOException  {

        for (int i = 0; i < mainController.getPublicCardList().size(); i++) {

            File file = new File("./");
            String fileName = mainController.getPublicCardList().get(i).getName();
            String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/public");

            try {
                System.out.println("consegna public board");
                fileStream = new FileInputStream(filePath + "/" + fileName + ".png");
                Image image = new Image(fileStream);
                if (i == 0) {
                    publicCard1.setImage(image);
                    publicCardZoom1.setImage(image);
                }
                if (i == 1) {
                    publicCard2.setImage(image);
                    publicCardZoom2.setImage(image);
                }
                if (i == 2) {
                    publicCard3.setImage(image);
                    publicCardZoom3.setImage(image);
                }
            }
            finally {
                fileStream.close();
            }

        }
    }

    private void loadToolCard() throws IOException {

        for (int i = 0; i < mainController.getToolList().size(); i++) {

            File file = new File("./");
            String fileName = mainController.getToolList().get(i).getName();
            String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/tool");

            try {
                System.out.println("consegna tool board");
                fileStream = new FileInputStream(filePath + "/" + fileName + ".png");
                Image image = new Image(fileStream);
                if (i == 0) {
                    toolCard1.setImage(image);
                    toolCardZoom1.setImage(image);
                }
                if (i == 1) {
                    toolCard2.setImage(image);
                    toolCardZoom2.setImage(image);
                }
                if (i == 2) {
                    toolCard3.setImage(image);
                    toolCardZoom3.setImage(image);
                }
            }
            finally {
                fileStream.close();
            }

        }
    }

    private void loadTokensNumber() {
        tokensNumber.setText("" + mainController.getPatternCurrent().getDifficulty());
    }

    private void loadOtherPattern() throws IOException {

        if (mainController.getPlayerID() == 0) {

            if (mainController.getPatternID1() != null) {
                String fileName = mainController.getPatternID1().getName();
                Image image = loadImage(fileName);
                patternPlayer2.setImage(image);
            }

            if (mainController.getPatternID2() != null) {
                String fileName = mainController.getPatternID2().getName();
                Image image = loadImage(fileName);
                patternPlayer3.setImage(image);
            }

            if (mainController.getPatternID3() != null) {
                String fileName = mainController.getPatternID3().getName();
                Image image = loadImage(fileName);
                patternPlayer4.setImage(image);
            }

        }

        if (mainController.getPlayerID() == 1) {

            if (mainController.getPatternID0() != null) {
                String fileName = mainController.getPatternID0().getName();
                Image image = loadImage(fileName);
                patternPlayer2.setImage(image);
            }

            if (mainController.getPatternID2() != null) {
                String fileName = mainController.getPatternID2().getName();
                Image image = loadImage(fileName);
                patternPlayer3.setImage(image);
            }

            if (mainController.getPatternID3() != null) {
                String fileName = mainController.getPatternID3().getName();
                Image image = loadImage(fileName);
                patternPlayer4.setImage(image);
            }

        }

        if (mainController.getPlayerID() == 2){

            if (mainController.getPatternID0() != null) {
                String fileName = mainController.getPatternID0().getName();
                Image image = loadImage(fileName);
                patternPlayer2.setImage(image);
            }

            if (mainController.getPatternID1() != null) {
                String fileName = mainController.getPatternID1().getName();
                Image image = loadImage(fileName);
                patternPlayer3.setImage(image);
            }

            if (mainController.getPatternID3() != null) {
                String fileName = mainController.getPatternID3().getName();
                Image image = loadImage(fileName);
                patternPlayer4.setImage(image);
            }

        }

        if (mainController.getPlayerID() == 3){

            if (mainController.getPatternID0() != null) {
                String fileName = mainController.getPatternID0().getName();
                Image image = loadImage(fileName);
                patternPlayer2.setImage(image);
            }

            if (mainController.getPatternID1() != null) {
                String fileName = mainController.getPatternID1().getName();
                Image image = loadImage(fileName);
                patternPlayer3.setImage(image);
            }

            if (mainController.getPatternID2() != null) {
                String fileName = mainController.getPatternID2().getName();
                Image image = loadImage(fileName);
                patternPlayer4.setImage(image);
            }

        }

    }

    private Image loadImage(String fileName) throws IOException {

        File file = new File("./");
        String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/pattern");
        fileStream = new FileInputStream(filePath + "/" + fileName + ".jpg");
        return new Image(fileStream);
    }
}
