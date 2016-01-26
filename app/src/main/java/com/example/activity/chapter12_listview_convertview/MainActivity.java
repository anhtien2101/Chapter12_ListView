package com.example.activity.chapter12_listview_convertview;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {
    private static final String[] items = { "lorem", "ipsum",
            "dolor", "sit", "amet", "consectetuer", "adipiscing",
            "elit", "morbi", "vel", "ligula", "vitae", "arcu",
            "aliquet", "mollis", "etiam", "vel", "erat", "placerat",
            "ante", "porttitor", "sodales", "pellentesque", "augue",
            "purus" };
    ListView listView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(android.R.id.list);
        textView = (TextView) findViewById(R.id.textview);
        RowAdapter adapter = new RowAdapter(MainActivity.this);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        textView.setText(items[position]);
    }

    public class RowAdapter extends ArrayAdapter<String> {
        public RowAdapter(Context context) {
            super(context, R.layout.row, items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            if (row == null) {
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.row, parent, false);
            }
            TextView textView = (TextView) row.findViewById(R.id.textview);
            textView.setText(items[position]);
            ImageView imageView = (ImageView) row.findViewById(R.id.imageView);
            if (items[position].length() > 4) {
                imageView.setImageResource(R.drawable.false_60_60);
            } else {
                imageView.setImageResource(R.drawable.check_60_60);
            }

            return row;
        }
    }

}
