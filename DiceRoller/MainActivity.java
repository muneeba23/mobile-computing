package com.example.diceroller;

import static android.widget.Toast.LENGTH_LONG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView tv;
    final Random myRandom = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.roll_button);
        tv=(TextView)findViewById(R.id.result_text);


  button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final int random = new Random().nextInt(7) ;
           tv.setText(String.valueOf(myRandom.nextInt(7)));

        }
    });
}
}