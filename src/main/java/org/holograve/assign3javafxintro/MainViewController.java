package org.holograve.assign3javafxintro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {

    @FXML
    private Button createBtn;
    @FXML
    private DatePicker dateField;
    @FXML
    private RadioButton fireRadio;
    @FXML
    private ListView<?> firstLV;
    @FXML
    private TextField healthField;
    @FXML
    private RadioButton holWatRadio;
    @FXML
    private TextField nameField;
    @FXML
    private Button secondViewbtn;
    @FXML
    private RadioButton silverRadio;
    @FXML
    private RadioButton sunRadio;


    @FXML
    void changeView(ActionEvent event) throws IOException {
    //change stage to the other one
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("SecondView.fxml"));
        Scene newScene = new Scene(fxmlLoader.load(), 600, 400);
        Stage currentStage = (Stage) secondViewbtn.getScene().getWindow();
        currentStage.setScene(newScene);
    }

    @FXML
    void createCharacter(ActionEvent event) {
    //simply just add character to the list and refresh the listview
        //if we cant display a message detailing what is wrong, pretty much only the health will ever be an issue
    }

}
