package com.example.learningbuddy;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

import static android.app.PendingIntent.FLAG_ONE_SHOT;

public class QuizClassStarted extends AppCompatActivity {
    private Button getstarted;
    DatabaseReference databaseReference;
    private Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_class_started);

        databaseReference = FirebaseDatabase.getInstance().getReference("asked");

        getstarted = findViewById(R.id.getstarted);
        mToastRunnable.run();
        getstarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(QuizClassStarted.this,category_all.class);
                startActivity(intent);
            }
        });
    }
    private Runnable mToastRunnable = new Runnable() {
        @Override
        public void run() {

            startAlarm(true,true);
            mHandler.postDelayed(this, 1000000);
        }
    };

    private void startAlarm(boolean isNotification, boolean isRepeat) {
        AlarmManager manager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);


        // SET TIME HERE
        Calendar calendar= Calendar.getInstance();

        int hour = calendar.get(Calendar.HOUR);
        int min = calendar.get(Calendar.MINUTE);
        int sec = calendar.get(Calendar.SECOND);
        if(hour>=1 && min >=0 && sec >=0)
        {
            //firebase

            String key = databaseReference.push().getKey();

            databaseReference.child(key).setValue("1");



            //firebase end
            NotificationCompat.Builder builder = new NotificationCompat.Builder(QuizClassStarted.this);

            Intent myIntent = new Intent(QuizClassStarted.this, category_all.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(
                    QuizClassStarted.this,
                    0,
                    myIntent,
                    FLAG_ONE_SHOT );

            builder.setAutoCancel(true)
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setWhen(System.currentTimeMillis())
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Learning buddy")
                    .setContentIntent(pendingIntent)
                    .setContentText("Let's practice for quiz ")
                    .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND)
                    .setContentInfo("Info");

            NotificationManager notificationManager = (NotificationManager)QuizClassStarted.this.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0,builder.build());

        }



    }

}