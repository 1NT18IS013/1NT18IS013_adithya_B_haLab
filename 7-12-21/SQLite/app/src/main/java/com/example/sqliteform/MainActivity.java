package com.example.sqliteform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.database.Cursor;
import android.app.AlertDialog;
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
        Button btnUpdate = findViewById(R.id.updBtn);
        Button btnDelete = findViewById(R.id.delBtn);
        Button btnView = findViewById(R.id.viewBtn);

        DatabaseHelper dbh = new DatabaseHelper(getApplicationContext());
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Order objOrd = new Order(order.getText().toString(), address.getText().toString(), phNo.getText().toString());
                if (dbh.InsertOrder(objOrd))
                    Toast.makeText(getApplicationContext(), "Record inserted successfully", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "Record not inserted", Toast.LENGTH_LONG).show();

            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Order objOrd = new Order(order.getText().toString(), address.getText().toString(), phNo.getText().toString());
                if (dbh.UpdateOrder(objOrd))
                    Toast.makeText(getApplicationContext(), "Record updated successfully", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "Record not updated", Toast.LENGTH_LONG).show();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Order objOrd = new Order(order.getText().toString(), address.getText().toString(), phNo.getText().toString());
                if (dbh.DeleteOrder(objOrd))
                    Toast.makeText(getApplicationContext(), "Record deleted successfully", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "Record not deleted", Toast.LENGTH_LONG).show();
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = dbh.viewData();

                if (res.getCount() == 0) {
                    Toast.makeText(MainActivity.this, "No Record Exist", Toast.LENGTH_SHORT).show();
                } else {
                    StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext()) {
                        buffer.append("PhNo :" + res.getString(2) + "\n");
                        buffer.append("Order :" + res.getString(0) + "\n");
                        buffer.append("Address :" + res.getString(1) + "\n");
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setCancelable(true);
                    builder.setTitle("User Data");
                    builder.setMessage(buffer.toString());
                    builder.show();
                }
            }
        });
    }
}
