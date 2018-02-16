package com.spring.cs2340.shelterseek.model;
/**
 * Created by jmc19 on 2/15/2018.
 * Created by ajay on 2/15/2018.
 *
 */

public class Admin extends Account {
    public Admin(String name, String userId, String password, String contactInfo) {
        super(name, userId, password, false, contactInfo);
    }

    public Admin() {
        // no args constructor
    }

    @Override
    public String toString() {
        return "------ADMIN------\n" +
                "Name: " + getName() + "\n" +
                "Username: " + getUserId() + "\n" +
                "Password: " + getPassword() + "\n" +
                "Contact Info: " + getContactInfo();
    }
}