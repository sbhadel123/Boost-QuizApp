package com.technewsandblog.basicmathquiz;

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
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
        ConstraintLayout linearLayout;
        AnimationDrawable animationDrawable;

        SharedPreferences shared;

        SharedPreferences shared_sound;

        ImageView imgSound;

        private Button mLogin1;
        private Button cancel1;
        private String name = "";


        private Button btn1;
    private Button btn;
    private Button btn2;
        private Button mLogin;
        private Button cancel;
        private String player = " ";

        private long back_pressed_time;

        int sound_status;
        int status_in_sound;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            linearLayout = (ConstraintLayout) findViewById(R.id.myLayout);
           // animationDrawable = (AnimationDrawable) linearLayout.getBackground();
           // animationDrawable.setEnterFadeDuration(3500);
           // animationDrawable.setExitFadeDuration(3500);
            //animationDrawable.start();


            //for sound
            //final MediaPlayer for_button = MediaPlayer.create(this, R.raw.butt);

            btn1 = (Button)findViewById(R.id.button1);


            //setVolumeControlStream(AudioManager.STREAM_MUSIC);

            SharedPreferences result = getSharedPreferences("Sound", Context.MODE_PRIVATE);
           // status_in_sound  = result.getInt("sound_status", 1);
            /*
            if(status_in_sound == 1){
                MediaPlayer mp = MediaPlayer.create(this, R.raw.main);
                mp.start();
                imgSound.setImageResource(0);
                imgSound.setBackgroundResource(R.drawable.sound_on);
                imgSound.getLayoutParams().height = 175;
                imgSound.getLayoutParams().width = 175;
            }
            else{
                imgSound.setImageResource(0);
                imgSound.setBackgroundResource(R.drawable.sound_of);
                imgSound.getLayoutParams().height = 175;
                imgSound.getLayoutParams().width = 175;
            }*/

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*if(status_in_sound == 1){
                        for_button.start();
                    }*/
                    alertBox1();
                }
            });

        }



        public void save_status_sound(){
            shared_sound = getSharedPreferences("Sound", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = shared_sound.edit();
            editor.putInt("sound_status", sound_status);
            editor.apply();
            return;
        }



        public void  alertBox1() {
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            View mView = null;
            mView = (View) getLayoutInflater().inflate(R.layout.dialog,null);

            final EditText username = (EditText) mView.findViewById(R.id.edit1);
            mLogin1 = (Button)mView.findViewById(R.id.btn);
            cancel1 = (Button) mView.findViewById(R.id.btn2);
            alertDialog.setView(mView);
            final AlertDialog dialog = alertDialog.create();
           // final MediaPlayer for_button = MediaPlayer.create(this, R.raw.butt);
            mLogin1.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    /*
                    if(status_in_sound == 1){
                        for_button.start();
                    } */

                    if(!username.getText().toString().isEmpty() ){
                        name = username.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), MathQuiz.class);
                        intent.putExtra("name", name);
                        dialog.cancel();
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Please enter your name", Toast.LENGTH_LONG).show();
                    }
                }
            });
            cancel1.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    /*
                    if(status_in_sound == 1){
                        for_button.start();
                    }*/

                    dialog.dismiss();
                }
            });

            dialog.show();
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            dialog.setCanceledOnTouchOutside(false);
        }

    }




