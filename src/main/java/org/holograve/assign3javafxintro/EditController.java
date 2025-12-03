package org.holograve.assign3javafxintro;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.holograve.assign3javafxintro.HorrorCharacterClasses.HorrorCharacter;
import org.holograve.assign3javafxintro.HorrorCharacterClasses.Vulnerability;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EditController implements Initializable {

    @FXML private Label customLabel;
    @FXML private TextField customName;
    @FXML private DatePicker dateField;
    @FXML private Button editBtn;
    @FXML private RadioButton fireRadio;
    @FXML private TextField healthField;
    @FXML private RadioButton holWatRadio;
    @FXML private ComboBox<String> monsterPreset;
    @FXML private ComboBox<String> monsterSelection;
    @FXML private TextField nameField;
    @FXML private Button discardBtn;
    @FXML private RadioButton silverRadio;
    @FXML private RadioButton sunRadio;
    @FXML private HBox customBox;

    HorrorCharacter charToEdit;

    @FXML
    void checkMonster(ActionEvent event) {
        if (monsterSelection.getValue() == "Custom") {
            customBox.setVisible(true);
        }
        else{
            customBox.setVisible(false);
        }
    }

    @FXML
    void discardChanges(ActionEvent event) {
        Stage currentStage = (Stage) this.discardBtn.getScene().getWindow();
        currentStage.close();
        //this works since the stage class is a child class of a window
    }

    @FXML
    void saveCharacter(ActionEvent event) { //TODO error messages & validation & saving functionality
        boolean didSave = false;
        ArrayList<Integer> errors = checkValid();

        //if there is nothing detected that may cause problems when trying to save the character
        if(errors.size() == 0) {
            //update each value of the character
            charToEdit.setName(nameField.getText());
            charToEdit.setHealth(Integer.parseInt(healthField.getText()));
            charToEdit.setMonsterType((String) monsterSelection.getValue());
            charToEdit.setCreationDate(dateField.getValue());
            charToEdit.setVulnerabilities(getVulnerabilities());
            didSave = true;
        }

        if(didSave){
            Stage currentStage = (Stage) this.editBtn.getScene().getWindow();
            currentStage.close();
            //this works since the stage class is a child class of a window
            System.out.println("Successfully edited"+ charToEdit.getName());
        }
        else{
            //check for error code and print out a message why the character was unable to be saved
            for(int i : errors)
            {
                if(i == 1){System.out.println("Health is an invalid input");}
                if(i==2){System.out.println("Date is an invalid input");}
            }
        }
    }

    //Same exact function in the create controller
    //honestly with using Modal windows its showing that keeping everything just to one controller would be pretty feasible
    private ArrayList<Integer> checkValid(){
        //uses an arraylist to save the specific spots in which the program would fail to create the character

        //check health field
        ArrayList<Integer> errors = new ArrayList<Integer>();

        //check health field
        try{
            Integer.parseInt(healthField.getText());
        } catch(NumberFormatException e){
            errors.add(1);
        }
        //check date field
        //check for any input
        if(dateField.getValue() == null){
            errors.add(2);
        }
        //check for invalid input
        return errors;
    }

    private ArrayList<Vulnerability> getVulnerabilities(){
        ArrayList<Vulnerability> vulList = new ArrayList<>();

        if(fireRadio.isSelected()){vulList.add(Vulnerability.FIRE);}
        if(holWatRadio.isSelected()){vulList.add(Vulnerability.HOLY_WATER);}
        if(silverRadio.isSelected()){vulList.add(Vulnerability.SILVER);}
        if(sunRadio.isSelected()){vulList.add(Vulnerability.SUNLIGHT);}

        return vulList;
    };


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        monsterSelection.setItems(FXCollections.observableArrayList("Zombie","Vampire","WereWolf","Custom"));
        monsterPreset.setItems(FXCollections.observableArrayList("Zombie","Vampire","WereWolf","Custom"));

        //Since this is the edit window we need to add the original character's stats
        charToEdit = AppState.horrorCharacterList.get(AppState.getIndex());

        nameField.setText(charToEdit.getName());
        healthField.setText(Integer.toString(charToEdit.getHealth()));
        dateField.setValue(charToEdit.getCreationDate());
        setRadios();
        monsterSelection.setValue(charToEdit.getMonsterType());
    }

    private void setRadios(){
        ArrayList<Vulnerability> charVuls = charToEdit.getVulnerabilities();
        if(charVuls.contains(Vulnerability.FIRE)){fireRadio.setSelected(true);}
        if(charVuls.contains(Vulnerability.SILVER)){silverRadio.setSelected(true);}
        if(charVuls.contains(Vulnerability.HOLY_WATER)){holWatRadio.setSelected(true);}
        if(charVuls.contains(Vulnerability.SUNLIGHT)){sunRadio.setSelected(true);}
    }
}
