package com.example.imagecarousel;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int img[] = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
    };

    int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView curImg = findViewById(R.id.imgView);
        Button prev = findViewById(R.id.prev);
        Button next = findViewById(R.id.nxt);

        curImg.setImageResource(img[pos]);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos = (pos + 1) % img.length;

                curImg.setImageResource(img[pos]);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos--;
                if(pos < 0){
                    pos = img.length - 1;
                }

                curImg.setImageResource(img[pos]);
            }
        });
    }
}
