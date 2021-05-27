package com.example.pokerchancecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.pokerchancecalculator.Algoritam.TestConsole;
import com.example.pokerchancecalculator.Algoritam.TestConsole;

public class Test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Button calc = findViewById(R.id.calculate);
        TextView ispis = findViewById(R.id.ispis);
        EditText karte = findViewById(R.id.karte);
        TestConsole c = null;
        String[] unos = {"-b","7d9dTs","JhJs","AdJd","KcQd"};

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    c.test(unos, ispis);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });



    }


}