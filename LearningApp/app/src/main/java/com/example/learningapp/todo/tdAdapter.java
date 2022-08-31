package com.example.learningapp.todo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.learningapp.R;

import java.util.ArrayList;

public class tdAdapter extends ArrayAdapter<todoModel> {
    Button bt;
    ArrayList<todoModel> tm;
    Context base;

    public tdAdapter(@NonNull Context context, @NonNull ArrayList<todoModel> objects) {

        super(context, 0, objects);
        tm = objects;
        base = context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        todoModel tdm = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.td, parent, false);

        TextView tn = convertView.findViewById(R.id.tname);
        TextView td = convertView.findViewById(R.id.tdes);
        Button edit = convertView.findViewById(R.id.edit);
        bt = convertView.findViewById(R.id.del);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper dbHelper = new dbHelper(getContext());
                dbHelper.deleteRow(tdm.getName().toString());
                tm.remove(position);
                notifyDataSetChanged();
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View rootView = ((Activity) base).getWindow().getDecorView().findViewById(android.R.id.content);
                EditText basename = (EditText) rootView.findViewById(R.id.todoName);
                EditText basedes = (EditText) rootView.findViewById(R.id.todoDesc);
                Button update = (Button) rootView.findViewById(R.id.update);
                Button submit = (Button) rootView.findViewById(R.id.submit);
                Button show = (Button) rootView.findViewById(R.id.show);

                Button cancel = (Button) rootView.findViewById(R.id.cancel);

                submit.setVisibility(View.GONE);
                show.setVisibility(View.GONE);
                cancel.setVisibility(View.VISIBLE);
                update.setVisibility(View.VISIBLE);

                String toname = tdm.getName().toString();

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        submit.setVisibility(View.VISIBLE);
                        show.setVisibility(View.VISIBLE);
                        cancel.setVisibility(View.GONE);
                        update.setVisibility(View.GONE);
                        basename.setText("");
                        basedes.setText("");
                    }
                });
                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String bd=basedes.getText().toString();
                        String bn=basename.getText().toString();
                        if(!toname.equals(bn)){
                            Toast.makeText(getContext(), "Add new todo,only desciption will be updated", Toast.LENGTH_SHORT).show();
                        }
                        dbHelper dbHelper = new dbHelper(getContext());
                        dbHelper.updateRow(toname,bd );
//                        tm.remove(position);
                        submit.setVisibility(View.VISIBLE);
                        show.setVisibility(View.VISIBLE);
                        cancel.setVisibility(View.GONE);
                        update.setVisibility(View.GONE);
                        basename.setText("");
                        basedes.setText("");
                        show.performClick();


                    }
                });
                basename.setText(tdm.getName());
                basedes.setText(tdm.getDescription());
            }
        });
        tn.setText(tdm.getName());
        td.setText(tdm.getDescription());
//        td.setText();

        return convertView;
    }


}
