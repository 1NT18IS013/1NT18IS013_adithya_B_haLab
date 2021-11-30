package com.example.musicplayer;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.song);

        Button bt1=findViewById(R.id.play);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Playing Song",Toast.LENGTH_LONG).show();
                mediaPlayer.start();
            }
        });
        Button bt2=findViewById(R.id.pause);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pausing Song",Toast.LENGTH_LONG).show();
                mediaPlayer.pause();
            }
        });

        Button rewind = findViewById(R.id.back);
        rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double curTime = mediaPlayer.getCurrentPosition();

                if(curTime - 5000 < 0) {
                    Toast.makeText(getApplicationContext(), "Cant rewind further", Toast.LENGTH_LONG).show();
                }else{
                    mediaPlayer.seekTo( (int) curTime - 5000);
                }
            }
        });

        Button forward = findViewById(R.id.forward);
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double curTime = mediaPlayer.getCurrentPosition();
                double dur = mediaPlayer.getDuration();
                if(curTime + 5000 > dur) {
                    Toast.makeText(getApplicationContext(), "Cant forward further", Toast.LENGTH_LONG).show();
                }else{
                    mediaPlayer.seekTo( (int) curTime + 5000);
                }
            }
        });

        SeekBar seek = findViewById(R.id.seek);
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                if(mediaPlayer != null && b){
                    mediaPlayer.seekTo(progress*1000);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Button reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             mediaPlayer.seekTo(0);
            }
        });
    }
}
