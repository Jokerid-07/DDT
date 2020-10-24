package com.example.deafanddumbtalk;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;


public class dashboard extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        mAuth = FirebaseAuth.getInstance();

        final Button text = findViewById(R.id.texttospeech);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text();
            }
        });

        final Button text1= findViewById(R.id.speechtotext);
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1();
            }
        });


        final Button text2= findViewById(R.id.signlanguage);
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text2();
            }
        });


        final Button text3= findViewById(R.id.writtingpad);
        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text3();
            }
        });
    }
    private void text1() {
        startActivity(new Intent(getApplicationContext(),SpeechToText.class));
    }
    private void text() {
        startActivity(new Intent(getApplicationContext(),TextToSpeech.class));
    }
    private void text2() {
        startActivity(new Intent(getApplicationContext(),SignLanguage.class));
    }
    private void text3() {
        startActivity(new Intent(getApplicationContext(),Writtingpad.class));
    }

    public void open(View view) {

        Uri ref=Uri.parse("geo:37.7749,-122.4194");
        Intent i = new Intent(Intent.ACTION_VIEW,ref);
        i.setPackage("com.google.android.apps.maps");
        startActivity(i);
    }

    public void logout(View view) {

        mAuth.signOut();
        Intent intent =  new Intent(dashboard.this, Login.class);
        startActivity(intent);
        finish();

    }
}