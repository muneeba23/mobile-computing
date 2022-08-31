package com.example.learningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Random;

public class Quiz extends AppCompatActivity implements View.OnClickListener{
    TextView alpa;
    ImageView myImage;
    RadioGroup rdg;
    RadioButton rb;
    Button a,b,c,d;
    Button btn;
    int marks=0;
    int questionNumber=0;
    String answer;
    String question;


    HashMap<String, String> hashMap = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        hashMap.put("q", "Queen");
        hashMap.put("w", "Watermelon");
        hashMap.put("e", "Elephant");
        hashMap.put("r", "Ring");
        hashMap.put("t", "Table");
        hashMap.put("y", "Yogurt");
        hashMap.put("u", "Umbrella");
        hashMap.put("i", "Igloo");
        hashMap.put("o", "Orange");
        hashMap.put("p", "Park");
        hashMap.put("a", "Apple");
        hashMap.put("s", "Sun");
        hashMap.put("d", "Dog");
        hashMap.put("f", "Fan");
        hashMap.put("g", "Glass");
        hashMap.put("h", "House");
        hashMap.put("j", "Jug");
        hashMap.put("k", "King");
        hashMap.put("l", "Lemon");
        hashMap.put("z", "Zig zag");
        hashMap.put("x", "X-Ray");
        hashMap.put("c", "Cat");
        hashMap.put("v", "Van");
        hashMap.put("b", "Ball");
        hashMap.put("n", "Nose");
        hashMap.put("m", "Moon");

        a=findViewById(R.id.one);
        b=findViewById(R.id.two);
        c=findViewById(R.id.three);
        d=findViewById(R.id.four);
        btn=findViewById(R.id.submit);

        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        btn.setOnClickListener(this);

        Random r = new Random();
        char ch = (char)(r.nextInt(26) + 'a');
        question = Character.toString(ch);

        generateQuestion(question);

    }
    @Override
    public void onClick(View view) {
        Button bs=(Button) view;
        if(bs.getId()==R.id.submit){
            String ans=hashMap.get(question);
            System.out.println(answer+ans);

            if(checkQuestion(ans,answer))
            {
                System.out.println(answer+ans);

                marks=marks+1;
            }
            questionNumber++;
            alpa.setText(Integer.toString(marks));
            Random r = new Random();
            char ch = (char)(r.nextInt(26) + 'a');
            question = Character.toString(ch);

            generateQuestion(question);

        }else{
            answer=bs.getText().toString();
        }
    }
    private boolean checkQuestion(String a,String b) {

        if(b==a) {
            return true;
        }
        else
            return false;

    }
    private void generateQuestion( String fnm) {
        if(questionNumber==5){
            finishQuiz();
            return;
        }
            myImage=(ImageView) findViewById(R.id.pic);
            alpa=findViewById(R.id.alpha);
            //to generate Random alphabet

            String PACKAGE_NAME = getApplicationContext().getPackageName();
            int imgId = getResources().getIdentifier(PACKAGE_NAME+":drawable/"+fnm , null, null);

             String answ=hashMap.get(fnm);

        Random r = new Random();
        char choice = (char)(r.nextInt(4) + 'a');
        String questionOption = Character.toString(choice);

        Random generator = new Random();
        Object[] values = hashMap.values().toArray();
        String randomValuea = (String) values[generator.nextInt(values.length)];
        String randomValueb = (String) values[generator.nextInt(values.length)];
        String randomValuec = (String) values[generator.nextInt(values.length)];
        String randomValued = (String) values[generator.nextInt(values.length)];




        a.setText(randomValuea);
        b.setText(randomValueb);
        c.setText(randomValuec );
        d.setText(randomValued);

        int num = (int) (Math.random()*(4-1+1)+1);

        switch (num) {
            case 1:
                a.setText(answ);
                break;
            case 2:
                b.setText(answ);
                break;
            case 3:
                c.setText(answ);
                break;
            case 4:
                d.setText(answ);
                break;
        }


        myImage.setImageResource(imgId);

        }

    private void finishQuiz() {
        new AlertDialog.Builder(this)
                .setTitle("Result")
                .setMessage("Score is "+marks+" out of 5")
                .setPositiveButton("Back",((dialogInterface, i) -> startActivity(new Intent(Quiz.this,MainActivity.class))))
    .show();
        //startActivity(new Intent(Quiz.this,MainActivity.class));
    }


}