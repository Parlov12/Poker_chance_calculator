package com.example.pokerchancecalculator.Algoritam;

public class Card implements Comparable<Card>  {
	public enum Suit {
	    CLUB, DIAMOND, HEART, SPADE
	}


	// definiranje varijabli jacine i zoga karte
	private Suit mSuit;
	private CardRank mRank;

	public Card(Suit suit, CardRank rank) {
		mSuit = suit;
		mRank = rank;
	}

	public Suit getSuit() {
		return mSuit;
	}

	public CardRank getRank() {
		return mRank;
	}



	public static Card fromString(String value) throws Exception {
		// value je ono sta upisemo ko kartu u console tipa Js - jack spades
		if(value.length() != 2) 
			throw new Exception(String.format("Invalid card value: %s", value));

		//izvadi iz stringa vrijednost
		String strRank = value.substring(0, 1).toLowerCase();
		//izvadi iz stringa zog
		String strSuit = value.substring(1, 2).toLowerCase();
		
		// ovdi dodjeljujemo zog karti
		Suit suit;
		if(strSuit.equals("c"))			suit = Suit.CLUB;
		else if(strSuit.equals("d"))	suit = Suit.DIAMOND;
		else if(strSuit.equals("h"))	suit = Suit.HEART;
		else if(strSuit.equals("s"))	suit = Suit.SPADE;
		else
			throw new Exception(String.format("Invalid card suit: %s", strSuit));

		//ovdi dodjeljujemo jacinu karte
		CardRank rank;
		if(strRank.equals("t"))			rank = new CardRank(CardRank.TEN);
		else if(strRank.equals("j"))	rank = new CardRank(CardRank.JACK);
		else if(strRank.equals("q"))	rank = new CardRank(CardRank.QUEEN);
		else if(strRank.equals("k"))	rank = new CardRank(CardRank.KING);
		else if(strRank.equals("a"))	rank = new CardRank(CardRank.ACE);
		else {
			try {
				int numericRank = Integer.parseInt(strRank);
				if(numericRank >= 2 && numericRank <= 9) {
					rank = new CardRank(numericRank);
				}
				else {
					throw new Exception(String.format("Invalid card rank: %s", strRank));
				}
			}
			catch(NumberFormatException nfe) {
				throw new Exception(String.format("Invalid card rank: %s", strRank));
			}
		}


		return new Card(suit, rank);
	}


	@Override
	public String toString() {
		String strSuit = "";

		if(mSuit == Suit.CLUB)			strSuit = "c";
		else if(mSuit == Suit.DIAMOND)	strSuit = "d";
		else if(mSuit == Suit.HEART)	strSuit = "h";
		else if(mSuit == Suit.SPADE)	strSuit = "s";

		return this.getRank().toString() + strSuit;
	}


	@Override
	public int compareTo(Card c) {
		return c.getRank().ordinal() - this.getRank().ordinal();
	}


	//usporeduje karte vraca true ili false ovisno o tome jesu li iste
	@Override
	public boolean equals(Object other){
		if (other == null) return false;
		if (!(other instanceof Card)) return false;

		Card otherCard = (Card)other;
		return (otherCard.getSuit().ordinal() == this.getSuit().ordinal() && otherCard.getRank().equals(this.getRank()));
	}
}