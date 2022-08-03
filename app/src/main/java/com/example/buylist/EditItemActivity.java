package com.example.buylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.buylist.models.Item;
import com.example.buylist.models.ItemType;
import com.example.buylist.models.DataManager;

import java.util.ArrayList;

public class EditItemActivity extends AppCompatActivity {

    private EditText txtName,txtDescription;
    private Spinner spinner;
    private ArrayList<String> another;
    private Intent intent;
    private int itemId;

    private DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        intent = getIntent();

        dataManager = new DataManager(this);

        another = new ArrayList<>();

        txtName = findViewById(R.id.itemNameTxt);
        txtDescription = findViewById(R.id.itemDescriptionTxt);

        spinner = findViewById(R.id.itemTypeSpinner);

        itemId = intent.getIntExtra(ItemsListActivity.EXTRA_ITEM_ID,0);

        txtName.setText(dataManager.getItems().get(itemId).getName());
        txtDescription.setText(dataManager.getItems().get(itemId).getDescription());





        if(dataManager.getItemTypes()!=null) {
            for (ItemType a : dataManager.getItemTypes()) {
                another.add(a.getName());
            }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, another);

            spinner.setAdapter(arrayAdapter);
        }



    }


    public void editItem(View view){

        EditText nameTxt = findViewById(R.id.itemNameTxt);
        EditText descriptionTxt = findViewById(R.id.itemDescriptionTxt);
        int itemPosition = spinner.getSelectedItemPosition();


        dataManager.addItems(new Item(nameTxt.getText().toString(),descriptionTxt.getText().toString(), dataManager.getItemTypes().get(itemPosition)));



    }

    public void goToAddItemType(View view){
        Intent intent = new Intent(this, AddItemTypeActivity.class);
        startActivity(intent);
    }

}