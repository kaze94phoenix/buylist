package com.example.buylist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.OnSwipe;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buylist.adapters.ShoppingItemAdapter;
import com.example.buylist.models.DataManager;
import com.example.buylist.models.Item;
import com.example.buylist.models.ItemType;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ItemsListActivity extends AppCompatActivity {
    public static final String EXTRA_ITEM_ID = "item_id";
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    DataManager dataManager;
    ShoppingItemAdapter shoppingItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_list);

        dataManager = new DataManager(this);
        shoppingItemAdapter = new ShoppingItemAdapter();

        shoppingItemAdapter.setItems(dataManager.getItems());
        shoppingItemAdapter.setActivity(this);


        recyclerView = findViewById(R.id.itemsListView);

        recyclerView.setAdapter(shoppingItemAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        swipeRefreshLayout = findViewById(R.id.swipeRefresh);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                shoppingItemAdapter.setItems(dataManager.getItems());
                recyclerView.setAdapter(shoppingItemAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(ItemsListActivity.this));
                swipeRefreshLayout.setRefreshing(false);
            }
        });


    }


    public void goToAddItems(View view){

        dialogBuilder = new AlertDialog.Builder(this);
        final View addItemPopoutView = getLayoutInflater().inflate(R.layout.add_item_popup,null);

        Spinner spinner = addItemPopoutView.findViewById(R.id.itemTypeSpinner);
        ArrayList<String> another = new ArrayList<String>();
        if(dataManager.getItemTypes()!=null)
            for (ItemType a : dataManager.getItemTypes())
                another.add(a.getName());
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, another);

        spinner.setAdapter(arrayAdapter);


        EditText nameTxt = addItemPopoutView.findViewById(R.id.itemNameTxt);
        EditText descriptionTxt = addItemPopoutView.findViewById(R.id.itemDescriptionTxt);
        Button saveBtn = addItemPopoutView.findViewById(R.id.btnSaveItem);
        Button cancelBtn = addItemPopoutView.findViewById(R.id.btnCancelItem);
        int itemPosition = spinner.getSelectedItemPosition();

        ///////////////////////

        dialogBuilder.setView(addItemPopoutView);
        dialog = dialogBuilder.create();
        dialog.show();

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dataManager.addItems(new Item(nameTxt.getText().toString(),descriptionTxt.getText().toString(), dataManager.getItemTypes().get(itemPosition)));
                Toast.makeText(ItemsListActivity.this, "Item Added", Toast.LENGTH_SHORT).show();
                shoppingItemAdapter.notifyItemInserted(dataManager.getItems().size()-1);
                dialog.dismiss();

            }
        });


        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });




        //Intent intent = new Intent(this,AddItemActivity.class);
        //startActivity(intent);
    }


}