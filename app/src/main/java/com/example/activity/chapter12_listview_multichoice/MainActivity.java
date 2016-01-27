package com.example.activity.chapter12_listview_multichoice;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] items = {"Linux", "Window7", "Suse", "Eclipse", "Ubuntu","Solaris", "Android", "iPhone",
                "Linux", "Window7", "Suse", "Eclipse", "Ubuntu","Solaris", "Android", "iPhone"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_single_choice,items);
        final List<String> listChoice = new ArrayList<>();
        setListAdapter(adapter);
        listView = getListView();
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }
}
