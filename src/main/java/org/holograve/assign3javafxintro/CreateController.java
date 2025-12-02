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
import org.holograve.assign3javafxintro.HorrorCharacterClasses.HorrorCharacter;
import org.holograve.assign3javafxintro.HorrorCharacterClasses.Vulnerability;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class CreateController {

    @FXML private Label CustomLabel;
    @FXML private TextField CustomNameField;
    @FXML private Button backBtn;
    @FXML private Button createBtn;
    @FXML private DatePicker dateField;
    @FXML private RadioButton fireRadio;
    @FXML private TextField healthField;
    @FXML private RadioButton holWatRadio;
    @FXML private ComboBox<?> monsterSelection;
    @FXML private TextField nameField;
    @FXML private ComboBox<?> presetMonster;
    @FXML private RadioButton silverRadio;
    @FXML private RadioButton sunRadio;

    @FXML
    void createCharacter(ActionEvent event) { //TODO error messages
        boolean didCreate = false;
        int errorCode = 0;
        //function here attempting to create the character
        //if the character successfully creates then set the didCreate to true
        //otherwise assign errorcode
        try{
            //check if the inputs are all valid
            //returns an int to help indentify the issue
            errorCode = checkValid();

            //otherwise try to create the character
            //create character
            HorrorCharacter newChar = new HorrorCharacter(new ArrayList<>(getVulnerabilities()){},nameField.getText(),Integer.parseInt(healthField.getText()),dateField.getValue(),monsterSelection.getPromptText());
            //Add to the list
            AppState.horrorCharacterList.add(newChar);

        } catch (Exception e) {
            //for cases not covered in our data validation method
            errorCode = -1;
        }
        //exiting the modal window once we are done
        if(didCreate){
            Stage currentStage = (Stage) this.createBtn.getScene().getWindow();
            currentStage.close();
            //this works since the stage class is a child class of a window
        }
        else{ // TODO error messages here
            //message for why the character was not able to be created
        }
    }

    private ArrayList<Vulnerability> getVulnerabilities(){
        ArrayList<Vulnerability> vulList = new ArrayList<>();

        if(fireRadio.isSelected()){vulList.add(Vulnerability.FIRE);}
        if(holWatRadio.isSelected()){vulList.add(Vulnerability.HOLY_WATER);}
        if(silverRadio.isSelected()){vulList.add(Vulnerability.SILVER);}
        if(sunRadio.isSelected()){vulList.add(Vulnerability.SUNLIGHT);}

        return vulList;
    };

    private int checkValid(){ //TODO go back through this function to ensure no problems
        //check health field
        int returnCode = 0;
        try{
            Integer.parseInt(healthField.getText());
        } catch(NumberFormatException e){
            returnCode = 1;
        }
        //check date field
        try{
            //check for any input
            if(dateField.getValue() == null){
                returnCode = 3;
            }
            //check for invalid input
            LocalDate.parse(dateField.getEditor().getText());
        }
        catch (DateTimeParseException e){
            returnCode = 2;
        }

        return returnCode;
    }


}
