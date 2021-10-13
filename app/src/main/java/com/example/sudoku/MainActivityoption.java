package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.io.IOException;

public class MainActivityoption extends AppCompatActivity {

    MediaPlayer song, s2, s3, s4;
    Switch tog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activityoption);

        song = MediaPlayer.create(MainActivityoption.this, R.raw.lambadina);
        s2 = MediaPlayer.create(MainActivityoption.this, R.raw.belstegn);
        s3 = MediaPlayer.create(MainActivityoption.this, R.raw.alamnalena);
        s4 = MediaPlayer.create(MainActivityoption.this, R.raw.yasteseryal);
        tog = findViewById(R.id.switch1);
        SharedPreferences sharedPreferences = getSharedPreferences("save", MODE_PRIVATE);
//        tog.setChecked(sharedPreferences.getBoolean("value", false));
        tog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tog.isChecked()) {
                    song.start();
                    tog.setChecked(true);
                    song.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            s2.start();
                            s2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    s3.start();
                                    s3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            s4.start();
                                        }
                                    });
                                }
                            });
                        }
                    });
                }else if(!tog.isChecked()){
                    tog.setChecked(false);
                    if(song.isPlaying())
                        song.pause();
                    if(song.isPlaying())
                        s2.pause();
                    if(song.isPlaying())
                        s3.pause();
                    if(song.isPlaying())
                        s4.pause();


                }

            }
        });

    }
}