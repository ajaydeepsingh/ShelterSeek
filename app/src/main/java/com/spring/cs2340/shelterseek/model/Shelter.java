package com.spring.cs2340.shelterseek.model;

import java.util.HashSet;

/**
 * Created by ajay on 02/15/18.
 */

public class Shelter {
    private String uniqueKey;
    private String name;
    private int capacity;
    private int vacancies;
    private int latitude;
    private int longitude;
    private float rating;
    private HashSet<String> restrictions;
    private float cost;
    private String contactInfo;
    private User[] blacklist;
    private User[] currentResidents;
}
