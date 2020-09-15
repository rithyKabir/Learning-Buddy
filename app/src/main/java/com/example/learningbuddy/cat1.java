package com.example.learningbuddy;


import android.animation.Animator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class cat1 extends AppCompatActivity implements View.OnClickListener {

    private TextView question,qcount ,timer ;
    private Button option1,option2,option3,option4;
    private List<Question> questionList;
    private int questionnumber;

    private CountDownTimer countd;
    int answer_right=0,score=0;   //it will check for the ans
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat1);
        question=findViewById(R.id.question);
        qcount=findViewById(R.id.quest_num);
        timer = findViewById(R.id.countdown);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);

        getquestioList();
        questionnumber=0;

    }
    private  void getquestioList()
    {
        questionList = new ArrayList<>();
        questionList.add(new Question("Question 1","A","B","C","D",2));
        questionList.add(new Question("Question 2","Abb","AbbB","CAbb","DAbb",2));
        questionList.add(new Question("Question 3","AAbb","AbbB","AbbvC","AbbD",2));
        questionList.add(new Question("Question 4","AAbb","BAbb","CfAbb","DAbb",2));
        questionList.add(new Question("Question 5","AAbb","BAbb","CAbb","DAbb",2));

        // question is being made
        setQuestion();
        // set the textviews
    }
    private void setQuestion()
    {
        timer.setText(String.valueOf(10));
        question.setText(questionList.get(0).getQuestion());
        option1.setText(questionList.get(0).getOptionA());
        option2.setText(questionList.get(0).getOptionB());
        option3.setText(questionList.get(0).getOptionC());
        option4.setText(questionList.get(0).getOptionD());

        //setting up the timerr
        qcount.setText(String.valueOf(1) + "/" +String.valueOf(questionList.size()));

        // a function to start the timer
        StartTimer();
        questionnumber=0;

    }




    @Override
    public void onClick(View v) {
        int selectedOption = 0;
        //determining which option is being clicked
        switch (v.getId())
        {

            case R.id.option1 :
                selectedOption=1;
                break;
            case R.id.option2 :
                selectedOption=2;
                break;
            case R.id.option3 :
                selectedOption=3;
                break;
            case R.id.option4 :
                selectedOption=4;
                break;

            default:

        }
        countd.cancel();
        checkAns(selectedOption,v);

    }
    private  void checkAns(int selectedOption ,View view) {
        if (selectedOption == questionList.get(questionnumber).correctAns) {
            //the ansr is r8

            answer_right++;
            score++;
            ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));


        } else {
            // wrong ansr
            ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.RED));

            switch (questionList.get(questionnumber).getCorrectAns()){
                case 1:
                    option1.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 2:
                    option2.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 3:
                    option3.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 4:
                    option4.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;

            }
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                changeQuestion();
                // after 2 sec it will cll run fun

            }
        }, 2000);

    }
    private  void changeQuestion()
    {
        if(questionnumber < questionList.size()-1)
        {
            /// go to next question
            // create animation
            questionnumber++;
            playAnim(question,0,0);
            playAnim(option1,0,1);
            playAnim(option2,0,2);
            playAnim(option3,0,3);
            playAnim(option4,0,4);

            qcount.setText(String.valueOf(questionnumber+1)+"/"+String.valueOf(questionList.size()));
            timer.setText(String.valueOf(10));
            StartTimer();

        }
        else
        {
            System.out.println(" YYYYYYYY   " +score );
            Intent intent = new Intent(cat1.this,ScoreActivity.class);

            intent.putExtra("SCORE",String.valueOf(score)+"/"+String.valueOf(questionList.size()));
            startActivity(intent);
            cat1.this.finish();
        }
    }
    private void StartTimer()
    {
        // i set the timer 10 sec and every 1 sec it will decrecreases
        countd = new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // here we will update the timer value 10...9...8....7........0
                if(millisUntilFinished<10000)
                    timer.setText(String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                /// after finishing the counter we will goto the next question
                changeQuestion();
            }
        };
        countd.start();
    }
    private  void playAnim(final View view , final int value , final int viewnum)
    {
        // option button will be zero in size then it again will be previous size :)
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100).setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if(value==0)
                {
                    switch (viewnum)
                    {
                        case 0 :
                            ((TextView)view).setText(questionList.get(questionnumber).getQuestion());
                            break;
                        case 1:
                            ((Button)view).setText(questionList.get(questionnumber).getOptionA());
                            break;
                        case 2:
                            ((Button)view).setText(questionList.get(questionnumber).getOptionB());
                            break;
                        case 3:
                            ((Button)view).setText(questionList.get(questionnumber).getOptionC());
                            break;
                        case 4:
                            ((Button)view).setText(questionList.get(questionnumber).getOptionD());
                            break;

                    }
                    playAnim(view,1,viewnum);
                }

                if(viewnum !=0 )
                {
                    ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1976D2")));
                }

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

}
