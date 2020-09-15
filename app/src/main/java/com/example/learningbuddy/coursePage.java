package com.example.learningbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

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
        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToJava();
            }
        });
        gk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToA();
            }
        });

    }
    void goToCprogrammingAnimation()
    {
        Intent intent = new Intent(this, cFirst.class);
        startActivity(intent);
        Animatoo.animateSplit(this);

    }
    void goToJava()
    {
        Intent intent = new Intent(this, jFirst.class);
        startActivity(intent);
        Animatoo.animateSplit(this);

    }
    void goToA()
    {
        Intent intent = new Intent(this, aFirst.class);
        startActivity(intent);
        Animatoo.animateSplit(this);

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSplit(this);

    }
}
