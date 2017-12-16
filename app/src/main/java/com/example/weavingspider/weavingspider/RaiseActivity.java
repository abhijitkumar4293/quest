package com.example.weavingspider.weavingspider;

import java.util.ArrayList;
import java.util.List;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.Spinner;


public class RaiseActivity extends AppCompatActivity {
    Button nextButton;
    private Spinner spinner2;
    private Spinner spinner3;

    public void addItemsOnSpinner2() {

        spinner2 = (Spinner) findViewById(R.id.spinnerTherapy);
        List<String> list = new ArrayList<String>();
        list.add("Cardiovascular");
        list.add("Oncology");
        list.add("Rare Diseases");
        list.add("Autoimmune");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }

    public void addItemsOnSpinner3() {

        spinner3 = (Spinner) findViewById(R.id.spinnerDrugType);
        List<String> list = new ArrayList<String>();
        list.add("Small Molecules");
        list.add("Biosimilars");
        list.add("Generics");
        list.add("Biologics");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(dataAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raise);

        addItemsOnSpinner2();
        addItemsOnSpinner3();
        nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Survey_FromApp_Activity.class);
                startActivity(intent);
            }
        });
    }
}
