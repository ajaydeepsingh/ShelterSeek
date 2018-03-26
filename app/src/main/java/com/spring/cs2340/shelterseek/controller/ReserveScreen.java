package com.spring.cs2340.shelterseek.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.spring.cs2340.shelterseek.R;
import com.spring.cs2340.shelterseek.model.Shelter;
import com.spring.cs2340.shelterseek.model.User;
import com.spring.cs2340.shelterseek.model.Model;


import org.w3c.dom.Text;

import java.util.ArrayList;

public class ReserveScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_screen);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);
        ArrayList<Shelter> shelters = MainScreen.getShelters();
        Shelter selectedShelter = shelters.get(position);
        final Model model = Model.getInstance();
        final User useraccount = (User) model.getCurrentUser();

        TextView capacity = findViewById(R.id.capacityToReserve);
        TextView vacancy = findViewById(R.id.vacancies);
        EditText numBeds = findViewById(R.id.ReserveBedNumber);
        Button reserve = findViewById(R.id.ActualReserveButton);
        TextView error = findViewById(R.id.ErrorTooMany);
        TextView alreadyReserved = findViewById(R.id.AlreadyReserved);
        Button cancelRes = findViewById(R.id.cancelRes);

        capacity.setText("Capacity: " + selectedShelter.getCapacity());
        vacancy.setText("Vacancies: " + selectedShelter.getVacancies());

        reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bedString = numBeds.getText().toString();
                int vac = Integer.parseInt(bedString);
                String vacString = selectedShelter.getVacancies();
                int compareVac = Integer.parseInt(vacString);
                if (vac > compareVac) {
                    error.setVisibility(view.VISIBLE);
                } else if (useraccount.getReservedBeds() > 0) {
                    alreadyReserved.setVisibility(view.VISIBLE);
                    // CHECK THE USER LOGGED IN
                    // IF HIS RESERVEDBEDS NUM IS >0, MAKE ALREADYRESERVED VISIBLE
                } else {
                    compareVac = compareVac - vac;
                    String currentVac = "" + compareVac;
                    selectedShelter.setVacancies(currentVac);
                    useraccount.setReservedBeds(vac);
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
                selectedShelter.setVacancies("" + newvac);
                useraccount.setReservedBeds(0);
                // ADD USER'S RESERVED BEDS TO THE VACANCIES
                // SET USER'S RESERVED BEDS TO 0
            }
        });
    }
}
