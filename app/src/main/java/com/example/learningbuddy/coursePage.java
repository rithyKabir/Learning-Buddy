package com.example.learningbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class coursePage extends AppCompatActivity {
    ImageButton cProgramming, gk, java, vocabulary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page);
        // Initializing the buttons with id
        cProgramming = findViewById(R.id.cProgramming);
        java = findViewById(R.id.javaProgramming);
        gk = findViewById(R.id.gk);
        vocabulary =  findViewById(R.id.english);

        // changes activity on button click
        cProgramming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCprogrammingAnimation();
            }
        });


    }
    void goToCprogrammingAnimation()
    {
        Intent intent = new Intent(this, cProgrammingAnimationPage.class);
        startActivity(intent);
        Animatoo.animateSplit(this);

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSplit(this);

    }
}
