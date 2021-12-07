package com.example.sqliteform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText order = findViewById(R.id.inp1);
        EditText address = findViewById(R.id.inp2);
        EditText phNo = findViewById(R.id.inp3);

        Button btnSave = findViewById(R.id.btn);

        DatabaseHelper dbh= new DatabaseHelper(getApplicationContext());
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Order objOrd = new Order(order.getText().toString(),address.getText().toString(),phNo.getText().toString());
                if(dbh.InsertOrder(objOrd))
                    Toast.makeText(getApplicationContext(),"Record inserted successfully",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(),"Record not inserted",Toast.LENGTH_LONG).show();

            }
        });
    }
}
