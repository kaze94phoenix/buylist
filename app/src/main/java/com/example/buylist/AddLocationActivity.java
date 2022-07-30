package com.example.buylist;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.buylist.models.Location;

public class AddLocationActivity extends AppCompatActivity {
    private Utils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location);

        utils = new Utils(this);

    }

    public void addLocation(View view){

        EditText nameTxt = findViewById(R.id.locationNameTxt);
        EditText descTxt = findViewById(R.id.locationDescriptionTxt);
        EditText addressTxt = findViewById(R.id.locationAdressTxt);

        utils.addLocation(new Location(nameTxt.getText().toString(),descTxt.getText().toString(),addressTxt.getText().toString()));


    }
}