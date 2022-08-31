package com.example.learningapp;

import static android.icu.lang.UCharacter.toLowerCase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Page extends AppCompatActivity {
TextView alpa;
ImageView myImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        Intent in=getIntent();

        alpa=findViewById(R.id.alpha);
        myImage=(ImageView) findViewById(R.id.pic);
        String alphabet=(String)in.getStringExtra("name");
        String value=(String)in.getStringExtra("value");


        String fnm = alphabet.toLowerCase(); //  this is image file name
        String PACKAGE_NAME = getApplicationContext().getPackageName();
        int imgId = getResources().getIdentifier(PACKAGE_NAME+":drawable/"+fnm , null, null);


        myImage.setImageResource(imgId);
        alpa.setText(value);
    }
}