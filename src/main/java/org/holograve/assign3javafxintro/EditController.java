package org.holograve.assign3javafxintro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditController {

    @FXML private Label customLabel;
    @FXML private TextField customName;
    @FXML private DatePicker dateField;
    @FXML private Button editBtn;
    @FXML private RadioButton fireRadio;
    @FXML private TextField healthField;
    @FXML private RadioButton holWatRadio;
    @FXML private ComboBox<?> monsterPreset;
    @FXML private ComboBox<?> monsterSelection;
    @FXML private TextField nameField;
    @FXML private Button discardBtn;
    @FXML private RadioButton silverRadio;
    @FXML private RadioButton sunRadio;

    @FXML
    void discardChanges(ActionEvent event) {
        Stage currentStage = (Stage) this.discardBtn.getScene().getWindow();
        currentStage.close();
        //this works since the stage class is a child class of a window
    }

    @FXML
    void saveCharacter(ActionEvent event) { //TODO error messages & validation & saving functionality
        boolean didSave = false;
        int errorCode = 0;


        if(didSave){
            Stage currentStage = (Stage) this.editBtn.getScene().getWindow();
            currentStage.close();
            //this works since the stage class is a child class of a window
        }
        else{
            //check for error code and print out a message why the character was unable to be saved
        }
    }

}
