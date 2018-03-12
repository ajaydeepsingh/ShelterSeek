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

    public User(String name, String userName, String password, boolean lockedOut, String contactInfo,
                String gender, String dateOfBirth, boolean isVeteran) {
        super(name, userName, password, lockedOut, contactInfo);
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.isVeteran = isVeteran;
    }


    public User(String name, String userName, String contactInfo, String password) {
        this(name, userName, password, false, contactInfo, "Male", null, false);
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