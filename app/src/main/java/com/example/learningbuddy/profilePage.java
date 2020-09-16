package com.example.learningbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;
import java.util.Calendar;

public class profilePage extends AppCompatActivity {

    TextView asked,attempts,correct,customQues,accuracyToday,overall;
    DatabaseReference referenceAsked,referenceAttempts,referenceCorrect,referenceCustomQues;
    DatabaseReference referencePerDay;
    int xx=0,yy=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        asked =findViewById(R.id.askedTextView);
        attempts = findViewById(R.id.attemptTextView);
        correct = findViewById(R.id.correctTextView);
        customQues = findViewById(R.id.customQusTextView);
        accuracyToday = findViewById(R.id.accuracyToday);
        overall = findViewById(R.id.overAllAccuracy);

        referenceAsked = FirebaseDatabase.getInstance().getReference("asked");
        referenceAttempts = FirebaseDatabase.getInstance().getReference("Attempts");
        referenceCorrect = FirebaseDatabase.getInstance().getReference("Scores");
        referenceCustomQues = FirebaseDatabase.getInstance().getReference("Questions and Answers");
        referencePerDay = FirebaseDatabase.getInstance().getReference("PerDay");


    }

    @Override
    protected void onStart() {

        referenceAsked.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String ans="";
                int k=0;
                for(DataSnapshot dataSnapshot1 : snapshot.getChildren())
                {
                    k++;
                }
                ans=Integer.toString(k);

                asked.setText(ans);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        referenceAttempts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String ans="";
                int k=0;
                for(DataSnapshot dataSnapshot1 : snapshot.getChildren())
                {
                    k++;
                }
                k*=5;
                ans=Integer.toString(k);
                xx=k;
                attempts.setText(ans);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        referenceCorrect.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int k=0;
                for(DataSnapshot dataSnapshot1 : snapshot.getChildren())
                {
                    String temp = dataSnapshot1.getValue(String.class);
                    k+=Integer.valueOf(temp);
                }
                yy=k;
                correct.setText(Integer.toString(k));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        referenceCustomQues.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String ans="";
                int k=0;
                for(DataSnapshot dataSnapshot1 : snapshot.getChildren())
                {
                    k++;
                }
                ans=Integer.toString(k);

                customQues.setText(ans+"  Custom Added Questions");
                if(xx!=0) {
                    double ans1 = yy * 100.0 / xx;

                    DecimalFormat df2 = new DecimalFormat("#.##");

                    overall.setText(df2.format(ans1)+"% Accuracy rate Overall");
                }
                else{
                    overall.setText("0.0% Accuracy rate Overall");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Calendar calendar = Calendar.getInstance();
        String date = Integer.toString(calendar.get(Calendar.DATE))+Integer.toString(calendar.get(Calendar.MONTH))+Integer.toString(calendar.get(Calendar.YEAR));

        referencePerDay.child(date).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int k=0;
                int cnt=0;
                for(DataSnapshot dataSnapshot1 : snapshot.getChildren()){
                    String temp = dataSnapshot1.getValue(String.class);
                    k+=Integer.valueOf(temp);
                    cnt++;
                }
                cnt*=5;
                double ans = k*100.0/cnt;

                DecimalFormat df2 = new DecimalFormat("#.##");

                accuracyToday.setText(df2.format(ans)+"% Accuracy rate Today");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
















        super.onStart();
    }

    void goToMenu()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        // animation
        Animatoo.animateSplit(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSplit(this);

    }
}
