package com.example.pokerchancecalculator.Karte;

import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pokerchancecalculator.MainActivity;
import com.example.pokerchancecalculator.R;

import java.util.ArrayList;
import java.util.List;


public class Cards{
    public  List<Card_model> spades = new ArrayList<Card_model>();
    public  List<Card_model> clubs = new ArrayList<Card_model>();
    public  List<Card_model> hearts = new ArrayList<Card_model>();
    public  List<Card_model> diamonds = new ArrayList   <Card_model>();
    public List<Player> igraci = new ArrayList<Player>(9);
    public List<Card_model> table = new ArrayList<Card_model>(5);
    public  List<Card_model> all_cards = new ArrayList<Card_model>(52);


    public  List<Card_model> selectedCards = new ArrayList<Card_model>();
    public int i;
    // prazni objekt za popunit liste
    Card_model empty_card = new Card_model();
    Player empty_player = new Player();

    public Cards(){

        for(i = 0; i < 9; i++)
        {
            igraci.add(empty_player);
        }

        for(i = 0; i < 5; i++)
        {
            table.add(empty_card);
        }


        for(i = 0; i < 13; i++)
        {
            spades.add(empty_card);
            hearts.add(empty_card);
            diamonds.add(empty_card);
            clubs.add(empty_card);
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

        for(i = 0; i < 52; i++)
        {
            all_cards.add(empty_card);
        }
        all_cards.get(0).setCard("spades",1, R.drawable.pik_1);
        all_cards.get(1).setCard("spades",2, R.drawable.pik_2);
        all_cards.get(2).setCard("spades",3, R.drawable.pik_3);
        all_cards.get(3).setCard("spades",4, R.drawable.pik_4);
        all_cards.get(4).setCard("spades",5, R.drawable.pik_5);
        all_cards.get(5).setCard("spades",6, R.drawable.pik_6);
        all_cards.get(6).setCard("spades",7, R.drawable.pik_7);
        all_cards.get(7).setCard("spades",8, R.drawable.pik_8);
        all_cards.get(8).setCard("spades",9, R.drawable.pik_9);
        all_cards.get(9).setCard("spades",10, R.drawable.pik_10);
        all_cards.get(10).setCard("spades",11, R.drawable.pik_11);
        all_cards.get(11).setCard("spades",12, R.drawable.pik_12);
        all_cards.get(12).setCard("spades",13, R.drawable.pik_13);

        all_cards.get(13).setCard("hearts",1, R.drawable.herc_1);
        all_cards.get(14).setCard("hearts",2, R.drawable.herc_2);
        all_cards.get(15).setCard("hearts",3, R.drawable.herc_3);
        all_cards.get(16).setCard("hearts",4, R.drawable.herc_4);
        all_cards.get(17).setCard("hearts",5, R.drawable.herc_5);
        all_cards.get(18).setCard("hearts",6, R.drawable.herc_6);
        all_cards.get(19).setCard("hearts",7, R.drawable.herc_7);
        all_cards.get(20).setCard("hearts",8, R.drawable.herc_8);
        all_cards.get(21).setCard("hearts",9, R.drawable.herc_9);
        all_cards.get(22).setCard("hearts",10, R.drawable.herc_10);
        all_cards.get(23).setCard("hearts",11, R.drawable.herc_11);
        all_cards.get(24).setCard("hearts",12, R.drawable.herc_12);
        all_cards.get(25).setCard("hearts",13, R.drawable.herc_13);

        all_cards.get(26).setCard("clubs",1, R.drawable.tref_1);
        all_cards.get(27).setCard("clubs",2, R.drawable.tref_2);
        all_cards.get(28).setCard("clubs",3, R.drawable.tref_3);
        all_cards.get(29).setCard("clubs",4, R.drawable.tref_4);
        all_cards.get(30).setCard("clubs",5, R.drawable.tref_5);
        all_cards.get(31).setCard("clubs",6, R.drawable.tref_6);
        all_cards.get(32).setCard("clubs",7, R.drawable.tref_7);
        all_cards.get(33).setCard("clubs",8, R.drawable.tref_8);
        all_cards.get(34).setCard("clubs",9, R.drawable.tref_9);
        all_cards.get(35).setCard("clubs",10, R.drawable.tref_10);
        all_cards.get(36).setCard("clubs",11, R.drawable.tref_11);
        all_cards.get(37).setCard("clubs",12, R.drawable.tref_12);
        all_cards.get(38).setCard("clubs",13, R.drawable.tref_13);

        all_cards.get(39).setCard("diamonds",1, R.drawable.karo_1);
        all_cards.get(40).setCard("diamonds",2, R.drawable.karo_2);
        all_cards.get(41).setCard("diamonds",3, R.drawable.karo_3);
        all_cards.get(42).setCard("diamonds",4, R.drawable.karo_4);
        all_cards.get(43).setCard("diamonds",5, R.drawable.karo_5);
        all_cards.get(44).setCard("diamonds",6, R.drawable.karo_6);
        all_cards.get(45).setCard("diamonds",7, R.drawable.karo_7);
        all_cards.get(46).setCard("diamonds",8, R.drawable.karo_8);
        all_cards.get(47).setCard("diamonds",9, R.drawable.karo_9);
        all_cards.get(48).setCard("diamonds",10, R.drawable.karo_10);
        all_cards.get(49).setCard("diamonds",11, R.drawable.karo_11);
        all_cards.get(50).setCard("diamonds",12, R.drawable.karo_12);
        all_cards.get(51).setCard("diamonds",13, R.drawable.karo_13);
        
        
    }


    public void addSelectedCard(int vrsta, int broj)
    {
        int f = 0;
        if(vrsta == 0)
        {
            f = 0;
        }
        else if(vrsta == 1)
        {
            f = 13;
        }
        else if(vrsta == 2)
        {
            f = 26;
        }
        else if(vrsta == 3)
        {
            f = 39;
        }
        selectedCards.add(all_cards.get(f+broj));
    }

    public void addSelectedCardToPlayer(int vrsta, int broj, int igrac, int red_br)
    {
        int f = 0;
        if(vrsta == 0)
        {
            f = 0;
        }
        else if(vrsta == 1)
        {
            f = 13;
        }
        else if(vrsta == 2)
        {
            f = 26;
        }
        else if(vrsta == 3)
        {
            f = 39;
        }
        igraci.get(igrac).addCard(red_br, all_cards.get(f+broj));
    }

    public void addTableCard(int vrsta, int broj) {
        int f = 0;
        if (vrsta == 0) {
            f = 0;
        } else if (vrsta == 1) {
            f = 13;
        } else if (vrsta == 2) {
            f = 26;
        } else if (vrsta == 3) {
            f = 39;
        }
        else
        {
            // do nothing
        }
        table.add(all_cards.get(f + broj));
    }


}
