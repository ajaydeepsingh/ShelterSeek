package com.spring.cs2340.shelterseek.model;

import java.util.HashSet;
import java.util.ArrayList;

/**
 * Created by ajay on 2/16/18.
 */

public class Model {
    /**
     * Singleton instance
     */
    private static final Model instance = new Model();
    private static ArrayList<Account> accounts;
    private HashSet<Shelter> shelters;
    private Account currentUser;

    /**
     * returns the static instance of the model to use in the controller
     *
     * @return an instance of the Model to interact with.
     */
    public static Model getInstance() {
        return instance;
    }

    /**
     * make a new model
     */
    private Model() {
        accounts = new ArrayList<Account>();
        this.dummyData();
    }

    public void dummyData() {
        User dummy = new User("Bob", "User", "1234567890", "Pass");
        this.addNewAccount(dummy);
    }

    public boolean addNewAccount(Account a) {
        if (a == null) {
            System.out.println("Account is null");
            return false;
        }
        accounts.add(a);
        return true;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}
