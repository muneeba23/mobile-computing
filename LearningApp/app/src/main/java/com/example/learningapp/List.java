package com.example.learningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.learningapp.todo.Todo;

import java.util.ArrayList;

public class List extends AppCompatActivity {
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<Poem> poems =new ArrayList<Poem>();
        poems.add(new Poem("humpty Dumpty","Humpty Dumpty sat on the wall\n" +
                "Humpty Dumpty had a great fall\n" +
                "All the king's horses and all the king's men\n" +
                "Couldn't put Humpty together again"));
        poems.add(new Poem("Bah, Bah a black Sheep,","Bah, Bah a black Sheep,\n" +
                "Have you any Wool?\n" +
                "Yes merry have I,\n" +
                "Three Bags full,\n" +
                "One for my master,\n" +
                "One for my Dame,\n" +
                "One for the little Boy\n" +
                "That lives down the lane."));
        poems.add(new Poem("Twinkle twinkle ","Twinkle, twinkle, little star\n" +
                "How I wonder what you are\n" +
                "Up above the world so high\n" +
                "Like a diamond in the sky"));

        lv=findViewById(R.id.poem);
        MyListViews mladapter=new MyListViews(this,poems);
        lv.setAdapter(mladapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                         String recipes = String.valueOf(parent.getItemAtPosition(position));
                Toast.makeText(List.this, poems.get(position).getName(), Toast.LENGTH_LONG).show();

//                        Log.d("vjdln",recipes);
            }
        });


    }
}