package it.polimi.se2018.client.view.login;

import it.polimi.se2018.client.view.cli.ClientCli;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class LoginController {


    @FXML
    private ToggleButton cliView;
    @FXML
    private ToggleGroup viewToggleGroup;
    @FXML
    private ToggleButton guiView;
    @FXML
    private ToggleGroup connectionToggleGroup;
    @FXML
    private ToggleButton socket;
    @FXML
    private ToggleButton rmi;

    private String connectionType;
    private String viewType;
    private Stage stage;

    @FXML
    private void connectionButtonSelected(ActionEvent event) {

        this.connectionType = connectionToggleGroup.getSelectedToggle().getUserData().toString();
        System.out.println(connectionType);

    }

    @FXML
    private void viewButtonSelected(ActionEvent event) {

        this.viewType = viewToggleGroup.getSelectedToggle().getUserData().toString();

    }



    @FXML
    private void loginButtonSelected(ActionEvent event) {

        if (viewType.equalsIgnoreCase("cli")) {
            new ClientCli(connectionType);
        }

        if (viewType.equalsIgnoreCase("gui")) {

        }



    }


}
