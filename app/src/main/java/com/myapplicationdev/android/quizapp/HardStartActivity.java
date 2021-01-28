package com.myapplicationdev.android.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HardStartActivity extends AppCompatActivity {

    Button btnStartHard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardstart);

        setTitle("Pro Mode");

        btnStartHard = (Button) findViewById(R.id.startButtonHard);

        btnStartHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HardStartActivity.this, HardQuizActivity.class);
                startActivity(intent);
            }
        });


    }
}