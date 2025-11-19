package org.holograve.assign3javafxintro.HorrorCharacterClasses;

import java.time.LocalDate;

/**
 * This is the superclass for all HorrorCharacters
 */
public class HorrorCharacter {

    //Attributes
    String name;
    int health;
    Vulnerability[] vulnerabilities;
    LocalDate creationDate; //-----------ADDED

    //Constructor

    /**
     * @param vulnerabilities character vulnerabilities
     * @param name name of the character
     * @param health health of the character
     * @param creationDate creation date of the object
     */
    public HorrorCharacter(Vulnerability[] vulnerabilities, String name, int health, LocalDate creationDate) {
    this.vulnerabilities = vulnerabilities;
    this.name = name;
    this.health = health;
    this.creationDate = creationDate;
    }
    //Methods
    //THESE SHOULD BE OVERRIDDEN IN SUBCLASSES

    /**
     * Should be overwritten in subclasses.
     */
    public void attack(){}

    /**
     * Should be overwritten in subclasses.
     */
    public void flee(){}

    //Getters and Setters

    /**
     * @return an array of vulnerabilities
     */
    public Vulnerability[] getVulnerabilities(){return this.vulnerabilities;}

    /**
     * @param vulnerabilities requires an array of vulnerabilities
     */
    public void setVulnerabilities(Vulnerability[] vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }
}
