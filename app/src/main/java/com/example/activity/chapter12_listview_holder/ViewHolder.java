package com.example.activity.chapter12_listview_holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Tien on 26-Jan-16.
 */
public class ViewHolder {
    ImageView imageView = null;
    TextView textView = null;

    ViewHolder(View view){
        this.imageView = (ImageView) view.findViewById(R.id.imageView);
        this.textView = (TextView) view.findViewById(R.id.textview);
    }
}
