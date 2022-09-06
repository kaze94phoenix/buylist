package com.example.buylist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.buylist.adapters.AddBuyListAdapter;
import com.example.buylist.adapters.BuyListAdapter;
import com.example.buylist.models.DataManager;
import com.example.buylist.models.Purchase;

import java.util.ArrayList;

public class AddBuyListActivity extends AppCompatActivity {

    private AlertDialog dialog;
    private AlertDialog.Builder dialogBuilder;
    private RecyclerView buylist;
    private DataManager dataManager;
    private BuyListAdapter buyListAdapter;
    private ArrayList<Purchase> purchases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_buy_list);
        dataManager = new DataManager(this);
        buyListAdapter = new BuyListAdapter();


        purchases = new ArrayList<>();

        buylist = findViewById(R.id.buylist);
        buyListAdapter.setBuylist(purchases);
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
               // test = new ArrayList<>();

                if(purchases.isEmpty())
                    for(Purchase p: listAdapter.aux)
                        purchases.add(p);

                    else {

                    for (int i = 0; i < listAdapter.aux.size(); i++) {
                        boolean found = false;
                        for (int j = 0; j < purchases.size(); j++)
                            if (purchases.get(j).getItemLocation().compareTo(listAdapter.aux.get(i).getItemLocation()) > 0) {
                                purchases.get(j).setQuantity(purchases.get(j).getQuantity() + listAdapter.aux.get(i).getQuantity());
                                found=true;
                            }

                        if(!found)
                            purchases.add(listAdapter.aux.get(i));


                    }

                }

                buyListAdapter.setBuylist(purchases);
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