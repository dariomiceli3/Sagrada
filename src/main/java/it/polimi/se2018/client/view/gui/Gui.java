package it.polimi.se2018.client.view.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Gui extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Sagrada Game");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Mode.fxml"));
        Parent root = loader.load();

        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        loader.getController();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
