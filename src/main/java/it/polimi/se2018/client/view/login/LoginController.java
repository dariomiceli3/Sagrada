package it.polimi.se2018.client.view.login;

import it.polimi.se2018.client.view.cli.ClientCli;
import it.polimi.se2018.client.view.gui.GuiController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

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


    public void initialize() {

        gui.setUserData("gui");
        cli.setUserData("cli");
        rmi.setUserData("rmi");
        socket.setUserData("socket");
    }


    @FXML
    void loginButtonSelected(ActionEvent event) {

        this.connectionType = connectionToggleGroup.getSelectedToggle().getUserData().toString();
        this.viewType = viewToggleGroup.getSelectedToggle().getUserData().toString();

        if (viewType.equalsIgnoreCase("cli")) {
            new ClientCli(connectionType);
        }

        if (viewType.equalsIgnoreCase("gui")) {
            new GuiController()
        }

    }


}
