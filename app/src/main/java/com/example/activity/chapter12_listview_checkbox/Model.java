package com.example.activity.chapter12_listview_checkbox;

/**
 * Created by Tien on 27-Jan-16.
 */
public class Model {
    private String name;
    private boolean selected;

    Model(String name) {
        this.name = name;
        selected = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
