package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView ls;
    TextView td;
    Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ls=findViewById(R.id.listView);
        td=findViewById(R.id.todo);
        add=findViewById(R.id.add);

        ArrayList<String> ToDos=new ArrayList<String>();

        ToDos.add("Make phone call to Ammi");
        ToDos.add("Have to do evaluation");
        ToDos.add("Dinner");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String >(this, android.R.layout.simple_list_item_1,ToDos);
        ls.setAdapter(arrayAdapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToDos.add(td.getText().toString());
                arrayAdapter.notifyDataSetChanged();

            }
        });

    }
}