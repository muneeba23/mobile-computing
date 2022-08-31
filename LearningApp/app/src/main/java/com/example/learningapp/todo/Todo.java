package com.example.learningapp.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learningapp.R;

import java.util.ArrayList;


public class Todo extends AppCompatActivity {
    Button submit,show,update,cancel;
    EditText name,desc;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        submit=findViewById(R.id.submit);
        show=findViewById(R.id.show);
        update=findViewById(R.id.update);
        cancel=findViewById(R.id.cancel);


        update.setVisibility(View.GONE);
        cancel.setVisibility(View.GONE);


        name=findViewById(R.id.todoName);
        desc=findViewById(R.id.todoDesc);
        listView=findViewById(R.id.listview);

        submit.setOnClickListener(new View.OnClickListener() {
            todoModel Todo;
            @Override
            public void onClick(View view) {
                String tname=name.getText().toString();
                String tdes=desc.getText().toString();
                if(!tname.equals("")){
                    if(!tdes.equals("")){
                try {
                    Todo = new todoModel(tname,tdes);
                    //Toast.makeText(MainActivity.this, todoModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(Todo.this, "Error", Toast.LENGTH_SHORT).show();
                }
                dbHelper dbHelper  = new dbHelper(Todo.this);
                dbHelper.addTodo(Todo);
                name.setText("");
                desc.setText("");
                show.performClick();
                }
                    else{
                        Toast.makeText(Todo.this, "Please Enter Todo Description", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(Todo.this, "Please Enter Todo Name", Toast.LENGTH_SHORT).show();
                }
            }

        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper dbHelper = new dbHelper(Todo.this);
                ArrayList<todoModel> listtd = dbHelper.getAllTodos();
                tdAdapter arrayAdapter = new tdAdapter(Todo.this,listtd);
                listView.setAdapter(arrayAdapter);

//                listView.setItemsCanFocus(false);

//                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        dbHelper.deleteRow(listtd.get(position).getName());
//                        show.performClick();
//                    }
//                });

            }
        });



    }

}