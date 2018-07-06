package it.polimi.se2018.client.view.login;

import it.polimi.se2018.client.view.cli.ClientCli;
import it.polimi.se2018.client.view.gui.GuiController;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

/**
 * Class LoginController: Login Controller handles all the choices made by the player in the login's scene.
 * @author fadda-miceli-mundo
 */
public class LoginController {

    private Stage stage;
    private boolean singlePlayer;

    /**
     * method that allows the set the stage of the view
     * @param stage stage of the view
     */
    public void setStage(Stage stage){
        this.stage = stage;
    }

    /**
     * method that initializes all the properties of the buttons at the beginning of the game
     */
    public void initialize() {

        gui.setUserData("gui");
        cli.setUserData("cli");
        rmi.setUserData("rmi");
        socket.setUserData("socket");
        multiButton.setUserData("multi");
        singleButton.setUserData("single");

        loginButton.disableProperty().bind(Bindings.isNull(viewToggleGroup.selectedToggleProperty()).or(Bindings.isNull(connectionToggleGroup.selectedToggleProperty()).or(Bindings.isNull(modeToggleGroup.selectedToggleProperty()))));
        singleButton.disableProperty().bind(cli.selectedProperty());
        multiButton.disableProperty().bind(cli.selectedProperty());
    }


    @FXML
    private ToggleButton socket;
    @FXML
    private ToggleButton cli;
    @FXML
    private ToggleButton gui;
    @FXML
    private ToggleButton rmi;
    @FXML
    private ToggleGroup viewToggleGroup;
    @FXML
    private ToggleGroup connectionToggleGroup;
    @FXML
    private ToggleButton multiButton;
    @FXML
    private ToggleGroup modeToggleGroup;
    @FXML
    private ToggleButton singleButton;
    @FXML
    private Button loginButton;

    // action event nel caso

    /**
     * method that allows to switch scene after choosing the type of the connection and the modality of the game
     * @throws IOException
     */
    @FXML
    void loginButtonSelected() throws IOException {

        String connectionType = connectionToggleGroup.getSelectedToggle().getUserData().toString();
        String viewType = viewToggleGroup.getSelectedToggle().getUserData().toString();

        if (singleButton.isSelected()){
            singlePlayer = true;
        }
        if (multiButton.isSelected()){
            singlePlayer = false;
        }


        if (viewType.equalsIgnoreCase("cli")) {
            new ClientCli(connectionType);
        }

        if (viewType.equalsIgnoreCase("gui")) {


            stage.setTitle("Welcome to Sagrada");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Mode.fxml"));
            Parent root = loader.load();

            GuiController controller = loader.getController();
            controller.setConnectionTypeAndStage(connectionType, stage, singlePlayer);

            Scene scene1 = new Scene(root);
            InputStream fileStream = LoginController.class.getResourceAsStream("/images/icon" + ".png");
            Image icon = new Image(fileStream);
            stage.getIcons().add(icon);
            stage.setScene(scene1);
            stage.show();
        }

    }


}
