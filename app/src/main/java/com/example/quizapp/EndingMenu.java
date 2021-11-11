package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EndingMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending_menu);
        Button restart=findViewById(R.id.button4);
        Button main=findViewById(R.id.button5);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                end();
            }
        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartPractice();
            }
        });

    }
    private void end()
    {
        Intent i = new Intent(EndingMenu.this,MainActivity.class);
        startActivity(i);
        finish();
    }
    private void restartPractice()
    {
        Intent i = new Intent(EndingMenu.this,PracticeActivity.class);
        startActivity(i);
        finish();
    }
}