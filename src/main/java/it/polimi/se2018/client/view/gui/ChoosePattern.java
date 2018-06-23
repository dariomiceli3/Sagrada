package it.polimi.se2018.client.view.gui;

import it.polimi.se2018.client.view.gui.GuiController;
import it.polimi.se2018.server.controller.ToolCard;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.server.model.Components.GlassBox;
import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.beans.binding.Bindings;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class ChoosePattern {


    @FXML
    private ImageView privateCard;
    @FXML
    private ImageView toolCardOne;
    @FXML
    private ImageView toolCardTwo;
    @FXML
    private ImageView toolCardThree;
    @FXML
    private ImageView publicOne;
    @FXML
    private ImageView publicTwo;
    @FXML
    private ImageView publicThree;
    @FXML
    private ImageView patternCardOne;
    @FXML
    private ImageView patternCardTwo;
    @FXML
    private ImageView patternCardThree;
    @FXML
    private ImageView patternCardFour;
    @FXML
    private ImageView toolCard1Zoom;
    @FXML
    private ImageView toolCard2Zoom;
    @FXML
    private ImageView toolCard3Zoom;
    @FXML
    private ImageView publicCard1Zoom;
    @FXML
    private ImageView publicCard2Zoom;
    @FXML
    private ImageView publicCard3Zoom;
    @FXML
    private ImageView privateCardZoom;
    @FXML
    private Button playGameButton;
    @FXML
    private Button loadButton;
    @FXML
    private RadioButton radioPatternOne;
    @FXML
    private RadioButton radioPatternTwo;
    @FXML
    private RadioButton radioPatternThree;
    @FXML
    private RadioButton radioPatternFour;
    @FXML
    private ToggleGroup patternToggleGroup;


    //-----------start single player fxml------------------

    @FXML
    private ImageView privateCardTwo;
    @FXML
    private ImageView toolCardFour;
    @FXML
    private ImageView toolCardFive;
    @FXML
    private ImageView privateCardZoom2;
    @FXML
    private ImageView toolCard5Zoom;
    @FXML
    private ImageView toolCard4Zoom;

    @FXML
    void handlePrivateUnzoom2(MouseEvent event) {
        privateCardZoom2.setVisible(false);

    }
    @FXML
    void handlePrivateZoomTwo(MouseEvent event) {
        privateCardZoom2.setVisible(true);

    }

    @FXML
    void handleToolUnzoom4(MouseEvent event) {
        toolCard4Zoom.setVisible(false);

    }
    @FXML
    void handleToolUnzoom5(MouseEvent event) {
        toolCard5Zoom.setVisible(false);
    }
    @FXML
    void handleToolZoom4(MouseEvent event) {
        toolCard4Zoom.setVisible(true);

    }
    @FXML
    void handleToolZoom5(MouseEvent event) {
        toolCard5Zoom.setVisible(true);

    }

    //-----------------end single player


    private FileInputStream fileStream;
    private int indexPattern;
    private static GuiController mainController;
    private SimpleBooleanProperty patternSetted = new SimpleBooleanProperty(false);


    public static void setMainController(GuiController mainController){
        ChoosePattern.mainController = mainController;
    }


    @FXML
    void handlePrivateUnzoom (MouseEvent event){
            privateCardZoom.setVisible(false);
        }

    @FXML
    void handlePrivateZoom (MouseEvent event){
        privateCardZoom.setVisible(true);
    }

    @FXML
    void handlePublicUnzoom1 (MouseEvent event){
        publicCard1Zoom.setVisible(false);
    }

    @FXML
    void handlePublicUnzoom2 (MouseEvent event){
        publicCard2Zoom.setVisible(false);
    }

    @FXML
    void handlePublicUnzoom3 (MouseEvent event){
        publicCard3Zoom.setVisible(false);
    }

    @FXML
    void handlePublicZoom1 (MouseEvent event){
        publicCard1Zoom.setVisible(true);
    }

    @FXML
    void handlePublicZoom2 (MouseEvent event){
        publicCard2Zoom.setVisible(true);
    }

    @FXML
    void handlePublicZoom3 (MouseEvent event){
        publicCard3Zoom.setVisible(true);
    }

    @FXML
    void handleToolUnzoom1 (MouseEvent event){
        toolCard1Zoom.setVisible(false);
    }

    @FXML
    void handleToolUnzoom2 (MouseEvent event){
        toolCard2Zoom.setVisible(false);
    }

    @FXML
    void handleToolUnzoom3 (MouseEvent event){
        toolCard3Zoom.setVisible(false);
    }

    @FXML
    void handleToolZoom1 (MouseEvent event){
        toolCard1Zoom.setVisible(true);
    }

    @FXML
    void handleToolZoom2 (MouseEvent event){
        toolCard2Zoom.setVisible(true);
    }

    @FXML
    void handleToolZoom3 (MouseEvent event){
        toolCard3Zoom.setVisible(true);
    }


    @FXML
    void playButtonSelected(ActionEvent event) {

            patternSetted.setValue(true);

            AlertBox.display("Sagrada Choose", "Please, wait some seconds and the game will start");

           if (patternToggleGroup.getSelectedToggle().equals(radioPatternFour)) {
                indexPattern = 3;
           }
           else if (patternToggleGroup.getSelectedToggle().equals(radioPatternThree)) {
               indexPattern = 2;
           }
           else if (patternToggleGroup.getSelectedToggle().equals(radioPatternTwo)) {
               indexPattern = 1;
           }
           else {
               indexPattern = 0;
           }

           mainController.setPattern(indexPattern);

    }

    @FXML
    void loadButtonSelected(ActionEvent event) throws FileNotFoundException  {

        // todo check quando entrambi provano ad aprire il filechooser

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select File");
        fileChooser.setInitialDirectory(new File("."));

        File file;

        do {
            file = fileChooser.showOpenDialog(mainController.getStage());
        }
        while (!(file.getName().matches(".*[a-zA-Z0-9]+.*" + ".json")));

        System.out.println(file.getName());

        renderingScheme(file);

    }


    public void initialize () throws IOException {

        if (mainController.isSinglePlayer()) {
            loadFilePrivateSingle();
            loadFileToolCard();
            loadFilePublicCard();
            loadFilePatternCard();
        }

        else {
            loadFilePrivate();
            loadFileToolCard();
            loadFilePublicCard();
            loadFilePatternCard();
        }

        playGameButton.disableProperty().bind(Bindings.isNull(patternToggleGroup.selectedToggleProperty()).or(patternSetted));

        playGameButton.disableProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

            }
        });

        toolCard1Zoom.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }

        });

        toolCard2Zoom.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }

        });

        toolCard3Zoom.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });

        privateCardZoom.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }

        });

        publicCard3Zoom.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }

        });

        publicCard2Zoom.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }

        });

        publicCard1Zoom.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }

        });
    }

    private void loadFilePrivate() throws IOException {

        File file = new File("./");
        String fileColor = mainController.getPrivateCard().getColour().toString();
        String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/private");

        try {
            fileStream = new FileInputStream(filePath + "/" + fileColor + ".png");
            Image image = new Image(fileStream);
            privateCard.setImage(image);
            privateCardZoom.setImage(image);
        }
        finally {
            fileStream.close();
        }
    }

    private void loadFilePrivateSingle() throws IOException {

        for (int i = 0; i < mainController.getPrivateCardSingle().size(); i++) {

            File file = new File("./");
            String fileColor = mainController.getPrivateCardSingle().get(i).getColour().toString();
            String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/private");

            try {
                fileStream = new FileInputStream(filePath + "/" + fileColor + ".png");
                Image image = new Image(fileStream);
                if (i == 0) {
                    privateCard.setImage(image);
                    privateCardZoom.setImage(image);
                }
                if (i == 1) {
                    privateCardTwo.setImage(image);
                    privateCardTwo.setVisible(true);
                    privateCardZoom2.setImage(image);
                }
            }
            finally {
                fileStream.close();
            }

        }


    }

    private void loadFileToolCard() throws IOException  {

        for (int i = 0; i < mainController.getToolList().size(); i++) {

            File file = new File("./");
            String fileName = mainController.getToolList().get(i).getName();
            String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/tool");

            if (mainController.isSinglePlayer()) {
                try {
                    fileStream = new FileInputStream(filePath + "/" + fileName + ".png");
                    Image image = new Image(fileStream);
                    if (i == 0) {
                        toolCardOne.setImage(image);
                        toolCard1Zoom.setImage(image);
                    }
                    if (i == 1) {
                        toolCardTwo.setImage(image);
                        toolCard2Zoom.setImage(image);
                    }
                    if (i == 2) {
                        toolCardThree.setImage(image);
                        toolCard3Zoom.setImage(image);
                    }
                    if (i == 3) {
                        toolCardFour.setImage(image);
                        toolCardFour.setVisible(true);
                        toolCard4Zoom.setImage(image);
                    }
                    if (i == 4) {
                        toolCardFive.setImage(image);
                        toolCardFive.setVisible(true);
                        toolCard5Zoom.setImage(image);
                    }
                } finally {
                    fileStream.close();
                }
            }

            else {

                try {
                    System.out.println("consegna tool");
                    fileStream = new FileInputStream(filePath + "/" + fileName + ".png");
                    Image image = new Image(fileStream);
                    if (i == 0) {
                        toolCardOne.setImage(image);
                        toolCard1Zoom.setImage(image);
                    }
                    if (i == 1) {
                        toolCardTwo.setImage(image);
                        toolCard2Zoom.setImage(image);
                    }
                    if (i == 2) {
                        toolCardThree.setImage(image);
                        toolCard3Zoom.setImage(image);
                    }
                } finally {
                    fileStream.close();
                }
            }

        }
    }

    private void loadFilePublicCard() throws IOException  {

        for (int i = 0; i < mainController.getPublicCardList().size(); i++) {

            File file = new File("./");
            String fileName = mainController.getPublicCardList().get(i).getName();
            String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/public");

            if (mainController.isSinglePlayer()) {
                try {

                    fileStream = new FileInputStream(filePath + "/" + fileName + ".png");
                    Image image = new Image(fileStream);
                    if (i == 0) {
                        publicOne.setImage(image);
                        publicCard1Zoom.setImage(image);
                    }
                    if (i == 1) {
                        publicTwo.setImage(image);
                        publicCard2Zoom.setImage(image);
                    }

                } finally {
                    fileStream.close();
                }
            }

            else{
                try {
                    System.out.println("consegna public");
                    fileStream = new FileInputStream(filePath + "/" + fileName + ".png");
                    Image image = new Image(fileStream);
                    if (i == 0) {
                        publicOne.setImage(image);
                        publicCard1Zoom.setImage(image);
                    }
                    if (i == 1) {
                        publicTwo.setImage(image);
                        publicCard2Zoom.setImage(image);
                    }
                    if (i == 2) {
                        publicThree.setImage(image);
                        publicCard3Zoom.setImage(image);
                    }
                } finally {
                    fileStream.close();
                }
            }

        }
    }

    private void loadFilePatternCard() throws IOException  {

        for (int i = 0; i < mainController.getPatternList().size(); i++) {

            File file = new File("./");
            String fileName = mainController.getPatternList().get(i).getName();
            String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/pattern");

            try {
                System.out.println("consegna pattern");
                fileStream = new FileInputStream(filePath + "/" + fileName + ".jpg");
                Image image = new Image(fileStream);
                if (i == 0) {
                    patternCardOne.setImage(image);
                }
                if (i == 1) {
                    patternCardTwo.setImage(image);
                }
                if (i == 2) {
                    patternCardThree.setImage(image);
                }
                if (i == 3) {
                    patternCardFour.setImage(image);
                }
            }
            finally {
                fileStream.close();
            }

        }
    }

    private void renderingScheme(File file) throws FileNotFoundException {

        PatternCard selfScheme = new PatternCard();
        selfScheme = selfScheme.loadCard(file.getAbsolutePath());

        System.out.println(selfScheme.toString());

        List<GlassBox> boxRender = selfScheme.getPattern();

        Canvas canvas = new Canvas();
        GraphicsContext gc = canvas.getGraphicsContext2D();



    }



}

