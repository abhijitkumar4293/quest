package com.example.weavingspider.weavingspider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class InsideAnswerActivity extends AppCompatActivity {

    ListView listView;
    QuestionAdapter questionAdapter;
    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_answer);
        Survey survey = getIntent().getParcelableExtra("survey");

        questionAdapter = new QuestionAdapter(this, survey.questions);
        listView = (ListView) findViewById(R.id.insideAnswerList);
        listView.setAdapter(questionAdapter);
        submitButton=(Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"j",Toast.LENGTH_LONG).show();

            }
        });
    }
}
