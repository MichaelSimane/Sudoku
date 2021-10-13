package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;


public class Intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        ImageView iv = (ImageView) findViewById(R.id.aau);
        iv.setImageResource(R.mipmap.aau2_foreground);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
           @Override
           public void run() {
               Intent in = new Intent(Intro.this, Level.class);
               startActivity(in);
               finish();
           }
       }, 1000);

    }
}