package com.example.weavingspider.weavingspider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;
import android.net.Uri;
import java.io.File;

public class Raise_NextActivity extends AppCompatActivity {


    Button nextButton;
    private Spinner spinner3;
    //private String create_frm_app;
    //private String create_frm_server;

    String create_frm_app = "Create within app";
    String create_frm_server = "Create using Excel Application";

    public void addItemsOnSpinner3() {

        spinner3 = (Spinner) findViewById(R.id.spinnerSurvey);
        List<String> list = new ArrayList<String>();
        list.add(create_frm_app);
        list.add(create_frm_server);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(dataAdapter);
    }

    protected void sendEmail() {
        Log.i("Send email", "");

        File filelocation = new File("\n" +
                "https://gist.githubusercontent.com/abhijitkumar4293/f6fb0828365d8024f2c5066b169d0607/raw/56a21ac9cd46c835a25ae30dcca9895203129297/ImportSurvey.jason");
        String[] TO = {"Key in your mail address here"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");

        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Link of excel survey - https://gist.githubusercontent.com/abhijitkumar4293/f6fb0828365d8024f2c5066b169d0607/raw/56a21ac9cd46c835a25ae30dcca9895203129297/ImportSurvey.jason");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "");
        //emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("https://gist.githubusercontent.com/abhijitkumar4293/f6fb0828365d8024f2c5066b169d0607/raw/56a21ac9cd46c835a25ae30dcca9895203129297/ImportSurvey.jason"));
        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Raise_NextActivity.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raise__next);

        addItemsOnSpinner3();

        nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner3 = (Spinner) findViewById(R.id.spinnerSurvey);
                String text = spinner3.getSelectedItem().toString();
                if(text.equals(create_frm_app)) {
                    Intent intent = new Intent(getApplicationContext(), RaiseActivity.class);
                    //intent.putExtra("selected option",text);
                    startActivity(intent);
                }else{
                    sendEmail();
                    Toast.makeText(getApplicationContext(), "You will shortly receive an excel application to create and launch survey",Toast.LENGTH_LONG).show();

                };
            }
        });
    }
}



