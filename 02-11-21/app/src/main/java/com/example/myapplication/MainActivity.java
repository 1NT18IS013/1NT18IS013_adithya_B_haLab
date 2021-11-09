package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean isNewOp = true;
    EditText out;
    String op, oldNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        out = findViewById(R.id.text);
    }

    public void numberEvent(View view){
        if(isNewOp)
            out.setText("");
        isNewOp = false;
        String num = out.getText().toString();

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
            case R.id.btDot: num += ".";
            break;
        }
        out.setText(num);
    }

    public void operatorEvent(View view){
        isNewOp = true;
        oldNum = out.getText().toString();
        switch(view.getId()){
            case R.id.btAdd:  op = "+";
            break;
            case R.id.btSub: op = "-";
            break;
            case R.id.btMul: op = "*";
            break;
            case R.id.btDiv: op = "/";
        }
        out.setText(op);
    }

    public void equalEvent(View view){
        String newNum = out.getText().toString();
        double res = 0.0;
        switch (op){
            case "+":
                res = Double.parseDouble(oldNum) + Double.parseDouble(newNum);
            break;
            case "-":
                res = Double.parseDouble(oldNum) - Double.parseDouble(newNum);
            break;
            case "*":
                res = Double.parseDouble(oldNum) * Double.parseDouble(newNum);
            break;
            case "/":
                res = Double.parseDouble(oldNum) / Double.parseDouble(newNum);
            break;
        }
        out.setText(res+"");
    }

    public void percentEvent(View view){
        double per = Double.parseDouble(out.getText().toString())/100;
        out.setText(per+"");
        isNewOp = true;
    }

    public void acEvent(View view){
        out.setText("0");
        isNewOp = true;
    }
}
