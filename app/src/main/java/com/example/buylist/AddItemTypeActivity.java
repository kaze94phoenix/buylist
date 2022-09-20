package com.example.buylist;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.buylist.models.ItemType;
import com.example.buylist.models.DataManager;

import java.util.ArrayList;

public class AddItemTypeActivity extends AppCompatActivity {

    private Spinner spinner;
    private ArrayList<String> another;

    private DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_type_item);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dataManager = new DataManager(this);
        another = new ArrayList<>();

        spinner = findViewById(R.id.spinnerTypesItem);

        if(dataManager.getItemTypes()!=null) {
            for (ItemType a : dataManager.getItemTypes()) {
                another.add(a.getName());
            }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, another);

            spinner.setAdapter(arrayAdapter);
        }




    }

    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }



    public void addData(View view){

        another = new ArrayList<>();
        EditText nameTxt = findViewById(R.id.nameTypeTxt);
        EditText descTxt = findViewById(R.id.descTypeTxt);
        spinner = findViewById(R.id.spinnerTypesItem);

        ////////////////////

        ItemType itemType = new ItemType(nameTxt.getText().toString(),descTxt.getText().toString());
        dataManager.addItemType(itemType);

        /////////////////////////////////////

        for(ItemType a: dataManager.getItemTypes()){
            another.add(a.getName());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,  another);

        spinner.setAdapter(arrayAdapter);

    }


    public void deleteData(View view){

        another = new ArrayList<>();
        spinner = findViewById(R.id.spinnerTypesItem);


        dataManager.deleteItemType(spinner.getSelectedItemPosition());

        for(ItemType a: dataManager.getItemTypes()){
            another.add(a.getName());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,  another);

        spinner.setAdapter(arrayAdapter);



    }



}