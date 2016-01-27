package com.example.activity.chapter12_listview_singlechoice;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
    String[] items = {"Linux", "Window7", "Suse", "Eclipse", "Ubuntu","Solaris", "Android", "iPhone",
                    "Linux", "Window7", "Suse", "Eclipse", "Ubuntu","Solaris", "Android", "iPhone"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_single_choice,items);
        setListAdapter(adapter);
        ListView listView = getListView();
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }
}
