package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.button2);
        Button practice=findViewById(R.id.button);
        Button git=findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPracticeActivity();
            }
        });
        practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizActivity();
            }
        });
        git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl();
            }
        });
    }
    public void openQuizActivity()
    {
        Intent intent = new Intent(this,QuizActivity.class);
        startActivity(intent);
    }
    public void openPracticeActivity()
    {
        Intent intent = new Intent(this,PracticeActivity.class);
        startActivity(intent);
    }
    public void openUrl()
    {
        Uri uri = Uri.parse("https://github.com/AliButt035/Quiz-App"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}