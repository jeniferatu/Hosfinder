package com.hospitalfinder.hosfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DaftarsActivity extends AppCompatActivity {
    private TextView textNama, textInfo, textTelepon;
    private ImageView imageGambar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textNama = (TextView) findViewById(R.id.tvNama);
        textInfo = (TextView) findViewById(R.id.tvInfo);
        textTelepon = (TextView) findViewById(R.id.tvTelepon);
        imageGambar = (ImageView) findViewById(R.id.ivGambar);


        Intent intent = getIntent();
        String nama = intent.getStringExtra("dataNama");
        String info = intent.getStringExtra("dataInfo");
        String telepon = intent.getStringExtra("dataTelepon");
        int gambar = intent.getIntExtra("dataGambar", 0);

        textNama.setText(nama);
        textInfo.setText(info);
        textTelepon.setText(telepon);
        imageGambar.setImageResource(gambar);

    }
}

