package com.example.pokerchancecalculator.Karte;

import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pokerchancecalculator.MainActivity;
import com.example.pokerchancecalculator.R;

import java.util.ArrayList;
import java.util.List;


public class Cards{
    public  List<Card_model> all_cards = new ArrayList<Card_model>();
    public  List<Card_model> spades = new ArrayList<Card_model>();
    public  List<Card_model> clubs = new ArrayList<Card_model>();
    public  List<Card_model> hearts = new ArrayList<Card_model>();
    public  List<Card_model> diamonds = new ArrayList<Card_model>();
    public List<Player> igraci = new ArrayList<Player>(9);
    public List<Card_model> table = new ArrayList<Card_model>(5);

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


        for(i = 0; i < 9; i++)
        {
            igraci.add(empty_player);
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

        all_cards.addAll(spades);
        all_cards.addAll(clubs);
        all_cards.addAll(hearts);
        all_cards.addAll(diamonds);
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
