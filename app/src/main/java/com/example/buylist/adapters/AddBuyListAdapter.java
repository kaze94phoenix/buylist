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
import com.example.buylist.models.Purchase;

import java.util.ArrayList;

public class AddBuyListAdapter extends RecyclerView.Adapter<AddBuyListAdapter.ViewHolder>{

    ArrayList<ItemLocation> itemLocations;
    public ArrayList<Purchase> aux;

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
        holder.quantity.setText("1");
        holder.isSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.isSelected.isChecked())
                    aux.add(new Purchase(itemLocations.get(holder.getAdapterPosition()),Integer.parseInt(holder.quantity.getText().toString())));
                else
                    for(Purchase p: aux)
                        if(p.getItemLocation().compareTo(itemLocations.get(holder.getAdapterPosition()))>0)
                            aux.remove(p);

            }
        });

    }

    @Override
    public int getItemCount() {
        return itemLocations.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView itemName, locationName, price, quantity;
        CheckBox isSelected;

        public ViewHolder(View itemView){
            super(itemView);

            itemName = itemView.findViewById(R.id.itemBuylist);
            locationName = itemView.findViewById(R.id.locationBuylist);
            price = itemView.findViewById(R.id.priceBuylist);
            quantity = itemView.findViewById(R.id.qttyAddBuylistText);
            isSelected = itemView.findViewById(R.id.checkBoxBuylist);

        }
    }

}
