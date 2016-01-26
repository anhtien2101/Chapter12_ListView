package com.example.activity.chapter12_listview_dynamic;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String[] items = { "lorem", "ipsum",
            "dolor", "sit", "amet", "consectetuer", "adipiscing",
            "elit", "morbi", "vel", "ligula", "vitae", "arcu",
            "aliquet", "mollis", "etiam", "vel", "erat", "placerat",
            "ante", "porttitor", "sodales", "pellentesque", "augue",
            "purus" };
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(android.R.id.list);
        IconicAdapter adapter = new IconicAdapter(MainActivity.this);
        listView.setAdapter(adapter);
    }

    public class IconicAdapter extends ArrayAdapter<String> {
        public IconicAdapter(Context context) {
            super(context, R.layout.row, items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, null);
            ImageView icon = (ImageView) row.findViewById(R.id.imageView);
            if (items[position].length() >= 4) {
                icon.setImageResource(R.drawable.false_30_30);
            } else {
                icon.setImageResource(R.drawable.check_30_30);
            }

            TextView textView = (TextView) row.findViewById(R.id.textview);
            textView.setText(items[position]);
            return row;
        }
    }
}


