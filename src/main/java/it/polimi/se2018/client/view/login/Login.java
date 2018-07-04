package it.polimi.se2018.client.view.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.InputStream;


public class Login extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Login.fxml"));
        Parent root = loader.load();
        LoginController controller = loader.getController();
        controller.setStage(primaryStage);

        Scene scene = new Scene(root);

        InputStream fileStream = Login.class.getResourceAsStream("/images/icon" + ".png");
        Image icon = new Image(fileStream);

        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Welcome to Sagrada");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);

    }

}
