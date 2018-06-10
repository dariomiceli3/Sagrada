package it.polimi.se2018.client.view.gui;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class Login {

    private static Stage window;
    private static Button button;




    public static void start(Stage primaryStage) throws IOException {
        window = primaryStage;
        window.setTitle("Welcome to Sagrada");

        final ToggleGroup group = new ToggleGroup();

        ToggleButton tb1 = new ToggleButton("Socket");
        tb1.setUserData("socket");
        tb1.setSelected(true);
        tb1.isSelected();
        group.getToggles().add(tb1);

        ToggleButton tb2 = new ToggleButton("RMI");
        tb2.setUserData("rmi");
        group.getToggles().add(tb2);


        final ToggleGroup group1 = new ToggleGroup();
        ToggleButton tb3 = new ToggleButton("Single");
        tb3.setUserData("single");
        ToggleButton tb4 = new ToggleButton("Multi");
        tb4.setUserData("multi");
        tb4.setSelected(true);
        tb4.isSelected();
        group1.getToggles().add(tb3);
        group1.getToggles().add(tb4);
        button = new Button("Play");


        BorderPane layout = new BorderPane();

        Scene scene = new Scene(layout, 430,550);
        File file = new File("./");
        String filePath = file.getAbsolutePath().replace(".", "src/main/res/Images/");
        FileInputStream inputStream = new FileInputStream(filePath+"pic3101613.jpg");
        Image image = new Image(inputStream);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(550);
        imageView.setFitWidth(430);
        window.setMaxWidth(430);
        window.setMaxHeight(550);
        window.setMinWidth(430);
        window.setMinHeight(550);





        layout.getChildren().add(imageView);

        HBox hbox = new HBox();
        HBox hbox1 = new HBox();
        HBox hBox2 = new HBox();
        VBox vBox = new VBox();

        hbox.setAlignment(Pos.TOP_CENTER);
        hbox1.setAlignment(Pos.TOP_CENTER);
        hBox2.setAlignment(Pos.TOP_CENTER);
        hBox2.setSpacing(100);
        hbox.getChildren().addAll(tb1,tb2);
        hbox1.getChildren().addAll(tb3,tb4);
        hBox2.getChildren().add(button);
        vBox.setPadding(new Insets(180, 50, 50, 50));
        vBox.setSpacing(10);
        Label lbl = new Label("Choose options to start game");


        lbl.setFont(Font.font("Amble CN", FontWeight.BLACK, 20));
        lbl.setTextFill(Color.web("#ffffff"));


        lbl.setAlignment(Pos.TOP_CENTER);



        vBox.getChildren().add(lbl);
        vBox.getChildren().addAll(hbox);
        vBox.getChildren().addAll(hbox1);
        vBox.getChildren().add(hBox2);



        BorderPane borderPane = new BorderPane();
        Scene scene1 = new Scene(borderPane, 430,550);
        File file1 = new File("./");
        String filePath1 = file1.getAbsolutePath().replace(".", "src/main/res/Images/");
        FileInputStream inputStream1 = new FileInputStream(filePath1+"pic3101613.jpg");
        Image image1 = new Image(inputStream1);
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitHeight(550);
        imageView1.setFitWidth(430);

        Label label = new Label("Choose a name");
        label.setFont(Font.font("Amble CN", FontWeight.BLACK, 24));
        label.setTextFill(Color.web("#ffffff"));
        TextField textField = new TextField();
        textField.setMaxWidth(200);
        HBox hBox = new HBox();
        HBox hBox1 = new HBox();
        HBox hbox2 = new HBox();
        hbox2.getChildren().add(label);
        hBox.getChildren().addAll(textField);

        Button button1 = new Button("Continue");
        hBox1.getChildren().add(button1);
        borderPane.getChildren().addAll(imageView1);
        VBox vBox1 = new VBox();
        vBox1.getChildren().addAll(hbox2, hBox, hBox1);
        vBox1.setPadding(new Insets(180, 50, 50, 150));

        borderPane.setCenter(vBox1);



        button1.disableProperty().bind(Bindings.isEmpty(textField.textProperty()));

        button.setOnAction(e ->{
            group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
                public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

                    if (group.getSelectedToggle() != null) {

                        System.out.println(group.getSelectedToggle().getUserData().toString());
                        // Do something here with the userData of newly selected radioButton

                    }

                }
            });
            group1.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
                public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
                    System.out.println("Ciao");
                    //if (group1.getSelectedToggle() != null) {

                        System.out.println(group1.getSelectedToggle().getUserData().toString());
                        // Do something here with the userData of newly selected radioButton

                    //}

                }
            });
            window.setScene(scene1);
        });

        layout.setCenter(vBox);




        window.setScene(scene);

        window.show();
    }

}
