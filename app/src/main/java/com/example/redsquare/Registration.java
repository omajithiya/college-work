package com.example.redsquare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity {

    private FirebaseAuth auth;
    private TextInputEditText reg_username,reg_pass,reg_name,reg_gender,reg_conformpass;
    private Button registration;
    String[] item={"Male","Female"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItem;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        auth=FirebaseAuth.getInstance();
        reg_name=(TextInputEditText) findViewById(R.id.reg_name);
        reg_username=(TextInputEditText) findViewById(R.id.reg_username);
        reg_pass=(TextInputEditText) findViewById(R.id.reg_password);
        reg_conformpass=(TextInputEditText) findViewById(R.id.regconfirm_password);
        registration=findViewById(R.id.RegistrationBtn);

        autoCompleteTextView=findViewById(R.id.auto_Complete_text);
        adapterItem = new ArrayAdapter<String>(this,R.layout.list_item, item);

        autoCompleteTextView.setAdapter(adapterItem);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item= parent.getItemAtPosition(position).toString();
//                Toast.makeText(Registration.this, "item"+ item, Toast.LENGTH_SHORT).show();
            }
        });

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String name=reg_name.getText().toString().trim();
//                String gender=reg_gender.getText().toString().trim();
                String user=reg_username.getText().toString().trim();
                String pass=reg_pass.getText().toString().trim();
//                String conpass=reg_conformpass.getText().toString().trim();

//                if (name.isEmpty()) {
//                    reg_name.setError("Name cannot be empty");
//                }
//                if (gender.isEmpty()) {
//                    reg_gender.setError("Gender cannot be empty");
//                }
                if (user.isEmpty()) {
                    reg_username.setError("Email cannot be empty");
                }
                if (pass.isEmpty()) {
                    reg_pass.setError("Password cannot be empty");
                } else {
                    auth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Sign Up successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), StartPage.class));
                            } else {
                                Toast.makeText(getApplicationContext(), "Sign Up Failed"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}

