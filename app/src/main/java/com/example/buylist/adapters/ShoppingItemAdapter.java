package com.example.buylist.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    //ID of each item used to navigate to or manipulate each item
    private static final String EXTRA_ITEM_ID = "item_id";
    //Context of the RecyclerView activity
    private Context context;

    public ShoppingItemAdapter() {
    }

    //Sets the list of items of the adapter
    public void setItems(ArrayList<Item> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    //Sets the context/Activity of the recyclerView
    public void setContext(Context context){
        this.context=context;
    }






    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //sets and inflates the view with the viewholder
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

    //Inner Class ViewHolder that takes the View Items to be used on the adapter
    //implements on click listener
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtItemName, txtItemAvgPrice, txtItemId;
        private Button editBtn;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtItemName=itemView.findViewById(R.id.itemName);
            txtItemAvgPrice=itemView.findViewById(R.id.itemAvgPrice);
            txtItemId = itemView.findViewById(R.id.itemId);
            editBtn = itemView.findViewById(R.id.btnEditItem);

            //gets the button to use the onclicklistener
            editBtn.setOnClickListener(this);


        }


        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context,EditItemActivity.class);
            intent.putExtra(EXTRA_ITEM_ID,getAdapterPosition());
            context.startActivity(intent);
        }
    }


}
