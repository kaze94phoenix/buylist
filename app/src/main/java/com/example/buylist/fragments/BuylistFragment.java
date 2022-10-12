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
import android.widget.TextView;

import com.example.buylist.AddBuyListActivity;
import com.example.buylist.BuyListListActivity;
import com.example.buylist.R;
import com.example.buylist.adapters.BuyListAdapter;
import com.example.buylist.adapters.BuyListListAdapter;
import com.example.buylist.models.DataManager;
import com.example.buylist.models.Purchase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

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



        purchases = dataManager.getBuyLists().get(0).getPurchases();

        buyListAdapter.setBuylist(purchases);

        buylist = view.findViewById(R.id.buylist);

        buylist.setAdapter(buyListAdapter);
        buylist.setLayoutManager(new LinearLayoutManager(getContext()));

        // Inflate the layout for this fragment
        return view;
    }


}