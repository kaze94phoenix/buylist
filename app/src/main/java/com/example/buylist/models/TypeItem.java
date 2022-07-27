package com.example.buylist.models;

public class TypeItem {
    private String name, description;

    public TypeItem() {
    }

    public TypeItem(String name) {
        this.name = name;
    }

    public TypeItem(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TypeItem{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
