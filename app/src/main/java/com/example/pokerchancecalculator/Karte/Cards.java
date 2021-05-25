package com.example.pokerchancecalculator.Karte;

import com.example.pokerchancecalculator.R;

import java.util.ArrayList;
import java.util.List;

public class Cards{
    // 5 lista od kojih ce 4 njih sluzit meni za prikaz karata u dijaloskom okviru,
    // a jedna lista je di su sve karte
    List<Card_model> spades = new ArrayList<Card_model>();
    List<Card_model> hearts = new ArrayList<Card_model>();
    List<Card_model> diamonds = new ArrayList<Card_model>();
    List<Card_model> clubs = new ArrayList<Card_model>();
    List<Card_model> all_cards = new ArrayList<Card_model>();
    int i = 0;
    // prazni objekt za popunit liste
    Card_model empty_object = new Card_model();

    public Cards(){
        for(i = 0; i < 13; i++)
        {
            spades.add(empty_object);
            hearts.add(empty_object);
            diamonds.add(empty_object);
            clubs.add(empty_object);
        }
        for(i = 0; i < 52; i++)
        {
            all_cards.add(empty_object);
        }

        // SPADES
        spades.get(0).setCard("spades",1, R.drawable.pik_1);
        spades.get(1).setCard("spades",2, R.drawable.pik_2);
        spades.get(2).setCard("spades",3, R.drawable.pik_3);
        spades.get(3).setCard("spades",4, R.drawable.pik_4);
        spades.get(4).setCard("spades",5, R.drawable.pik_5);
        spades.get(5).setCard("spades",6, R.drawable.pik_6);
        spades.get(6).setCard("spades",7, R.drawable.pik_7);
        spades.get(7).setCard("spades",8, R.drawable.pik_8);
        spades.get(8).setCard("spades",9, R.drawable.pik_9);
        spades.get(9).setCard("spades",10, R.drawable.pik_10);
        spades.get(10).setCard("spades",11, R.drawable.pik_11);
        spades.get(11).setCard("spades",12, R.drawable.pik_12);
        spades.get(12).setCard("spades",13, R.drawable.pik_13);

        // HEARTS
        hearts.get(0).setCard("hearts",1, R.drawable.herc_1);
        hearts.get(1).setCard("hearts",2, R.drawable.herc_2);
        hearts.get(2).setCard("hearts",3, R.drawable.herc_3);
        hearts.get(3).setCard("hearts",4, R.drawable.herc_4);
        hearts.get(4).setCard("hearts",5, R.drawable.herc_5);
        hearts.get(5).setCard("hearts",6, R.drawable.herc_6);
        hearts.get(6).setCard("hearts",7, R.drawable.herc_7);
        hearts.get(7).setCard("hearts",8, R.drawable.herc_8);
        hearts.get(8).setCard("hearts",9, R.drawable.herc_9);
        hearts.get(9).setCard("hearts",10, R.drawable.herc_10);
        hearts.get(10).setCard("hearts",11, R.drawable.herc_11);
        hearts.get(11).setCard("hearts",12, R.drawable.herc_12);
        hearts.get(12).setCard("hearts",13, R.drawable.herc_13);

        // CLUBS
        clubs.get(0).setCard("clubs",1, R.drawable.tref_1);
        clubs.get(1).setCard("clubs",2, R.drawable.tref_2);
        clubs.get(2).setCard("clubs",3, R.drawable.tref_3);
        clubs.get(3).setCard("clubs",4, R.drawable.tref_4);
        clubs.get(4).setCard("clubs",5, R.drawable.tref_5);
        clubs.get(5).setCard("clubs",6, R.drawable.tref_6);
        clubs.get(6).setCard("clubs",7, R.drawable.tref_7);
        clubs.get(7).setCard("clubs",8, R.drawable.tref_8);
        clubs.get(8).setCard("clubs",9, R.drawable.tref_9);
        clubs.get(9).setCard("clubs",10, R.drawable.tref_10);
        clubs.get(10).setCard("clubs",11, R.drawable.tref_11);
        clubs.get(11).setCard("clubs",12, R.drawable.tref_12);
        clubs.get(12).setCard("clubs",13, R.drawable.tref_13);
        
        // DIAMONDS
        diamonds.get(0).setCard("diamonds",1, R.drawable.karo_1);
        diamonds.get(1).setCard("diamonds",2, R.drawable.karo_2);
        diamonds.get(2).setCard("diamonds",3, R.drawable.karo_3);
        diamonds.get(3).setCard("diamonds",4, R.drawable.karo_4);
        diamonds.get(4).setCard("diamonds",5, R.drawable.karo_5);
        diamonds.get(5).setCard("diamonds",6, R.drawable.karo_6);
        diamonds.get(6).setCard("diamonds",7, R.drawable.karo_7);
        diamonds.get(7).setCard("diamonds",8, R.drawable.karo_8);
        diamonds.get(8).setCard("diamonds",9, R.drawable.karo_9);
        diamonds.get(9).setCard("diamonds",10, R.drawable.karo_10);
        diamonds.get(10).setCard("diamonds",11, R.drawable.karo_11);
        diamonds.get(11).setCard("diamonds",12, R.drawable.karo_12);
        diamonds.get(12).setCard("diamonds",13, R.drawable.karo_13);
    }

}
