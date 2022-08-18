package com.example.buylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.buylist.models.Location;
import com.example.buylist.models.DataManager;

public class AddLocationActivity extends AppCompatActivity {
    private DataManager dataManager;
    private  Intent intent;
    private int itemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location);

        dataManager = new DataManager(this);
        intent = getIntent();
        itemId = intent.getIntExtra(ItemDetailsActivity.EXTRA_ITEM_ID,0);

    }

    public void addLocation(View view){

        EditText nameTxt = findViewById(R.id.locationNameTxt);
        EditText descTxt = findViewById(R.id.locationDescriptionTxt);
        EditText addressTxt = findViewById(R.id.locationAdressTxt);

        dataManager.addLocation(new Location(nameTxt.getText().toString(),descTxt.getText().toString(),addressTxt.getText().toString()));
        Toast.makeText(AddLocationActivity.this, "Location Added", Toast.LENGTH_SHORT).show();
        intent = new Intent(AddLocationActivity.this,ItemDetailsActivity.class);
        intent.putExtra(ItemDetailsActivity.EXTRA_ITEM_ID,itemId);
        startActivity(intent);

    }


    public void cancelLocation(View view){
        intent = new Intent(AddLocationActivity.this,ItemDetailsActivity.class);
        intent.putExtra(ItemDetailsActivity.EXTRA_ITEM_ID,itemId);
        startActivity(intent);
    }
}