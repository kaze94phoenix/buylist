package com.example.buylist;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.buylist.models.TypeItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils {

    private Context context;
    private static final String ITEMS_TYPE = "items type";
    private SharedPreferences sharedPreference;
    private Gson gson;
    private ArrayList<TypeItem> typeItems;
    private SharedPreferences.Editor editor;


    public Utils(Context context) {
        sharedPreference = context.getSharedPreferences("shopping_db",Context.MODE_PRIVATE);
        editor = sharedPreference.edit();
        gson = new Gson();
        Type type = new TypeToken<ArrayList<TypeItem>>(){}.getType();
        typeItems = gson.fromJson(sharedPreference.getString(ITEMS_TYPE,null),type);
    }


    public ArrayList<TypeItem> getTypeItems(){
       return typeItems;
    }

    public void addTypeItems(TypeItem typeItem){
        typeItems.add(typeItem);
        editor.putString(ITEMS_TYPE,gson.toJson(typeItems));
        editor.commit();
    }

    public void deleteTypeItems(int index){
        typeItems.remove(index);
        editor.putString(ITEMS_TYPE,gson.toJson(typeItems));
        editor.commit();


    }


}
