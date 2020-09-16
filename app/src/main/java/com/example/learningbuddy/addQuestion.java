package com.example.learningbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addQuestion extends AppCompatActivity {
    Button press;
    EditText answer, question;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
        press = findViewById(R.id.press);
        answer = findViewById(R.id.answer);
        question = findViewById(R.id.question);
        databaseReference = FirebaseDatabase.getInstance().getReference("Questions and Answers");
        press.setOnLongClickListener(new View.OnLongClickListener() {

            @Override

            public boolean onLongClick(View v) {
                ADD();
                Toast.makeText( addQuestion.this, "ADDED QUESTION", Toast.LENGTH_SHORT).show();

                return false;

            }

        });

    }
    void ADD()
    {
        //database
        String ques = question.getText().toString().trim();
        String ans = answer.getText().toString().trim();

        String key = databaseReference.push().getKey();

        CustomQuestion customQuestion = new CustomQuestion(ques,ans);
        databaseReference.child(key).setValue(customQuestion);

        question.setText("");
        answer.setText("");




        //database end
        goToMenu();

    }
    void goToMenu()
    {
        Intent intent = new Intent(this, customPage.class);
        startActivity(intent);

        // animation
        Animatoo.animateSplit(this);
    }
    public void onBackPressed() {

        super.onBackPressed();

        // animation
        Animatoo.animateSplit(this);
    }
}
