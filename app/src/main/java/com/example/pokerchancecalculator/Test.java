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
        EditText karta1 = findViewById(R.id.karte);
        EditText karta2 = findViewById(R.id.karte2);
        EditText karta3 = findViewById(R.id.karte3);
        EditText board = findViewById(R.id.board);

        TestConsole c = null;
        String[] unos = {"-b","7d9dTs","JhJs","AdJd","KcQd"};

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!karta1.getText().toString().matches(""))
                {
                    unos[2] = karta1.getText().toString();
                }
                if(!karta2.getText().toString().matches(""))
                {
                    unos[3] = karta2.getText().toString();
                }
                if(!karta3.getText().toString().matches(""))
                {
                    unos[4] = karta3.getText().toString();
                }

                if(!board.getText().toString().matches(""))
                {
                    unos[1] = board.getText().toString();
                }

                System.out.println(String.format("Unos1 - %s Unos2 - %s Unos3 - %s Unos4 - %s", unos[0], unos[1], unos[2], unos[3]));



                try {
                    //c.test(unos, ispis);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });



    }


}