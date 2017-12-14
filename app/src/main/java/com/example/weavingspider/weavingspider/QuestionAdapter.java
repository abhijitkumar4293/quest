package com.example.weavingspider.weavingspider;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by amitkumar on 15/12/17.
 */

public class QuestionAdapter extends ArrayAdapter<Question> {
    String TAG = "QuestionAdapter";
    public QuestionAdapter(Context context, ArrayList<Question> questions){
        super(context,0,questions);
    }

    @Override
    @Nullable
    public View getView(int position, View convertView, ViewGroup parent){
        Question question= getItem(position);
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.answer_fill,parent,false);
        }
        TextView textView = convertView.findViewById(R.id.question_text_view);
        TextView textView1 = convertView.findViewById(R.id.question_number_text_view);
        textView1.setText("Q"+(position+1)+". ");
        textView.setText(question.text);
        return convertView;
    }
}
