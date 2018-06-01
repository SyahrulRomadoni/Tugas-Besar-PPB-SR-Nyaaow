package com.example.mrssr.bookingwarnetsr;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivityProsesMasukAplikasi extends AppCompatActivity {

    private  int waktu_proses = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_proses_masuk_aplikasi);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent pindah = new Intent(MainActivityProsesMasukAplikasi.this, MainActivityLogin.class);
                startActivity(pindah);
            }
        },waktu_proses);
    }
}
