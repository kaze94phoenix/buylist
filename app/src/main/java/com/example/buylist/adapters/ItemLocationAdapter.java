package com.example.buylist.adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buylist.R;
import com.example.buylist.models.Item;
import com.example.buylist.models.ItemLocation;

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

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView priceLabel,locationLabel;


        public ViewHolder(View itemView){
            super(itemView);
            priceLabel = itemView.findViewById(R.id.priceLocationLabel);
            locationLabel = itemView.findViewById(R.id.locationItemLabel);
        }
    }
}
