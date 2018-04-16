package com.spring.cs2340.shelterseek.model;

/**
 * Account class
 * @version 1.0
 */
public abstract class Account {
    private String name;
    private String userName;
    private String password;
    private boolean lockedOut;
    private String contactInfo;


    /**
     * creates an account
     * @param name name
     * @param userName the chosen username
     * @param password the chosen password
     * @param lockedOut if the user is locked out
     * @param contactInfo the users contact info
     */
    public Account(String name, String userName, String password, boolean lockedOut,
                   String contactInfo) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.lockedOut = lockedOut;
        this.contactInfo = contactInfo;
    }

    /**
     * creates an account
     * DEV use only
     */
    public Account() {
        // no args constructor
    }

    /**
     * return a username
     * @return username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * sets a username to another
     * @param userName new username
     */
    public void setUserId(String userName) {
        this.userName = userName;
    }

    /**
     * return password
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * sets a new password
     * @param password new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * if user is locked out
     * @return if user is locked out
     */
    public boolean isLockedOut() {
        return lockedOut;
    }

    /**
     * sets if user locked out
     * @param lockedOut true or false manual setting
     */
    public void setLockedOut(boolean lockedOut) {
        this.lockedOut = lockedOut;
    }

    /**
     * contact info getter
     * @return contact info
     */
    public String getContactInfo() {
        return contactInfo;
    }

    /**
     * sets new contact info
     * @param contactInfo new contact info
     */
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    /**
     * gets the name
     * @return the user's actual name
     */
    public String getName() {
        return name;
    }

    /**
     * sets a new name
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }

    public void toStringDebug() {

    }
}
