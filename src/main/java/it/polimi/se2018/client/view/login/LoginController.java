package it.polimi.se2018.client.view.login;

import it.polimi.se2018.client.view.cli.ClientCli;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;

public class LoginController {

    @FXML
    private RadioButton cliView;

    @FXML
    private RadioButton guiView;

    @FXML
    private RadioButton socket;

    @FXML
    private RadioButton rmi;

    @FXML
    void handlerClient(ActionEvent event) {

        if (cliView.isSelected()) {

            if (socket.isSelected()){

                new ClientCli("socket");
            }

            if (rmi.isSelected()) {

                new ClientCli("rmi");

            }

        }

        if (guiView.isSelected()) {

            if (socket.isSelected()) {

            }

            if (rmi.isSelected()) {

            }

        }






        }
}
