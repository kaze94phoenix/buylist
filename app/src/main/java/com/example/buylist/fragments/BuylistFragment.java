package com.example.buylist.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.buylist.AddBuyListActivity;
import com.example.buylist.MainActivity;
import com.example.buylist.R;
import com.example.buylist.adapters.AddBuyListAdapter;
import com.example.buylist.adapters.BuyListAdapter;
import com.example.buylist.models.BuyList;
import com.example.buylist.models.DataManager;
import com.example.buylist.models.Purchase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class BuylistFragment extends Fragment {

    private AlertDialog dialog;
    private AlertDialog.Builder dialogBuilder;
    private RecyclerView buylist;
    private DataManager dataManager;
    private BuyListAdapter buyListAdapter;
    private ArrayList<Purchase> purchases;
    FloatingActionButton addToBuyList,saveBuylist;
    Intent intent;

    public BuylistFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buylist, container, false);

        dataManager = new DataManager(getActivity());
        buyListAdapter = new BuyListAdapter();
        purchases = dataManager.getPurchases();

        buyListAdapter.setBuylist(purchases);
        buyListAdapter.setDataManager(dataManager);

        buylist = view.findViewById(R.id.buylist);

        buylist.setAdapter(buyListAdapter);
        buylist.setLayoutManager(new LinearLayoutManager(getContext()));

        addToBuyList = view.findViewById(R.id.addItemBtn);
        addToBuyList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBuyListItems();
            }
        });


        saveBuylist = view.findViewById(R.id.saveBuylistBtn);
        saveBuylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveBuyListItems();
            }
        });




        // Inflate the layout for this fragment
        return view;
    }

    public void addBuyListItems() {
        //Building the popup to add items to the buylist
        dialogBuilder = new AlertDialog.Builder(getContext());
        final View addItemView = getLayoutInflater().inflate(R.layout.add_item_buylist, null);

        Button add = addItemView.findViewById(R.id.addSelected);
        Button dismiss = addItemView.findViewById(R.id.cancelPopout);

        RecyclerView items = addItemView.findViewById(R.id.itemsRecyclerView);
        AddBuyListAdapter listAdapter = new AddBuyListAdapter();
        listAdapter.setItemLocations(dataManager.getItemLocations());
        items.setAdapter(listAdapter);
        items.setLayoutManager(new LinearLayoutManager(getContext()));

        dialogBuilder.setView(addItemView);
        dialog = dialogBuilder.create();

        dialog.show();

        //Adding elements selected to the buylist
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (purchases.isEmpty())
                    //If there are no items on the playlist the items checked on the extra list on the adapter are added to it
                    for (Purchase p : listAdapter.aux)
                        purchases.add(p);
                else {
                    //If there are some items on the playlist, the previous action will be performed, and also quantities will be updated if there are repeated ones
                    for (int i = 0; i < listAdapter.aux.size(); i++) {
                        boolean found = false;
                        for (int j = 0; j < purchases.size(); j++)
                            if (purchases.get(j).getItemLocation().compareTo(listAdapter.aux.get(i).getItemLocation()) > 0) {
                                //Every new added item is compared with the existent ones, if they exist it will update its quantities
                                purchases.get(j).setQuantity(purchases.get(j).getQuantity() + listAdapter.aux.get(i).getQuantity());
                                found = true;
                            }
                        if (!found)
                            //If there are no existent elements it will add a brand new one
                            purchases.add(listAdapter.aux.get(i));


                    }

                }
                dataManager.setPurchases(purchases);
                buyListAdapter.setBuylist(purchases);
                buylist.setAdapter(buyListAdapter);
                buylist.setLayoutManager(new LinearLayoutManager(getContext()));
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

    public void saveBuyListItems() {
        dataManager = new DataManager(getActivity());
        Date date = new Date(Calendar.YEAR, Calendar.MONTH, Calendar.DATE);
        dataManager.addBuyList(new BuyList("BuyList #" + dataManager.getBuyLists().size(), date, purchases));
            Toast.makeText(getContext(), "List Saved", Toast.LENGTH_SHORT).show();

    }


}