package com.example.activity.chapter12_static;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {
    private static final String[] items = { "lorem", "ipsum",
            "dolor", "sit", "amet", "consectetuer", "adipiscing",
            "elit", "morbi", "vel", "ligula", "vitae", "arcu",
            "aliquet", "mollis", "etiam", "vel", "erat", "placerat",
            "ante", "porttitor", "sodales", "pellentesque", "augue",
            "purus" };
    private TextView textview;
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = (TextView) findViewById(R.id.textview);
        textview.setText("abcde");
//        lv = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.row, R.id.text, items);
        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        textview.setText(items[position]);
    }
}
