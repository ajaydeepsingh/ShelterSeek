package com.spring.cs2340.shelterseek.model;

public abstract class Account {
    private String name;
    private String userName;
    private String password;
    private boolean lockedOut;
    private String contactInfo;



    public Account(String name, String userName, String password, boolean lockedOut, String contactInfo) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.lockedOut = lockedOut;
        this.contactInfo = contactInfo;
    }

    public Account() {
        // no args constructor
    }

    public String getUserName() {
        return userName;
    }

    public void setUserId(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLockedOut() {
        return lockedOut;
    }

    public void setLockedOut(boolean lockedOut) {
        this.lockedOut = lockedOut;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
