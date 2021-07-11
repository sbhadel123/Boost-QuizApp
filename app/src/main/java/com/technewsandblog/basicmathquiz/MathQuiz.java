package com.technewsandblog.basicmathquiz;

import android.app.AlertDialog;
import android.os.Bundle;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;



public class MathQuiz extends AppCompatActivity{

    TextView textView;
    Button main;

    int clicked = 0;
    int time;
    int time1;
    int time2;


    ColorStateList oldColors;
    ColorStateList oldColors1;
    ColorStateList oldColors2;



    Button exit;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    ArrayList<Integer> answers1 = new ArrayList<Integer>();
    ArrayList<Integer> answers2 = new ArrayList<Integer>();

    int locationOFCorrect;
    int locationOFCorrect1;
    int locationOFCorrect2;


    int score1;
    int score2;
    int score;
    int numberOfQuestions = 0;
    int numberOfQuestions1 = 0;
    int numberOfQuestions2 = 0;

    //    In inital layout
    Button Easy;
    Button Medium;
    Button Hard;
    RelativeLayout initalLay;

    //    In finalLayOut
    Button playagain;

    RelativeLayout easyMode;
    RelativeLayout mediumMode;
    RelativeLayout hardMode;

    RelativeLayout easyFinal;
    RelativeLayout mediumFinal;
    RelativeLayout hardFinal;

    //        In easy mode
    TextView resultTextView;
    TextView pointsTextView;
    TextView sumTextView;
    TextView timer;
    TextView FinalResult;

    Button button2;
    Button button3;
    Button button4;
    Button button5;

    //    In medium mode
    TextView mAnswer;
    TextView mQuestion;
    TextView mPoint;
    TextView mtime;
    TextView mScore;

    Button button6;
    Button button7;
    Button button8;
    Button button9;

    TextView mResult;
    Button mPlay;

    CountDownTimer start;
    CountDownTimer start1;
    CountDownTimer start2;



    //    In hard mode
    TextView hAnswer;
    TextView hQuestion;
    TextView hPoint;
    TextView htime;
    TextView hScore;

    Button buttonA;
    Button buttonB;
    Button buttonC;
    Button buttonD;

    TextView hResult;
    Button hPlay;

    public void easy(View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Lets see how many you can solve with in 30 second.");

        builder.setPositiveButton("GO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                initalLay.setVisibility(View.INVISIBLE);
                easyMode.setVisibility(View.VISIBLE);
                playAgain(findViewById(R.id.play));
            }
        });

        builder.setNeutralButton("Return", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    public void medium(View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Lets see how many you can solve with in 45 second.");

        builder.setPositiveButton("GO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                initalLay.setVisibility(View.INVISIBLE);
                mediumMode.setVisibility(View.VISIBLE);
                mplayAgain(findViewById(R.id.mPlay));
            }
        });

        builder.setNeutralButton("Return", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    public void hard(View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Lets see how many you can solve with in 60 second.");

        builder.setPositiveButton("GO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                initalLay.setVisibility(View.INVISIBLE);
                hardMode.setVisibility(View.VISIBLE);
                hplayAgain(findViewById(R.id.hPlay));
            }
        });

        builder.setNeutralButton("Return", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }


    public void playAgain(View view){
        easyFinal.setVisibility(View.INVISIBLE);
        easyMode.setVisibility(View.VISIBLE);

        score = 0;
        numberOfQuestions = 1;

        textView.setText("0");
        timer.setText("30s");
        pointsTextView.setText("1");
        resultTextView.setText("");
        playagain.setVisibility(View.INVISIBLE);


        oldColors = timer.getTextColors();

        generateQuestion();


        start = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time = (Integer)(int)millisUntilFinished/1000;

                if(time<5)
                    timer.setTextColor(Color.RED);
                timer.setText(String.valueOf(millisUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                timer.setText("0s");
                timer.setTextColor(oldColors);
                alertdialog();
            }
        }.start();
    }

    private void alertdialog(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Time is up.");
        alert.setCancelable(false);
        alert.setPositiveButton("Show Result", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                easyMode.setVisibility(View.INVISIBLE);
                easyFinal.setVisibility(View.VISIBLE);
                playagain.setVisibility(View.VISIBLE);
                if (score == numberOfQuestions && numberOfQuestions != 0) {
                    FinalResult.setText("Congtrz, You got it all correct." + "Your score: " + Integer.toString(score) + "/" + Integer.toString(numberOfQuestions - 1));
                } else {
                    FinalResult.setText("Your score: " + Integer.toString(score) + "/" + Integer.toString(numberOfQuestions - 1) + " in 30 seconds.");
                }
            }
        });

        AlertDialog alert11 = alert.create();
        alert11.show();
    }

    public void mplayAgain(View view){
        mediumFinal.setVisibility(View.INVISIBLE);
        mediumMode.setVisibility(View.VISIBLE);

        score1 = 0;
        numberOfQuestions1 = 1;

        mScore.setText("0");
        mtime.setText("45s");
        mPoint.setText("1");
        mAnswer.setText("");
        oldColors1 = mtime.getTextColors();
        mgenerateQuestion();

        start = new CountDownTimer(45000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time1 = (Integer)(int)millisUntilFinished/1000;

                if(time1 < 10)
                    mtime.setTextColor(Color.RED);
                mtime.setText(String.valueOf(millisUntilFinished/1000)+ "s");
            }

            @Override
            public void onFinish() {
                mtime.setText("0s");
                mtime.setTextColor(oldColors1);
                alertdialog1();
            }
        }.start();

    }

    private void alertdialog1(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Time is up.");
        alert.setCancelable(false);
        alert.setPositiveButton("Show Result", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mediumMode.setVisibility(View.INVISIBLE);
                mediumFinal.setVisibility(View.VISIBLE);
                mPlay.setVisibility(View.VISIBLE);
                if (score == numberOfQuestions && numberOfQuestions != 0) {
                    mResult.setText("Congtrz, You got it all correct." + "Your score: " + Integer.toString(score1) + "/" + Integer.toString(numberOfQuestions1 - 1));
                } else {
                    mResult.setText("Your score: " + Integer.toString(score1) + "/" + Integer.toString(numberOfQuestions1 - 1) + " in 45 seconds.");
                }
            }
        });

        AlertDialog alert11 = alert.create();
        alert11.show();
    }


    public void hplayAgain(View view){
        hardFinal.setVisibility(View.INVISIBLE);
        hardMode.setVisibility(View.VISIBLE);

        score2 = 0;
        numberOfQuestions2 = 1;

        hScore.setText("0");
        htime.setText("60s");
        hPoint.setText("1");
        hAnswer.setText("");
        oldColors2 = htime.getTextColors();
        hgenerateQuestion();

        start2 = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time2 = (Integer)(int)millisUntilFinished/1000;

                if(time2 < 10){
                    htime.setTextColor(Color.RED);}
                htime.setText(String.valueOf(millisUntilFinished/1000)+ "s");
            }

            @Override
            public void onFinish() {
                htime.setText("0s");
                htime.setTextColor(oldColors2);
                alertdialog2();
            }
        }.start();

    }

    private void alertdialog2(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Time is up.");
        alert.setCancelable(false);
        alert.setPositiveButton("Show Result", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                hardMode.setVisibility(View.INVISIBLE);
                hardFinal.setVisibility(View.VISIBLE);
                hPlay.setVisibility(View.VISIBLE);

                if (score == numberOfQuestions && numberOfQuestions != 0) {
                    hResult.setText("Congtrz, You got it all correct." + "Your score: " + Integer.toString(score2) + "/" + Integer.toString(numberOfQuestions2 - 1));
                } else {
                    hResult.setText("Your score: " + Integer.toString(score2) + "/" + Integer.toString(numberOfQuestions2 - 1)+ " in 60 seconds");
                }
            }
        });

        AlertDialog alert11 = alert.create();
        alert11.show();
    }


    public void generateQuestion(){

        button2.setBackgroundResource(android.R.drawable.btn_default);
        button3.setBackgroundResource(android.R.drawable.btn_default);
        button4.setBackgroundResource(android.R.drawable.btn_default);
        button5.setBackgroundResource(android.R.drawable.btn_default);

        button2.setClickable(true);
        button3.setClickable(true);
        button4.setClickable(true);
        button5.setClickable(true);



        numberOfQuestions++;

        clicked = 0;

        Random rand = new Random();
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        sumTextView.setText(Integer.toString(a) + "+" + Integer.toString(b)+ "=");

        locationOFCorrect = rand.nextInt(4);
        answers.clear();

        int incorrectAnswer;
        for(int i = 0; i<4; i++){
            if(i == locationOFCorrect){
                answers.add(a + b);

            } else {
                incorrectAnswer = rand.nextInt(41);
                while(incorrectAnswer == a + b){
                    incorrectAnswer = rand.nextInt(41);
                }
                answers.add(incorrectAnswer);
            }
        }

        button2.setText(Integer.toString(answers.get(0)));
        button3.setText(Integer.toString(answers.get(1)));
        button4.setText(Integer.toString(answers.get(2)));
        button5.setText(Integer.toString(answers.get(3)));

    }

    public void mgenerateQuestion(){

        button6.setBackgroundResource(android.R.drawable.btn_default);
        button7.setBackgroundResource(android.R.drawable.btn_default);
        button8.setBackgroundResource(android.R.drawable.btn_default);
        button9.setBackgroundResource(android.R.drawable.btn_default);

        button6.setClickable(true);
        button7.setClickable(true);
        button8.setClickable(true);
        button9.setClickable(true);

        numberOfQuestions1++;
        clicked = 0;

        Random ran = new Random();
        int a = ran.nextInt(41);
        int b = ran.nextInt(41);
        int c = ran.nextInt(41);

        int z = a + b - c;

        mQuestion.setText(Integer.toString(a)+ "+" + Integer.toString(b) + "-" + Integer.toString(c));

        locationOFCorrect1 = ran.nextInt(4);
        answers1.clear();

        int incorrectAnswer;
        for(int i = 0; i<4; i++){
            if(i == locationOFCorrect1){
                answers1.add(z);
            } else {
                incorrectAnswer = ran.nextInt(82+1+41)-41;
                while(incorrectAnswer == z){
                    incorrectAnswer = ran.nextInt(82+1+41)-41;
                }
                answers1.add(incorrectAnswer);
            }
        }

        button6.setText(Integer.toString(answers1.get(0)));
        button7.setText(Integer.toString(answers1.get(1)));
        button8.setText(Integer.toString(answers1.get(2)));
        button9.setText(Integer.toString(answers1.get(3)));
    }

    public void hgenerateQuestion(){
        buttonA.setBackgroundResource(android.R.drawable.btn_default);
        buttonB.setBackgroundResource(android.R.drawable.btn_default);
        buttonC.setBackgroundResource(android.R.drawable.btn_default);
        buttonD.setBackgroundResource(android.R.drawable.btn_default);

        buttonA.setClickable(true);
        buttonB.setClickable(true);
        buttonC.setClickable(true);
        buttonD.setClickable(true);

        numberOfQuestions2++;
        clicked = 0;

        Random ran = new Random();
        int a = ran.nextInt(20);
        int b = ran.nextInt(20);
        int c = ran.nextInt(15);
        int d= ran.nextInt(55);

        int z = (a + b) * c - d;

        hQuestion.setText("(" +Integer.toString(a)+ "+" + Integer.toString(b) + ")" + "*" + Integer.toString(c) + "-" + Integer.toString(d));

        locationOFCorrect2 = ran.nextInt(4);

        answers2.clear();

        int incorrectAnswer;
        for(int i = 0; i<4; i++){
            if(i == locationOFCorrect2){
                answers2.add(z);
            } else {
                incorrectAnswer = ran.nextInt(600+1+55)-55;
                while(incorrectAnswer == z){
                    incorrectAnswer = ran.nextInt(600+1+55)-55;
                }
                answers2.add(incorrectAnswer);
            }

        }

        buttonA.setText(Integer.toString(answers2.get(0)));
        buttonB.setText(Integer.toString(answers2.get(1)));
        buttonC.setText(Integer.toString(answers2.get(2)));
        buttonD.setText(Integer.toString(answers2.get(3)));
    }

    public void chooseAnswer(View view){

        if(view.getTag().toString().equals(Integer.toString(locationOFCorrect))){

            view.setBackgroundColor(Color.GREEN);
            resultTextView.setText("Correct!");
            if(clicked == 0){
                score++;
                clicked++;}
            view.setClickable(false);
        }
        else{
            view.setBackgroundColor(Color.RED);
            resultTextView.setText("Wrong!");
            clicked++;
            view.setClickable(false);
        }

        textView.setText(Integer.toString(score));

    }

    public void chooseAnswer1(View view){

        if(view.getTag().toString().equals(Integer.toString(locationOFCorrect1))){

            view.setBackgroundColor(Color.GREEN);
            mAnswer.setText("Correct!");
            if(clicked == 0){
                score1++;
                clicked++;}
            view.setClickable(false);
        }
        else{
            view.setBackgroundColor(Color.RED);
            mAnswer.setText("Wrong!");
            clicked++;
            view.setClickable(false);
        }

        mScore.setText(Integer.toString(score1));
    }

    public void chooseAnswer2(View view){

        if(view.getTag().toString().equals(Integer.toString(locationOFCorrect2))){

            view.setBackgroundColor(Color.GREEN);
            hAnswer.setText("Correct!");
            if(clicked == 0){
                score2++;
                clicked++;}
            view.setClickable(false);
        }
        else{
            view.setBackgroundColor(Color.RED);
            hAnswer.setText("Wrong!");
            clicked++;
            view.setClickable(false);
        }

        hScore.setText(Integer.toString(score2));
    }

    public void nextQuestion(View view){
        pointsTextView.setText(Integer.toString(numberOfQuestions));

        generateQuestion();
    }

    public void mnextQuestion(View view){
        mPoint.setText(Integer.toString(numberOfQuestions1));

        mgenerateQuestion();
    }

    public void hnextQuestion(View view){
        hPoint.setText(Integer.toString(numberOfQuestions2));

        hgenerateQuestion();
    }


    public void exit(View view){
        AlertDialog.Builder build = new AlertDialog.Builder(this);
        build.setTitle("Exit...");
        build.setMessage("You are about to leave the game.");
        build.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);
            }
        });
        build.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alert11 = build.create();
        alert11.show();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        textView = (TextView)findViewById(R.id.textView);

        exit = (Button) findViewById(R.id.exit);
        //main = (Button) findViewById(R.id.main);

        initalLay = (RelativeLayout) findViewById(R.id.firstLayout);

        Easy = (Button) findViewById(R.id.easy);
        Medium = (Button) findViewById(R.id.medium);
        Hard = (Button) findViewById(R.id.hard);

//        forEasyMode
        easyMode = (RelativeLayout) findViewById(R.id.easyMode);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        timer = (TextView) findViewById(R.id.timerTextView);
        pointsTextView = (TextView) findViewById(R.id.pointsTextView);
        sumTextView = (TextView) findViewById(R.id.sumtextView);

//        forMediumMode
        mediumMode = (RelativeLayout)findViewById(R.id.mediumMode);
        mAnswer = (TextView) findViewById(R.id.mAnswer);
        mQuestion = (TextView) findViewById(R.id.mQuestion);
        mPoint = (TextView) findViewById(R.id.mPoint);
        mtime = (TextView) findViewById(R.id.mtime);
        mScore = (TextView)findViewById(R.id.mScore);

        button6 = (Button) findViewById(R.id.button23);
        button7 = (Button) findViewById(R.id.button22);
        button8 = (Button) findViewById(R.id.button21);
        button9 = (Button) findViewById(R.id.button20);

        mResult = (TextView) findViewById(R.id.mResult);
        mPlay = (Button) findViewById(R.id.mPlay);

//            forHardMode
        hardMode = (RelativeLayout) findViewById(R.id.hardMode);
        hAnswer = (TextView) findViewById(R.id.hAnswer);
        hQuestion = (TextView) findViewById(R.id.hQuestion);
        hPoint = (TextView) findViewById(R.id.hPoint);
        htime = (TextView) findViewById(R.id.htime);
        hScore = (TextView)findViewById(R.id.hScore);

        buttonA = (Button)findViewById(R.id.button24);
        buttonB = (Button)findViewById(R.id.button25);
        buttonC = (Button)findViewById(R.id.button26);
        buttonD = (Button)findViewById(R.id.button27);

        hResult = (TextView) findViewById(R.id.hResult);
        hPlay = (Button) findViewById(R.id.hPlay);

//        finalResult
        easyFinal = (RelativeLayout) findViewById(R.id.easyFinal);
        mediumFinal = (RelativeLayout) findViewById(R.id.mediumFinal);
        hardFinal = (RelativeLayout) findViewById(R.id.hardFinal);

        resultTextView = (TextView) findViewById(R.id.result);
        playagain = (Button) findViewById(R.id.play);
        FinalResult = (TextView) findViewById(R.id.FinalResult);

    }

    public void newMode(View view){
        easyFinal.setVisibility(View.INVISIBLE);
        mediumFinal.setVisibility(View.INVISIBLE);
        hardFinal.setVisibility(View.INVISIBLE);
        initalLay.setVisibility(View.VISIBLE);
    }
}
