package com.example.buylist.models;

public class Item {

    private String name,description;
    private TypeItem typeItem;

    public Item() {
    }

    public Item(String name, TypeItem typeItem) {
        this.name = name;
        this.typeItem = typeItem;
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Item(String name, String description, TypeItem typeItem) {
        this.name = name;
        this.description = description;
        this.typeItem = typeItem;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTypeItem(TypeItem typeItem) {
        this.typeItem = typeItem;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public TypeItem getTypeItem() {
        return typeItem;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", typeItem=" + typeItem.getName() +
                '}';
    }
}
