package com.example.mrssr.bookingwarnetsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivityAbout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_about);
    }

    public void pindahKewebview(View view){
        Intent pindahKeWebView = new Intent(MainActivityAbout.this, MainActivityWebView.class);
        startActivity(pindahKeWebView);
    }
}
