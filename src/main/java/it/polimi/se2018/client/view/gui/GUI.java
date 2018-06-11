package it.polimi.se2018.client.view.gui;


import it.polimi.se2018.client.view.View;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.stage.Stage;



import static javafx.application.Application.launch;


public class GUI extends Application{

    private GuiView view;

    public GuiView getView() {
        return view;
    }

    public void setView(GuiView view) {
        this.view = view;
    }

    public static void main(String []args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Login.start(primaryStage, view);
    }
}