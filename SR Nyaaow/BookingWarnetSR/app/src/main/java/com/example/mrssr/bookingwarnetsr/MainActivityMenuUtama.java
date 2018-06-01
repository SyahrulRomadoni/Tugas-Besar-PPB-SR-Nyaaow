package com.example.mrssr.bookingwarnetsr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityMenuUtama extends AppCompatActivity {

    Button btn_logout;
//    TextView txt_id, txt_username;
    String id, username;
    SharedPreferences sharedpreferences;

    public static final String TAG_ID = "id";
    public static final String TAG_USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_utama);

//        txt_id = (TextView) findViewById(R.id.txt_id);
//        txt_username = (TextView) findViewById(R.id.txt_username);
        btn_logout = (Button) findViewById(R.id.btn_logout);

        sharedpreferences = getSharedPreferences(MainActivityLogin.my_shared_preferences, Context.MODE_PRIVATE);

        id = getIntent().getStringExtra(TAG_ID);
        username = getIntent().getStringExtra(TAG_USERNAME);

//        txt_id.setText("ID : " + id);
//        txt_username.setText(username);

        btn_logout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // update login session ke FALSE dan mengosongkan nilai id dan username
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(MainActivityLogin.session_status, false);
                editor.putString(TAG_ID, null);
                editor.putString(TAG_USERNAME, null);
                editor.commit();

                Intent intent = new Intent(MainActivityMenuUtama.this, MainActivityLogin.class);
                finish();
                startActivity(intent);
            }
        });
    }

    // ----- Intent Text ----- //
    public void bookingPc(View view){
        Intent pindahKeBookingPc = new Intent(MainActivityMenuUtama.this, MainActivityBookingPC.class);
        startActivity(pindahKeBookingPc);
    }

    public void listBooking(View view){
        Intent pindahKeListBooking = new Intent(MainActivityMenuUtama.this, MainActivityListBooking.class);
        startActivity(pindahKeListBooking);
    }

    public void gallerySr(View view){
        Intent pindahKeGallerySR = new Intent(MainActivityMenuUtama.this, MainActivityGallery.class);
        startActivity(pindahKeGallerySR);
    }

    public void aboutSr(View view){
        Intent pindahKeAboutSR = new Intent(MainActivityMenuUtama.this, MainActivityAbout.class);
        startActivity(pindahKeAboutSR);
    }

    // ----- Intent Button ----- //
    public void bookingPc1(View view){
        Intent pindahKeBookingPc1 = new Intent(MainActivityMenuUtama.this, MainActivityBookingPC.class);
        startActivity(pindahKeBookingPc1);
    }

    public void listBooking1(View view){
        Intent pindahKeListBooking1 = new Intent(MainActivityMenuUtama.this, MainActivityListBooking.class);
        startActivity(pindahKeListBooking1);
    }

    public void gallerySr1(View view){
        Intent pindahKeGallerySR1 = new Intent(MainActivityMenuUtama.this, MainActivityGallery.class);
        startActivity(pindahKeGallerySR1);
    }

    public void aboutSr1(View view){
        Intent pindahKeAboutSR1 = new Intent(MainActivityMenuUtama.this, MainActivityAbout.class);
        startActivity(pindahKeAboutSR1);
    }
}
