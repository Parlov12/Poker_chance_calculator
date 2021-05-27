package com.example.pokerchancecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Button calc = findViewById(R.id.calculate);
        TextView ispis = findViewById(R.id.ispis);
        EditText karte = findViewById(R.id.karte);
    }


}