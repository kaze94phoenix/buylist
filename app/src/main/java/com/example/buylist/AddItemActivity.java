package com.example.buylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.buylist.models.Item;
import com.example.buylist.models.ItemType;

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

        spinner = findViewById(R.id.itemTypeSpinner);

        if(utils.getItemTypes()!=null) {
            for (ItemType a : utils.getItemTypes()) {
                another.add(a.getName());
            }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, another);

            spinner.setAdapter(arrayAdapter);
        }

        

    }


    public void addItem(View view){

        EditText nameTxt = findViewById(R.id.itemNameTxt);
        EditText descriptionTxt = findViewById(R.id.itemDescriptionTxt);
        int itemPosition = spinner.getSelectedItemPosition();


        utils.addItems(new Item(nameTxt.getText().toString(),descriptionTxt.getText().toString(),utils.getItemTypes().get(itemPosition)));



    }

}