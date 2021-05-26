package com.example.pokerchancecalculator.Karte;

import android.util.Log;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Player {
    public List<Card_model> cards = new ArrayList<Card_model>(2);
    Card_model empty_card = new Card_model();

    public Player()
    {
        cards.add(empty_card);
        cards.add(empty_card);

        cards.get(0).setCard("null",0,0);
        cards.get(1).setCard("null",0,0);
    }

    public void addCard1(Card_model a)
    {
        cards.get(0).number = a.number;
        cards.get(0).type = a.type;
        cards.get(0).pic = a.pic;
    }

    public void addCard2(Card_model a)
    {
        cards.get(1).number = a.number;
        cards.get(1).type = a.type;
        cards.get(1).pic = a.pic;
    }

    public void addCard(int i, Card_model a)
    {
        if(i == 0)
        {
            addCard1(a);
        }
        else if(i == 1)
        {
            addCard2(a);
        }
        else
        {
            Log.d("PLAYER CLASS", "Error");
        }
    }
}
