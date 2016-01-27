package com.example.activity.chapter12_listview_ratingbar;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends ListActivity {
    private static final String[] items = { "lorem", "ipsum", "dolor", "sit",
            "amet", "consectetuer", "adipiscing", "elit", "morbi", "vel", "ligula",
            "vitae", "arcu", "aliquet", "mollis", "etiam", "vel","erat", "placerat",
            "ante", "porttitor", "sodales", "pellentesque", "augue", "purus" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<RowModel> list = new ArrayList<>();
        for (int i = 0;i < items.length;i++) {
            list.add(new RowModel(items[i]));
        }

        setListAdapter(new RatingAdapter(MainActivity.this, R.layout.row, list));
    }

    private RowModel getModel(int position) {
        return (RowModel) getListAdapter().getItem(position);
    }
    class RatingAdapter extends ArrayAdapter<RowModel> {
        RatingAdapter(Context context,int layout, ArrayList<RowModel> listRowModel) {
            super(context, layout, listRowModel);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
//            View row = super.getView(position, convertView, parent);
            View row = null;
            LayoutInflater layoutInflater = getLayoutInflater();
            row = layoutInflater.inflate(R.layout.row, parent, false);
            ViewHolder holder = (ViewHolder) row.getTag();
            if (holder == null) {
                holder = new ViewHolder(row);
                row.setTag(holder);
                RatingBar.OnRatingBarChangeListener l = new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromTouch) {
                        int myPosition = (int) ratingBar.getTag();
                        RowModel rowModel = getModel(myPosition);
                        rowModel.rating = rating;
                        LinearLayout parent = (LinearLayout) ratingBar.getParent();
                        TextView tv = (TextView) parent.findViewById(R.id.textview);
                        tv.setText(rowModel.toString());
                    }
                };
                holder.ratingBar.setOnRatingBarChangeListener(l);
            }
            RowModel model = getModel(position);
            holder.ratingBar.setTag(position);
            holder.ratingBar.setRating(model.rating);
            holder.textView.setText(items[position]);
            return row;
        }
    }

    class RowModel {
        String label;
        float rating = 2.0f;
        RowModel(String label) {
            this.label = label;
        }

        public String toString() {
            if (rating >= 3.0) {
                return label.toUpperCase();
            }
                return label;
        }
    }
}
