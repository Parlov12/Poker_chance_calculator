package com.example.pokerchancecalculator.Karte;

public class Card_model {

    public String type;
    public int number;
    public int pic;

    public Card_model()
    {
        type = null;
        number = 0;
        pic = 0;
    }

    public void setCard(String vrsta, int broj, int slika)
    {
        type = vrsta;
        number = broj;
        pic = slika;
    }

    public void setCard(Card_model c)
    {
        type = c.type;
        number = c.number;
        pic = c.pic;
    }


}

