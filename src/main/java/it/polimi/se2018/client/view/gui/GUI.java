package it.polimi.se2018.client.view.gui;


import it.polimi.se2018.client.Client;
import it.polimi.se2018.client.ClientInterface;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader load = new FXMLLoader(getClass().getResource("/Login.fxml"));
        Parent root = load.load();
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        load.getController();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
