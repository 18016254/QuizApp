package com.myapplicationdev.android.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EasyResultActivity extends AppCompatActivity {

    TextView finalScore, congratulations;
    Button retryButton, homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easyresult);

        setTitle("Results");

        congratulations = (TextView) findViewById(R.id.congrats);
        finalScore = (TextView) findViewById(R.id.result);
        retryButton = (Button) findViewById(R.id.retry);
        homeButton = (Button) findViewById(R.id.home);

        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("finalScore");

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference easyRef = rootRef.child("easy");
        com.google.firebase.database.ValueEventListener valueEventListener = new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot snapshot) {
                int count = (int) snapshot.getChildrenCount();
                finalScore.setText("You scored " + score + "/" + count);
                if (score == count) {
                    congratulations.setText("Congratulations on getting full marks! You have now unlocked pro mode!");
                } else if (score >= (count / 2) && score != count) {
                    congratulations.setText("Congratulations on passing the quiz! Unfortunately you have to get full marks to unlock pro mode. Try again to unlock pro mode!");
                } else {
                    congratulations.setText("Unfortunately, you have not passed the quiz. Try again!");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        easyRef.addListenerForSingleValueEvent(valueEventListener);

        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EasyResultActivity.this, EasyStartActivity.class);
                startActivity(intent);
                EasyResultActivity.this.finish();
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
                DatabaseReference easyRef = rootRef.child("easy");
                com.google.firebase.database.ValueEventListener valueEventListener = new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot snapshot) {
                        int count = (int) snapshot.getChildrenCount();
                        Intent intent = new Intent(EasyResultActivity.this, MenuActivity.class);
                        if (score == count) {
                            intent.putExtra("status", "pass");
                        }
                        EasyResultActivity.this.finish();
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                };
                easyRef.addListenerForSingleValueEvent(valueEventListener);

            }
        });

    }
}