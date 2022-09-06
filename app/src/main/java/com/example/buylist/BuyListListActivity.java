package com.example.buylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.buylist.adapters.BuyListListAdapter;
import com.example.buylist.models.DataManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BuyListListActivity extends AppCompatActivity {

    RecyclerView buylistList;
    //FloatingActionButton addBuylist;
    DataManager dataManager;
    BuyListListAdapter buyListListAdapter;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_list_list);

        dataManager = new DataManager(this);
        buyListListAdapter = new BuyListListAdapter();

        buylistList = findViewById(R.id.buyListListRV);
        //addBuylist = findViewById(R.id.addBuylistBtn);

        buyListListAdapter.setBuyLists(dataManager.getBuyLists());

        buylistList.setAdapter(buyListListAdapter);
        buylistList.setLayoutManager(new LinearLayoutManager(BuyListListActivity.this));

    }



    public void goToAddBuyList(View view){
        intent = new Intent(BuyListListActivity.this,AddBuyListActivity.class);
        startActivity(intent);
    }
}