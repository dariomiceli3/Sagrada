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
        Parent root = (Parent) loader.load();
        LoginController controller = (LoginController) loader.getController();
        controller.setStage(primaryStage);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Sagrada Login");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);

    }

}
