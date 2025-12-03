package org.holograve.assign3javafxintro.HorrorCharacterClasses;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This is the superclass for all HorrorCharacters
 */
public class HorrorCharacter {

    //Attributes
    String name;
    int health;
    ArrayList<Vulnerability> vulnerabilities;
    LocalDate creationDate;
    String monsterType; //---------ADDED

    //Constructor

    /**
     * @param vulnerabilities character vulnerabilities
     * @param name name of the character
     * @param health health of the character
     * @param creationDate creation date of the object
     */
    public HorrorCharacter(ArrayList<Vulnerability> vulnerabilities, String name, int health, LocalDate creationDate, String monsterType) {
    this.vulnerabilities = vulnerabilities;
    this.name = name;
    this.health = health;
    this.creationDate = creationDate;
    this.monsterType = monsterType;
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
    public ArrayList<Vulnerability> getVulnerabilities(){return this.vulnerabilities;}

    /**
     * @param vulnerabilities requires an array of vulnerabilities
     */
    public void setVulnerabilities(ArrayList<Vulnerability> vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
    }

    public String toStringShort(){
        return this.monsterType+" "+this.name+" "+this.health;
    }

    @Override
    public String toString(){
        return ("Monster: "+this.monsterType+" | Name: "+this.name+" | Health: "+this.health+" | Vuls: "+this.vulnerabilities+" | Creation date: "+this.creationDate);
    }

}
