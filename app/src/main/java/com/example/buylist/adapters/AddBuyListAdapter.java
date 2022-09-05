package com.example.buylist.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buylist.R;
import com.example.buylist.models.Item;
import com.example.buylist.models.ItemLocation;

import java.util.ArrayList;

public class AddBuyListAdapter extends RecyclerView.Adapter<AddBuyListAdapter.ViewHolder>{

    ArrayList<ItemLocation> itemLocations;
    public ArrayList<ItemLocation> aux;

    public AddBuyListAdapter(){

    }

    public void setItemLocations(ArrayList<ItemLocation> itemLocations) {
        this.itemLocations = itemLocations;
        aux = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.buylist_item_location,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemName.setText(itemLocations.get(position).getItem().getName());
        holder.locationName.setText(itemLocations.get(position).getLocation().getName());
        holder.price.setText(String.valueOf(itemLocations.get(position).getPrice()));
        holder.isSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.isSelected.isChecked())
                    aux.add(itemLocations.get(holder.getAdapterPosition()));
                else
                    aux.remove(itemLocations.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemLocations.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView itemName, locationName, price;
        CheckBox isSelected;

        public ViewHolder(View itemView){
            super(itemView);

            itemName = itemView.findViewById(R.id.itemBuylist);
            locationName = itemView.findViewById(R.id.locationBuylist);
            price = itemView.findViewById(R.id.priceBuylist);
            isSelected = itemView.findViewById(R.id.checkBoxBuylist);

        }
    }

}
