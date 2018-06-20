package it.polimi.se2018.client.view.gui;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Components.GlassBox;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class ChoosePatternSingle {

    @FXML
    private ImageView background;

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
    private ImageView privateCard1;

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
    private ImageView privateCardZoom1;

    @FXML
    private Button playGameButton;

    @FXML
    private ImageView patternCardOne;

    @FXML
    private RadioButton radioPatternOne;

    @FXML
    private ToggleGroup patternToggleGroup;

    @FXML
    private RadioButton radioPatternThree;

    @FXML
    private RadioButton radioPatternTwo;

    @FXML
    private RadioButton radioPatternFour;

    @FXML
    private Button loadButton;

    @FXML
    private ImageView privateCard2;

    @FXML
    private ImageView privateCard3;

    @FXML
    private ImageView privateCardZoom2;

    @FXML
    private ImageView privateCardZoom3;

    private FileInputStream fileStream;
    private int indexPattern;
    private static GuiController mainController;
    private SimpleBooleanProperty patternSetted = new SimpleBooleanProperty(false);


    public static void setMainController(GuiController mainControllerSingle){
        //ChoosePattern.mainController = mainController; todo controllare questo punto

    }

    @FXML
    void handlePrivateUnzoom1(MouseEvent event) {
        privateCardZoom1.setVisible(false);
    }

    @FXML
    void handlePrivateUnzoom2(MouseEvent event) {
        privateCardZoom2.setVisible(false);
    }

    @FXML
    void handlePrivateUnzoom3(MouseEvent event) {
        privateCardZoom3.setVisible(false);
    }

    @FXML
    void handlePrivateZoom1(MouseEvent event) {
        privateCardZoom1.setVisible(true);
    }

    @FXML
    void handlePrivateZoom2(MouseEvent event) {
        privateCardZoom2.setVisible(true);
    }

    @FXML
    void handlePrivateZoom3(MouseEvent event) {
        privateCardZoom3.setVisible(true);
    }

    @FXML
    void handlePublicUnzoom1(MouseEvent event) {
        publicCard1Zoom.setVisible(false);
    }

    @FXML
    void handlePublicUnzoom2(MouseEvent event) {
        publicCard2Zoom.setVisible(false);
    }

    @FXML
    void handlePublicUnzoom3(MouseEvent event) {
        publicCard3Zoom.setVisible(false);
    }

    @FXML
    void handlePublicZoom1(MouseEvent event) {
        publicCard1Zoom.setVisible(true);
    }

    @FXML
    void handlePublicZoom2(MouseEvent event) {
        publicCard2Zoom.setVisible(true);
    }

    @FXML
    void handlePublicZoom3(MouseEvent event) {
        publicCard3Zoom.setVisible(true);
    }

    @FXML
    void handleToolUnzoom1(MouseEvent event) {
        toolCard1Zoom.setVisible(false);
    }

    @FXML
    void handleToolUnzoom2(MouseEvent event) {
        toolCard2Zoom.setVisible(false);
    }

    @FXML
    void handleToolUnzoom3(MouseEvent event) {
        toolCard3Zoom.setVisible(false);
    }

    @FXML
    void handleToolZoom1(MouseEvent event) {
        toolCard1Zoom.setVisible(true);
    }

    @FXML
    void handleToolZoom2(MouseEvent event) {
        toolCard2Zoom.setVisible(true);
    }

    @FXML
    void handleToolZoom3(MouseEvent event) {
        toolCard2Zoom.setVisible(true);
    }

    @FXML
    void loadButtonSelected(ActionEvent event) {
        AlertBox.display("Sagrada Choose", "Please, wait some seconds and the game will start");

        if (patternToggleGroup.getSelectedToggle().equals(radioPatternFour)) {
            indexPattern = 3;
        }
        else if (patternToggleGroup.getSelectedToggle().equals(radioPatternThree)) {
            indexPattern = 2;
        }
        else if (patternToggleGroup.getSelectedToggle().equals(radioPatternTwo)) {
            indexPattern = 1;
            System.out.println("Single");
        }
        else {
            indexPattern = 0;
        }

        mainController.setPattern(indexPattern);
    }

    @FXML
    void playButtonSelected(ActionEvent event) throws FileNotFoundException {
        // todo check quando entrambi provano ad aprire il filechooser

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select File");
        fileChooser.setInitialDirectory(new File("."));

        File file;
        System.out.println("Single");
        do {
            file = fileChooser.showOpenDialog(mainController.getStage());
        }
        while (!(file.getName().matches(".*[a-zA-Z0-9]+.*" + ".json")));

        System.out.println(file.getName());

        renderingScheme(file);

    }

    public void initialize () throws IOException {


        loadFilePrivate();

        loadFileToolCard();

        loadFilePublicCard();

        loadFilePatternCard();

        playGameButton.disableProperty().bind(Bindings.isNull(patternToggleGroup.selectedToggleProperty()));
        playGameButton.disableProperty().bind(patternSetted);

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

        privateCardZoom1.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }

        });

        privateCardZoom2.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }

        });
        privateCardZoom3.visibleProperty().addListener(new ChangeListener<Boolean>() {
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
        for (int i = 0; i < mainController.get.size(); i++) {
            // todo aggiungere la getPrivateSingle

        File file = new File("./");
        String fileColor = mainController.getPrivateCard().get(i).getColour().toString();
        String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/private");

        try {
                System.out.println("consegna private");
                fileStream = new FileInputStream(filePath + "/" + fileName + ".png");
                Image image = new Image(fileStream);
                if (i == 0) {
                    privateCard1.setImage(image);
                    privateCardZoom1.setImage(image);
                }
                if (i == 1) {
                    privateCard2.setImage(image);
                    privateCardZoom2.setImage(image);
                }
                if (i == 2) {
                    privateCard3.setImage(image);
                    privateCardZoom3.setImage(image);
                }
            }
            finally {
                fileStream.close();
            }

        }

    }

    private void loadFileToolCard() throws IOException  {
        //todo fare come in board controller per l'other pattern

        for (int i = 0; i < mainController.getToolList().size(); i++) {

            File file = new File("./");
            String fileName = mainController.getToolList().get(i).getName();
            String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/tool");

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
            }
            finally {
                fileStream.close();
            }

        }
    }

    private void loadFilePublicCard() throws IOException  {

        for (int i = 0; i < mainController.getPublicCardList().size(); i++) {

            File file = new File("./");
            String fileName = mainController.getPublicCardList().get(i).getName();
            String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/public");

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
            }
            finally {
                fileStream.close();
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
