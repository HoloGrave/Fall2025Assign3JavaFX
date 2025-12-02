package org.holograve.assign3javafxintro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.holograve.assign3javafxintro.HorrorCharacterClasses.HorrorCharacter;

import java.util.ArrayList;

public class AppState {
    public static ArrayList<HorrorCharacter> horrorCharacterList = new ArrayList<>();
    private static boolean firstCreate = true;

    public static ObservableList<HorrorCharacter> getHorrorCharacterList(){

        return FXCollections.observableArrayList(horrorCharacterList);
    }

    public static ObservableList<String> getHorrorCharacterListStringShort (){

        ArrayList<String> horrorCharacterStrings = new ArrayList<>();
        for(HorrorCharacter hc: horrorCharacterList) {
            horrorCharacterStrings.add(hc.toStringShort());
        }
        return FXCollections.observableArrayList(horrorCharacterStrings);
    }
    public static ObservableList<String> getHorrorCharacterListString (){

        ArrayList<String> horrorCharacterStrings = new ArrayList<>();
        for(HorrorCharacter hc: horrorCharacterList) {
            horrorCharacterStrings.add(hc.toString());
        }
        return FXCollections.observableArrayList(horrorCharacterStrings);
    }

    public static void setHorrorCharacterList(ArrayList<HorrorCharacter> aList)
    {
        AppState.horrorCharacterList = aList;
    }

    //ADD CHARACTER TO LIST DONE
    public static void addCharacter(HorrorCharacter character){
        horrorCharacterList.add(character);
    }

    public static void dropCharacter(int index){
        horrorCharacterList.remove(index);
    }

    //EDIT CHARACTER TODO
    public static void editCharacter(HorrorCharacter originalChar,HorrorCharacter newCharacter) {
        //Requires a character to edit and a new character to overwrite them with
        //I believe this should be fine with referencing but if not research how we can edit them easily
        //since we lack pointers in java
    }

    public static boolean firstLaunch(){
        if(firstCreate)
        {
            firstCreate = false;
            return true;
        }
        return false;
    }
}
