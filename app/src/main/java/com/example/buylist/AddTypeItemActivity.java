package com.example.buylist;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.buylist.models.TypeItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class AddTypeItemActivity extends AppCompatActivity {

    private static final String TEST_CONSTANT = "test constant";
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_type_item);

        SharedPreferences sharedPreference = this.getSharedPreferences("shopping_db",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreference.edit();
        Gson gson = new Gson();

        spinner = findViewById(R.id.spinnerTypesItem);



        Type type = new TypeToken<ArrayList<TypeItem>>(){}.getType();
        ArrayList<TypeItem> typeItems = gson.fromJson(sharedPreference.getString(TEST_CONSTANT,null),type);

        if(typeItems!=null) {
            ArrayList<String> another = new ArrayList<>();

            for (TypeItem a : typeItems) {
                another.add(a.getName());
            }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, another);

            spinner.setAdapter(arrayAdapter);
        }




    }



    public void addData(View view){
        ArrayList<TypeItem> typeItems = new ArrayList<TypeItem>();
        ArrayList<String> another = new ArrayList<>();
        SharedPreferences sharedPreference = this.getSharedPreferences("shopping_db",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreference.edit();
        Gson gson = new Gson();



        ///////

        EditText nameTxt = findViewById(R.id.nameTypeTxt);
        EditText descTxt = findViewById(R.id.descTypeTxt);
        TextView testText = findViewById(R.id.testText);
        spinner = findViewById(R.id.spinnerTypesItem);

        Type type = new TypeToken<ArrayList<TypeItem>>(){}.getType();
        typeItems = gson.fromJson(sharedPreference.getString(TEST_CONSTANT,null),type);

        ////////////////////

        TypeItem typeItem = new TypeItem(nameTxt.getText().toString(),descTxt.getText().toString());
        typeItems.add(typeItem);

        editor.putString(TEST_CONSTANT,gson.toJson(typeItems));

        editor.commit();


        /////////////////////////////////////

        for(TypeItem a: typeItems){
            another.add(a.getName());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,  another);

        spinner.setAdapter(arrayAdapter);

    }

}