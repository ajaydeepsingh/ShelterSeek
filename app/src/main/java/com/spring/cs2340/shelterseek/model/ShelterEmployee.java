package com.spring.cs2340.shelterseek.model;

/**
 * Shelter Employee
 * @version 1.0
 */
public class ShelterEmployee extends Account {

    private String shelterID;

    /**
     * creates a shelter employee
     * Dev use only
     */
    public ShelterEmployee() {

    }

    /**
     * creates an employee
     * @param name name
     * @param userName username
     * @param password password
     * @param contactInfo phone num
     */
    public ShelterEmployee(String name, String userName, String password, String contactInfo) {
        this(name, userName, password, contactInfo, null);
    }

    /**
     * creates a full shelter employee
     * @param name name
     * @param userName username
     * @param password password
     * @param contactInfo phone num
     * @param shelterID shelter ID (where they work)
     */
    public ShelterEmployee(String name, String userName, String password, String contactInfo,
                           String shelterID) {
        super(name, userName, password, false, contactInfo);
        this.shelterID = shelterID;
    }

    /**
     * gets the id
     * @return id
     */
    public String getShelterID() {
        return shelterID;
    }

    /**
     * sets the ID
     * @param shelterID new ID
     */
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

    @Override
    public void toStringDebug() {
        System.out.print("---SHELTER EMPLOYEE---\n" +
                "Name: " + getName() + "\n" +
                "Username: " + getUserName() + "\n" +
                "Password: " + getPassword() + "\n" +
                "Contact Info: " + getContactInfo() + "\n" +
                "ShelterEmployee: " + getShelterID());
    }
}