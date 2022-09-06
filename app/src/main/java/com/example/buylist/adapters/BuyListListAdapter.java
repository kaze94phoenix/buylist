package com.example.buylist.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buylist.R;
import com.example.buylist.models.BuyList;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class BuyListListAdapter extends RecyclerView.Adapter<BuyListListAdapter.ViewHolder> {

    ArrayList<BuyList> buyLists;

    public BuyListListAdapter(){

    }

    public void setBuyLists(ArrayList<BuyList> buyLists) {
        this.buyLists = buyLists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.buylist,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(buyLists.get(position).getName());
        holder.date.setText(String.valueOf(buyLists.get(position).getDate()));

    }

    @Override
    public int getItemCount() {
        return buyLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name, date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.buyListName);
            date = itemView.findViewById(R.id.buyListDate);
        }
    }

}
