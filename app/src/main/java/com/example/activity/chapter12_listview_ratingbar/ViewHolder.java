package com.example.activity.chapter12_listview_ratingbar;

import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by Tien on 27-Jan-16.
 */
public class ViewHolder {
    RatingBar ratingBar = null;
    TextView textView = null;
    ViewHolder(View view) {
        this.ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        this.textView = (TextView) view.findViewById(R.id.textview);
    }
}
