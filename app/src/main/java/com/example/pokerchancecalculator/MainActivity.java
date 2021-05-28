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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pokerchancecalculator.Algoritam.Card;
import com.example.pokerchancecalculator.Algoritam.TestConsole;
import com.example.pokerchancecalculator.Karte.Card_model;
import com.example.pokerchancecalculator.Karte.Cards;
import com.example.pokerchancecalculator.Karte.Player;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int currentImageView = 0;
    ImageView choosenImageView = null;
    String TAG = "TAG";
    int i = 0;
    Drawable draw;
    int vrsta = 0;
    int num = 0;
    int igrac = 0;
    int karta = 1;
    int tableInd = 0;
    Boolean checkTable = false;
    public Player[] players = new Player[9];
    public Card_model[] table = new Card_model[5];

    //definira si varijable -> objekt klase TestConsole i array String koji će sadržavat ruke svih igraća i opcionalno ploču
    TestConsole c = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (i = 0; i < 9; i++) {
            players[i] = new Player();
        }

        for (i = 0; i < 5; i++) {
            table[i] = new Card_model();
        }


        // test
        Intent startTest = new Intent(MainActivity.this, Test.class);
        startTest.putExtra("key", 0); //Optional parameters

        Button testniButton = findViewById(R.id.test);
        //kraj test

        Log.d(TAG, "onCreate created");

        LinearLayout dialog_cards_view = findViewById(R.id.dialog_frame);
        dialog_cards_view.setVisibility(View.INVISIBLE);


        Cards karte = new Cards();
        String s;

        Handler handler = new Handler();


        Resources res = getResources();
        Drawable foreground = ResourcesCompat.getDrawable(res, R.drawable.foreground_selector, null);
        Drawable foreground_null = ResourcesCompat.getDrawable(res, R.drawable.foreground_null, null);

        info();


        //      KARTE U RUCI POJEDINOG IGRAČA TE TextView ZA STATISTIKU
        // karte pojedinog igraca imaju id po modelu -> player<broj>_card<1/2>
        // a statistika pojedinog igrača je označena po modelu win_stats<broj igrača>,
        // draw_stats<broj igrača>, lose_stats<broj igrača>

        TextView[] textViews = new TextView[9];

        ImageView p1_c1 = findViewById(R.id.player1_card1);
        ImageView p1_c2 = findViewById(R.id.player1_card2);
        textViews[0] = findViewById(R.id.win_stats1);
        TextView draw1 = findViewById(R.id.draw_stats1);
        TextView lose1 = findViewById(R.id.lose_stats1);

        ImageView p2_c1 = findViewById(R.id.player2_card1);
        ImageView p2_c2 = findViewById(R.id.player2_card2);
        textViews[1] = findViewById(R.id.win_stats2);
        TextView draw2 = findViewById(R.id.draw_stats2);
        TextView lose2 = findViewById(R.id.lose_stats2);

        ImageView p3_c1 = findViewById(R.id.player3_card1);
        ImageView p3_c2 = findViewById(R.id.player3_card2);
        textViews[2] = findViewById(R.id.win_stats3);
        TextView draw3 = findViewById(R.id.draw_stats3);
        TextView lose3 = findViewById(R.id.lose_stats3);

        ImageView p4_c1 = findViewById(R.id.player4_card1);
        ImageView p4_c2 = findViewById(R.id.player4_card2);
        textViews[3] = findViewById(R.id.win_stats4);
        TextView draw4 = findViewById(R.id.draw_stats4);
        TextView lose4 = findViewById(R.id.lose_stats4);

        ImageView p5_c1 = findViewById(R.id.player5_card1);
        ImageView p5_c2 = findViewById(R.id.player5_card2);
        textViews[4] = findViewById(R.id.win_stats5);
        TextView draw5 = findViewById(R.id.draw_stats5);
        TextView lose5 = findViewById(R.id.lose_stats5);

        ImageView p6_c1 = findViewById(R.id.player6_card1);
        ImageView p6_c2 = findViewById(R.id.player6_card2);
        textViews[5] = findViewById(R.id.win_stats6);
        TextView draw6 = findViewById(R.id.draw_stats6);
        TextView lose6 = findViewById(R.id.lose_stats6);

        ImageView p7_c1 = findViewById(R.id.player7_card1);
        ImageView p7_c2 = findViewById(R.id.player7_card2);
        textViews[6] = findViewById(R.id.win_stats7);
        TextView draw7 = findViewById(R.id.draw_stats7);
        TextView lose7 = findViewById(R.id.lose_stats7);

        ImageView p8_c1 = findViewById(R.id.player8_card1);
        ImageView p8_c2 = findViewById(R.id.player8_card2);
        textViews[7] = findViewById(R.id.win_stats8);
        TextView draw8 = findViewById(R.id.draw_stats8);
        TextView lose8 = findViewById(R.id.lose_stats8);

        ImageView p9_c1 = findViewById(R.id.player9_card1);
        ImageView p9_c2 = findViewById(R.id.player9_card2);
        textViews[8] = findViewById(R.id.win_stats9);
        TextView draw9 = findViewById(R.id.draw_stats9);
        TextView lose9 = findViewById(R.id.lose_stats9);

        // doda san sve textView-ove u niz textView-ov


        testniButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hands = 0;
                String[] konacan_unos = {"", "", "", "", "", "", "", "", "", ""};
                // prvo kupi karte sa boards i sprema ih u prvi clan niza konacan_unos
                for (int i = 0; i < table.length; i++) {
                    if (table[i].getNumber() != null) {
                        // ovdi spaja number ( npr. J ) i type ( npr. h - hearts) u jedinstveni niz karata na boardu
                        konacan_unos[0] = konacan_unos[0] + table[i].getNumber() + table[i].getType();
                        // npr. konacan_unos[0] = "JhJsJd"
                    }
                }

                // ovdje vrtiš kroz svih 9 igrača i provjeravaš sadrže li obe njegove karte nekakvu vrijednost
                // ako DA, onda su pogodne za slanje na računanje u c.test()
                for (int i = 0; i < players.length; i++) {
                    // ukoliko je korisnik odabra obe karte

                    // PROBLEM JE ŠTA STALNO ULAZI U OVI IF I KAD NISU ODABRANE KARTE
                    if (players[i].cards[0].getNumber() != "null" && players[i].cards[1].getNumber() != "null") {
                        // ovdi spaja number ( npr. J ) i type ( npr. h - hearts) dva puta u jedinstvenu ruku igrača
                        konacan_unos[i + 1] = "" + players[i].cards[0].getNumber() + players[i].cards[0].getType() + players[i].cards[1].getNumber() + players[i].cards[1].getType();
                        // hands broji broj igraca koji su odabrali obje karte
                        hands = hands + 1;
                    }
                }

                // broj textView-ova korespondira broju igraca sa obje karte odabrane
                TextView[] textViewsConsole = new TextView[hands];
                System.out.println(hands);
                int t = 0;

                //ovdi ćemo sad sastavljat argumente za slanje u c.test(), trebamo formatirat string za slanje i testViews
                String[] testConsole;

                // ako postoji nesto na boardu, u testconsole salji -b i board npr. -b JhJsJd
                if (konacan_unos[0] != "") {
                    testConsole = new String[hands + 2];
                    testConsole[0] = "-b";
                    testConsole[1] = konacan_unos[0];
                    t = 2;
                } else {
                    testConsole = new String[hands];
                }

                // ova varijabla broji dodane textView-ove
                int tv = 0;
                // ova petlja ide po konacnom unosu i gleda koji igraci imaju ruku, ovisno o tome ćemo slagat textViewove u niz
                // tj oni igraci koji imaju ruku, njihovi textViewovi idu u testConsole
                for (int i = 0; i < konacan_unos.length-1; i++) {
                    if(konacan_unos[i+1] != ""){
                        testConsole[t] = konacan_unos[i+1];
                        // dodaj odgovarajući textView u array textView-ova koji će se slat
                        textViewsConsole[tv] = textViews[i];
                        System.out.println("Main ac");
                        System.out.println(tv);
                        System.out.println(i);
                        System.out.println("Main ac - kraj");
                        tv++;
                        t++;
                    }
                }
                try {
                    c.test(testConsole, textViewsConsole);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //LIST KARATA SVIH MOGUCIH IGRACA(MAX 9)
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

        // KARTE NA STOLU
        ImageView t1 = findViewById(R.id.table_card1);
        ImageView t2 = findViewById(R.id.table_card2);
        ImageView t3 = findViewById(R.id.table_card3);
        ImageView t4 = findViewById(R.id.table_card4);
        ImageView t5 = findViewById(R.id.table_card5);

        List<ImageView> tableCards = new ArrayList<ImageView>();
        tableCards.add(t1);
        tableCards.add(t2);
        tableCards.add(t3);
        tableCards.add(t4);
        tableCards.add(t5);


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


        // postavljanje karata u dijaloskom okviru na sve pik karte
        setSpades(dialogCards);

        // ImageView vrsta karata u dijaloskom okviru
        ImageView spades = findViewById(R.id.spades);
        ImageView hearts = findViewById(R.id.hearts);
        ImageView clubs = findViewById(R.id.clubs);
        ImageView diamonds = findViewById(R.id.diamonds);

        // postavljanje na default - pik karte
        spades.setForeground(foreground);


        // CLICK LISTENERS
        spades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vrsta = 0;
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
                vrsta = 1;
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
                vrsta = 2;
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
                vrsta = 3;
                setDiamonds(dialogCards);
                spades.setForeground(foreground_null);
                hearts.setForeground(foreground_null);
                clubs.setForeground(foreground_null);
                diamonds.setForeground(foreground);
            }
        });


        playerCards.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info();
                openDialog(0, dialog_cards_view, playerCards.get(0));
                igrac = 0;
                karta = 0;
            }
        });
        playerCards.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(1, dialog_cards_view, playerCards.get(1));
                igrac = 0;
                karta = 1;
            }
        });
        playerCards.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(2, dialog_cards_view, playerCards.get(2));
                igrac = 1;
                karta = 0;
            }
        });
        playerCards.get(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(3, dialog_cards_view, playerCards.get(3));
                igrac = 1;
                karta = 1;
            }
        });
        playerCards.get(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(4, dialog_cards_view, playerCards.get(4));
                igrac = 2;
                karta = 0;
            }
        });
        playerCards.get(5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(5, dialog_cards_view, playerCards.get(5));
                igrac = 2;
                karta = 1;
            }
        });
        playerCards.get(6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(6, dialog_cards_view, playerCards.get(6));
                igrac = 3;
                karta = 0;
            }
        });
        playerCards.get(7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(7, dialog_cards_view, playerCards.get(7));
                igrac = 3;
                karta = 1;
            }
        });
        playerCards.get(8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(8, dialog_cards_view, playerCards.get(8));
                igrac = 4;
                karta = 0;
            }
        });
        playerCards.get(9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(9, dialog_cards_view, playerCards.get(9));
                igrac = 4;
                karta = 1;
            }
        });
        playerCards.get(10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(10, dialog_cards_view, playerCards.get(10));
                igrac = 5;
                karta = 0;
            }
        });
        playerCards.get(11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(11, dialog_cards_view, playerCards.get(11));
                igrac = 5;
                karta = 1;
            }
        });
        playerCards.get(12).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(12, dialog_cards_view, playerCards.get(12));
                igrac = 6;
                karta = 0;
            }
        });
        playerCards.get(13).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(13, dialog_cards_view, playerCards.get(13));
                igrac = 6;
                karta = 1;
            }
        });
        playerCards.get(14).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(14, dialog_cards_view, playerCards.get(14));
                igrac = 7;
                karta = 0;
            }
        });
        playerCards.get(15).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(15, dialog_cards_view, playerCards.get(15));
                igrac = 7;
                karta = 1;
            }
        });
        playerCards.get(16).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(16, dialog_cards_view, playerCards.get(16));
                igrac = 8;
                karta = 0;
            }
        });
        playerCards.get(17).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(17, dialog_cards_view, playerCards.get(17));
                igrac = 8;
                karta = 1;
            }
        });


        dialogCards.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = 0;
                closeDialog(dialog_cards_view, dialogCards.get(0), playerCards, tableCards);
                if (!checkTable) {
                    addSelectedCardToPlayer(vrsta, num, igrac, karta, players, karte.all_cards);
                } else if (checkTable) {
                    addCardTable(vrsta, num, tableInd, karte.all_cards);
                }
                checkTable = false;
                info();
            }
        });
        dialogCards.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = 1;
                closeDialog(dialog_cards_view, dialogCards.get(1), playerCards, tableCards);
                if (!checkTable) {
                    addSelectedCardToPlayer(vrsta, num, igrac, karta, players, karte.all_cards);
                } else if (checkTable) {
                    addCardTable(vrsta, num, tableInd, karte.all_cards);
                }
                checkTable = false;
                info();
            }
        });
        dialogCards.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = 2;
                closeDialog(dialog_cards_view, dialogCards.get(2), playerCards, tableCards);
                if (!checkTable) {
                    addSelectedCardToPlayer(vrsta, num, igrac, karta, players, karte.all_cards);
                } else if (checkTable) {
                    addCardTable(vrsta, num, tableInd, karte.all_cards);
                }
                checkTable = false;
                info();
            }
        });
        dialogCards.get(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = 3;
                closeDialog(dialog_cards_view, dialogCards.get(3), playerCards, tableCards);
                if (!checkTable) {
                    addSelectedCardToPlayer(vrsta, num, igrac, karta, players, karte.all_cards);
                } else if (checkTable) {
                    addCardTable(vrsta, num, tableInd, karte.all_cards);
                }
                checkTable = false;
                info();
            }
        });
        dialogCards.get(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = 4;
                closeDialog(dialog_cards_view, dialogCards.get(4), playerCards, tableCards);
                if (!checkTable) {
                    addSelectedCardToPlayer(vrsta, num, igrac, karta, players, karte.all_cards);
                } else if (checkTable) {
                    addCardTable(vrsta, num, tableInd, karte.all_cards);
                }
                checkTable = false;
                info();
            }
        });
        dialogCards.get(5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = 5;
                closeDialog(dialog_cards_view, dialogCards.get(5), playerCards, tableCards);
                if (!checkTable) {
                    addSelectedCardToPlayer(vrsta, num, igrac, karta, players, karte.all_cards);
                } else if (checkTable) {
                    addCardTable(vrsta, num, tableInd, karte.all_cards);
                }
                checkTable = false;
                info();
            }
        });
        dialogCards.get(6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = 6;
                closeDialog(dialog_cards_view, dialogCards.get(6), playerCards, tableCards);
                if (!checkTable) {
                    addSelectedCardToPlayer(vrsta, num, igrac, karta, players, karte.all_cards);
                } else if (checkTable) {
                    addCardTable(vrsta, num, tableInd, karte.all_cards);
                }
                checkTable = false;
                info();
            }
        });
        dialogCards.get(7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = 7;
                closeDialog(dialog_cards_view, dialogCards.get(7), playerCards, tableCards);
                if (!checkTable) {
                    addSelectedCardToPlayer(vrsta, num, igrac, karta, players, karte.all_cards);
                } else if (checkTable) {
                    addCardTable(vrsta, num, tableInd, karte.all_cards);
                }
                checkTable = false;
                info();
            }
        });
        dialogCards.get(8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = 8;
                closeDialog(dialog_cards_view, dialogCards.get(8), playerCards, tableCards);
                if (!checkTable) {
                    addSelectedCardToPlayer(vrsta, num, igrac, karta, players, karte.all_cards);
                } else if (checkTable) {
                    addCardTable(vrsta, num, tableInd, karte.all_cards);
                }
                checkTable = false;
                info();
            }
        });
        dialogCards.get(9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = 9;
                closeDialog(dialog_cards_view, dialogCards.get(9), playerCards, tableCards);
                if (!checkTable) {
                    addSelectedCardToPlayer(vrsta, num, igrac, karta, players, karte.all_cards);
                } else if (checkTable) {
                    addCardTable(vrsta, num, tableInd, karte.all_cards);
                }
                checkTable = false;
                info();
            }
        });
        dialogCards.get(10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = 10;
                closeDialog(dialog_cards_view, dialogCards.get(10), playerCards, tableCards);
                if (!checkTable) {
                    addSelectedCardToPlayer(vrsta, num, igrac, karta, players, karte.all_cards);
                } else if (checkTable) {
                    addCardTable(vrsta, num, tableInd, karte.all_cards);
                }
                checkTable = false;
                info();
            }
        });
        dialogCards.get(11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = 11;
                closeDialog(dialog_cards_view, dialogCards.get(11), playerCards, tableCards);
                if (!checkTable) {
                    addSelectedCardToPlayer(vrsta, num, igrac, karta, players, karte.all_cards);
                } else if (checkTable) {
                    addCardTable(vrsta, num, tableInd, karte.all_cards);
                }
                checkTable = false;
                info();
            }
        });
        dialogCards.get(12).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = 12;
                closeDialog(dialog_cards_view, dialogCards.get(12), playerCards, tableCards);
                if (!checkTable) {
                    addSelectedCardToPlayer(vrsta, num, igrac, karta, players, karte.all_cards);
                } else if (checkTable) {
                    addCardTable(vrsta, num, tableInd, karte.all_cards);
                }
                checkTable = false;
                info();
                mate();
            }
        });

        tableCards.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableInd = 0;
                openDialog(18, dialog_cards_view, tableCards.get(0));
                checkTable = true;
            }
        });
        tableCards.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableInd = 1;
                openDialog(19, dialog_cards_view, tableCards.get(1));
                checkTable = true;
            }
        });
        tableCards.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableInd = 2;
                openDialog(20, dialog_cards_view, tableCards.get(2));
                checkTable = true;
            }
        });
        tableCards.get(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableInd = 3;
                openDialog(21, dialog_cards_view, tableCards.get(3));
                checkTable = true;
            }
        });
        tableCards.get(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableInd = 4;
                openDialog(22, dialog_cards_view, tableCards.get(4));
                checkTable = true;
            }
        });


    }

    public void openDialog(int l, LinearLayout dialog, ImageView m) {
        System.out.println("Dialog opened!");
        dialog.setVisibility(View.VISIBLE);
        saveCurrentCard(l);
        currentImageView = l;
    }

    public void closeDialog(LinearLayout dialog, ImageView m, List<ImageView> lista, List<ImageView> lista2) {
        System.out.println("Dialog closed!");
        dialog.setVisibility(View.INVISIBLE);
        draw = m.getDrawable();
        if ((currentImageView >= 18) && (currentImageView <= 22)) {
            lista2.get(currentImageView - 18).setImageDrawable(draw);
        } else if ((currentImageView >= 0) && (currentImageView <= 17)) {
            lista.get(currentImageView).setImageDrawable(draw);
        } else {
            Toast toast;
            toast = Toast.makeText(getApplicationContext(), "closeDialog ERROR!\ncurrentImageView out of range!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }


    public void setSpades(List<ImageView> a) {
        vrsta = 0;
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
        vrsta = 1;
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
        vrsta = 2;
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
        vrsta = 3;
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

    public void saveCurrentCard(int num) {
        SharedPreferences sharedPref = getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("NUMBER", num);
        editor.commit();
    }

    public void loadCurrentCard() {
        SharedPreferences sharedPref = getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
        currentImageView = sharedPref.getInt("NUMBER", 0);
    }

    public void info() {
        for (int i = 0; i < 9; i++) {
            System.out.println(String.format("IGRAC%d", i + 1));
            players[i].sysOut();
        }
        for (i = 0; i < 5; i++) {
            System.out.println(String.format("%d. table card -> %s %s", i + 1, table[i].getType(), table[i].getNumber()));
        }
    }

    public void mate() {

    }

    public void addSelectedCardToPlayer(int vrsta, int broj, int igrac, int red_br, Player[] p, List<Card_model> all_c) {
        int a = vrsta;
        int b = broj;
        int c = igrac;
        int d = red_br;
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
        System.out.println(String.format("vrst = %d, broj = %d, igrac = %d, red_br = %d", a, b, c, d));

        p[igrac].addCard(red_br, all_c.get(f + broj));
    }

    public void addCardTable(int vrsta, int broj, int tableIndex, List<Card_model> all_cards) {
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
        table[tableIndex] = all_cards.get(f + broj);
    }


}

