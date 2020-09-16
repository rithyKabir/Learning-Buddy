package com.example.learningbuddy;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<CustomQuestion> {

    private Activity context;
    private List<CustomQuestion> customQuestionList;

    public CustomAdapter(Activity context, List<CustomQuestion> customQuestionList) {
        super(context, R.layout.layout_for_list_view, customQuestionList);
        this.context = context;
        this.customQuestionList = customQuestionList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView,ViewGroup parent) {


        LayoutInflater layoutInflater = context.getLayoutInflater();

        View view = layoutInflater.inflate(R.layout.layout_for_list_view,null,true);

        CustomQuestion customQuestion = customQuestionList.get(position);

        TextView ques1 = view.findViewById(R.id.quesLayoutId);
        TextView ans1 = view.findViewById(R.id.ansLayoutId);

        ques1.setText("Question : "+customQuestion.getQuestion());
        ans1.setText("Answer : "+customQuestion.getAnswer());


        return view;
    }
}
