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

public class CreateController implements Initializable {

    @FXML private Label CustomLabel;
    @FXML private TextField CustomNameField;
    @FXML private Button backBtn;
    @FXML private Button createBtn;
    @FXML private DatePicker dateField;
    @FXML private RadioButton fireRadio;
    @FXML private TextField healthField;
    @FXML private RadioButton holWatRadio;
    @FXML private ComboBox<String> monsterSelection;
    @FXML private TextField nameField;
    @FXML private ComboBox<String> presetMonster;
    @FXML private RadioButton silverRadio;
    @FXML private RadioButton sunRadio;
    @FXML private HBox customBox;

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
    void createCharacter(ActionEvent event) {
        boolean didCreate = false;
        java.util.ArrayList<Integer> errors = new ArrayList<Integer>();
        //check if the inputs are all valid
        //returns an int to help indentify the issue
        errors = checkValid();

        //function here attempting to create the character
        //if the character successfully creates then set the didCreate to true
        //otherwise assign errorcode
        if(errors.size() == 0) {
            try {
                //otherwise try to create the character
                //create character
                HorrorCharacter newChar = new HorrorCharacter(new ArrayList<>(getVulnerabilities()) {
                }, nameField.getText(), Integer.parseInt(healthField.getText()), dateField.getValue(), monsterSelection.getPromptText());
                //Add to the list
                AppState.horrorCharacterList.add(newChar);
                didCreate = true;

            } catch (Exception e) {
                //for cases not covered in our data validation method
                errors.add(-1);
            }
        }
        //exiting the modal window once we are done
        if(didCreate){
            Stage currentStage = (Stage) this.createBtn.getScene().getWindow();
            currentStage.close();
            //this works since the stage class is a child class of a window
        }
        else {
            //message for why the character was not able to be created
            for (int i : errors) {
                if (i == 1) {
                    System.out.println("Health is an invalid input");
                }
                if (i == 2) {
                    System.out.println("Date is an invalid input");
                }
                if (i == -1) {
                    System.out.println("Unknown error: Code -1");
                }
            }
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
        if (dateField.getValue() == null) {
            errors.add(2);
        }
        return errors;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        monsterSelection.setItems(FXCollections.observableArrayList("Zombie","Vampire","WereWolf","Custom"));
        presetMonster.setItems(FXCollections.observableArrayList("Zombie","Vampire","WereWolf","Custom"));
    }
}
