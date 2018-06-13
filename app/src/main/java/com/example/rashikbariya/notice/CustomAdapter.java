package com.example.rashikbariya.notice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter{

    Context c;
    List<Module> module;
    TextView title,description;

    public CustomAdapter(Welcome welcome, List<Module> module){
        this.c=welcome;
        this.module=module;
    }

    @Override
    public int getCount() {
        return module.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(c).inflate(R.layout.row_data,null);

        title=convertView.findViewById(R.id.title);
        description=convertView.findViewById(R.id.desc);
        //date=convertView.findViewById(R.id.date);

        title.setText(module.get(position).getTitle());
        description.setText(module.get(position).getDescription());
        //date.setText(module.get(position).getDate());

        return convertView;
    }
}
