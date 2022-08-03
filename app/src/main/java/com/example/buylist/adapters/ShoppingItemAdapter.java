package com.example.buylist.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buylist.EditItemActivity;
import com.example.buylist.ItemsListActivity;
import com.example.buylist.R;
import com.example.buylist.models.Item;

import java.util.ArrayList;

public class ShoppingItemAdapter extends RecyclerView.Adapter<ShoppingItemAdapter.ViewHolder> {
    private ArrayList<Item> items;

    public ShoppingItemAdapter() {
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
        notifyDataSetChanged();
    }





    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //sets the view used on viewholder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_shopping_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //binds the attributes of the model to the viewHolder
        holder.txtItemName.setText(items.get(position).getName());
        holder.txtItemId.setText(String.valueOf(position));
    }


    @Override
    public int getItemCount() {
        return items.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtItemName, txtItemAvgPrice, txtItemId;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtItemName=itemView.findViewById(R.id.itemName);
            txtItemAvgPrice=itemView.findViewById(R.id.itemAvgPrice);
            txtItemId = itemView.findViewById(R.id.itemId);
        }



    }
}
