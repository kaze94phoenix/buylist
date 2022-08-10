package com.example.buylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.buylist.models.Item;
import com.example.buylist.models.ItemType;
import com.example.buylist.models.DataManager;

import java.util.ArrayList;

public class AddItemActivity extends AppCompatActivity {

    private Spinner spinner;
    private ArrayList<String> another;
    private Intent intent;
    private DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        dataManager = new DataManager(this);
        another = new ArrayList<>();

        spinner = findViewById(R.id.itemTypeSpinner);

        if(dataManager.getItemTypes()!=null) {
            for (ItemType a : dataManager.getItemTypes()) {
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


        dataManager.addItems(new Item(nameTxt.getText().toString(),descriptionTxt.getText().toString(), dataManager.getItemTypes().get(itemPosition)));
        Toast.makeText(this, "Item Added", Toast.LENGTH_SHORT).show();
        intent = new Intent(this, ItemsListActivity.class);
        startActivity(intent);


    }

    public void goToAddItemType(View view){
        intent = new Intent(this, AddItemTypeActivity.class);
        startActivity(intent);
    }

}