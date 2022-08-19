package com.example.buylist.models;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.buylist.models.ItemType;
import com.example.buylist.models.Item;
import com.example.buylist.models.Location;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class DataManager {

    private Context context;

    private static final String ITEMS_TYPE = "items type";
    private static final String ITEMS = "items";
    private static final String LOCATIONS = "locations";
    private static final String ITEM_LOCATIONS = "item_locations";

    private SharedPreferences sharedPreference;
    private SharedPreferences.Editor editor;
    private Gson gson;


    private ArrayList<ItemType> itemTypes;
    private ArrayList<Item> items;
    private ArrayList<Location> locations;
    private ArrayList<ItemLocation> itemLocations;


    public DataManager(Context context) {
        sharedPreference = context.getSharedPreferences("shopping_db",Context.MODE_PRIVATE);
        editor = sharedPreference.edit();

        gson = new Gson();

        Type typeTypeItem = new TypeToken<ArrayList<ItemType>>(){}.getType();
        itemTypes = gson.fromJson(sharedPreference.getString(ITEMS_TYPE,null),typeTypeItem);
        if(itemTypes ==null)
            itemTypes = new ArrayList<ItemType>();

        Type typeItem = new TypeToken<ArrayList<Item>>(){}.getType();
        items = gson.fromJson(sharedPreference.getString(ITEMS,null),typeItem);
        if(items==null)
            items = new ArrayList<Item>();


        Type typeLocation = new TypeToken<ArrayList<Location>>(){}.getType();
        locations = gson.fromJson(sharedPreference.getString(LOCATIONS,null),typeLocation);
        if(locations==null)
            locations = new ArrayList<Location>();

        Type typeItemLocation = new TypeToken<ArrayList<ItemLocation>>(){}.getType();
        itemLocations = gson.fromJson(sharedPreference.getString(ITEM_LOCATIONS,null),typeItemLocation);
        if(itemLocations==null)
            itemLocations = new ArrayList<ItemLocation>();


    }

//Item Type
    public ArrayList<ItemType> getItemTypes(){
       return itemTypes;
    }



    public void addItemType(ItemType itemType){
        itemTypes.add(itemType);
        editor.putString(ITEMS_TYPE,gson.toJson(itemTypes));
        editor.commit();
    }

    public void deleteItemType(int index){
        itemTypes.remove(index);
        editor.putString(ITEMS_TYPE,gson.toJson(itemTypes));
        editor.commit();


    }


    //Item
    public void editItem(int position, Item item){
        items.set(position,item);
        editor.putString(ITEMS,gson.toJson(items));
        editor.commit();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItems(Item item){
        items.add(item);
        editor.putString(ITEMS,gson.toJson(items));
        editor.commit();
    }

    public void deleteItem(int position){
        items.remove(position);
        editor.putString(ITEMS,gson.toJson(items));
        editor.commit();
    }

    //Location
    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void addLocation(Location location){
        locations.add(location);
        editor.putString(LOCATIONS,gson.toJson(locations));
        editor.commit();
    }

    //Item Location
    public ArrayList<ItemLocation> getItemLocations() {
        return itemLocations;
    }

    public void addItemLocation(ItemLocation itemLocation){
        itemLocations.add(itemLocation);
        editor.putString(ITEM_LOCATIONS,gson.toJson(itemLocations));
        editor.commit();
    }

    public void editItemLocation(int position, ItemLocation itemLocation){
        itemLocations.set(position,itemLocation);
        editor.putString(ITEM_LOCATIONS,gson.toJson(itemLocations));
        editor.commit();
    }


}
