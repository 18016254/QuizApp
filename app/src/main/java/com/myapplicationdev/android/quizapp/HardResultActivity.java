package com.myapplicationdev.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HardResultActivity extends AppCompatActivity {

    TextView finalScore, congratulations;
    Button retryButton, homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardresult);

        setTitle("Results");

        finalScore = (TextView) findViewById(R.id.result);
        retryButton = (Button) findViewById(R.id.retry);
        homeButton = (Button) findViewById(R.id.home);
        congratulations = (TextView) findViewById(R.id.congrats);

        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("finalScore");

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference hardRef = rootRef.child("pro");
        com.google.firebase.database.ValueEventListener valueEventListener = new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot snapshot) {
                int count = (int) snapshot.getChildrenCount();
                finalScore.setText("You scored " + score + "/" + count);
                if (score >= (count / 2)) {
                    congratulations.setText("Congratulations on passing the quiz!");
                } else {
                    congratulations.setText("Unfortunately, you have not passed the quiz. Try again!");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        hardRef.addListenerForSingleValueEvent(valueEventListener);

        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HardResultActivity.this, HardStartActivity.class);
                startActivity(intent);
                HardResultActivity.this.finish();
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
                DatabaseReference hardRef = rootRef.child("pro");
                com.google.firebase.database.ValueEventListener valueEventListener = new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot snapshot) {
                        int count = (int) snapshot.getChildrenCount();
                        Intent intent = new Intent(HardResultActivity.this, MenuActivity.class);
                        if (score == count) {
                            intent.putExtra("status", "pass");
                        }
                        HardResultActivity.this.finish();
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                };
                hardRef.addListenerForSingleValueEvent(valueEventListener);

            }
        });

    }
}