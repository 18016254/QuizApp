package com.myapplicationdev.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HardQuizActivity extends AppCompatActivity {

    private TextView tvScoreView;
    private TextView tvQuestionView;
    private RadioButton radioChoice1;
    private RadioButton radioChoice2;
    private RadioButton radioChoice3;
    private RadioButton radioChoice4;
    private Button nextButton;
    private RadioGroup radioGrp;

    private String correctAnswer;
    private int currentScore = 0;
    private int qnNumber = 0;

    private Firebase questionFb, choice1Fb, choice2Fb, choice3Fb, choice4Fb, answerFb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardquiz);

        setTitle("Quiz");

        tvScoreView = (TextView) findViewById(R.id.score);
        tvQuestionView = (TextView) findViewById(R.id.question);
        radioChoice1 = (RadioButton) findViewById(R.id.choice1);
        radioChoice2 = (RadioButton) findViewById(R.id.choice2);
        radioChoice3 = (RadioButton) findViewById(R.id.choice3);
        radioChoice4 = (RadioButton) findViewById(R.id.choice4);
        nextButton = (Button) findViewById(R.id.nextButton);
        radioGrp = (RadioGroup) findViewById(R.id.radioGroup);

        updateQuestion();
        updateScore(currentScore);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioChoice1.isChecked() == true && radioChoice1.getText().equals(correctAnswer)) {
                    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
                    DatabaseReference hardRef = rootRef.child("pro");
                    com.google.firebase.database.ValueEventListener valueEventListener = new com.google.firebase.database.ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot snapshot) {
                            int count = (int) snapshot.getChildrenCount();
                            if (qnNumber == count) {
                                nextButton.setText("End");
                                Intent intent = new Intent(HardQuizActivity.this, HardResultActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("finalScore", currentScore);
                                intent.putExtras(bundle);
                                startActivity(intent);
                                HardQuizActivity.this.finish();
                            } else {
                                updateQuestion();
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    };
                    hardRef.addListenerForSingleValueEvent(valueEventListener);
                    radioGrp.clearCheck();
                    currentScore += 1;
                    updateScore(currentScore);
                    Toast.makeText(HardQuizActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                } else if (radioChoice2.isChecked() == true && radioChoice2.getText().equals(correctAnswer)) {
                    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
                    DatabaseReference hardRef = rootRef.child("pro");
                    com.google.firebase.database.ValueEventListener valueEventListener = new com.google.firebase.database.ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot snapshot) {
                            int count = (int) snapshot.getChildrenCount();
                            if (qnNumber == count) {
                                nextButton.setText("End");
                                Intent intent = new Intent(HardQuizActivity.this, HardResultActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("finalScore", currentScore);
                                intent.putExtras(bundle);
                                startActivity(intent);
                                HardQuizActivity.this.finish();
                            } else {
                                updateQuestion();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    };
                    hardRef.addListenerForSingleValueEvent(valueEventListener);
                    radioGrp.clearCheck();
                    currentScore += 1;
                    updateScore(currentScore);
                    Toast.makeText(HardQuizActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                } else if (radioChoice3.isChecked() == true && radioChoice3.getText().equals(correctAnswer)) {
                    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
                    DatabaseReference hardRef = rootRef.child("pro");
                    com.google.firebase.database.ValueEventListener valueEventListener = new com.google.firebase.database.ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot snapshot) {
                            int count = (int) snapshot.getChildrenCount();
                            if (qnNumber == count) {
                                nextButton.setText("End");
                                Intent intent = new Intent(HardQuizActivity.this, HardResultActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("finalScore", currentScore);
                                intent.putExtras(bundle);
                                startActivity(intent);
                                HardQuizActivity.this.finish();
                            } else {
                                updateQuestion();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    };
                    hardRef.addListenerForSingleValueEvent(valueEventListener);
                    radioGrp.clearCheck();
                    currentScore += 1;
                    updateScore(currentScore);
                    Toast.makeText(HardQuizActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                } else if (radioChoice4.isChecked() == true && radioChoice4.getText().equals(correctAnswer)) {
                    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
                    DatabaseReference hardRef = rootRef.child("pro");
                    com.google.firebase.database.ValueEventListener valueEventListener = new com.google.firebase.database.ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot snapshot) {
                            int count = (int) snapshot.getChildrenCount();
                            if (qnNumber == count) {
                                nextButton.setText("End");
                                Intent intent = new Intent(HardQuizActivity.this, HardResultActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("finalScore", currentScore);
                                intent.putExtras(bundle);
                                startActivity(intent);
                                HardQuizActivity.this.finish();
                            } else {
                                updateQuestion();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    };
                    hardRef.addListenerForSingleValueEvent(valueEventListener);
                    radioGrp.clearCheck();
                    currentScore += 1;
                    updateScore(currentScore);
                    Toast.makeText(HardQuizActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                } else if (radioGrp.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(HardQuizActivity.this, "Please select an answer!", Toast.LENGTH_SHORT).show();
                } else {
                    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
                    DatabaseReference hardRef = rootRef.child("pro");
                    com.google.firebase.database.ValueEventListener valueEventListener = new com.google.firebase.database.ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot snapshot) {
                            int count = (int) snapshot.getChildrenCount();
                            if (qnNumber == count) {
                                nextButton.setText("End");
                                Intent intent = new Intent(HardQuizActivity.this, HardResultActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("finalScore", currentScore);
                                intent.putExtras(bundle);
                                startActivity(intent);
                                HardQuizActivity.this.finish();
                            } else {
                                updateQuestion();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    };
                    hardRef.addListenerForSingleValueEvent(valueEventListener);
                    radioGrp.clearCheck();
                    Toast.makeText(HardQuizActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void updateQuestion() {
        questionFb = new Firebase("https://quizapp-69420-default-rtdb.firebaseio.com/pro/" + qnNumber + "/question");

        questionFb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String question = dataSnapshot.getValue(String.class);
                tvQuestionView.setText(qnNumber + ") " + question);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        choice1Fb = new Firebase("https://quizapp-69420-default-rtdb.firebaseio.com/pro/" + qnNumber + "/choice1");

        choice1Fb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                radioChoice1.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        choice2Fb = new Firebase("https://quizapp-69420-default-rtdb.firebaseio.com/pro/" + qnNumber + "/choice2");

        choice2Fb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                radioChoice2.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        choice3Fb = new Firebase("https://quizapp-69420-default-rtdb.firebaseio.com/pro/" + qnNumber + "/choice3");

        choice3Fb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                radioChoice3.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        choice4Fb = new Firebase("https://quizapp-69420-default-rtdb.firebaseio.com/pro/" + qnNumber + "/choice4");

        choice4Fb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                radioChoice4.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        answerFb = new Firebase("https://quizapp-69420-default-rtdb.firebaseio.com/pro/" + qnNumber + "/answer");

        answerFb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                correctAnswer = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        qnNumber++;

    }

    private void updateScore(int theScore) {
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference hardRef = rootRef.child("pro");
        com.google.firebase.database.ValueEventListener valueEventListener = new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot snapshot) {
                int count = (int) snapshot.getChildrenCount();
                tvScoreView.setText("" + currentScore + "/" + count);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        hardRef.addListenerForSingleValueEvent(valueEventListener);
    }

}