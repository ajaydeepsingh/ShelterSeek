package com.spring.cs2340.shelterseek.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.spring.cs2340.shelterseek.R;
import com.spring.cs2340.shelterseek.model.Shelter;

public class ShelterDetail extends AppCompatActivity {
    private Shelter _shelterDisplayed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_detail);
        EditText id = (EditText) findViewById(R.id.ShelterId);
        EditText name = (EditText) findViewById(R.id.ShelterName);
        EditText address = (EditText) findViewById(R.id.ShelterAddress);
        EditText ll = (EditText) findViewById(R.id.ShelterLongLat);
        EditText restrictions = (EditText) findViewById(R.id.ShelterRestrictions);
        EditText notes = (EditText) findViewById(R.id.ShelterNotes);
        EditText capacity = (EditText) findViewById(R.id.ShelterCapacity);
        EditText contact_info = (EditText) findViewById(R.id.ShelterPhone);
        if (getIntent().hasExtra(SOMETHING) { // GET THE EXTRA THING PASSED IN
             _shelterDisplayed = (Shelter) getIntent().getParcelableExtra(SAME SOMETHING); // THIS SHOULD CHANGE IT TO THE CORRECT SHELTER
            id.setText(_shelterDisplayed.getUniqueKey());
            name.setText(_shelterDisplayed.getName());
            address.setText(_shelterDisplayed.getName());
            String newString = "" + _shelterDisplayed.getLatitude() + ", " + _shelterDisplayed.
                    getLongitude()
            ll.setText(newString);
            restrictions.setText(_shelterDisplayed.getRestrictions());
            notes.setText(_shelterDisplayed.getSpecialNotes());
            capacity.setText(_shelterDisplayed.getCapacity());
            contact_info.setText(_shelterDisplayed.getContactInfo());
    }
}
