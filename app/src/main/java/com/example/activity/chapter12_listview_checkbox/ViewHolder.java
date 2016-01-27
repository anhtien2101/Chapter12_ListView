package com.example.activity.chapter12_listview_checkbox;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by Tien on 27-Jan-16.
 */
public class ViewHolder {
    protected TextView tvName;
    protected CheckBox check;

    ViewHolder(View view) {
        this.tvName = (TextView) view.findViewById(R.id.tvName);
        this.check = (CheckBox) view.findViewById(R.id.cbx);
    }
}
