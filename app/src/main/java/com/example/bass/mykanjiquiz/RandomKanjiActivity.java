package com.example.bass.mykanjiquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RandomKanjiActivity extends AppCompatActivity {

    public static final int WRITING = 0;
    public static final int MEANING = 2;

    private String[] buttons = {"Kanji","Reading","Meaning"};
    private ArrayList<String[]> kanjiStruct;
    private Random rand;
    private int category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_kanji);
        Intent intent = getIntent();
        kanjiStruct = (ArrayList<String[]>) intent.getSerializableExtra(MainActivity.KANJI);
        //Collections.shuffle(kanjiStruct);
        rand = new Random();
        category = WRITING;
        newKanji();
    }

    private void newKanji() {
        int n = category;
        int m = rand.nextInt(kanjiStruct.size());

        TextView mainTextView = findViewById(R.id.textView);
        mainTextView.setText(((String[]) kanjiStruct.get(m))[n]);

        if (n == 2) n = 0;
        else n++;
        TextView textView1 = findViewById(R.id.textView3);
        textView1.setText(((String[]) kanjiStruct.get(m))[n]);
        textView1.setVisibility(View.INVISIBLE);
        Button button1 = findViewById(R.id.button);
        button1.setText(buttons[n]);

        if (n == 2) n = 0;
        else n++;
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText(((String[]) kanjiStruct.get(m))[n]);
        textView2.setVisibility(View.INVISIBLE);
        Button button2 = findViewById(R.id.button2);
        button2.setText(buttons[n]);

    }

    public void onClickNext(View view) {
        newKanji();
    }

    public void onClickShow1(View view) {
        TextView textView1 = findViewById(R.id.textView3);
        textView1.setVisibility(View.VISIBLE);
    }

    public void onClickShow2(View view) {
        TextView textView1 = findViewById(R.id.textView2);
        textView1.setVisibility(View.VISIBLE);
    }

    public void onClickCategory(View view) {
        if(category == WRITING)category = MEANING;
        else category = WRITING;
        newKanji();
    }

}
