package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.util.Hex;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class PracticeActivity extends AppCompatActivity {

    private TextView questionTV,questionNumberTv;
    private Button option1Btn,option2Btn,option3Btn,option4Btn,optionNextBtn,optionFinishBtn;
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
        optionNextBtn=findViewById(R.id.button7);
        optionFinishBtn=findViewById(R.id.button8);
        quizModelArrayList=new ArrayList<>();
        random=new Random();
        getQuizQuestion(quizModelArrayList);
        currPos= random.nextInt(quizModelArrayList.size());
        setDataToViews(currPos);
        optionNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDataToViews(currPos);
            }
        });
        optionFinishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endPractice();
            }
        });
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModelArrayList.get(currPos).getAnswer().equals(option1Btn.getText().toString()))
                {
                    option1Btn.setBackgroundColor(Color.GREEN);
                }
                else{
                    option1Btn.setBackgroundColor(Color.RED);
                    if(quizModelArrayList.get(currPos).getAnswer().equals(option2Btn.getText().toString()))
                    {
                        option2Btn.setBackgroundColor(Color.GREEN);
                    }
                    else if(quizModelArrayList.get(currPos).getAnswer().equals(option3Btn.getText().toString()))
                    {
                        option3Btn.setBackgroundColor(Color.GREEN);
                    }
                    else{
                        option4Btn.setBackgroundColor(Color.GREEN);
                    }
                }
                questionAttempted++;
                currPos=random.nextInt(quizModelArrayList.size());

            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModelArrayList.get(currPos).getAnswer().equals(option2Btn.getText().toString()))
                {
                    option2Btn.setBackgroundColor(Color.GREEN);
                }
                else{
                    option2Btn.setBackgroundColor(Color.RED);
                    if(quizModelArrayList.get(currPos).getAnswer().equals(option1Btn.getText().toString()))
                    {
                        option1Btn.setBackgroundColor(Color.GREEN);
                    }
                    else if(quizModelArrayList.get(currPos).getAnswer().equals(option3Btn.getText().toString()))
                    {
                        option3Btn.setBackgroundColor(Color.GREEN);
                    }
                    else{
                        option4Btn.setBackgroundColor(Color.GREEN);
                    }
                }
                questionAttempted++;
                currPos=random.nextInt(quizModelArrayList.size());

            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModelArrayList.get(currPos).getAnswer().equals(option3Btn.getText().toString()))
                {
                    option3Btn.setBackgroundColor(Color.GREEN);
                }
                else{
                    option3Btn.setBackgroundColor(Color.RED);
                    if(quizModelArrayList.get(currPos).getAnswer().equals(option1Btn.getText().toString()))
                    {
                        option1Btn.setBackgroundColor(Color.GREEN);
                    }
                    else if(quizModelArrayList.get(currPos).getAnswer().equals(option2Btn.getText().toString()))
                    {
                        option2Btn.setBackgroundColor(Color.GREEN);
                    }
                    else{
                        option4Btn.setBackgroundColor(Color.GREEN);
                    }
                }
                questionAttempted++;
                currPos=random.nextInt(quizModelArrayList.size());

            }
        });
        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModelArrayList.get(currPos).getAnswer().equals(option4Btn.getText().toString()))
                {
                    option4Btn.setBackgroundColor(Color.GREEN);
                }
                else{
                    option4Btn.setBackgroundColor(Color.RED);
                    if(quizModelArrayList.get(currPos).getAnswer().equals(option1Btn.getText().toString()))
                    {
                        option1Btn.setBackgroundColor(Color.GREEN);
                    }
                    else if(quizModelArrayList.get(currPos).getAnswer().equals(option2Btn.getText().toString()))
                    {
                        option2Btn.setBackgroundColor(Color.GREEN);
                    }
                    else{
                        option3Btn.setBackgroundColor(Color.GREEN);
                    }
                }
                questionAttempted++;
                currPos=random.nextInt(quizModelArrayList.size());

            }
        });
    }
    private void setColorsDefault()
    {
        option1Btn.setBackgroundColor(0xFF6200EE);
        option2Btn.setBackgroundColor(0xFF6200EE);
        option3Btn.setBackgroundColor(0xFF6200EE);
        option4Btn.setBackgroundColor(0xFF6200EE);
    }
    private void endPractice()
    {
        Intent i = new Intent(PracticeActivity.this,EndingMenu.class);
        startActivity(i);
        finish();
    }
    private void setDataToViews(int currPos)
    {
        setColorsDefault();
        if(questionAttempted>10) {
            endPractice();
        }
        else {
            questionNumberTv.setText("Questions "+questionAttempted+"/10");
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
        savedInstanceState.putInt("questionAttempted",questionAttempted);

        int cd1 = ((ColorDrawable)option1Btn.getBackground()).getColor();
        //boolean colorId = cd.equals(Color.GREEN);
        boolean colorId1 = cd1 ==Color.GREEN;
        if(colorId1) {
            savedInstanceState.putString("color1","GREEN");
        }
        colorId1 = cd1==Color.RED;
        if(colorId1){
            savedInstanceState.putString("color1","RED");
        }
        /*if (option1Btn.getBackground() instanceof ColorDrawable) {
            ColorDrawable cd = (ColorDrawable) option1Btn.getBackground();
            //boolean colorId = cd.equals(Color.GREEN);
            boolean colorId = cd.getColor()==Color.GREEN;
            if(colorId) {
                savedInstanceState.putString("color1","GREEN");
            }
            colorId = cd.getColor()==Color.RED;
            if(colorId){
                savedInstanceState.putString("color1","RED");
            }
        }*/
        if (option2Btn.getBackground() instanceof ColorDrawable) {
            ColorDrawable cd = (ColorDrawable) option2Btn.getBackground();
            boolean colorId = cd.getColor()==Color.GREEN;
            if(colorId) {
                savedInstanceState.putString("color2","GREEN");
            }
            colorId = cd.getColor()==Color.RED;
            if(colorId){
                savedInstanceState.putString("color2","RED");
            }
        }
        if (option3Btn.getBackground() instanceof ColorDrawable) {
            ColorDrawable cd = (ColorDrawable) option3Btn.getBackground();
            boolean colorId = cd.getColor()==Color.GREEN;
            if(colorId) {
                savedInstanceState.putString("color3","GREEN");
            }
            colorId = cd.getColor()==Color.RED;
            if(colorId){
                savedInstanceState.putString("color3","RED");
            }
        }
        if (option4Btn.getBackground() instanceof ColorDrawable) {
            ColorDrawable cd = (ColorDrawable) option4Btn.getBackground();
            boolean colorId = cd.getColor()==Color.GREEN;
            if(colorId) {
                savedInstanceState.putString("color4","GREEN");
            }
            colorId = cd.getColor()==Color.RED;
            if(colorId){
                savedInstanceState.putString("color4","RED");
            }
        }
        super.onSaveInstanceState(savedInstanceState);
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String temp = savedInstanceState.getString("Question");
        questionTV.setText(temp);
        temp = savedInstanceState.getString("QuestionMarker");
        questionNumberTv.setText(temp);
        temp = savedInstanceState.getString("Option1");
        option1Btn.setText(temp);
        temp = savedInstanceState.getString("Option2");
        option2Btn.setText(temp);
        temp = savedInstanceState.getString("Option3");
        option3Btn.setText(temp);
        temp = savedInstanceState.getString("Option4");
        option4Btn.setText(temp);

        int t=savedInstanceState.getInt("currPos");
        currPos=t;
        t=savedInstanceState.getInt("questionAttempted");
        questionAttempted=t;
        //Button 1 color save state
        temp=savedInstanceState.getString("color1");
        if(!temp.equals("GREEN"))
        {
            option1Btn.setBackgroundColor(Color.GREEN);
        }
        else if(!temp.equals("RED"))
        {
            option1Btn.setBackgroundColor(Color.RED);
        }
        //Button 2 color save state
        temp=savedInstanceState.getString("color2");
        if(!temp.equals("GREEN"))
        {
            option2Btn.setBackgroundColor(Color.GREEN);
        }
        else if(!temp.equals("RED"))
        {
            option2Btn.setBackgroundColor(Color.RED);
        }
        //Button 3 color save state
        temp=savedInstanceState.getString("color3");
        if(!temp.equals("GREEN"))
        {
            option3Btn.setBackgroundColor(Color.GREEN);
        }
        else if(!temp.equals("RED"))
        {
            option3Btn.setBackgroundColor(Color.RED);
        }
        //Button 4 color save state
        temp=savedInstanceState.getString("color4");
        if(!temp.equals("GREEN"))
        {
            option4Btn.setBackgroundColor(Color.GREEN);
        }
        else if(!temp.equals("RED"))
        {
            option4Btn.setBackgroundColor(Color.RED);
        }
    }
}