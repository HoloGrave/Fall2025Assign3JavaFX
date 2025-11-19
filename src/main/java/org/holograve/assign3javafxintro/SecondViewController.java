package org.holograve.assign3javafxintro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class SecondViewController {

    @FXML
    private Button backBtn;
    @FXML
    private Button editBtn;
    @FXML
    private ListView<?> secondLV;

    private boolean editing = false;

    @FXML
    void backBtn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("MainView.fxml"));
        Scene newScene = new Scene(fxmlLoader.load(), 300, 300);
        Stage currentStage = (Stage) backBtn.getScene().getWindow();
        currentStage.setScene(newScene);
    }

    @FXML
    void editBtn(ActionEvent event) {
        //Check if this button is a done button or not via editing bool
        if(editing){
            boolean valid = false;
            //check the status of the contents of the listview if they are all valid
            if(valid){

            }
            else{
                //show some sort of popup stating that the values given are invalid
                //ask if the user wants to discard their changes instead
            }
        }
        else{
            editing = true;
        }
    }

}