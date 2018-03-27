package com.spring.cs2340.shelterseek.model;

import java.util.List;

/**
 *
 * Created by ajay on 2/15/2018
 *
 */


public class User extends Account {
    private String gender;
    private String dateOfBirth;
    private boolean isVeteran;
    private int reservedBeds;

    public User(String name, String userName, String password, boolean lockedOut, String contactInfo,
                String gender, String dateOfBirth, boolean isVeteran) {
        super(name, userName, password, lockedOut, contactInfo);
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.isVeteran = isVeteran;
        this.reservedBeds = 0;
    }


    public User(String name, String userName, String contactInfo, String password) {
        this(name, userName, password, false, contactInfo, "Male", null, false);
        this.reservedBeds = 0;
    }

    public User() {

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isVeteran() {
        return isVeteran;
    }

    public void setVeteran(boolean veteran) {
        isVeteran = veteran;
    }

    public void setReservedBeds(int bedBool) { reservedBeds = bedBool; }

    public int getReservedBeds() { return reservedBeds; }



    @Override
    public String toString() {
        return "------USER------\n" +
                "Name: " + getName() + "\n" +
                "Username: " + getUserName() + "\n" +
                "Password: " + getPassword() + "\n" +
                "Contact Info: " + getContactInfo() + "\n" +
                "Gender: " + getGender() + "\n" +
                "DOB: " + getDateOfBirth() + "\n" +
                "Veteran: " + isVeteran();
    }
}