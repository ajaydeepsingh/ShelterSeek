package com.spring.cs2340.shelterseek.model;

/**
 * Created by jmc19 on 2/15/2018.
 * Created by ajay on 2/15/2018.
 */

public class ShelterEmployee extends Account {

    private String shelterID;

    public ShelterEmployee() {

    }

    public ShelterEmployee(String name, String userName, String password, String contactInfo) {
        this(name, userName, password, contactInfo, null);
    }

    public ShelterEmployee(String name, String userName, String password, String contactInfo, String shelterID) {
        super(name, userName, password, false, contactInfo);
        this.shelterID = shelterID;
    }

    public String getShelterID() {
        return shelterID;
    }

    public void setShelterID(String shelterID) {
        this.shelterID = shelterID;
    }

    @Override
    public String toString() {
        return "---SHELTER EMPLOYEE---\n" +
                "Name: " + getName() + "\n" +
                "Username: " + getUserName() + "\n" +
                "Password: " + getPassword() + "\n" +
                "Contact Info: " + getContactInfo() + "\n" +
                "ShelterEmployee: " + getShelterID();
    }
}