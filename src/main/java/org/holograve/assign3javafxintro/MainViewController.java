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
import java.time.format.DateTimeParseException;
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
        int valid = checkValid();
        if(valid == 0)
        {
            //create character
            HorrorCharacter newChar = new HorrorCharacter(new ArrayList<>(getVulnerabilities()){},nameField.getText(),Integer.parseInt(healthField.getText()),dateField.getValue());
            //Add to the list
            AppState.horrorCharacterList.add(newChar);
            //MAKE SURE TO CLEAR THE VALUES TODO

            //TOAST SAYING CHARACTER WAS CREATED SUCCESSFULLY TODO

            //we need to refresh the list to get the new values to show unlike I thought :(
            this.firstLV.setItems(AppState.getHorrorCharacterList());
        }
        else{ // TODO
            System.out.println(valid);
            //return of 1: invalid Health
            //2: Malformed date
            //3: No date provided
            //Print a toast for each to give user feedback why character was not made
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
    private int checkValid(){
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


    private void getListData(){
        //Fake backend
        //Normally here is where we would get the data from the database and fill it in
        if(AppState.firstLaunch()) { //IF STATEMENT IS TO PREVENT US FROM READDING THESE VALUES EACH TIME WE OPEN THE SCENE
            AppState.addCharacter(new HorrorCharacter(new ArrayList<Vulnerability>(Arrays.asList(Vulnerability.SILVER)), "Jerry", 100, LocalDate.of(2002, 6, 30)));
            AppState.addCharacter(new HorrorCharacter(new ArrayList<Vulnerability>(Arrays.asList(Vulnerability.HOLY_WATER, Vulnerability.FIRE)), "Terry", 75, LocalDate.of(1995, 9, 12)));
            AppState.addCharacter(new HorrorCharacter(new ArrayList<Vulnerability>(Arrays.asList(Vulnerability.HOLY_WATER, Vulnerability.SUNLIGHT)), "Scary", 50, LocalDate.of(2022, 3, 17)));
        }
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
