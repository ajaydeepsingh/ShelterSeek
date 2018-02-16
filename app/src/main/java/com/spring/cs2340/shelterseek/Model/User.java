package com.spring.cs2340.shelterseek.Model;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class User implements Parcelable {

    protected static int Next_Id = 0;

    protected int _id;
    protected String _username;
    protected String _password;


    /* **********************
     * Getters and setters
     */
    public String getName() {
        return _username;
    }

    public String getPassword() {
        return _password;
    }

    public int getId() {
        return _id;
    }

    public void setName(String name) {
        _username = name;
    }

    public void setPassword(String password) {
        _password = password;
    }


    /**
     * No param constructor -- DO NOT CALL NORMALLY
     * This constructor only for GUI use in creation dialog
     */
    public User() {
        this("enter new name", "NA");
    }

    /**
     * The usual constructor
     *
     * @param name     username
     * @param password password
     */
    public User(String name, String password) {
        _username = name;
        _password = password;
        _id = User.Next_Id++;
    }

    /**
     * @return the display string representation
     */
    public String toString() {
        return _username + " " + _password;
    }
}
