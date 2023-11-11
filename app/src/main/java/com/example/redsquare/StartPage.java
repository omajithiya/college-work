package com.example.redsquare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.ClosedSubscriberGroupInfo;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StartPage extends AppCompatActivity {

    EditText username,password;
    TextView linkclick;
    Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);

        username=(EditText)findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);
        loginBtn=(Button) findViewById(R.id.loginBtn);
        linkclick=(TextView) findViewById(R.id.signupText);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("om")&&password.getText().toString().equals("1234")){
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Login Fail", Toast.LENGTH_LONG).show();
                }

            }
        });

        linkclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Registration.class));
            }
        });
    }
}