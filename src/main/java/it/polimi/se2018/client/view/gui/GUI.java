package it.polimi.se2018.client.view.gui;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader laer = new FXMLLoader(getClass().getResource("/Login.fxml"));
        Parent root = laer.load();
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        laer.getController();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
