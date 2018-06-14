package it.polimi.se2018.client.view.login;

import it.polimi.se2018.client.view.cli.ClientCli;
import it.polimi.se2018.client.view.gui.GuiController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

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

    private String connectionType;
    private String viewType;
    private Stage stage;

    public void setStage(Stage stage){
        this.stage = stage;
    }


    public void initialize() {

        gui.setUserData("gui");
        cli.setUserData("cli");
        rmi.setUserData("rmi");
        socket.setUserData("socket");
    }


    @FXML
    void loginButtonSelected(ActionEvent event) throws IOException {

        this.connectionType = connectionToggleGroup.getSelectedToggle().getUserData().toString();
        this.viewType = viewToggleGroup.getSelectedToggle().getUserData().toString();

        if (viewType.equalsIgnoreCase("cli")) {
            new ClientCli(connectionType);
        }

        if (viewType.equalsIgnoreCase("gui")) {


                stage.setTitle("Sagrada Game");

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Mode.fxml"));
                Parent root = loader.load();

                GuiController controller = (GuiController) loader.getController();
                controller.setConnectionTypeAndStage(connectionType, stage);

                Scene scene1 = new Scene(root);
                stage.setScene(scene1);
                stage.show();

        }

    }


}
