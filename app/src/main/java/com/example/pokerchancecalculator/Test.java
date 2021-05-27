package com.example.pokerchancecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pokerchancecalculator.Algoritam.EquityCalculator;
import com.example.pokerchancecalculator.Algoritam.Hand;
import com.example.pokerchancecalculator.Algoritam.HandEquity;
import com.example.pokerchancecalculator.Algoritam.HandRanking;

import java.util.ArrayList;

public class Test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Button calc = findViewById(R.id.calculate);
        TextView ispis = findViewById(R.id.ispis);
        EditText karte = findViewById(R.id.karte);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String unos = karte.getText().toString();

                //KOPIRANO
                boolean isBoard = false;
                String board = "";
                ArrayList<String> handsStr = new ArrayList<>();
                ArrayList<Hand> hands = new ArrayList<>();
                String[] uneseneKarte = unos.split("\\s+");

                for (int i = 0; i < uneseneKarte.length; i++) {
                    uneseneKarte[i] = uneseneKarte[i].replaceAll("[^\\w]", "");
                    if(uneseneKarte[i].equals("-b")) {
                        isBoard = true;
                        continue;
                    }


                    if(isBoard) {
                        board = uneseneKarte[i];
                        isBoard = false;
                    }
                    else {
                        handsStr.add(uneseneKarte[i]);
                    }
                }

                EquityCalculator calculator = new EquityCalculator();
                calculator.setMaxIterations(200000);

                // ako ima nesto na ploci, napravi plocu iz zadanog stringa
                if(!board.isEmpty()) {
                    try {
                        calculator.setBoardFromString(board);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                // za svaku ruku napravi objekt klase Hand (koji predstavlja igracevu ruku)
                for(int i = 0; i < handsStr.size(); i++) {
                    Hand h = null;
                    try {
                        h = Hand.fromString(handsStr.get(i));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    hands.add(h);
                    // u kalkulator dodaje ruke
                    calculator.addHand(h);
                }

                // objekt kalkulator racuna postotke, ovi longovi mjere potrebno vrijeme (ovo ce dobro doc kod loading komponente)
                long startTime = System.currentTimeMillis();
                try {
                    calculator.calculate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                long elapsedTime = System.currentTimeMillis() - startTime;

                //kalkulator ispisuje plocu
                calculator.printBoard();
                System.out.println("");
                Log.d("matejekralj", String.valueOf(hands.size()));

                for(int i = 0; i < hands.size(); i++) {

                    HandRanking hr = calculator.getHandRanking(i);
                    HandEquity he = calculator.getHandEquity(i);

                    String preprend = calculator.boardIsEmpty() ? "~" : "";

                    System.out.println(String.format("Player %d: %s - %s --- %s%s", 1+i, hands.get(i), hr, preprend, he));
                }


                if(calculator.boardIsEmpty()) {
                    float elapsedSeconds = elapsedTime / 1000.0f;

                    System.out.println("");
                    //getMaxIterations() racuna koliko smo simulacija proveli, elapsedSeconds je vrijeme racunanje simulacija i postotaka
                    System.out.println(String.format("Simulated %d random boards in %.1f seconds", calculator.getMaxIterations(), elapsedSeconds));
                }

                //KRAJ KOPIRANJA

            }
        });
    }
}