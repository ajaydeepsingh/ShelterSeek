package com.spring.cs2340.shelterseek.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.spring.cs2340.shelterseek.R;
import com.spring.cs2340.shelterseek.model.Shelter;

import java.util.ArrayList;

public class ShelterDetail extends AppCompatActivity {
//    private Shelter _shelterDisplayed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_detail);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);


        TextView id = findViewById(R.id.ShelterId);
        TextView name = findViewById(R.id.ShelterName);
        TextView address = findViewById(R.id.ShelterAddress);
        TextView ll = findViewById(R.id.ShelterLongLat);
        TextView restrictions = findViewById(R.id.ShelterRestrictions);
        TextView notes = findViewById(R.id.ShelterNotes);
        TextView capacity = findViewById(R.id.ShelterCapacity);
        TextView contact_info = findViewById(R.id.ShelterPhone);
        Button resButton = findViewById(R.id.ReserveButton);
        ArrayList<Shelter> shelters = MainScreen.getShelters();
        Shelter selectedShelter = shelters.get(position);
        id.setText("Shelter ID: " + selectedShelter.getUniqueKey());
        name.setText("Shelter Name: " + selectedShelter.getName());
        capacity.setText("Capacity: " + selectedShelter.getCapacity());
        restrictions.setText("Restrictions: " + selectedShelter.getRestrictions());
        address.setText("Address: " + selectedShelter.getAddress());
        ll.setText("Latitude, Longitude: " + selectedShelter.getLatitude() + ", "
                + selectedShelter.getLongitude());
        notes.setText("Special Notes: " + selectedShelter.getSpecialNotes());
        contact_info.setText("Contact Information: " + selectedShelter.getContactInfo());
        System.out.println("Set all text fields");
        resButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ReserveScreen.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }
}

//
////        if (getIntent().hasExtra(SOMETHING) { // GET THE EXTRA THING PASSED IN
////             _shelterDisplayed = (Shelter) getIntent().getParcelableExtra(SAME SOMETHING); // THIS SHOULD CHANGE IT TO THE CORRECT SHELTER
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
////    }
//
