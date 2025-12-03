package org.holograve.assign3javafxintro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
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
    @FXML private Button editBtn;
    @FXML private ListView<HorrorCharacter> firstLV;

    @FXML
    void chngCreateView(ActionEvent event) throws IOException {
        //open view in a new window, dont close the other one but rather make it uninteractable
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("CreateView.fxml"));
        Stage createStage = new Stage();
        createStage.setScene(new Scene(fxmlLoader.load()));
        createStage.initModality(Modality.WINDOW_MODAL);
        createStage.initOwner(createBtn.getScene().getWindow());
        createStage.setTitle("Create Character");

        //Init modality prevents events from occuring on the original window or could also be set for the whole application
        //but that isnt neccessary for this application as there is only one main window

        //show and wait isnt as neccessary for this circumstance but its still good practice to use it
        //prevents the code from continueing on from this point until the modal window is closed
        //Would be neccessary if we werent just using another controller on the modal window for data control
        createStage.showAndWait();
        //no nvm upon testing its neccessary to make sure we refresh the list only after we do our actions in the modal
        this.firstLV.setItems(AppState.getHorrorCharacterList());
    }

    @FXML
    void chngEditView(ActionEvent event) throws IOException {
        //check if the user has a character selected to edit in the first place
        if(firstLV.getSelectionModel().getSelectedIndex() > -1) {
            //if they do then we can open the new view
            AppState.provideIndex(firstLV.getSelectionModel().getSelectedIndex());
            //open view in a new window, dont close the other one but rather make it uninteractable
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("editView.fxml"));
            Stage editStage = new Stage();
            editStage.setScene(new Scene(fxmlLoader.load()));
            editStage.initModality(Modality.WINDOW_MODAL);
            editStage.initOwner(editBtn.getScene().getWindow());
            editStage.setTitle("Create Character");

            //Init modality prevents events from occuring on the original window or could also be set for the whole application
            //but that isnt neccessary for this application as there is only one main window

            //show and wait isnt as neccessary for this circumstance but its still good practice to use it
            //prevents the code from continueing on from this point until the modal window is closed
            //Would be neccessary if we werent just using another controller on the modal window for data control
            editStage.showAndWait();
            this.firstLV.setItems(AppState.getHorrorCharacterList());
        }
        else{
            System.out.println("No character selected to open\nPlease select a character to open");
        }
    }

    @FXML
    void deleteValue(ActionEvent event) {
            //simply delete the value from the database and refresh the data
            int selectedItem = firstLV.getSelectionModel().getSelectedIndex();
            if(selectedItem > -1) {
                AppState.dropCharacter(selectedItem);
                //refresh the list with new values
                this.firstLV.setItems(AppState.getHorrorCharacterList());
            }
            else{
                //message that tells the user that they dont have anything selected
                System.out.println("No data selected to delete");
            }
    }

    private void getListData(){
        //Fake backend
        //Normally here is where we would get the data from the database and fill it in
        if(AppState.firstLaunch()) { //IF STATEMENT IS TO PREVENT US FROM READDING THESE VALUES EACH TIME WE OPEN THE SCENE
            AppState.addCharacter(new HorrorCharacter(new ArrayList<Vulnerability>(Arrays.asList(Vulnerability.SILVER)), "Jerry", 100, LocalDate.of(2002, 6, 30),"Sample Monster A"));
            AppState.addCharacter(new HorrorCharacter(new ArrayList<Vulnerability>(Arrays.asList(Vulnerability.HOLY_WATER, Vulnerability.FIRE)), "Terry", 75, LocalDate.of(1995, 9, 12),"Sample Monster B"));
            AppState.addCharacter(new HorrorCharacter(new ArrayList<Vulnerability>(Arrays.asList(Vulnerability.HOLY_WATER, Vulnerability.SUNLIGHT)), "Scary", 50, LocalDate.of(2022, 3, 17),"Sample Monster C"));
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
