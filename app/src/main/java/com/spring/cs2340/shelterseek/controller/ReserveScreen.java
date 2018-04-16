package com.spring.cs2340.shelterseek.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.spring.cs2340.shelterseek.R;
import com.spring.cs2340.shelterseek.model.Shelter;
import com.spring.cs2340.shelterseek.model.User;
import com.spring.cs2340.shelterseek.model.Model;


import java.util.ArrayList;

/**
 * screen to reserve beds
 * @version 1.0
 */
public class ReserveScreen extends AppCompatActivity {
    private DatabaseReference mdatabase2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_screen);
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);
        ArrayList<Shelter> shelters = MainScreen.getShelters();
        Shelter selectedShelter = shelters.get(position);
        TextView mCapacity = findViewById(R.id.capacityToReserve);
        TextView mVacancy = findViewById(R.id.vacancies);
        DatabaseReference mdatabase = FirebaseDatabase.getInstance().getReference()
                .child("shelters").child(selectedShelter.getUniqueKey()
        ).child("Capacity");
        mdatabase2 = FirebaseDatabase.getInstance().getReference().child("shelters")
                .child(selectedShelter.getUniqueKey()
        ).child("Vacancy");
        mdatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() != null) {
                    String capacity = dataSnapshot.getValue().toString();
                    mCapacity.setText("Capacity: " + capacity);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        })   ;
        mdatabase2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() != null) {
                    String vacancy = dataSnapshot.getValue().toString();
                    mVacancy.setText("Vacancy: " + vacancy);
                    selectedShelter.setVacancies(vacancy);
                }
            }

            @Override

            
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        final Model model = Model.getInstance();
        final User useraccount = (User) model.getCurrentUser();
        EditText numBeds = findViewById(R.id.ReserveBedNumber);
        Button reserve = findViewById(R.id.ActualReserveButton);
        TextView error = findViewById(R.id.ErrorTooMany);
        TextView alreadyReserved = findViewById(R.id.AlreadyReserved);
        Button cancelRes = findViewById(R.id.cancelRes);

        reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //how to get the data?
                String bedString = numBeds.getText().toString();
                int bedNum = Integer.parseInt(bedString);
                String vac = selectedShelter.getVacancies();
                int vac1 = Integer.parseInt(vac);
                if (((vac1 > bedNum) || (vac1 == bedNum)) && (useraccount.getReservedBeds() == 0)) {
                    int result = vac1 - bedNum;
                    vac = Integer.toString(result);
                    }
                mdatabase2.setValue(vac);
                String vacString = selectedShelter.getVacancies();
                int compareVac = Integer.parseInt(vacString);
                if (bedNum > compareVac) {
                    error.setVisibility(View.VISIBLE);
                } else if (useraccount.getReservedBeds() > 0) {
                    alreadyReserved.setVisibility(View.VISIBLE);
                    // CHECK THE USER LOGGED IN
                    // IF HIS RESERVEDBEDS NUM IS >0, MAKE ALREADYRESERVED VISIBLE
                } else {
                    compareVac = compareVac - bedNum;
                    String currentVac = "" + compareVac;
                    selectedShelter.setVacancies(currentVac);
                    useraccount.setReservedBeds(bedNum);
                    // FIND A WAY TO GET THE USER THAT IS LOGGED IN,
                    // SET THE RESERVEDBEDS INT TO VAC
                }
            }
        });

        cancelRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int newvac = useraccount.getReservedBeds();
                int oldvac = Integer.parseInt(selectedShelter.getVacancies());
                newvac += oldvac;
                String newvac1 = Integer.toString(newvac);
                mdatabase2.setValue(newvac1);
                selectedShelter.setVacancies("" + newvac);
                useraccount.setReservedBeds(0);
                // ADD USER'S RESERVED BEDS TO THE VACANCIES
                // SET USER'S RESERVED BEDS TO 0
            }
        });
    }
}
