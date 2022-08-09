package com.example.buylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buylist.adapters.ShoppingItemAdapter;
import com.example.buylist.models.DataManager;

public class ItemsListActivity extends AppCompatActivity {
    public static final String EXTRA_ITEM_ID = "item_id";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_list);

        DataManager dataManager = new DataManager(this);
        ShoppingItemAdapter shoppingItemAdapter = new ShoppingItemAdapter();

        shoppingItemAdapter.setItems(dataManager.getItems());
        shoppingItemAdapter.setContext(this);


        recyclerView = findViewById(R.id.itemsListView);

        recyclerView.setAdapter(shoppingItemAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }

    public void goToEditItem(View view){

    }


    public void goToAddItems(View view){
        Intent intent = new Intent(this,AddItemActivity.class);
        startActivity(intent);
    }


}