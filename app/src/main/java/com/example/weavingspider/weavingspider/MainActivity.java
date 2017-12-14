package com.example.weavingspider.weavingspider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button loginButton=null;
    EditText usernameEditText=null,passwordEditText=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setVariables();
        initialize();
    }

    void setVariables(){
        loginButton = (Button) findViewById(R.id.loginButton);
        usernameEditText = (EditText)findViewById(R.id.usernameInput);
        passwordEditText = (EditText) findViewById(R.id.passwordInput);
    }

    void initialize(){
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if(username.equals("a") && password.equals("p")){
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    intent.putExtra("name",username);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Username and password doesn't match"+username+password,Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
