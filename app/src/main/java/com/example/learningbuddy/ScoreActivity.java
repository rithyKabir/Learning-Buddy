package com.example.learningbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class ScoreActivity extends AppCompatActivity {

    DatabaseReference databaseReference,databaseReference2,databaseReference3;
    private TextView score;
    private Button done;
    String score_str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        databaseReference = FirebaseDatabase.getInstance().getReference("Attempts");
        databaseReference2 = FirebaseDatabase.getInstance().getReference("Scores");
        databaseReference3 = FirebaseDatabase.getInstance().getReference("PerDay");

        score = findViewById(R.id.sa_score);
        done = findViewById(R.id.sa_done);

        score_str = getIntent().getStringExtra("SCORE");

        String key = databaseReference.push().getKey();
        databaseReference.child(key).setValue("5");
        databaseReference2.child(key).setValue(score_str);

        Calendar calendar = Calendar.getInstance();


        databaseReference3.child(Integer.toString(calendar.get(Calendar.DATE))+Integer.toString(calendar.get(Calendar.MONTH))+Integer.toString(calendar.get(Calendar.YEAR))).child(key).setValue(score_str);





        score.setText(score_str+"/5");


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ScoreActivity.this,MainActivity.class);
                ScoreActivity.this.startActivity(intent);
                ScoreActivity.this.finish();


            }
        });

    }
}