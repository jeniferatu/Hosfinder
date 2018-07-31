package com.hospitalfinder.hosfinder;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * Created by User on 05/07/2017.
 */

public class ListVIew extends AppCompatActivity{

    private ListView listViews;
    private DatabaseHandler myDbHelper;
    private Cursor cursor;
    private ListAdapter adapter;
    private SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftars);

        listViews = (ListView) findViewById(R.id.ListViewRS);
        myDbHelper = new DatabaseHandler(this);
        db = myDbHelper.getReadableDatabase();


        try{
            cursor = db.rawQuery("SELECT * FROM rss ORDER BY nama ASC", null);
            adapter = new SimpleCursorAdapter(this, R.layout.mylist, cursor,
                    new String[] {"gambar", "nama"},
                    new int [] {R.id.ivGambar,R.id.tvNama});
            listViews.setAdapter(adapter);
            listViews.setTextFilterEnabled(true);
            listViews.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View v,
                                        int position, long id) {
                    detail(position);
                }
            });
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void detail(int position){
        int gambar = 0;
        String nama = "";
        String info = "";
        String telepon = "";

        if(cursor.moveToFirst()){
            cursor.moveToPosition(position);
            nama = cursor.getString(cursor.getColumnIndex("nama"));
            info = cursor.getString(cursor.getColumnIndex("informasi"));
            telepon = cursor.getString(cursor.getColumnIndex("telepon"));
            gambar = cursor.getInt(cursor.getColumnIndex("gambar"));

        }

        Intent iIntent = new Intent(this, DaftarsActivity.class);
        iIntent.putExtra("dataNama", nama);
        iIntent.putExtra("dataInfo", info);
        iIntent.putExtra("dataTelepon", telepon);
        iIntent.putExtra("dataGambar", gambar);

        setResult(RESULT_OK, iIntent);
        startActivityForResult(iIntent, 99);


    }

}

