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
import com.example.buylist.models.ItemLocation;
import com.example.buylist.models.ItemType;
import com.example.buylist.models.DataManager;

import java.util.ArrayList;

public class EditItemActivity extends AppCompatActivity {

    private EditText txtName,txtDescription;
    private Spinner spinner;
    private ArrayList<String> another;
    private Intent intent;
    private int itemId;
    private Item item;

    private DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        intent = getIntent();

        dataManager = new DataManager(this);

        another = new ArrayList<>();

        txtName = findViewById(R.id.itemNameTxt);
        txtDescription = findViewById(R.id.itemDescriptionTxt);

        spinner = findViewById(R.id.itemTypeSpinner);

        itemId = intent.getIntExtra(ItemsListActivity.EXTRA_ITEM_ID,0);

        item = dataManager.getItems().get(itemId);

        txtName.setText(dataManager.getItems().get(itemId).getName());
        txtDescription.setText(dataManager.getItems().get(itemId).getDescription());





        if(dataManager.getItemTypes()!=null) {
            for (ItemType a : dataManager.getItemTypes()) {
                another.add(a.getName());
            }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, another);

            spinner.setAdapter(arrayAdapter);

            for(int i=0; i<dataManager.getItemTypes().size(); i++)
                if(item.getItemType().compareTo(dataManager.getItemTypes().get(i))>0)
                    spinner.setSelection(i);



        }



    }


    public void editItem(View view){

        EditText nameTxt = findViewById(R.id.itemNameTxt);
        EditText descriptionTxt = findViewById(R.id.itemDescriptionTxt);
        int itemPosition = spinner.getSelectedItemPosition();


        dataManager.editItem(itemId,new Item(nameTxt.getText().toString(),descriptionTxt.getText().toString(), dataManager.getItemTypes().get(itemPosition)));
        Toast.makeText(this, "Item Edited", Toast.LENGTH_SHORT).show();
        intent = new Intent(this, ItemsListActivity.class);

        startActivity(intent);


    }

}