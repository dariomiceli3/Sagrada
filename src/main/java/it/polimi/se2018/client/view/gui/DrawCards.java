package it.polimi.se2018.client.view.gui;
import  javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class DrawCards {

    private Scene scene;

    public DrawCards(Stage window) throws FileNotFoundException {
        BorderPane layout = new BorderPane();
        window.setMaxWidth(550);
        window.setMaxHeight(430);
        scene = new Scene(layout, 550,430);

        File file = new File("./");
        String filePath = file.getAbsolutePath().replace(".", "src/main/res/Images/");
        FileInputStream inputStream = new FileInputStream(filePath+"Virtus .jpg");
        Image image = new Image(inputStream);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(230);

        Button button = new Button("ciao baby");
        layout.getChildren().addAll(imageView);


        window.setScene(scene);
        window.show();


    }

    public Scene getScene() {
        return scene;
    }


}
