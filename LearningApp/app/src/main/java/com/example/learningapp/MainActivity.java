package com.example.learningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.learningapp.todo.Todo;

public class MainActivity extends AppCompatActivity {
    Button link,lesson,quiz,list,todo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        link=findViewById(R.id.code);
        lesson=findViewById(R.id.lessons);
        quiz=findViewById(R.id.quiz);
        list=findViewById(R.id.Poems);
        todo=findViewById(R.id.todos);


        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri= Uri.parse("https://github.com/bsef19m502/MobileComputing");
                Intent in=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(in);
            }
        });
        lesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this,Lessons.class);
                startActivity(in);

            }
        });
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this,Quiz.class);
                startActivity(in);

            }
        });
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this,List.class);
                startActivity(in);

            }
        });
        todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this, Todo.class);
                startActivity(in);

            }
        });




    }
}