package com.example.pokerchancecalculator.Karte;

import android.util.Log;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Player {
    public Card_model[] cards = new Card_model[2];
    Card_model empty_card = new Card_model();



    public Player()
    {

        cards[0] =  new Card_model("null","null",0);
        cards[1] = new Card_model("null","null",0);
    }

    public Player(int i,Card_model a)
    {
        if(i == 0)
        {
            cards[0].setCard(a);
        }
        if(i == 1)
        {
            cards[1].setCard(a);
        }
    }




    public void addCard(int i, Card_model a)
    {

       if(i == 0) {
           cards[0] = a;
       }
       else if(i == 1) {
           cards[1] = a;
       }
       else {
           System.out.println("Error - Player class!");
       }


    }

    public void sysOut()
    {
        System.out.println(String.format("1.karta - %s %s\n2. karta - %s %s", cards[0].getNumber(), cards[0].getType(), cards[1].getNumber(), cards[1].getType()));
    }
}
