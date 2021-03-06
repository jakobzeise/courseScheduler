package com.jakobzeise.coursescheduler.modell.dataclasses;

import androidx.annotation.NonNull;

public class Type {

    int icon;
    String name;
    int numberOfItems;

    public Type(int icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return "Type{" +
                "icon=" + icon +
                ", name='" + name + '\'' +
                ", numberOfItems=" + numberOfItems +
                '}';
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
