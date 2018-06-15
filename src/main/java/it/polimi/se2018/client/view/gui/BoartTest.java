package it.polimi.se2018.client.view.gui;

import it.polimi.se2018.client.view.login.LoginController;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class BoartTest extends Application {
    @FXML
    private ImageView privateCard;

    @FXML
    private ImageView toolCard1;

    @FXML
    private ImageView toolCard2;

    @FXML
    private ImageView toolCard3;

    @FXML
    private ImageView public1;

    @FXML
    private ImageView public2;

    @FXML
    private ImageView public3;

    @FXML
    private ImageView pattern1;

    @FXML
    private ImageView pattern2;

    @FXML
    private ImageView pattern3;

    @FXML
    private ImageView pattern4;

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


    public BoartTest() throws IOException {
    }

    @FXML
    void handleZoom(MouseEvent event) throws InterruptedException {
        if(toolCard1.isPickOnBounds()) {
            toolCard1Zoom.setVisible(true);
        }
        else if(toolCard2.isPickOnBounds()) {
            toolCard2Zoom.setVisible(true);
        }
    }

    @FXML
    void handleUnzoom(MouseEvent event) {
        if(toolCard1Zoom.isPickOnBounds()) {
            toolCard1Zoom.setVisible(false);
        }
        else if(toolCard2Zoom.isPickOnBounds()) {
            toolCard2Zoom.setVisible(false);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/CardDraw.fxml"));
        Parent root1 = (Parent) loader.load();
        //LoginController controller = (LoginController) loader.getController();
        //controller.setStage(primaryStage);

        Scene scene = new Scene(root1);
        primaryStage.setTitle("Sagrada Login");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();


    }
    @FXML
    public void initialize() {
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
    }


    public static void main(String[] args) {
        launch(args);

    }
}

