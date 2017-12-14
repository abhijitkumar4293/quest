package com.example.weavingspider.weavingspider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AnswerActivity extends AppCompatActivity {

    String URL = "https://gist.githubusercontent.com/asaharan/c24aa2365812432f342ef743f7e2fdfe/raw/678f8cf06616cf91062bcaf0669e9f5d816c771d/main.json";
    String TAG="tag";
    Gson gson;
    private RequestQueue queue;
    AnswerResponse answerResponse;
    private SurveyAdapter surveyAdapter;
    ListView answerList;
    AdapterView.OnItemClickListener onItemClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        onItemClickListener = new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Intent intent = new Intent(getApplicationContext(),InsideAnswerActivity.class);
                Survey selectedSurvey = answerResponse.surveys.get(i);
                intent.putExtra("survey",selectedSurvey);
                startActivity(intent);
            }
        };

        answerList = (ListView) findViewById(R.id.answerList);
        answerList.setOnItemClickListener(onItemClickListener);

        answerResponse = new AnswerResponse();

        surveyAdapter = new SurveyAdapter(this,answerResponse.surveys);
        answerList.setAdapter(surveyAdapter);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("M/d/yy hh:mm a");
        gson = gsonBuilder.create();
        queue = Volley.newRequestQueue(this);
        request();
    }

    void request(){
        String finalUrl = URL;
        Log.d(TAG, "filterActivities: "+finalUrl);
        StringRequest stringRequest = new CustomStringRequest(Request.Method.GET, finalUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                answerResponse = gson.fromJson(response,AnswerResponse.class);
                surveyAdapter.clear();
                surveyAdapter.addAll(answerResponse.surveys);
                surveyAdapter.notifyDataSetInvalidated();
                Log.d(TAG,"Updated" + answerResponse.surveys.size());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }){
            @Override
            public Map<String,String> getHeaders(){
                Map<String,String> params = (Map<String, String>) ((HashMap) super.getHeaders()).clone();
                return params;
            }
        };
        queue.add(stringRequest);
    }
}
