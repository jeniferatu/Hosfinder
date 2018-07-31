package com.hospitalfinder.hosfinder;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    private ListView listViews;
    private DatabaseHandler myDbHelper;
    private Cursor cursor;
    private ListAdapter adapter;
    private SQLiteDatabase db;
    private Toolbar toolbar;
    private EditText editTextCari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

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
            info = cursor.getString(cursor.getColumnIndex("info"));
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


    @SuppressWarnings("deprecation")
    public void search_db(View v){
        String edit_db = editTextCari.getText().toString();
        if(!edit_db.equals("")){
            try{
                cursor = db.rawQuery("SELECT * FROM rss WHERE nama LIKE ?", new String[] {"%" +edit_db+ "%"});
                adapter = new SimpleCursorAdapter(this, R.layout.mylist, cursor,
                        new String[] {"gambar", "nama"},
                        new int [] {R.id.ivGambar,R.id.tvNama});
                if(adapter.getCount() == 0){
                    Toast.makeText(this, "Search not found "+edit_db+"", Toast.LENGTH_SHORT).show();
                }else{
                    listViews.setAdapter(adapter);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            try{
                cursor = db.rawQuery("SELECT * FROM rss ORDER BY nama ASC", null);
                adapter = new SimpleCursorAdapter(this, R.layout.mylist, cursor,
                        new String[] {"gambar", "nama"},
                        new int [] {R.id.ivGambar,R.id.tvNama});
                listViews.setAdapter(adapter);
                listViews.setTextFilterEnabled(true);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
