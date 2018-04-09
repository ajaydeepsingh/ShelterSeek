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

/**
 * in-depth look at the shelter
 * @version 1.0
 */
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
        TextView longLat = findViewById(R.id.ShelterLongLat);
        TextView restrictions = findViewById(R.id.ShelterRestrictions);
        TextView notes = findViewById(R.id.ShelterNotes);
        TextView capacity = findViewById(R.id.ShelterCapacity);
        TextView contactInfo = findViewById(R.id.ShelterPhone);
        Button reserveButton = findViewById(R.id.ReserveButton);
        ArrayList<Shelter> shelters = MainScreen.getShelters();
        Shelter selectedShelter = shelters.get(position);
        id.setText("Shelter ID: " + selectedShelter.getUniqueKey());
        name.setText("Shelter Name: " + selectedShelter.getName());
        capacity.setText("Capacity: " + selectedShelter.getCapacity());
        restrictions.setText("Restrictions: " + selectedShelter.getRestrictions());
        address.setText("Address: " + selectedShelter.getAddress());
        longLat.setText("Latitude, Longitude: " + selectedShelter.getLatitude() + ", "
                + selectedShelter.getLongitude());
        notes.setText("Special Notes: " + selectedShelter.getSpecialNotes());
        contactInfo.setText("Contact Information: " + selectedShelter.getContactInfo());
        reserveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ReserveScreen.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }
}