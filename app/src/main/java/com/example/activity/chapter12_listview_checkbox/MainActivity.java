package com.example.activity.chapter12_listview_checkbox;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Model> listModel = (ArrayList<Model>) getData();
        ModelAdapter adapter = new ModelAdapter(MainActivity.this, R.layout.row, listModel);
        setListAdapter(adapter);
    }

    class ModelAdapter extends ArrayAdapter<Model> {
        Context context;
        int layout;
        ArrayList<Model> models;

        public ModelAdapter(Context context, int layout, ArrayList<Model> models) {
            super(context, layout, models);
            this.context = context;
            this.models = models;
            this.layout = layout;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = null;
            if (convertView == null) {
                LayoutInflater layoutInflater = getLayoutInflater();
                row = layoutInflater.inflate(R.layout.row, parent, false);
                final ViewHolder holder = new ViewHolder(row);
                holder.tvName.setText(models.get(position).getName());
                holder.check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        Model element = (Model) holder.check.getTag();
                        element.setSelected(compoundButton.isSelected());
                    }
                });
                row.setTag(holder);
                holder.check.setTag(models.get(position));
            } else {
                row = convertView;
                ((ViewHolder) row.getTag()).check.setChecked(models.get(position).isSelected());
                ((ViewHolder) row.getTag()).tvName.setText(models.get(position).getName());
            }
            return row;
        }
    }

    public List<Model> getData() {
        String[] items = {"Linux", "Window7", "Suse", "Eclipse", "Ubuntu", "Solaris", "Android", "iPhone",
                "Linux", "Window7", "Suse", "Eclipse", "Ubuntu", "Solaris", "Android", "iPhone"};
        ArrayList<Model> list = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            Model m = new Model(items[i]);
            list.add(m);
        }
        return list;
    }
}
