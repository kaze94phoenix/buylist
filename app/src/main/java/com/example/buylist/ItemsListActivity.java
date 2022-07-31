package com.example.buylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.buylist.adapters.ShoppingItemAdapter;
import com.example.buylist.models.DataManager;

public class ItemsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_list);

        DataManager dataManager = new DataManager(this);
        ShoppingItemAdapter shoppingItemAdapter = new ShoppingItemAdapter();

        shoppingItemAdapter.setItems(dataManager.getItems());

        RecyclerView recyclerView = findViewById(R.id.itemsListView);


        recyclerView.setAdapter(shoppingItemAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }
}