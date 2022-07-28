package com.example.buylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.buylist.models.TypeItem;

import java.util.ArrayList;

public class AddItemActivity extends AppCompatActivity {

    private Spinner spinner;
    private ArrayList<String> another;

    private Utils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        utils = new Utils(this);
        another = new ArrayList<>();

        spinner = findViewById(R.id.spinnerTypesItem);

        if(utils.getTypeItems()!=null) {
            for (TypeItem a : utils.getTypeItems()) {
                another.add(a.getName());
            }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, another);

            spinner.setAdapter(arrayAdapter);
        }

        

    }
}