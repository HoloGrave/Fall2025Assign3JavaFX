package org.holograve.assign3javafxintro;

import org.holograve.assign3javafxintro.HorrorCharacterClasses.HorrorCharacter;
import org.holograve.assign3javafxintro.HorrorCharacterClasses.Vulnerability;

import java.time.LocalDate;
import java.util.List;

public class AppState {
    public static List<HorrorCharacter> horrorCharacterList;

    public static List<HorrorCharacter> getHorrorCharacterList(){
        return horrorCharacterList;
    }

    public static void setHorrorCharacterList(List<HorrorCharacter> aList)
    {
        AppState.horrorCharacterList = aList;
    }

    //ADD CHARACTER TO LIST TODO

    //EDIT CHARACTER TODO
        //Requires a character to edit and a new character to overwrite them with
        //I believe this should be fine with referencing but if not research how we can edit them easily
        //since we lack pointers in java
}
