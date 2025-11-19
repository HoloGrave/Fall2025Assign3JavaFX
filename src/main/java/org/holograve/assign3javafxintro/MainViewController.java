package org.holograve.assign3javafxintro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

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
    void createCharacter(ActionEvent event) { //TODO
    //simply just add character to the list and refresh the listview
        //if we can display a message detailing what is wrong, pretty much only the health will ever be an issue
        //check if we are actually given an int from the health field
        if(isNumeric(healthField.getText()))
        {
            //create character
            //refresh the listview
        }
        else{
            //print a toast detailing that the health integer is invalid and character has not been created TODO
        }
    }

    //function for testing if a string is an integer
    private static boolean isNumeric(String s){
        try{
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static void refreshList(){
        //clear the listview TODO
        //read the list to the listview
            //THIS IS IN THE APPSTATE
    }

    private static void createList(){
        //TODO
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Create the characterlist here and refresh it to the list view

        refreshList();
    }
}
