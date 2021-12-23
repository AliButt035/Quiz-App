package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        textView=findViewById(R.id.idTvScore);
        Button button=findViewById(R.id.idBtnRestart);
        Button home=findViewById(R.id.button6);
        if(getIntent().getExtras() != null) {
            Intent intent = getIntent();
            String score=intent.getStringExtra("score");
            textView.setText("Your Score is \n"+score+"/10");
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ScoreActivity.this,QuizActivity.class);
                startActivity(i);
                finish();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ScoreActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("Data",textView.getText().toString());
        super.onSaveInstanceState(savedInstanceState);
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String scoreString = savedInstanceState.getString("Data");
        textView.setText(scoreString);
    }
}