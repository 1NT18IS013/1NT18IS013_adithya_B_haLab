package com.example.mylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView myList;
    String playersList[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myList = findViewById(R.id.list);
        playersList = getResources().getStringArray(R.array.players);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, R.layout.support_simple_spinner_dropdown_item, playersList
        );

        myList.setAdapter(arrayAdapter);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                Toast.makeText(MainActivity.this,
                        "You have clicked: "+parent.getItemAtPosition(pos),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}
