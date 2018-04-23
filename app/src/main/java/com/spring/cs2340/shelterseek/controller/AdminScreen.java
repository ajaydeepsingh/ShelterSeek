package com.spring.cs2340.shelterseek.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.spring.cs2340.shelterseek.R;
import com.spring.cs2340.shelterseek.model.Account;
import com.spring.cs2340.shelterseek.model.Model;
import com.spring.cs2340.shelterseek.model.Shelter;

import java.util.ArrayList;

public class AdminScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_screen);
        Button delete = (Button) findViewById(R.id.delete);
        ListView userList = findViewById(R.id.userList);
        EditText nameToDelete = findViewById(R.id.NameToDelete);
        ArrayAdapter<Account> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, Model.getInstance().getAccounts());
        userList.setAdapter(adapter);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = nameToDelete.getText().toString();
                ArrayList<Account> acc = Model.getInstance().getAccounts();
                for (int i = 0; i < acc.size(); i++) {
                    if (acc.get(i).getUserName().equals(str)) {
                        acc.remove(acc.get(i));
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });

    }
}
