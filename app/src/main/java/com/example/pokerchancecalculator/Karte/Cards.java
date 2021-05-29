package com.example.pokerchancecalculator.Karte;

import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pokerchancecalculator.MainActivity;
import com.example.pokerchancecalculator.R;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;


public class Cards{
    public  List<Card_model> s = new ArrayList<Card_model>();
    public  List<Card_model> c = new ArrayList<Card_model>();
    public  List<Card_model> h = new ArrayList<Card_model>();
    public List<Card_model> d = new ArrayList   <Card_model>();
    public Card_model[] table = new Card_model[5];
    public  List<Card_model> all_cards = new ArrayList<Card_model>();
    public Player[] igraci = new Player[9];

    public  List<Card_model> selectedCards = new ArrayList<Card_model>();
    public int i;
    // prazni objekt za popunit liste
    Card_model empty_card = new Card_model();
    Player empty_player = new Player();

    public Cards(){

        for(i = 0; i < 9; i++)
        {
            igraci[i] = empty_player;
        }

        for(i = 0; i < 5; i++)
        {
            table[i] = empty_card;
        }


        for(i = 0; i < 13; i++)
        {
            s.add(empty_card);
            h.add(empty_card);
            d.add(empty_card);
            c.add(empty_card);
        }

        // s
        s.get(0).setCard("s","A", R.drawable.pik_1);
        s.get(1).setCard("s","2", R.drawable.pik_2);
        s.get(2).setCard("s","3", R.drawable.pik_3);
        s.get(3).setCard("s","4", R.drawable.pik_4);
        s.get(4).setCard("s","5", R.drawable.pik_5);
        s.get(5).setCard("s","6", R.drawable.pik_6);
        s.get(6).setCard("s","7", R.drawable.pik_7);
        s.get(7).setCard("s","8", R.drawable.pik_8);
        s.get(8).setCard("s","9", R.drawable.pik_9);
        s.get(9).setCard("s","T", R.drawable.pik_10);
        s.get(10).setCard("s","J", R.drawable.pik_11);
        s.get(11).setCard("s","Q", R.drawable.pik_12);
        s.get(12).setCard("s","K", R.drawable.pik_13);

        // h
        h.get(0).setCard("h","A", R.drawable.herc_1);
        h.get(1).setCard("h","2", R.drawable.herc_2);
        h.get(2).setCard("h","3", R.drawable.herc_3);
        h.get(3).setCard("h","4", R.drawable.herc_4);
        h.get(4).setCard("h","5", R.drawable.herc_5);
        h.get(5).setCard("h","6", R.drawable.herc_6);
        h.get(6).setCard("h","7", R.drawable.herc_7);
        h.get(7).setCard("h","8", R.drawable.herc_8);
        h.get(8).setCard("h","9", R.drawable.herc_9);
        h.get(9).setCard("h","T", R.drawable.herc_10);
        h.get(10).setCard("h","J", R.drawable.herc_11);
        h.get(11).setCard("h","Q", R.drawable.herc_12);
        h.get(12).setCard("h","K", R.drawable.herc_13);

        // c
        c.get(0).setCard("c","A", R.drawable.tref_1);
        c.get(1).setCard("c","2", R.drawable.tref_2);
        c.get(2).setCard("c","3", R.drawable.tref_3);
        c.get(3).setCard("c","4", R.drawable.tref_4);
        c.get(4).setCard("c","5", R.drawable.tref_5);
        c.get(5).setCard("c","6", R.drawable.tref_6);
        c.get(6).setCard("c","7", R.drawable.tref_7);
        c.get(7).setCard("c","8", R.drawable.tref_8);
        c.get(8).setCard("c","9", R.drawable.tref_9);
        c.get(9).setCard("c","T", R.drawable.tref_10);
        c.get(10).setCard("c","J", R.drawable.tref_11);
        c.get(11).setCard("c","Q", R.drawable.tref_12);
        c.get(12).setCard("c","K", R.drawable.tref_13);

        // d
        d.get(0).setCard("d","A", R.drawable.karo_1);
        d.get(1).setCard("d","2", R.drawable.karo_2);
        d.get(2).setCard("d","3", R.drawable.karo_3);
        d.get(3).setCard("d","4", R.drawable.karo_4);
        d.get(4).setCard("d","5", R.drawable.karo_5);
        d.get(5).setCard("d","6", R.drawable.karo_6);
        d.get(6).setCard("d","7", R.drawable.karo_7);
        d.get(7).setCard("d","8", R.drawable.karo_8);
        d.get(8).setCard("d","9", R.drawable.karo_9);
        d.get(9).setCard("d","T", R.drawable.karo_10);
        d.get(10).setCard("d","J", R.drawable.karo_11);
        d.get(11).setCard("d","Q", R.drawable.karo_12);
        d.get(12).setCard("d","K", R.drawable.karo_13);

        for(i = 0; i < 52; i++)
        {
            all_cards.add(empty_card);
        }
        all_cards.set(0, new Card_model("s","A", R.drawable.pik_1));
        all_cards.set(1, new Card_model("s","2", R.drawable.pik_2));
        all_cards.set(2, new Card_model("s","3", R.drawable.pik_3));
        all_cards.set(3, new Card_model("s","4", R.drawable.pik_4));
        all_cards.set(4, new Card_model("s","5", R.drawable.pik_5));
        all_cards.set(5, new Card_model("s","6", R.drawable.pik_6));
        all_cards.set(6, new Card_model("s","7", R.drawable.pik_7));
        all_cards.set(7, new Card_model("s","8", R.drawable.pik_8));
        all_cards.set(8, new Card_model("s","9", R.drawable.pik_9));
        all_cards.set(9, new Card_model("s","T", R.drawable.pik_10));
        all_cards.set(10, new Card_model("s","J", R.drawable.pik_11));
        all_cards.set(11, new Card_model("s","Q", R.drawable.pik_12));
        all_cards.set(12, new Card_model("s","K", R.drawable.pik_13));

        all_cards.set(13, new Card_model("h","A", R.drawable.herc_1));
        all_cards.set(14, new Card_model("h","2", R.drawable.herc_2));
        all_cards.set(15, new Card_model("h","3", R.drawable.herc_3));
        all_cards.set(16, new Card_model("h","4", R.drawable.herc_4));
        all_cards.set(17, new Card_model("h","5", R.drawable.herc_5));
        all_cards.set(18, new Card_model("h","6", R.drawable.herc_6));
        all_cards.set(19, new Card_model("h","7", R.drawable.herc_7));
        all_cards.set(20, new Card_model("h","8", R.drawable.herc_8));
        all_cards.set(21, new Card_model("h","9", R.drawable.herc_9));
        all_cards.set(22, new Card_model("h","T", R.drawable.herc_10));
        all_cards.set(23, new Card_model("h","J", R.drawable.herc_11));
        all_cards.set(24, new Card_model("h","Q", R.drawable.herc_12));
        all_cards.set(25, new Card_model("h","K", R.drawable.herc_13));

        all_cards.set(26, new Card_model("c","A", R.drawable.tref_1));
        all_cards.set(27, new Card_model("c","2", R.drawable.tref_2));
        all_cards.set(28, new Card_model("c","3", R.drawable.tref_3));
        all_cards.set(29, new Card_model("c","4", R.drawable.tref_4));
        all_cards.set(30, new Card_model("c","5", R.drawable.tref_5));
        all_cards.set(31, new Card_model("c","6", R.drawable.tref_6));
        all_cards.set(32, new Card_model("c","7", R.drawable.tref_7));
        all_cards.set(33, new Card_model("c","8", R.drawable.tref_8));
        all_cards.set(34, new Card_model("c","9", R.drawable.tref_9));
        all_cards.set(35, new Card_model("c","T", R.drawable.tref_10));
        all_cards.set(36, new Card_model("c","J", R.drawable.tref_11));
        all_cards.set(37, new Card_model("c","Q", R.drawable.tref_12));
        all_cards.set(38, new Card_model("c","K", R.drawable.tref_13));

        all_cards.set(39, new Card_model("d","A", R.drawable.karo_1));
        all_cards.set(40, new Card_model("d","2", R.drawable.karo_2));
        all_cards.set(41, new Card_model("d","3", R.drawable.karo_3));
        all_cards.set(42, new Card_model("d","4", R.drawable.karo_4));
        all_cards.set(43, new Card_model("d","5", R.drawable.karo_5));
        all_cards.set(44, new Card_model("d","6", R.drawable.karo_6));
        all_cards.set(45, new Card_model("d","7", R.drawable.karo_7));
        all_cards.set(46, new Card_model("d","8", R.drawable.karo_8));
        all_cards.set(47, new Card_model("d","9", R.drawable.karo_9));
        all_cards.set(48, new Card_model("d","T", R.drawable.karo_10));
        all_cards.set(49, new Card_model("d","J", R.drawable.karo_11));
        all_cards.set(50, new Card_model("d","Q", R.drawable.karo_12));
        all_cards.set(51, new Card_model("d","K", R.drawable.karo_13));
        for(i = 0; i < 52; i++)
        {
            System.out.println(String.format("%d. karta -> %s %s", i+1, all_cards.get(i).getNumber(), all_cards.get(i).getType()));
        }


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

    // vrsta - s,h,c,d - zog
    // broj - redni broj karte u skupu vrste(0 do 12)
    // igrac - redni broj igraca(0-8)
    // red_br - 0 ili 1 tj 1. ili 2. karta pojedinog igraca
    public void addSelectedCardToPlayer(int vrsta, int broj, int igrac, int red_br)
    {
        int a = vrsta;
        int b = broj;
        int c = igrac;
        int d = red_br;
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
        System.out.println(String.format("vrst = %d, broj = %d, igrac = %d, red_br = %d", a,b,c,d));

        igraci[igrac].addCard(red_br, all_cards.get(f+broj));
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
        //
    }


}
