package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.TypedArrayUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.google.android.gms.common.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private TextView questionTV,questionNumberTv;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<QuizModel> quizModelArrayList;
    Random random;
    int currScore=0,questionAttempted=1,currPos;
    int temp[]={};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        questionTV=findViewById(R.id.idTvQuestion);
        questionNumberTv=findViewById(R.id.idTvQuestionsAttempted);
        option1Btn=findViewById(R.id.idBtnOption1);
        option2Btn=findViewById(R.id.idBtnOption2);
        option3Btn=findViewById(R.id.idBtnOption3);
        option4Btn=findViewById(R.id.idBtnOption4);
        quizModelArrayList=new ArrayList<>();
        random=new Random();
        getQuizQuestion(quizModelArrayList);
        currPos= random.nextInt(quizModelArrayList.size());
        temp = Arrays.copyOf(temp, temp.length + 1);
        temp[temp.length - 1] = currPos;
        setDataToViews(currPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModelArrayList.get(currPos).getAnswer().equals(option1Btn.getText().toString()))
                {
                    currScore++;
                }
                questionAttempted++;
                currPos=random.nextInt(quizModelArrayList.size());
                while(ArrayUtils.contains(temp, currPos)&&questionAttempted<=10)
                {
                    currPos=random.nextInt(quizModelArrayList.size());
                }
                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length - 1] = currPos;
                setDataToViews(currPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModelArrayList.get(currPos).getAnswer().equals(option2Btn.getText().toString()))
                {
                    currScore++;
                }
                questionAttempted++;
                currPos=random.nextInt(quizModelArrayList.size());
                while(ArrayUtils.contains(temp, currPos)&&questionAttempted<=10)
                {
                    currPos=random.nextInt(quizModelArrayList.size());
                }
                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length - 1] = currPos;
                setDataToViews(currPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModelArrayList.get(currPos).getAnswer().equals(option3Btn.getText().toString()))
                {
                    currScore++;
                }
                questionAttempted++;
                currPos=random.nextInt(quizModelArrayList.size());
                while(ArrayUtils.contains(temp, currPos)&&questionAttempted<=10)
                {
                    currPos=random.nextInt(quizModelArrayList.size());
                }
                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length - 1] = currPos;
                setDataToViews(currPos);
            }
        });
        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModelArrayList.get(currPos).getAnswer().equals(option4Btn.getText().toString()))
                {
                    currScore++;
                }
                questionAttempted++;
                currPos=random.nextInt(quizModelArrayList.size());
                while(ArrayUtils.contains(temp, currPos)&&questionAttempted<=10)
                {
                    currPos=random.nextInt(quizModelArrayList.size());
                }
                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length - 1] = currPos;
                setDataToViews(currPos);
            }
        });
    }
    private void showScoreSheet()
    {
        Intent i = new Intent(QuizActivity.this,ScoreActivity.class);
        i.putExtra("score",String.valueOf(currScore) );
        startActivity(i);
        finish();
    }
    private void setDataToViews(int currPos)
    {
        if(questionAttempted>10) {
            showScoreSheet();
        }
        else {
            questionNumberTv.setText("Questions Attempted :"+questionAttempted+"/10");
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
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putString("Question",questionTV.getText().toString());
        savedInstanceState.putString("QuestionMarker",questionNumberTv.getText().toString());
        savedInstanceState.putString("Option1",option1Btn.getText().toString());
        savedInstanceState.putString("Option2",option2Btn.getText().toString());
        savedInstanceState.putString("Option3",option3Btn.getText().toString());
        savedInstanceState.putString("Option4",option4Btn.getText().toString());
        savedInstanceState.putInt("currPos",currPos);
        savedInstanceState.putInt("currScore",currScore);
        savedInstanceState.putIntArray("temp",temp);
        savedInstanceState.putInt("questionAttempted",questionAttempted);

        super.onSaveInstanceState(savedInstanceState);
    }

    //    private TextView questionTV,questionNumberTv;
//    private Button option1Btn,option2Btn,option3Btn,option4Btn,optionNextBtn,optionFinishBtn;
//    private ArrayList<QuizModel> quizModelArrayList;
//    Random random;
//    int questionAttempted=1,currPos;
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String tp = savedInstanceState.getString("Question");
        questionTV.setText(tp);
        tp = savedInstanceState.getString("QuestionMarker");
        questionNumberTv.setText(tp);
        tp = savedInstanceState.getString("Option1");
        option1Btn.setText(tp);
        tp = savedInstanceState.getString("Option2");
        option2Btn.setText(tp);
        tp = savedInstanceState.getString("Option3");
        option3Btn.setText(tp);
        tp = savedInstanceState.getString("Option4");
        option4Btn.setText(tp);
        int t=savedInstanceState.getInt("currPos");
        currPos=t;
        t=savedInstanceState.getInt("currScore");
        currScore=t;
        t=savedInstanceState.getInt("questionAttempted");
        questionAttempted=t;
        int [] te=savedInstanceState.getIntArray("temp");
        temp=te;

    }
}