package com.example.pokerchancecalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.opengl.Visibility;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.pokerchancecalculator.Karte.Card_model;
import com.example.pokerchancecalculator.Karte.Cards;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int currentImageView = 0;
    ImageView choosenImageView = null;
    String TAG = "TAG";
    int i = 0;
    Drawable draw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate created");

        LinearLayout dialog_cards_view = findViewById(R.id.dialog_frame);
        dialog_cards_view.setVisibility(View.INVISIBLE);


        Cards karte = new Cards();
        String s;

        Handler handler = new Handler();



        Resources res = getResources();
        Drawable foreground = ResourcesCompat.getDrawable(res, R.drawable.foreground_selector, null);
        Drawable foreground_null = ResourcesCompat.getDrawable(res, R.drawable.foreground_null, null);





        //      KARTE U RUCI POJEDINOG IGRAČA TE TextView ZA STATISTIKU
        // karte pojedinog igraca imaju id po modelu -> player<broj>_card<1/2>
        // a statistika pojedinog igrača je označena po modelu win_stats<broj igrača>,
        // draw_stats<broj igrača>, lose_stats<broj igrača>

        ImageView p1_c1 = findViewById(R.id.player1_card1);
        ImageView p1_c2 = findViewById(R.id.player1_card2);
        TextView win1 = findViewById(R.id.win_stats1);
        TextView draw1 = findViewById(R.id.draw_stats1);
        TextView lose1 = findViewById(R.id.lose_stats1);

        ImageView p2_c1 = findViewById(R.id.player2_card1);
        ImageView p2_c2 = findViewById(R.id.player2_card2);
        TextView win2 = findViewById(R.id.win_stats2);
        TextView draw2 = findViewById(R.id.draw_stats2);
        TextView lose2 = findViewById(R.id.lose_stats2);

        ImageView p3_c1 = findViewById(R.id.player3_card1);
        ImageView p3_c2 = findViewById(R.id.player3_card2);
        TextView win3 = findViewById(R.id.win_stats3);
        TextView draw3 = findViewById(R.id.draw_stats3);
        TextView lose3 = findViewById(R.id.lose_stats3);

        ImageView p4_c1 = findViewById(R.id.player4_card1);
        ImageView p4_c2 = findViewById(R.id.player4_card2);
        TextView win4 = findViewById(R.id.win_stats4);
        TextView draw4 = findViewById(R.id.draw_stats4);
        TextView lose4 = findViewById(R.id.lose_stats4);

        ImageView p5_c1 = findViewById(R.id.player5_card1);
        ImageView p5_c2 = findViewById(R.id.player5_card2);
        TextView win5 = findViewById(R.id.win_stats5);
        TextView draw5 = findViewById(R.id.draw_stats5);
        TextView lose5 = findViewById(R.id.lose_stats5);

        ImageView p6_c1 = findViewById(R.id.player6_card1);
        ImageView p6_c2 = findViewById(R.id.player6_card2);
        TextView win6 = findViewById(R.id.win_stats6);
        TextView draw6 = findViewById(R.id.draw_stats6);
        TextView lose6 = findViewById(R.id.lose_stats6);

        ImageView p7_c1 = findViewById(R.id.player7_card1);
        ImageView p7_c2 = findViewById(R.id.player7_card2);
        TextView win7 = findViewById(R.id.win_stats7);
        TextView draw7 = findViewById(R.id.draw_stats7);
        TextView lose7 = findViewById(R.id.lose_stats7);

        ImageView p8_c1 = findViewById(R.id.player8_card1);
        ImageView p8_c2 = findViewById(R.id.player8_card2);
        TextView win8 = findViewById(R.id.win_stats8);
        TextView draw8 = findViewById(R.id.draw_stats8);
        TextView lose8 = findViewById(R.id.lose_stats8);

        ImageView p9_c1 = findViewById(R.id.player9_card1);
        ImageView p9_c2 = findViewById(R.id.player9_card2);
        TextView win9 = findViewById(R.id.win_stats9);
        TextView draw9 = findViewById(R.id.draw_stats9);
        TextView lose9 = findViewById(R.id.lose_stats9);

        // KARTE KOJE ODABEREMO KAD SE OTVORI DIJALOSKI OVKIR
        ImageView k1 = findViewById(R.id.karta_1);
        ImageView k2 = findViewById(R.id.karta_2);
        ImageView k3 = findViewById(R.id.karta_3);
        ImageView k4 = findViewById(R.id.karta_4);
        ImageView k5 = findViewById(R.id.karta_5);
        ImageView k6 = findViewById(R.id.karta_6);
        ImageView k7 = findViewById(R.id.karta_7);
        ImageView k8 = findViewById(R.id.karta_8);
        ImageView k9 = findViewById(R.id.karta_9);
        ImageView k10 = findViewById(R.id.karta_10);
        ImageView k11 = findViewById(R.id.karta_11);
        ImageView k12 = findViewById(R.id.karta_12);
        ImageView k13 = findViewById(R.id.karta_13);

        List<ImageView> dialogCards = new ArrayList<ImageView>();
        dialogCards.add(k1);
        dialogCards.add(k2);
        dialogCards.add(k3);
        dialogCards.add(k4);
        dialogCards.add(k5);
        dialogCards.add(k6);
        dialogCards.add(k7);
        dialogCards.add(k8);
        dialogCards.add(k9);
        dialogCards.add(k10);
        dialogCards.add(k11);
        dialogCards.add(k12);
        dialogCards.add(k13);

        List<ImageView> playerCards = new ArrayList<ImageView>();
        playerCards.add(p1_c1);
        playerCards.add(p1_c2);
        playerCards.add(p2_c1);
        playerCards.add(p2_c2);
        playerCards.add(p3_c1);
        playerCards.add(p3_c2);
        playerCards.add(p4_c1);
        playerCards.add(p4_c2);
        playerCards.add(p5_c1);
        playerCards.add(p5_c2);
        playerCards.add(p6_c1);
        playerCards.add(p6_c2);
        playerCards.add(p7_c1);
        playerCards.add(p7_c2);
        playerCards.add(p8_c1);
        playerCards.add(p8_c2);
        playerCards.add(p9_c1);
        playerCards.add(p9_c2);



        setSpades(dialogCards);

        ImageView spades = findViewById(R.id.spades);
        ImageView hearts = findViewById(R.id.hearts);
        ImageView clubs = findViewById(R.id.clubs);
        ImageView diamonds = findViewById(R.id.diamonds);

        spades.setForeground(foreground);


        // CLICK LISTENERS
        spades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSpades(dialogCards);
                spades.setForeground(foreground);
                hearts.setForeground(foreground_null);
                clubs.setForeground(foreground_null);
                diamonds.setForeground(foreground_null);
            }
        });

        hearts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setHearts(dialogCards);
                spades.setForeground(foreground_null);
                hearts.setForeground(foreground);
                clubs.setForeground(foreground_null);
                diamonds.setForeground(foreground_null);
            }
        });

        clubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setClubs(dialogCards);
                spades.setForeground(foreground_null);
                hearts.setForeground(foreground_null);
                clubs.setForeground(foreground);
                diamonds.setForeground(foreground_null);
            }
        });

        diamonds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDiamonds(dialogCards);
                spades.setForeground(foreground_null);
                hearts.setForeground(foreground_null);
                clubs.setForeground(foreground_null);
                diamonds.setForeground(foreground);
            }
        });

        for(i = 0; i < playerCards.size()-1; i++)
        {
            playerCards.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openDialog(i, dialog_cards_view, playerCards.get(i));
                }
            });
        }

        for(i = 0; i < dialogCards.size()-1; i++)
        {
            dialogCards.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    closeDialog(dialog_cards_view, dialogCards.get(i), playerCards);
                }
            });
        }

    }

    public void openDialog(int l, LinearLayout dialog, ImageView m)
    {
        System.out.println("Dialog opened!");
        dialog.setVisibility(View.VISIBLE);
        saveCurrentCard(l);
        currentImageView = l;
    }

    public void closeDialog(LinearLayout dialog, ImageView m, List<ImageView> lista)
    {
        System.out.println("Dialog closed!");
        dialog.setVisibility(View.INVISIBLE);
        draw = m.getDrawable();
        lista.get(currentImageView).setImageDrawable(draw);

    }


    public void setSpades(List<ImageView> a) {
        a.get(0).setImageResource(R.drawable.pik_1);
        a.get(1).setImageResource(R.drawable.pik_2);
        a.get(2).setImageResource(R.drawable.pik_3);
        a.get(3).setImageResource(R.drawable.pik_4);
        a.get(4).setImageResource(R.drawable.pik_5);
        a.get(5).setImageResource(R.drawable.pik_6);
        a.get(6).setImageResource(R.drawable.pik_7);
        a.get(7).setImageResource(R.drawable.pik_8);
        a.get(8).setImageResource(R.drawable.pik_9);
        a.get(9).setImageResource(R.drawable.pik_10);
        a.get(10).setImageResource(R.drawable.pik_11);
        a.get(11).setImageResource(R.drawable.pik_12);
        a.get(12).setImageResource(R.drawable.pik_13);
    }

    public void setClubs(List<ImageView> a) {
        a.get(0).setImageResource(R.drawable.tref_1);
        a.get(1).setImageResource(R.drawable.tref_2);
        a.get(2).setImageResource(R.drawable.tref_3);
        a.get(3).setImageResource(R.drawable.tref_4);
        a.get(4).setImageResource(R.drawable.tref_5);
        a.get(5).setImageResource(R.drawable.tref_6);
        a.get(6).setImageResource(R.drawable.tref_7);
        a.get(7).setImageResource(R.drawable.tref_8);
        a.get(8).setImageResource(R.drawable.tref_9);
        a.get(9).setImageResource(R.drawable.tref_10);
        a.get(10).setImageResource(R.drawable.tref_11);
        a.get(11).setImageResource(R.drawable.tref_12);
        a.get(12).setImageResource(R.drawable.tref_13);
    }

    public void setHearts(List<ImageView> a) {
        a.get(0).setImageResource(R.drawable.herc_1);
        a.get(1).setImageResource(R.drawable.herc_2);
        a.get(2).setImageResource(R.drawable.herc_3);
        a.get(3).setImageResource(R.drawable.herc_4);
        a.get(4).setImageResource(R.drawable.herc_5);
        a.get(5).setImageResource(R.drawable.herc_6);
        a.get(6).setImageResource(R.drawable.herc_7);
        a.get(7).setImageResource(R.drawable.herc_8);
        a.get(8).setImageResource(R.drawable.herc_9);
        a.get(9).setImageResource(R.drawable.herc_10);
        a.get(10).setImageResource(R.drawable.herc_11);
        a.get(11).setImageResource(R.drawable.herc_12);
        a.get(12).setImageResource(R.drawable.herc_13);
    }

    public void setDiamonds(List<ImageView> a) {
        a.get(0).setImageResource(R.drawable.karo_1);
        a.get(1).setImageResource(R.drawable.karo_2);
        a.get(2).setImageResource(R.drawable.karo_3);
        a.get(3).setImageResource(R.drawable.karo_4);
        a.get(4).setImageResource(R.drawable.karo_5);
        a.get(5).setImageResource(R.drawable.karo_6);
        a.get(6).setImageResource(R.drawable.karo_7);
        a.get(7).setImageResource(R.drawable.karo_8);
        a.get(8).setImageResource(R.drawable.karo_9);
        a.get(9).setImageResource(R.drawable.karo_10);
        a.get(10).setImageResource(R.drawable.karo_11);
        a.get(11).setImageResource(R.drawable.karo_12);
        a.get(12).setImageResource(R.drawable.karo_13);
    }

    public void saveCurrentCard(int num)
    {
        SharedPreferences sharedPref = getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("NUMBER", num);
        editor.commit();
    }

    public void loadCurrentCard()
    {
        SharedPreferences sharedPref = getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
        currentImageView = sharedPref.getInt("NUMBER", 0);
    }




}

