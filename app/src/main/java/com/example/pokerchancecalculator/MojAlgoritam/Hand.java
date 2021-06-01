package com.example.pokerchancecalculator.MojAlgoritam;

import com.example.pokerchancecalculator.Karte.Card_model;

public class Hand {
    private Card[] hand = new Card[2];
    private int num = 0;

    private Hand()
    {

    }

    public Card getHand(int i)
    {
        return hand[i];
    }

    public void setHand(Hand a)
    {
        hand[0] = a.getHand(0);
        hand[1] = a.getHand(1);
    }

}
