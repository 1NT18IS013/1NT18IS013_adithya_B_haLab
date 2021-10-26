package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView out = findViewById(R.id.result);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String val = extras.getString("output");
            out.setText(val);
        }
    }
}