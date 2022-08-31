package com.example.learningapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MyListViews extends ArrayAdapter<Poem>
{

    public MyListViews(@NonNull Context context,@NonNull ArrayList<Poem> objects) {
        super(context,0, objects);
    }

    @Override
    public View getView(int position,View convertView, ViewGroup parent) {
        Poem p=getItem(position);
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.singlelist,parent,false);

        TextView name=convertView.findViewById(R.id.name);
        TextView desc=convertView.findViewById(R.id.des);

        name.setText(p.getName());
        desc.setText(p.getDescription());

        return convertView;
    }
}
