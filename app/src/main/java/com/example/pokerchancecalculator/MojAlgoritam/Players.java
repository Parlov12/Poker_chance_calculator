package com.example.pokerchancecalculator.MojAlgoritam;

public class Players {
    private Hand[] igraci = new Hand[9];
    public int num_of_players = 0;

    private Players()
    {

    }

    public void addPlayer(Hand a)
    {
        for(int i = 0; i < 9; i++)
        {
            if(igraci[i].getHand(i) == null)
            {
                igraci[i].setHand(a);
            }
        }
    }

    public Hand getPlayer(int i)
    {return igraci[i];}



}
