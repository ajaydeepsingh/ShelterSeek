package com.spring.cs2340.shelterseek.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;

import com.spring.cs2340.shelterseek.R;
import com.spring.cs2340.shelterseek.model.Shelter;

public class ShelterDetail extends AppCompatActivity {
    private Shelter _shelterDisplayed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_detail);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);


        TextView id = (EditText) findViewById(R.id.ShelterId);
        TextView name = (EditText) findViewById(R.id.ShelterName);
        TextView address = (EditText) findViewById(R.id.ShelterAddress);
        TextView ll = (EditText) findViewById(R.id.ShelterLongLat);
        TextView restrictions = (EditText) findViewById(R.id.ShelterRestrictions);
        TextView notes = (EditText) findViewById(R.id.ShelterNotes);
        TextView capacity = (EditText) findViewById(R.id.ShelterCapacity);
        TextView contact_info = (EditText) findViewById(R.id.ShelterPhone);
    }
}


//        if (getIntent().hasExtra(SOMETHING) { // GET THE EXTRA THING PASSED IN
//             _shelterDisplayed = (Shelter) getIntent().getParcelableExtra(SAME SOMETHING); // THIS SHOULD CHANGE IT TO THE CORRECT SHELTER
//            id.setText(_shelterDisplayed.getUniqueKey());
//            name.setText(_shelterDisplayed.getName());
//            address.setText(_shelterDisplayed.getName());
//            String newString = "" + _shelterDisplayed.getLatitude() + ", " + _shelterDisplayed.
//                    getLongitude();
//            ll.setText(newString);
//            restrictions.setText(_shelterDisplayed.getRestrictions());
//            notes.setText(_shelterDisplayed.getSpecialNotes());
//            capacity.setText(_shelterDisplayed.getCapacity());
//            contact_info.setText(_shelterDisplayed.getContactInfo());
//    }

