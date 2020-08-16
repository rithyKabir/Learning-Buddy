package com.example.learningbuddy;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import static java.lang.Thread.sleep;


public class splashscreen1 extends AppCompatActivity {

    private TextView appname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen1);
        appname = findViewById(R.id.appname3);
        Typeface typeface = ResourcesCompat.getFont(this, R.font.blacklist);
        appname.setTypeface(typeface);
        Animation anime = AnimationUtils.loadAnimation(this,R.anim.anim);
        appname.setAnimation(anime);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(splashscreen1.this,QuizClassStarted.class);
                startActivity(intent);
            }
        }).start();



    }
}