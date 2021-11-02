package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean isNewOp = true;
    TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        res = findViewById(R.id.text);
    }

    protected void numberEvent(View view){
        if(isNewOp)
            res.setText("");
        isNewOp = false;
        String num = res.getText().toString();

        switch (view.getId()){
            case R.id.bt1: num += "1";
            break;
            case R.id.bt2: num += "2";
            break;
            case R.id.bt3: num += "3";
            break;
            case R.id.bt4: num += "4";
            break;
            case R.id.bt5: num += "5";
            break;
            case R.id.bt6: num += "6";
            break;
            case R.id.bt7: num += "7";
            break;
            case R.id.bt8: num += "8";
            break;
            case R.id.bt9: num += "9";
            break;
            case R.id.bt0: num += "0";
            break;
            case R.id.btSign: num = "-" + num;
            break;
        }
    }

    protected void operatorEvent(){

    }

    protected void equalEvent(){

    }

    protected void percentEvent(){

    }

    protected void acEvent(){

    }
}
