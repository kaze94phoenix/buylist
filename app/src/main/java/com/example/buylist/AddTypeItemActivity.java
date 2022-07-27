package com.example.buylist;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.buylist.models.TypeItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class AddTypeItemActivity extends AppCompatActivity {

    public static final String TEST_CONSTANT = "test constant";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_type_item);








    }



    public void addData(View view){

         SharedPreferences sharedPreference = this.getSharedPreferences("shopping_db",MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreference.edit();
        Gson gson = new Gson();

        EditText nameTxt = findViewById(R.id.nameTypeTxt);
        EditText descTxt = findViewById(R.id.descTypeTxt);
        TextView testText = findViewById(R.id.testText);

        TypeItem typeItem = new TypeItem(nameTxt.getText().toString(),descTxt.getText().toString());
        editor.putString(TEST_CONSTANT,gson.toJson(typeItem));

        editor.commit();

        Type type = new TypeToken<TypeItem>(){}.getType();
        TypeItem another = gson.fromJson(sharedPreference.getString(TEST_CONSTANT,""),type);

        testText.setText(another.getName());

    }

}