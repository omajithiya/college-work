package com.example.redsquare;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    String[] item={"Male","Female"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItem;
    Drawable eye;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

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
    }
}

