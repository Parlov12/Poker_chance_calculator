package com.example.pokerchancecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.pokerchancecalculator.Karte.Cards;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout cards_view = findViewById(R.id.dialog_frame);
        cards_view.setVisibility(View.INVISIBLE);

        Cards karte = new Cards();



    }
}

