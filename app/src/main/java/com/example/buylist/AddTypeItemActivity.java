package com.example.buylist;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.buylist.models.TypeItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class AddTypeItemActivity extends AppCompatActivity {

    private Spinner spinner;
    private ArrayList<String> another;

    private Utils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_type_item);

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



    public void addData(View view){

        another = new ArrayList<>();
        EditText nameTxt = findViewById(R.id.nameTypeTxt);
        EditText descTxt = findViewById(R.id.descTypeTxt);
        spinner = findViewById(R.id.spinnerTypesItem);

        ////////////////////

        TypeItem typeItem = new TypeItem(nameTxt.getText().toString(),descTxt.getText().toString());
        utils.addTypeItems(typeItem);

        /////////////////////////////////////

        for(TypeItem a: utils.getTypeItems()){
            another.add(a.getName());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,  another);

        spinner.setAdapter(arrayAdapter);

    }


    public void deleteData(View view){

        another = new ArrayList<>();
        spinner = findViewById(R.id.spinnerTypesItem);


        utils.deleteTypeItems(spinner.getSelectedItemPosition());

        for(TypeItem a: utils.getTypeItems()){
            another.add(a.getName());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,  another);

        spinner.setAdapter(arrayAdapter);



    }



}