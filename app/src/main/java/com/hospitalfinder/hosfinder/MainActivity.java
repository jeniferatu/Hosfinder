package com.hospitalfinder.hosfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_main);


        Button btn_dekat = (Button) findViewById(R.id.button1);
        Button btn_daftar = (Button) findViewById(R.id.button2);
        Button btn_bantuan = (Button) findViewById(R.id.button3);
        Button btn_tentang = (Button) findViewById(R.id.button4);
        btn_dekat.setOnClickListener(this);
        btn_daftar.setOnClickListener(this);
        btn_bantuan.setOnClickListener(this);
        btn_tentang.setOnClickListener(this);
    }

    /** ini yg jelly bean yg dikasih ke ibunya **/
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Intent pindah1 = new Intent(this, MapsActivity.class);
                startActivity(pindah1);
                break;

            case R.id.button2:
                Intent pindah2 = new Intent(this, ListVIew.class);
                startActivity(pindah2);
                break;

            case R.id.button3:
                Intent pindah3 = new Intent(this, BantuanActivity.class);
                startActivity(pindah3);
                break;

            case R.id.button4:
                Intent pindah4 = new Intent(this, TentangActivity.class);
                startActivity(pindah4);

        }
    }

    long lastPress;

    @Override
    public void onBackPressed() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastPress > 5000) {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_LONG).show();
            lastPress = currentTime;
        } else {
            super.onBackPressed();
        }
    }


}
