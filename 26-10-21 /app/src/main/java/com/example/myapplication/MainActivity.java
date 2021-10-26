package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.addBtn);
        TextView out = findViewById(R.id.output);
        EditText inp1 = findViewById(R.id.num1);
        EditText inp2 = findViewById(R.id.num2);

        Intent it = new Intent(this, ResultActivity.class);

        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int num1 = Integer.parseInt(inp1.getText().toString());
                int num2 = Integer.parseInt(inp2.getText().toString());
                int res = num1 + num2;
//                out.setText("Sum is "+String.valueOf(res));
                it.putExtra("output", String.valueOf(res));
                startActivity(it);
            }
        });
    }

}