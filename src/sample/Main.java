package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import sample.ui.Memorama;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setTitle("Prácticas de Tópicos 2020");
        primaryStage.setMaximized(true);
        //primaryStage.setScene(new Scene(new BorderPane(), 300, 275));
        primaryStage.show();

        new Memorama();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
