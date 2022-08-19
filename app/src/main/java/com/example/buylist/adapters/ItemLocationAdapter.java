package com.example.buylist.adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buylist.ItemDetailsActivity;
import com.example.buylist.R;
import com.example.buylist.models.DataManager;
import com.example.buylist.models.Item;
import com.example.buylist.models.ItemLocation;
import com.example.buylist.models.Location;

import java.util.ArrayList;

public class ItemLocationAdapter extends RecyclerView.Adapter<ItemLocationAdapter.ViewHolder> {
    private ArrayList<ItemLocation> itemLocations;
    //ID of each item used to navigate to or manipulate each item
    public static final String EXTRA_ITEM_ID = "item_id";
    //Context of the RecyclerView activity
    private Activity activity;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    Intent intent;
    private DataManager dataManager;

    public ItemLocationAdapter() {
    }

    //Sets the list of items of the adapter
    public void setItemLocations(ArrayList<ItemLocation> itemLocations) {
        this.itemLocations = itemLocations;
        notifyDataSetChanged();
    }

    //Sets the context/Activity of the recyclerView
    public void setActivity(Activity activity){
        this.activity=activity;
    }






    @NonNull
    @Override
    public ItemLocationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //sets and inflates the view with the viewholder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_item_location,parent,false);
        ItemLocationAdapter.ViewHolder holder = new ItemLocationAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLocationAdapter.ViewHolder holder, int position) {
        //binds the attributes of the model to the viewHolder
        holder.priceLabel.setText(String.valueOf(itemLocations.get(position).getPrice()));
        holder.locationLabel.setText(itemLocations.get(position).getLocation().getName());
    }


    @Override
    public int getItemCount() {
        return itemLocations.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView priceLabel,locationLabel;
        private Button editItemLoc, deleteItemLoc;


        public ViewHolder(View itemView){
            super(itemView);
            priceLabel = itemView.findViewById(R.id.priceLocationLabel);
            locationLabel = itemView.findViewById(R.id.locationItemLabel);
            editItemLoc = itemView.findViewById(R.id.editItemLocBtn);
            deleteItemLoc = itemView.findViewById(R.id.deleteItemLocBtn);

            editItemLoc.setOnClickListener(this);
            deleteItemLoc.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            EditText priceTxt;
            Spinner locationSpinner;
            ArrayList<String> locationsNames = new ArrayList<>();
            dataManager = new DataManager(activity);
            switch (view.getId()){

                case R.id.editItemLocBtn:
                    dialogBuilder = new AlertDialog.Builder(activity);
                    final View editItemLocView = activity.getLayoutInflater().inflate(R.layout.add_item_location_popup,null);

                    priceTxt = editItemLocView.findViewById(R.id.itemPriceTxt);
                    priceTxt.setText(String.valueOf(itemLocations.get(getAdapterPosition()).getPrice()));
                    locationSpinner = editItemLocView.findViewById(R.id.locationSpinner);
                    if (dataManager.getLocations() != null) {
                        for (Location a : dataManager.getLocations()) {
                            locationsNames.add(a.getName());
                        }

                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(activity, android.R.layout.simple_spinner_dropdown_item, locationsNames);
                        locationSpinner.setAdapter(arrayAdapter);



                    }

                    dialogBuilder.setView(editItemLocView);
                    dialog = dialogBuilder.create();
                    dialog.show();

                    Toast.makeText(activity, "Edit Button", Toast.LENGTH_SHORT).show();
                    break;


                case R.id.deleteItemLocBtn:
                    Toast.makeText(activity, "Delete Button", Toast.LENGTH_SHORT).show();
                    break;

            }
        }
    }
}
