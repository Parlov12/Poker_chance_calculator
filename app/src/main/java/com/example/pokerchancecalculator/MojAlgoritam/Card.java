package com.example.pokerchancecalculator.MojAlgoritam;

public class Card {
    String type;
    String number;


    private Card()
    {
        type = null;
        number = null;
    }

    public void setCard(String a, String b)
    {
        this.type = a;
        this.number = b;
    }

    public void setCard(Card a)
    {
        this.type = a.type;
        this.number = a.number;
    }

    public String getType()
    {return type;}
    public String getNumber()
    {return number;}


}
