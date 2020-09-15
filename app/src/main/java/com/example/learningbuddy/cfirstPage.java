package com.example.learningbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class cfirstPage extends AppCompatActivity {
    private static int SPLASH_SCREEN = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cgif);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(cfirstPage.this, cPage1.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }
}
