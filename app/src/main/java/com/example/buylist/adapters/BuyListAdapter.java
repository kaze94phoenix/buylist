package com.example.buylist.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buylist.R;
import com.example.buylist.models.Purchase;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class BuyListAdapter extends RecyclerView.Adapter<BuyListAdapter.ViewHolder> {

    ArrayList<Purchase> buylist;

    public BuyListAdapter(){

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.buylist_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return buylist.size();
    }


    public void setBuylist(ArrayList<Purchase> buylist) {
        this.buylist = buylist;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
