package it.polimi.se2018.client.view.gui;


import it.polimi.se2018.client.view.View;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.stage.Stage;



import static javafx.application.Application.launch;


public class GUI extends Application{

    public static void main(String []args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Login.start(primaryStage);
    }
}