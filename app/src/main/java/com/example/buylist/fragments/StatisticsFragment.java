package com.example.buylist.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.buylist.AddBuyListActivity;
import com.example.buylist.R;
import com.example.buylist.adapters.BuyListListAdapter;
import com.example.buylist.models.DataManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StatisticsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StatisticsFragment extends Fragment {

    RecyclerView buylistList;
    public DataManager dataManager;
    private SwipeRefreshLayout swipeRefreshLayout;
    BuyListListAdapter buyListListAdapter;
    Intent intent;
    FloatingActionButton addBuyListBtn;


    public StatisticsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);
        dataManager = new DataManager(getActivity());
        buyListListAdapter = new BuyListListAdapter();

        buylistList = view.findViewById(R.id.buyListListTest);

        buyListListAdapter.setActivity(getActivity());
        buyListListAdapter.setBuyLists(dataManager.getBuyLists());

        buylistList.setAdapter(buyListListAdapter);
        buylistList.setLayoutManager(new LinearLayoutManager(getActivity()));


        swipeRefreshLayout = view.findViewById(R.id.swipeRefresh);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                dataManager = new DataManager(getContext());
                buyListListAdapter.setBuyLists(dataManager.getBuyLists());
                buylistList.setAdapter(buyListListAdapter);
                buylistList.setLayoutManager(new LinearLayoutManager(getContext()));
                swipeRefreshLayout.setRefreshing(false);
            }
        });


        addBuyListBtn = view.findViewById(R.id.addBuylistBtn);

        addBuyListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAddBuyList();
            }
        });

        return view;


    }

    public void goToAddBuyList(){
        intent = new Intent(getActivity(), AddBuyListActivity.class);
        startActivity(intent);
    }
}