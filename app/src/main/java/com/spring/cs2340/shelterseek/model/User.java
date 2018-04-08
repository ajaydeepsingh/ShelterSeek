package com.spring.cs2340.shelterseek.model;

/**
 * User class
 * @version 1.0
 */
public class User extends Account {
    private String gender;
    private String dateOfBirth;
    private boolean isVeteran;
    private int reservedBeds;

    /**
     * creates a user
     * @param name name
     * @param userName username
     * @param password password
     * @param lockedOut if locked out
     * @param contactInfo phone num
     * @param gender gender
     * @param dateOfBirth DOB
     * @param isVeteran if is Veteran
     */
    public User(String name, String userName, String password, boolean lockedOut,
                String contactInfo, String gender, String dateOfBirth, boolean isVeteran) {
        super(name, userName, password, lockedOut, contactInfo);
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.isVeteran = isVeteran;
        this.reservedBeds = 0;
    }

    /**
     * creates a BASIC user
     * @param name name
     * @param userName username
     * @param contactInfo phone number
     * @param password password
     */
    public User(String name, String userName, String contactInfo, String password) {
        this(name, userName, password, false, contactInfo, "Male", null, false);
        this.reservedBeds = 0;
    }

    /**
     * user no args
     * DEV use only
     */
    public User() {}

    /**
     * gets gender
     * @return user's gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * sets gender
     * @param gender new gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * return date of birth
     * @return DOB
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * sets new date of birth
     * @param dateOfBirth new DOB
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * gets if user is veteran
     * @return isVeteran
     */
    public boolean isVeteran() {
        return isVeteran;
    }

    /**
     * sets if user is veteran
     * @param veteran new veteran status
     */
    public void setVeteran(boolean veteran) {
        isVeteran = veteran;
    }

    /**
     * set num of reserved beds
     * @param bedBool new reservedbed num
     */
    public void setReservedBeds(int bedBool) { reservedBeds = bedBool; }

    /**
     * gets number of reserved beds
     * @return reserved bed number
     */
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