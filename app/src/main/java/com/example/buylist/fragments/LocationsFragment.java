package com.example.buylist.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.buylist.AddItemTypeActivity;
import com.example.buylist.R;
import com.example.buylist.adapters.ShoppingItemAdapter;
import com.example.buylist.adapters.ShoppingLocationAdapter;
import com.example.buylist.models.DataManager;
import com.example.buylist.models.Item;
import com.example.buylist.models.ItemType;
import com.example.buylist.models.Location;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LocationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LocationsFragment extends Fragment implements View.OnClickListener {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    DataManager dataManager;
    ShoppingLocationAdapter shoppingLocationAdapter;
    FloatingActionButton actionButton;
    Intent intent;


    public LocationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_locations, container, false);

        dataManager = new DataManager(getContext());
        shoppingLocationAdapter = new ShoppingLocationAdapter();

        shoppingLocationAdapter.setLocations(dataManager.getLocations());
        shoppingLocationAdapter.setActivity(getActivity());


        recyclerView = view.findViewById(R.id.locationsListView);

        recyclerView.setAdapter(shoppingLocationAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        swipeRefreshLayout = view.findViewById(R.id.swipeRefresh);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                shoppingLocationAdapter.setLocations(dataManager.getLocations());
                recyclerView.setAdapter(shoppingLocationAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        actionButton = view.findViewById(R.id.addLocationFloatBtn);
        actionButton.setOnClickListener(this);




        // Inflate the layout for this fragment
        return view;
    }

    public void onClick(View view) {
        goToAddLocation();
    }

    public void goToAddLocation(){

        dialogBuilder = new AlertDialog.Builder(getContext());
        final View addLocationPopoutView = getLayoutInflater().inflate(R.layout.add_location_popup,null);



        EditText nameTxt = addLocationPopoutView.findViewById(R.id.locationNameTxt);
        EditText descriptionTxt = addLocationPopoutView.findViewById(R.id.locationDescriptionTxt);
        EditText addressTxt = addLocationPopoutView.findViewById(R.id.locationAdressTxt);
        Button saveBtn = addLocationPopoutView.findViewById(R.id.saveLocation);
        Button cancelBtn = addLocationPopoutView.findViewById(R.id.cancelLocation);

        ///////////////////////

        dialogBuilder.setView(addLocationPopoutView);
        dialog = dialogBuilder.create();
        dialog.show();

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dataManager.addLocation(new Location(nameTxt.getText().toString(),descriptionTxt.getText().toString(), addressTxt.getText().toString()));
                Toast.makeText(getContext(), "Location Added", Toast.LENGTH_SHORT).show();
                shoppingLocationAdapter.notifyItemInserted(shoppingLocationAdapter.getItemCount()-1);
                dialog.dismiss();

            }
        });


        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });






    }
}