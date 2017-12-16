package com.example.weavingspider.weavingspider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    Button raiseButton, answerButton, exploreButton;
    static String strOption = "a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        raiseButton = (Button) findViewById(R.id.raiseButton);
        answerButton = (Button) findViewById(R.id.answerButton);
        exploreButton = (Button) findViewById(R.id.exploreButton);

        raiseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getApplicationContext(),RaiseActivity.class);
                Intent intent = new Intent(getApplicationContext(),Raise_NextActivity.class);
                startActivity(intent);
            }
        });

        answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strOption = null;
                Intent intent = new Intent(getApplicationContext(),AnswerActivity.class);
                intent.putExtra("STRING_I_NEED",strOption);
                startActivity(intent);
            }
        });

        exploreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Username and password doesn't match",Toast.LENGTH_LONG).show();
                strOption = "exploresurvey";
                Intent intent = new Intent(getApplicationContext(),AnswerActivity.class);
                intent.putExtra("STRING_I_NEED",strOption);
                startActivity(intent);
            }
        });
    }
}
