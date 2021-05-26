package com.example.pokerchancecalculator.Karte;

import android.widget.ImageView;

import com.example.pokerchancecalculator.R;

import java.util.ArrayList;
import java.util.List;


public class Cards{
    public  List<Card_model> all_cards = new ArrayList<Card_model>();
    public int i;
    // prazni objekt za popunit liste
    Card_model empty_object = new Card_model();

    public Cards(){
        i = 0;

        for(i = 0; i < 52; i++)
        {
            all_cards.add(empty_object);
        }

    }

}
