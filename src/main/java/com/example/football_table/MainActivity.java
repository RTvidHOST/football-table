package com.example.football_table;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Integer spartak = 0;
    private Integer loko = 0;
    private TextView spartakTextView;
    private TextView lokoTextView;

    private static final String TAG = "MainActivity";

    @SuppressLint("RT")
    @Override
    protected void onResume() {
        super.onResume();
        resetUI();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spartakTextView = findViewById(R.id.spartak_score);
        lokoTextView = findViewById(R.id.loko_score);
    }

    @SuppressLint("RT")
    public void onClickAddSpartak(View view) {
        spartak++;
        spartakTextView.setText(spartak.toString());
    }

    @SuppressLint("RT")
    public void onClickAddLokomotiv(View view) {
        loko++;
        lokoTextView.setText(loko.toString());
    }

    @SuppressLint("RT")
    public void onClickButtonClear(View view) {
        spartak = 0;
        loko = 0;

        resetUI();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("spartak", spartak);
        outState.putInt("loko", loko);
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("spartak")) {
            spartak = savedInstanceState.getInt("spartak");
        }
        if ((savedInstanceState != null && savedInstanceState.containsKey("loko"))) {
            loko = savedInstanceState.getInt("loko");
        }
        Log.d(TAG, "onRestoreInstanceState");
    }

    @SuppressLint("RT")
    private void resetUI() {
        spartakTextView.setText(spartak.toString());
        lokoTextView.setText(loko.toString());
        Log.d(TAG, "resetUI");
    }

}
