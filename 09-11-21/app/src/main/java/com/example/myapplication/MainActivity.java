package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText phone;
    Button call, save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone = findViewById(R.id.phno);
        call = findViewById(R.id.btCall);
        save = findViewById(R.id.btSave);
    }

    public void makeACall(View view){
        String num = phone.getText().toString();

        if(num != " " || num != null){
            Intent it = new Intent(Intent.ACTION_CALL);
            it.setData(Uri.parse("tel:"+num));
            startActivity(it);
        }else{
            Toast.makeText(getApplicationContext(), "Enter the phone number", Toast.LENGTH_SHORT).show();
        }
    }

    public void saveContact(View view){
        String contact = phone.getText().toString();
        if(contact != " " || contact !=null){
            Intent it = new Intent(Intent.ACTION_INSERT);
            it.setType(ContactsContract.Contacts.CONTENT_TYPE);
            it.putExtra(ContactsContract.Intents.Insert.PHONE, contact);
            startActivity(it);
        }
    }
}
