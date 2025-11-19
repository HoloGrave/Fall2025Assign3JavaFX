package org.holograve.assign3javafxintro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //used to load our FXML files to our scene creation
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("MainView.fxml"));
        //using fxmlloader in the scene construction
        Scene mainScene = new Scene(fxmlLoader.load(), 300, 300);

        stage.setTitle("");
        stage.setScene(mainScene);
        stage.setResizable(false);
        stage.show();
    }
}
