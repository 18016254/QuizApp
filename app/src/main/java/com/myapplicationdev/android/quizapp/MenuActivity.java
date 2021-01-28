package com.myapplicationdev.android.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    Button btnEasy, btnPro;
    TextView tvWarning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent svc=new Intent(this, BackgroundSoundService.class);
        startService(svc);

        setTitle("Home");

        btnEasy = (Button) findViewById(R.id.easyMode);
        btnPro = (Button) findViewById(R.id.proMode);
        tvWarning = (TextView) findViewById(R.id.warning);

        if(getIntent().hasExtra("status")){
            if (getIntent().getStringExtra("status").equals("pass")){
                btnPro.setEnabled(true);
                tvWarning.setVisibility(View.INVISIBLE);
            } else {
                btnPro.setEnabled(false);
                tvWarning.setVisibility(View.VISIBLE);
            }
        } else {
            btnPro.setEnabled(false);
            tvWarning.setVisibility(View.VISIBLE);
        }

        btnEasy.setOnClickListener(v -> startActivity(new Intent(MenuActivity.this, EasyStartActivity.class)));

        btnPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnPro.isEnabled() == true) {
                    startActivity(new Intent(MenuActivity.this, HardStartActivity.class));
                } else {
                    Toast.makeText(MenuActivity.this, "You can only unlock Pro mode once you get full marks on Easy Mode!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}