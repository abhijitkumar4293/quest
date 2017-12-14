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

/**
 * Created by Amit Saharan on 24/08/17.
 */

public class SurveyAdapter extends ArrayAdapter<Survey> {
    String TAG = "LocationAdapter";
    public SurveyAdapter(Context context, ArrayList<Survey> surveys){
        super(context,0,surveys);
    }

    @Override
    @Nullable
    public View getView(int position, View convertView, ViewGroup parent){
        Survey survey= getItem(position);
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.survey_list_item,parent,false);
        }
        TextView textView = convertView.findViewById(R.id.survey_list_view_text);
        textView.setText(survey.name);
        return convertView;
    }
}
