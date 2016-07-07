package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {

    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 800;
    private static final String WINDOW_TITLE = "Office Calendar";


    @Override
    public void start(Stage primaryStage) throws Exception {
        Locale.setDefault(new Locale("pl", "PL"));
        //Locale.setDefault(new Locale("en", "EN"));

        //ResourceBundle languageBundle = ResourceBundle.getBundle("LangBundle", Locale.getDefault());

        Parent root = FXMLLoader.load(getClass().getResource("../sample.fxml"));
        primaryStage.setTitle(WINDOW_TITLE);
        primaryStage.setScene(new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
