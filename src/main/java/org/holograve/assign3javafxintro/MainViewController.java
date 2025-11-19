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
import org.holograve.assign3javafxintro.HorrorCharacterClasses.HorrorCharacter;
import org.holograve.assign3javafxintro.HorrorCharacterClasses.Vulnerability;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML private Button createBtn;
    @FXML private DatePicker dateField;
    @FXML private RadioButton fireRadio;
    @FXML private ListView<HorrorCharacter> firstLV;
    @FXML private TextField healthField;
    @FXML private RadioButton holWatRadio;
    @FXML private TextField nameField;
    @FXML private Button secondViewbtn;
    @FXML private RadioButton silverRadio;
    @FXML private RadioButton sunRadio;


    @FXML
    void changeView(ActionEvent event) throws IOException {
    //change stage to the other one
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("SecondView.fxml"));
        Scene newScene = new Scene(fxmlLoader.load(), 600, 400);
        Stage currentStage = (Stage) secondViewbtn.getScene().getWindow();
        currentStage.setScene(newScene);
    }

    @FXML
    void createCharacter(ActionEvent event) { //TODO DONE unsure, need to check for exceptions
    //simply just add character to the list and refresh the listview
        //if we can display a message detailing what is wrong, pretty much only the health will ever be an issue
        //check if we are actually given an int from the health field
        if(isNumeric(healthField.getText()))
        {

            //create character
            HorrorCharacter newChar = new HorrorCharacter(new ArrayList<>(getVulnerabilities()){},nameField.getText(),Integer.parseInt(healthField.getText()),dateField.getValue());
            //Add to the list
            AppState.horrorCharacterList.add(newChar);
        }
        else{ // TODO
            //print a toast detailing that the health integer is invalid and character has not been created TODO
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

    //function for testing if a string is an integer
    private static boolean isNumeric(String s){
        try{
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }


    private void getListData(){
        //Clear the current data in the listview so that we wont end up adding onto the old data
        AppState.horrorCharacterList.clear();

        //Fake backend
        //Normally here is where we would get the data from the database and fill it in
        AppState.addCharacter(new HorrorCharacter(new ArrayList<Vulnerability>(Arrays.asList(Vulnerability.SILVER,Vulnerability.FIRE)),"Jerry",50, LocalDate.of(2002,9,30)));
        AppState.addCharacter(new HorrorCharacter(new ArrayList<Vulnerability>(Arrays.asList(Vulnerability.SILVER,Vulnerability.FIRE)),"Jerry",50, LocalDate.of(2002,9,30)));
        AppState.addCharacter(new HorrorCharacter(new ArrayList<Vulnerability>(Arrays.asList(Vulnerability.SILVER,Vulnerability.FIRE)),"Jerry",50, LocalDate.of(2002,9,30)));

        //We only have to supply the values once because any changes to the list in our creation tab should automatically update the listview
        this.firstLV.setItems(AppState.getHorrorCharacterList());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Create the characterlist here
        //We dont need to refresh when new values come in as listview does that already by itself
        getListData();
    }
}
