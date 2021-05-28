package com.example.pokerchancecalculator.Karte;

import android.widget.ImageView;

public class DialogCards {
    Boolean check;
    ImageView img;

    public DialogCards()
    {
        check = true;
        img = null;
    }

    public void setDialogCard(ImageView i, Boolean b)
    {
        img = i;
        check = b;
    }
}
