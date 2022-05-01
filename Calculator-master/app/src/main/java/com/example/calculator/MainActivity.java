package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,equall,add,sub,mul,div,delete,dott;
    EditText edit;
    double num1,num2;
    double result;

    int index;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0 = findViewById(R.id.button0);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
       btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
      btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        equall=findViewById(R.id.equal);
        sub=findViewById(R.id.minus);
        add=findViewById(R.id.plus);
        div=findViewById(R.id.divide);
        delete=findViewById(R.id.del);
        mul=findViewById(R.id.multi);
        dott=findViewById(R.id.dot);
        edit=findViewById(R.id.edit);
        btn1.setOnClickListener(v -> edit.setText(edit.getText() + "1"));

        btn2.setOnClickListener(v -> edit.setText(edit.getText() + "2"));

        btn3.setOnClickListener(v -> edit.setText(edit.getText() + "3"));

       btn4.setOnClickListener(v -> edit.setText(edit.getText() + "4"));

       btn5.setOnClickListener(v -> edit.setText(edit.getText() + "5"));

        btn6.setOnClickListener(v -> edit.setText(edit.getText() + "6"));

        btn7.setOnClickListener(v -> edit.setText(edit.getText() + "7"));

        btn8.setOnClickListener(v -> edit.setText(edit.getText() + "8"));

        btn9.setOnClickListener(v -> edit.setText(edit.getText() + "9"));

       btn0.setOnClickListener(v -> edit.setText(edit.getText() + "0"));
        add.setOnClickListener(v -> edit.setText(edit.getText() + "+"));
        sub.setOnClickListener(v -> edit.setText(edit.getText() + "-"));
        div.setOnClickListener(v -> edit.setText(edit.getText() + "/"));
        mul.setOnClickListener(v -> edit.setText(edit.getText() + "*"));
        dott.setOnClickListener(v -> edit.setText(edit.getText() + "."));
        equall.setOnClickListener(view -> {
            String str=edit.getText().toString();

            boolean flag1=str.contains("+");
            boolean flag2=str.contains("-");
            boolean flag3=str.contains("/");
            boolean flag4=str.contains("*");

            if(flag1)
            {
                index=str.indexOf("+");
                num1= Double.parseDouble((String) str.subSequence(0,index));
                num2= Double.parseDouble((String) str.subSequence(index+1,str.length()));
                result=  num1+num2;
            }
           else if(flag2)
            {
                index=str.indexOf("-");
                num1= Double.parseDouble((String) str.subSequence(0,index));
                num2=Double.parseDouble((String) str.subSequence(index+1,str.length()));
                result=  num1-num2;
            }
           else if(flag3) {
                index = str.indexOf("/");
                num1 = Double.parseDouble((String) str.subSequence(0, index));
                num2 = Double.parseDouble((String) str.subSequence(index + 1, str.length()));
                result = num1 / num2;
            }
           else if(flag4)
           {
               index=str.indexOf("*");
               num1= Double.parseDouble((String) str.subSequence(0,index));
               num2= Double.parseDouble((String) str.subSequence(index+1,str.length()));
               result=  num1*num2;
           }
            String r=Double.toString((double) result);
            edit.setText(r);
        });
      delete.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              edit.setText("");
          }
      });
   }

}