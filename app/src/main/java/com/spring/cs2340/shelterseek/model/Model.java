package com.spring.cs2340.shelterseek.model;

import java.util.HashSet;

/**
 * Created by ajay on 2/16/18.
 */

public class Model {
    /**
     * Singleton instance
     */
    private static final Model instance = new Model();

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
        // empty for now
    }
}
