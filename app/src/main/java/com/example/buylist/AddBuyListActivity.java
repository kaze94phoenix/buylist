package com.example.buylist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.example.buylist.adapters.AddBuyListAdapter;
import com.example.buylist.models.DataManager;
import com.example.buylist.models.ItemLocation;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AddBuyListActivity extends AppCompatActivity {

    private AlertDialog dialog;
    private AlertDialog.Builder dialogBuilder;
    private RecyclerView buylist;
    private DataManager dataManager;
    private AddBuyListAdapter buyListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_buy_list);
        dataManager = new DataManager(this);
        buyListAdapter = new AddBuyListAdapter();


        ArrayList<ItemLocation> test = new ArrayList<ItemLocation>();

        buylist = findViewById(R.id.buylist);
        buyListAdapter.setItemLocations(test);
        buylist.setAdapter(buyListAdapter);
        buylist.setLayoutManager(new LinearLayoutManager(AddBuyListActivity.this));

    }



    public void addItem(View view){

        dialogBuilder = new AlertDialog.Builder(this);
        final View addItemView = getLayoutInflater().inflate(R.layout.add_item_buylist,null);

        Button add = addItemView.findViewById(R.id.addSelected);
        Button dismiss = addItemView.findViewById(R.id.cancelPopout);

        RecyclerView items = addItemView.findViewById(R.id.itemsRecyclerView);
        AddBuyListAdapter listAdapter = new AddBuyListAdapter();
        listAdapter.setItemLocations(dataManager.getItemLocations());
        items.setAdapter(listAdapter);
        items.setLayoutManager(new LinearLayoutManager(AddBuyListActivity.this));

        dialogBuilder.setView(addItemView);
        dialog = dialogBuilder.create();

        dialog.show();


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buyListAdapter.setItemLocations(listAdapter.aux);
                buylist.setAdapter(buyListAdapter);
                buylist.setLayoutManager(new LinearLayoutManager(AddBuyListActivity.this));
                dialog.dismiss();
            }
        });


        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


    }


}