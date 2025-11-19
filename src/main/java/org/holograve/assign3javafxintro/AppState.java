package org.holograve.assign3javafxintro;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.holograve.assign3javafxintro.HorrorCharacterClasses.HorrorCharacter;

import java.util.ArrayList;
import java.util.List;

public class AppState {
    public static List<HorrorCharacter> horrorCharacterList = new ArrayList<HorrorCharacter>();



    public static ObservableList<HorrorCharacter> getHorrorCharacterList(){

        return FXCollections.observableArrayList(horrorCharacterList);
    }

    public static void setHorrorCharacterList(List<HorrorCharacter> aList)
    {
        AppState.horrorCharacterList = aList;
    }

    //ADD CHARACTER TO LIST DONE
    public static void addCharacter(HorrorCharacter character){
        horrorCharacterList.add(character);
    }

    //EDIT CHARACTER TODO
    public static void editCharacter(HorrorCharacter originalChar,HorrorCharacter newCharacter) {
        //Requires a character to edit and a new character to overwrite them with
        //I believe this should be fine with referencing but if not research how we can edit them easily
        //since we lack pointers in java
    }
}
