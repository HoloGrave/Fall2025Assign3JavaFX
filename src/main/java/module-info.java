module org.holograve.assign3javafxintro {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires javafx.base;


    opens org.holograve.assign3javafxintro to javafx.fxml;
    exports org.holograve.assign3javafxintro;
    exports org.holograve.assign3javafxintro.HorrorCharacterClasses;
    opens org.holograve.assign3javafxintro.HorrorCharacterClasses to javafx.fxml;
}