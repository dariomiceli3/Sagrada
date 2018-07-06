package it.polimi.se2018.client.view.gui;

import javafx.scene.image.Image;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

import java.io.InputStream;
import java.util.logging.Logger;

/**
 * Class AlertBox: AlertBox used during the game to warns players of a message
 * @author fadda-miceli-mundo
 */
public class AlertBox {

    /**
     * Class constructor
     */
    private AlertBox() {
        final Logger log = Logger.getLogger(AlertBox.class.getName());
        log.info("private constructor");
    }

    /**
     * method that allows to display the alert box with the title of the window and the message to display
     * @param title title of the window
     * @param message message to display
     */
    public static void display(String title, String message) {
        InputStream fileStream;
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        window.setMinHeight(150);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout);
        fileStream = AlertBox.class.getResourceAsStream("/images/icon" + ".png");
        Image image = new Image(fileStream);
        window.getIcons().add(image);
        window.setScene(scene);
        window.setResizable(false);
        window.showAndWait();

    }
}

