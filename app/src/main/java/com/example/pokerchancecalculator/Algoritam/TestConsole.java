package com.example.pokerchancecalculator.Algoritam;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TestConsole
{
	// prominit ćeš da test prima array textview-ova
	//
	public static void test(String[] args, TextView[] c) throws Exception {
		Log.d("TAG","Test started");

		boolean isBoard = false;
		String board = "";
		ArrayList<String> handsStr = new ArrayList<>();
		ArrayList<Hand> hands = new ArrayList<>();

		System.out.println("Test console");
		for (String s: args) {
			System.out.println(s);
			if(s.equals("-b")) {
				isBoard = true;
				continue;
			}


			if(isBoard) {
				board = s;
				isBoard = false;
			}
			else {
				handsStr.add(s);
			}
		}
		System.out.println("Test console - kraj");

		if(handsStr.size() < 2) {
			throw new Exception("You must enter at least 2 hands");
			// hm
		}




		// stvara objekt klase kalkulator koji zapravo racuna postotke
		EquityCalculator calculator = new EquityCalculator();
		calculator.setMaxIterations(200000);

		// ako ima nesto na ploci, napravi plocu iz zadanog stringa
		if(!board.isEmpty()) {
			calculator.setBoardFromString(board);
		}
		
		// za svaku ruku napravi objekt klase Hand (koji predstavlja igracevu ruku)
		for(int i = 0; i < handsStr.size(); i++) {
			Hand h = Hand.fromString(handsStr.get(i));
			hands.add(h);
			// u kalkulator dodaje ruke
			calculator.addHand(h);
		}

		// objekt kalkulator racuna postotke, ovi longovi mjere potrebno vrijeme (ovo ce dobro doc kod loading komponente)
		long startTime = System.currentTimeMillis();
		calculator.calculate();
		long elapsedTime = System.currentTimeMillis() - startTime;

		//kalkulator ispisuje plocu
		calculator.printBoard();
		System.out.println("");

		
		for(int i = 0; i < hands.size(); i++) {
			HandRanking hr = calculator.getHandRanking(i);
			HandEquity he = calculator.getHandEquity(i);

			String preprend = calculator.boardIsEmpty() ? "~" : "";

			System.out.println(String.format("Player %d: %s - %s --- %s%s\n", 1+i, hands.get(i), hr, preprend, he));
			c[i].setText(String.format("%s - %s --- %s%s", hands.get(i), hr, preprend, he));
		}


		if(calculator.boardIsEmpty()) {
			float elapsedSeconds = elapsedTime / 1000.0f;
			
			System.out.println("");
			//getMaxIterations() racuna koliko smo simulacija proveli, elapsedSeconds je vrijeme racunanje simulacija i postotaka
			System.out.println(String.format("Simulated %d random boards in %.1f seconds", calculator.getMaxIterations(), elapsedSeconds));

			Log.d("TAG","Test completed");


		}

		Log.d("TAG","Test completed");

	}
}