package com.example.learningbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class java2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java2);
        Button buttonShow = findViewById(R.id.selector);
        Button next = findViewById(R.id.next);
        Button prev = findViewById(R.id.prev);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cPage1();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cPage3();
            }
        });

        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        java2.this ,R.style.BottomSheetDialogueTheme
                );
                View bottomSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(
                                R.layout.layout_bottom_sheet,
                                (LinearLayout) findViewById(R.id.bottomSheetContainer)
                        );
                bottomSheetView.findViewById(R.id.page1).setOnClickListener(new View.OnClickListener(){
                                                                                public void onClick(View v)
                                                                                {
                                                                                    Toast.makeText(java2.this, "Going to Page 1", Toast.LENGTH_SHORT).show();
                                                                                    bottomSheetDialog.dismiss();
                                                                                    cPage1();
                                                                                }
                                                                            }
                );
                bottomSheetView.findViewById(R.id.page2).setOnClickListener(new View.OnClickListener(){
                                                                                public void onClick(View v)
                                                                                {
                                                                                    Toast.makeText(java2.this, "Already in Page 2", Toast.LENGTH_SHORT).show();
                                                                                    bottomSheetDialog.dismiss();
                                                                                }
                                                                            }
                );
                bottomSheetView.findViewById(R.id.page3).setOnClickListener(new View.OnClickListener(){
                                                                                public void onClick(View v)
                                                                                {
                                                                                    Toast.makeText(java2.this, "Going to Page 3", Toast.LENGTH_SHORT).show();
                                                                                    bottomSheetDialog.dismiss();
                                                                                    cPage3();
                                                                                }
                                                                            }
                );
                bottomSheetView.findViewById(R.id.page4).setOnClickListener(new View.OnClickListener(){
                                                                                public void onClick(View v)
                                                                                {
                                                                                    Toast.makeText(java2.this, "Going to Page 4", Toast.LENGTH_SHORT).show();
                                                                                    bottomSheetDialog.dismiss();
                                                                                    cPage4();
                                                                                }
                                                                            }
                );
                bottomSheetView.findViewById(R.id.page5).setOnClickListener(new View.OnClickListener(){
                                                                                public void onClick(View v)
                                                                                {
                                                                                    Toast.makeText(java2.this, "Going to Page 5", Toast.LENGTH_SHORT).show();
                                                                                    bottomSheetDialog.dismiss();
                                                                                    cPage5();
                                                                                }
                                                                            }
                );
                bottomSheetView.findViewById(R.id.page6).setOnClickListener(new View.OnClickListener(){
                                                                                public void onClick(View v)
                                                                                {
                                                                                    Toast.makeText(java2.this, "Going to Page 6", Toast.LENGTH_SHORT).show();
                                                                                    bottomSheetDialog.dismiss();
                                                                                    cPage6();
                                                                                }
                                                                            }
                );
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }

        });
    }
    void cPage6()
    {
        Intent intent = new Intent(this, java6.class);
        startActivity(intent);

        // animation
        Animatoo.animateInAndOut(this);
    }
    void cPage4()
    {
        Intent intent = new Intent(this, java4.class);
        startActivity(intent);

        // animation
        Animatoo.animateInAndOut(this);
    }

    void cPage1()
    {
        Intent intent = new Intent(this, java1.class);
        startActivity(intent);

        // animation
        Animatoo.animateSlideRight(this);
    }
    void cPage2()
    {
        Intent intent = new Intent(this, java2.class);
        startActivity(intent);

        // animation
        Animatoo.animateSlideLeft(this);
    }

    void cPage3()
    {
        Intent intent = new Intent(this, java3.class);
        startActivity(intent);

        // animation
        Animatoo.animateSlideLeft(this);
    }


    void cPage5()
    {
        Intent intent = new Intent(this, java5.class);
        startActivity(intent);

        // animation
        Animatoo.animateInAndOut(this);
    }
    public void onBackPressed() {
        Intent intent = new Intent(this, coursePage.class);
        startActivity(intent);
        Animatoo.animateSplit(this);

    }
}
