package com.example.buylist.fragments;

import android.content.Intent;
import android.os.Bundle;

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
import com.example.buylist.adapters.BuyListListAdapter;
import com.example.buylist.models.DataManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BuylistFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BuylistFragment extends Fragment {

    RecyclerView buylistList;
    //FloatingActionButton addBuylist;
    DataManager dataManager;
    BuyListListAdapter buyListListAdapter;
    Intent intent;
    FloatingActionButton addBuyListBtn;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BuylistFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BuylistFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BuylistFragment newInstance(String param1, String param2) {
        BuylistFragment fragment = new BuylistFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buylist, container, false);
        dataManager = new DataManager(getActivity());
        buyListListAdapter = new BuyListListAdapter();

        buylistList = view.findViewById(R.id.buyListListTest);
        //addBuylist = findViewById(R.id.addBuylistBtn);

        buyListListAdapter.setActivity(getActivity());
        buyListListAdapter.setBuyLists(dataManager.getBuyLists());

        buylistList.setAdapter(buyListListAdapter);
        buylistList.setLayoutManager(new LinearLayoutManager(getActivity()));

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
        getActivity().finish();
        startActivity(intent);
    }
}