package com.spring.cs2340.shelterseek.model;
/**
 * Admin class
 * @version 1.0
 */
public class Admin extends Account {
    /**
     * creates a new admin
     * @param name name
     * @param userName username chosen
     * @param password password
     * @param contactInfo phone number
     */
    public Admin(String name, String userName, String password, String contactInfo) {
        super(name, userName, password, false, contactInfo);
    }

    /**
     * admin no arg constructor
     * DEV use only
     */
    public Admin() {
        // no args constructor
    }

    @Override
    public String toString() {
        return "------ADMIN------\n" +
                "Name: " + getName() + "\n" +
                "Username: " + getUserName() + "\n" +
                "Password: " + getPassword() + "\n" +
                "Contact Info: " + getContactInfo();
    }
}