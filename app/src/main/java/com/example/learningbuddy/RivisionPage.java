package com.example.learningbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RivisionPage extends AppCompatActivity {

    private ListView listView;
    DatabaseReference databaseReference;
    private List<CustomQuestion> customQuestionList;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rivision_page);

        databaseReference = FirebaseDatabase.getInstance().getReference("Questions and Answers");

        customQuestionList = new ArrayList<>();
        customAdapter = new CustomAdapter(RivisionPage.this,customQuestionList);



        listView = findViewById(R.id.listViewId);
    }

    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                customQuestionList.clear();
                for(DataSnapshot dataSnapshot1 : snapshot.getChildren()){
                    CustomQuestion customQuestion = dataSnapshot1.getValue(CustomQuestion.class);
                    customQuestionList.add(customQuestion);
                }
                listView.setAdapter(customAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        super.onStart();
    }
}