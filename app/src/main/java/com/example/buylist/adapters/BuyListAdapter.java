package com.example.buylist.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buylist.R;
import com.example.buylist.models.Purchase;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class BuyListAdapter extends RecyclerView.Adapter<BuyListAdapter.ViewHolder> {

    ArrayList<Purchase> buylist;

    public BuyListAdapter(){
        buylist = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.buylist_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.item.setText(buylist.get(position).getItemLocation().getItem().getName());
        holder.location.setText(buylist.get(position).getItemLocation().getLocation().getName());
        holder.price.setText(String.valueOf(buylist.get(position).getItemLocation().getPrice()));
        holder.quantity.setText(buylist.get(position).getQuantity()+" Unit(s)");
    }

    @Override
    public int getItemCount() {
        return buylist.size();
    }


    public void setBuylist(ArrayList<Purchase> buylist) {
        this.buylist = buylist;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView item, location, price,quantity;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.itemBuylistName);
            location = itemView.findViewById(R.id.locationBuylistName);
            price = itemView.findViewById(R.id.priceBuylistName);
            quantity = itemView.findViewById(R.id.qttyBuylistName);
        }
    }

}
