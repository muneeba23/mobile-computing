package com.example.tictactoa;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    boolean gameActive=true;
    int activePlayer=0;// o
    int[] gameState={2,2,2,2,2,2,2,2,2};
    int countTurns=0;

    int[][] winingStates={{0,1,2},{3,4,5},{6,7,8},
                         {0,3,6},{1,4,7},{2,5,8},
                         {0,4,8},{2,4,6}};
    //TextView tv=findViewById(R.id.playerMove);

    public void playerTap(View view){
        countTurns+=1;
        ImageView img=(ImageView) view;
        int imgid=Integer.parseInt( img.getTag().toString());

if(gameActive){
        if(gameState[imgid]==2){
            //tv.setText("Player "+String.valueOf(activePlayer)+ " move");
            gameState[imgid]=activePlayer;
            if(activePlayer==0) {
                //change player to 1 and set image to o
                img.setImageResource(R.drawable.o);
                activePlayer=1;
                TextView status=findViewById(R.id.playerMove);
                status.setText("X's move: Tap to play");
            }
            else{
                //change player to 0 and set image to x
                img.setImageResource(R.drawable.x);
                activePlayer=0;
                TextView status=findViewById(R.id.playerMove);
                status.setText("o's move: Tap to play");
            }
        }
        else{
            Toast.makeText(getApplicationContext(),"Sorry,please select another cell", Toast.LENGTH_SHORT).show();
        }
        //check who won
        for(int[] winPosition:winingStates)
        {
            if(gameState[winPosition[0]]== gameState[winPosition[1]] &&
                    gameState[winPosition[1]]== gameState[winPosition[2]]&&
                    gameState[winPosition[1]]!=2)
            {
                String winner ;
                if (gameState[winPosition[0]] == 1)
                    winner  = "X won";
                else winner = "O won";
            //update player move status
            TextView status=findViewById(R.id.playerMove);
            status.setText(winner);
            gameActive=false;
            break;
            }
            // if nobody won and no turn left
            if(countTurns==9){
                TextView status=findViewById(R.id.playerMove);
                status.setText("NOBODY WON");
                gameActive=false;
            }
        }
}else
    gameReset(view);
        }

    private void gameReset(View view) {
        countTurns=0;
        gameActive=true;
        activePlayer=0;
        for(int i=0;i<gameState.length;i++){
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView status=findViewById(R.id.playerMove);
        status.setText("o's move: Tap to play");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}