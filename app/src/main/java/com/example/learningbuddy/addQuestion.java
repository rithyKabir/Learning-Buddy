package com.example.learningbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class addQuestion extends AppCompatActivity {
    Button press;
    EditText answer, question;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
        press = findViewById(R.id.press);
        answer = findViewById(R.id.answer);
        question = findViewById(R.id.question);
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

        Intent intent = new Intent(this, customPage.class);
        startActivity(intent);

        // animation
        Animatoo.animateSplit(this);
    }
}
