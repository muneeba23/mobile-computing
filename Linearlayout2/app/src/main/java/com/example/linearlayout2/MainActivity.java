package com.example.Linearlayout2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "This is Main Activity";
    Button bn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac);
        Log.d(TAG, "This is my on create");
        bn1 = findViewById(R.id.button2);
        bn1.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);

            }

        });


    }
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "This my on start");

    }
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "This my on resume");

    }
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "This my on pause");

    }
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "This my on stop");

    }
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "This my on Destroy");

    }
}