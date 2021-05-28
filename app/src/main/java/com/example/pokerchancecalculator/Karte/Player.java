package com.example.pokerchancecalculator.Karte;

import android.util.Log;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private Card_model[] cards = new Card_model[2];
    Card_model empty_card = new Card_model();



    public Player()
    {
        cards.add(empty_card);
        cards.add(empty_card);

        cards[0] =  new Card_model("null","null",0);
        cards[1] = new Card_model("null","null",0);
    }

    public Player(Card_model a, Card_model b)
    {
        cards.add(empty_card);
        cards.add(empty_card);

        cards.set(0, new Card_model(a));
        cards.set(1, new Card_model(b));
    }

    public Player(int i,Card_model a)
    {
        cards.add(empty_card);
        cards.add(empty_card);
        if(i == 0)
        {
            cards.set(0, a);
        }
        if(i == 1)
        {
            cards.set(1, a);
        }    }

        public Card_model getFirstCard()
        {
            return cards.get(0);
        }

        public Card_model getSecondCard()
        {
            return cards.get(1);
        }



    public void addCard(int i, Card_model a)
    {

       if(i == 0) {
           cards.set(0, new Card_model(a.getNumber(),a.getType(),0));
       }
       else if(i == 1) {
           cards.set(1, new Card_model(a.getNumber(),a.getType(),0));
       }
       else {
           System.out.println("Error - Player class!");
       }


    }

    public void sysOut()
    {
        System.out.println(String.format("1.karta - %s %s\n2. karta - %s %s", cards.get(0).getNumber(), cards.get(0).getType(), cards.get(0).getNumber(), cards.get(0).getType()));
    }
}
