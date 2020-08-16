package com.example.learningbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class category_all extends AppCompatActivity {
    private GridLayout gdl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_all);

        gdl=findViewById(R.id.gdlay);
        setSingleEvent(gdl);




    }

    private void setSingleEvent(GridLayout gdl) {
        for(int i=0;i<gdl.getChildCount();i++)
        {
            CardView cardview = (CardView) gdl.getChildAt(i);
            final int finall = i;
            cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(finall==0)
                    {
                        Intent intent = new Intent(category_all.this,cat1.class);
                        startActivity(intent);
                    }
                    else  if(finall==1)
                    {
                        Intent intent = new Intent(category_all.this,cat2.class);
                        startActivity(intent);
                    }
                    else  if(finall==2)
                    {
                        Intent intent = new Intent(category_all.this,cat3.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }
}
