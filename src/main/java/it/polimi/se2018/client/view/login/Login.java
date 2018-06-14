package it.polimi.se2018.client.view.login;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Login extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Login.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        primaryStage.setTitle("Sagrada Login");
        primaryStage.setScene(scene);
        primaryStage.show();

        loader.getController();


    }

    public static void main(String[] args) {
        launch(args);

    }

}
