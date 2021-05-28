package com.example.pokerchancecalculator.Karte;

public class Card_model {

    private String type;
    private String number;
    private int pic;

    public Card_model()
    {
        type = null;
        number = null;
        pic = 0;
    }

    public Card_model(Card_model a)
    {
        type = a.type;
        number = a.number;
        pic = a.pic;
    }



    public Card_model(String vrsta, String broj, int slika)
    {
        this.type = vrsta;
        this.number = broj;
        this.pic = slika;
    }

    public void setCard(String vrsta, String broj, int slika)
    {
        this.type = vrsta;
        this.number = broj;
        this.pic = slika;
    }

    public String getType()
    {
        return type;
    }

    public String getNumber()
    {
        return number;
    }

    public int getPic()
    {
        return pic;
    }




    public void setCard(Card_model c)
    {
        type = c.type;
        number = c.number;
        pic = c.pic;
    }


}

