package com.example.learningbuddy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class MainActivity extends AppCompatActivity {
    ImageView bgapp,clover;
    Button profile,quiz,course,custom;
    LinearLayout textsplash,textHome, menu;
    Animation frombutton;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing the animation view elements
        textsplash = findViewById(R.id.textsplash);
        textHome = findViewById(R.id.texthome);
        menu = findViewById(R.id.menus);
        frombutton = AnimationUtils.loadAnimation(this,R.anim.frombutton);
        bgapp = (ImageView) findViewById(R.id.bgapp);
        clover = (ImageView) findViewById(R.id.clover);


        // animation effects of beginning
        bgapp.animate().translationY(-750).setDuration(1500).setStartDelay(300);
        clover.animate().alpha(0).setDuration(1200).setStartDelay(300);
        textsplash.animate().translationY(140).alpha(0).setStartDelay(300);
        textHome.startAnimation(frombutton);
        menu.startAnimation(frombutton);

        // animation work ended

        //Initializing the buttons with id
        profile = findViewById(R.id.profile);
        quiz = findViewById(R.id.quiz12);
        course = findViewById(R.id.course);
        custom =  findViewById(R.id.custom);

        // changes activity on button click
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToProfile();
            }
        });
        course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCourse();
            }
        });
        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCustom();
            }
        });

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToQuiz();
            }
        });

    }
    void goToProfile()
    {
        Intent intent = new Intent(this, profilePage.class);
        startActivity(intent);

        // animation
        Animatoo.animateSplit(this);    }
    void goToCourse()
    {
        Intent intent = new Intent(this, coursePage.class);
        startActivity(intent);

        // animation
        Animatoo.animateSplit(this);    }
    void goToCustom()
    {
        Intent intent = new Intent(this, customPage.class);
        startActivity(intent);

        // animation
        Animatoo.animateSplit(this);    }

    /// will go to the new intent quiz started
    void goToQuiz()
    {
        Intent intent = new Intent(this,splashscreen1.class);
        startActivity(intent);
        Animatoo.animateSplit(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}