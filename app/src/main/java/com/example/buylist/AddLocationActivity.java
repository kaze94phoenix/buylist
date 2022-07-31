package com.example.buylist;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.buylist.models.Location;
import com.example.buylist.models.DataManager;

public class AddLocationActivity extends AppCompatActivity {
    private DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location);

        dataManager = new DataManager(this);

    }

    public void addLocation(View view){

        EditText nameTxt = findViewById(R.id.locationNameTxt);
        EditText descTxt = findViewById(R.id.locationDescriptionTxt);
        EditText addressTxt = findViewById(R.id.locationAdressTxt);

        dataManager.addLocation(new Location(nameTxt.getText().toString(),descTxt.getText().toString(),addressTxt.getText().toString()));


    }
}