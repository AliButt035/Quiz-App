package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class PracticeActivity extends AppCompatActivity {

    private TextView questionTV,questionNumberTv;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<QuizModel> quizModelArrayList;
    Random random;
    int questionAttempted=1,currPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        questionTV=findViewById(R.id.Question);
        questionNumberTv=findViewById(R.id.QuestionsAttempted);
        option1Btn=findViewById(R.id.Option1);
        option2Btn=findViewById(R.id.Option2);
        option3Btn=findViewById(R.id.Option3);
        option4Btn=findViewById(R.id.Option4);
        quizModelArrayList=new ArrayList<>();
        random=new Random();
        getQuizQuestion(quizModelArrayList);
        currPos= random.nextInt(quizModelArrayList.size());
        setDataToViews(currPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModelArrayList.get(currPos).getAnswer().equals(option1Btn.getText().toString()))
                {
                    Toast toast= Toast. makeText(getApplicationContext(),"Correct Answer",Toast. LENGTH_SHORT);
                    toast. show();
                }
                else{
                    Toast toast= Toast. makeText(getApplicationContext(),"Wrong Answer\nCorrect Answer: "+quizModelArrayList.get(currPos).getAnswer(),Toast. LENGTH_SHORT);
                    toast. show();
                }
                questionAttempted++;
                currPos=random.nextInt(quizModelArrayList.size());
                setDataToViews(currPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModelArrayList.get(currPos).getAnswer().equals(option2Btn.getText().toString()))
                {
                    Toast toast= Toast. makeText(getApplicationContext(),"Correct Answer",Toast. LENGTH_SHORT);
                    toast. show();
                }
                else{
                    Toast toast= Toast. makeText(getApplicationContext(),"Wrong Answer\nCorrect Answer: "+quizModelArrayList.get(currPos).getAnswer(),Toast. LENGTH_SHORT);
                    toast. show();
                }
                questionAttempted++;
                currPos=random.nextInt(quizModelArrayList.size());
                setDataToViews(currPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModelArrayList.get(currPos).getAnswer().equals(option3Btn.getText().toString()))
                {
                    Toast toast= Toast. makeText(getApplicationContext(),"Correct Answer",Toast. LENGTH_SHORT);
                    toast. show();
                }
                else{
                    Toast toast= Toast. makeText(getApplicationContext(),"Wrong Answer\nCorrect Answer: "+quizModelArrayList.get(currPos).getAnswer(),Toast. LENGTH_SHORT);
                    toast. show();
                }
                questionAttempted++;
                currPos=random.nextInt(quizModelArrayList.size());
                setDataToViews(currPos);
            }
        });
        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModelArrayList.get(currPos).getAnswer().equals(option4Btn.getText().toString()))
                {
                    Toast toast= Toast. makeText(getApplicationContext(),"Correct Answer",Toast. LENGTH_SHORT);
                    toast. show();
                }
                else{
                    Toast toast= Toast. makeText(getApplicationContext(),"Wrong Answer\nCorrect Answer: "+quizModelArrayList.get(currPos).getAnswer(),Toast. LENGTH_SHORT);
                    toast. show();
                }
                questionAttempted++;
                currPos=random.nextInt(quizModelArrayList.size());
                setDataToViews(currPos);
            }
        });
    }
    private void endPractice()
    {
        Intent i = new Intent(PracticeActivity.this,EndingMenu.class);
        startActivity(i);
        finish();
    }
    private void setDataToViews(int currPos)
    {
        questionNumberTv.setText("Questions "+questionAttempted+"/10");
        if(questionAttempted==10) {
            endPractice();
        }
        else {
            questionTV.setText(quizModelArrayList.get(currPos).getQuestion());
            option1Btn.setText(quizModelArrayList.get(currPos).getOption1());
            option2Btn.setText(quizModelArrayList.get(currPos).getOption2());
            option3Btn.setText(quizModelArrayList.get(currPos).getOption3());
            option4Btn.setText(quizModelArrayList.get(currPos).getOption4());
        }
    }
    private void getQuizQuestion(ArrayList<QuizModel> quizModelArrayList)
    {
        quizModelArrayList.add(new QuizModel("Number of months in islamic Year?","5","10","12","None of the above","12"));
        quizModelArrayList.add(new QuizModel("How many Ashab are there in Jang-E-Badar with Hazrat Muhammad(S.A.W)?","100","1500","2000","313","313"));
        quizModelArrayList.add(new QuizModel("Who is the first Caliph of Islam?","Hazrat Abu Bakar(R.A)","Hazrat Omer(R.A)","Hazrat Usman(R.A)","Hazrat Ali(R.A)","Hazrat Abu Bakar(R.A)"));
        quizModelArrayList.add(new QuizModel("How long did first Caliph rule?","12 months","27 months","18 months","24 months","27 months"));
        quizModelArrayList.add(new QuizModel("When was Prophet Muhammad(S.A.W) born Islamic day?","8 Rabiulawal","20 Rabiulawal","12 Rabiulawal","None of the above","12 Rabiulawal"));
        quizModelArrayList.add(new QuizModel("How old is Quran?","1,370 years old","4,000 years old","5,000 years old","1,000 years old","1,370 years old"));
        quizModelArrayList.add(new QuizModel("First Surah of Quran?","Surah at-tin","Surah al-Bakara","Surah al-Kausar","Surah al-Fatihah","Surah al-Fatihah"));
        quizModelArrayList.add(new QuizModel("Which fruit is from heaven?","Apple","Fig","Banana","All of the Above","Fig"));
        quizModelArrayList.add(new QuizModel("How old was Prophet Muhammad(S.A.W) when he died?","70 years old","50 years old","63 years old","75 years old","63 years old"));
        quizModelArrayList.add(new QuizModel("Nisab of zakat on silver in tola?","52.5 tola","62.5 tola","7.5 tola","50 tola","52.5 tola"));

    }
}