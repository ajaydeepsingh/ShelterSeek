package com.example.jmc19.shelterseeker.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private static int Next_Id = 0;

    private int _id;
    private String _username;
    private String _password;


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

    /* *********************************
     * These methods are required by the Parcelable interface
     * I just wanted to demo how to pass information from one activity
     * to another through an intent.   If this were a real project, I
     * would probably have the facade maintain information about the
     * currently selected user which would remove the need to
     * pass the user object in an intent, which would remove the need
     * to implement the Parcelable interface and these methods.
     */

    /**
     * Constructor used by Parcel to make a new user out of the
     * parceled information
     *
     * @param in the parcel containing the user information
     */
    private User(Parcel in) {
        _username = in.readString();
        _password = in.readString();
        _id = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /* *************************
       If you add new instance vars to user, you will need to add them to the write
       Be sure the order you write information matches the order that the constructor above
       reads them.
     */

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_username);
        dest.writeString(_password);
        dest.writeInt(_id);
    }

    /**
     * Should not have to edit this method if the constructor and write method are
     * working correctly.
     */
    public static final Parcelable.Creator<User> CREATOR
            = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
