package com.example.buylist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.buylist.adapters.ShoppingItemAdapter;
import com.example.buylist.models.DataManager;
import com.example.buylist.models.Item;

import java.util.ArrayList;

public class ItemDetailsActivity extends AppCompatActivity {
    private TextView itemName,itemDescription, itemPrice, itemType;
    private DataManager dataManager;
    private ArrayList<Item> items;
    private Intent intent;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        intent = getIntent();
        int itemId = intent.getIntExtra(ShoppingItemAdapter.EXTRA_ITEM_ID,0);

        itemName = findViewById(R.id.itemDName);
        itemDescription = findViewById(R.id.itemDDescription);
        itemPrice = findViewById(R.id.itemDPrice);
        itemType = findViewById(R.id.itemDType);

        dataManager = new DataManager(this);
        items = dataManager.getItems();


        itemName.setText(items.get(itemId).getName());
        itemDescription.setText(items.get(itemId).getDescription());
        itemType.setText(items.get(itemId).getItemType().getName());



    }

    public void addItemLocation(View view){

    }
}