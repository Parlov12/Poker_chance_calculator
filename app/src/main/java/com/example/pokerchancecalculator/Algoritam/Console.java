package com.example.pokerchancecalculator.Algoritam;

import java.util.ArrayList;

public class Console
{
	public static void main(String[] args) throws Exception
	{
		boolean isBoard = false;
		String board = "";
		ArrayList<String> handsStr = new ArrayList<>();
		ArrayList<Hand> hands = new ArrayList<>();

		//odavde iscitavas sta je korisnik unia u konzolu. Nakon '-b' kupi string koji predstavalja plocu a nakon toga kupi stringove koji
		//predstavljaju ruke
		// u redu
		for (String s: args) {
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

		if(handsStr.size() < 2) {
			throw new Exception("You must enter at least 2 hands");
			// hm
		}




		// stvara objekt klase kalkulator koji zapravo racuna postotke
		EquityCalculator calculator = new EquityCalculator();
		calculator.setMaxIterations(1000);

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

			System.out.println(String.format("Player %d: %s - %s --- %s%s", 1+i, hands.get(i), hr, preprend, he));
		}


		if(calculator.boardIsEmpty()) {
			float elapsedSeconds = elapsedTime / 1000.0f;
			
			System.out.println("");
			//getMaxIterations() racuna koliko smo simulacija proveli, elapsedSeconds je vrijeme racunanje simulacija i postotaka
			System.out.println(String.format("Simulated %d random boards in %.1f seconds", calculator.getMaxIterations(), elapsedSeconds));
		}
	}
}