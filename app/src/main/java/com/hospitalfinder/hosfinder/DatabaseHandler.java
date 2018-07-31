package com.hospitalfinder.hosfinder;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 05/07/2017.
 */

class DatabaseHandler extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 29;

    // Nama Database
    public static final String DATABASE_NAME = "rs";

    // Nama tabel
    public static final String TABLE_RS= "rss";

    // Tabel RS
    public static final String KEY_ID = "_id";
    public static final String KEY_NAMA = "nama";
    public static final String KEY_INFORMASI = "informasi";
    public static final String KEY_TELEPON = "telepon";
    public static final String KEY_GAMBAR = "gambar";

    public Resources res;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        res = context.getResources();
    }

    // Method untuk membuat database
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_RS= "CREATE TABLE " + TABLE_RS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAMA  + " TEXT," + KEY_INFORMASI + " TEXT," + KEY_TELEPON + " TEXT,"
                + KEY_GAMBAR + " INTEGER);";

        db.execSQL(CREATE_TABLE_RS);

        ContentValues values = new ContentValues();
        //database Daftar RS
        //1
        values.put(KEY_INFORMASI, "Alamat : Jl. Kesambi No.56 Kota Cirebon – 45134.\n\n" +
                "Tipe Kelas : Pemkot / B \n\n"+
                "-Buka 24 jam-\n");
        values.put(KEY_TELEPON, "0231-206330");
        values.put(KEY_GAMBAR, R.drawable.gunungjati);
        values.put(KEY_NAMA, "RSUD Gunung Jati");
        db.insert(TABLE_RS, null, values);

        //2
        values.put(KEY_NAMA, "RS Pelabuhan Cirebon");
        values.put(KEY_INFORMASI, "Alamat : Jl. Sisingamangaraja No.45 Kota Cirebon – 45112\n\n" +
                "Tipe kelas : BUMN / C \n\n" +
                "Website :  http://rspelabuhan.com \n\n" +
                "-Buka 24 jam-\n");
        values.put(KEY_TELEPON, "0231-205657");
        values.put(KEY_GAMBAR, R.drawable.pelabuhancirebon);
        db.insert(TABLE_RS, null, values);

        //3
        values.put(KEY_NAMA, "RS Tingkat III Ciremai");
        values.put(KEY_INFORMASI, "Alamat : Jl. Kesambi no. 237 Kota Cirebon – 45133\n\n" +
                "Tipe kelas : TNI AD / B \n\n" +
                "Website : rsadciremai.com\n\n"+
                "-Buka 24 jam-\n");
        values.put(KEY_TELEPON, "0231-238335");
        values.put(KEY_GAMBAR, R.drawable.ciremai);
        db.insert(TABLE_RS, null, values);

        //4
        values.put(KEY_NAMA, "RSU Muhammadiyah");
        values.put(KEY_INFORMASI, "Alamat : Jalan Wahidin Sudirohusodo No. 79, Sukapura, Kejaksaan\n\n" +
                "Cirebon, Jawa Barat, Indonesia 45122\n\n" +
                "Tipe kelas : Organisasi Islam / C \n");
        values.put(KEY_TELEPON, "0231-202463 , 0231-247406");
        values.put(KEY_GAMBAR, R.drawable.muhammadiyah);
        db.insert(TABLE_RS, null, values);

        //5
        values.put(KEY_NAMA, "RSB Panti Abdi Dharma");
        values.put(KEY_INFORMASI, "Alamat : Jl. Pulasaren No.7, Kota Cirebon – 45114\n\n" +
                "Tipe kelas : Organisasi Katholik\n\n" +
                "Buka : 08.00 WIB\n");
        values.put(KEY_TELEPON, "0231-203873\n");
        values.put(KEY_GAMBAR, R.drawable.abdidarma);
        db.insert(TABLE_RS, null, values);

        //6
        values.put(KEY_NAMA, "RSB Putera Bahagia");
        values.put(KEY_INFORMASI, "Alamat : Jl. Ciremai Raya No 114 Perumnas Kota Cirebon – 45142.\n\n" +
                "Tipe kelas : Perusahaan / C\n\n" +
                "Website : rsputerabahagia.com\n\n"+
                "-Buka 24 jam-\n");
        values.put(KEY_TELEPON, "0231-4865654");
        values.put(KEY_GAMBAR, R.drawable.puterabahagia);
        db.insert(TABLE_RS, null, values);

        //7
        values.put(KEY_NAMA, "RSU Budi Luhur");
        values.put(KEY_INFORMASI, "Alamat : Kebon Pelok Harjamukti Kota Cirebon – 45144.\n\n" +
                "Tipe kelas : Organisasi Sosial\n\n"+
                "Website :  rsblcirebon.blogspot.com\n\n"+
                "-Buka 24 jam-\n");
        values.put(KEY_TELEPON, "0231-483236");
        values.put(KEY_GAMBAR, R.drawable.budiluhur);
        db.insert(TABLE_RS, null, values);

        //8
        values.put(KEY_NAMA, "RSU Sumber Kasih");
        values.put(KEY_INFORMASI, "Alamat : Jl. Siliwangi No.135 Kota Cirebon – 45124.\n\n" +
                "Tipe kelas : Swasta / C\n\n"+
                "Website : kasih-group.com\n\n"+
                "-Buka 24 jam-\n");
        values.put(KEY_TELEPON, "0231-203815");
        values.put(KEY_GAMBAR, R.drawable.sumberkasih);
        db.insert(TABLE_RS, null, values);

        //9
        values.put(KEY_NAMA, "RSK Bedah Budi Asta");
        values.put(KEY_INFORMASI, "Alamat : Jl. Kalitanjung No.51 Kota Cirebon – 45143.\n\n" +
                "Tipe kelas : Organisasi Sosial\n\n"+
                "-Buka 24 jam-\n");
        values.put(KEY_TELEPON, "0231-488211");
        values.put(KEY_GAMBAR, R.drawable.budiasta);
        db.insert(TABLE_RS, null, values);

        //10
        values.put(KEY_NAMA, "RSK Bedah Medimas");
        values.put(KEY_INFORMASI, "Alamat : Jl. Evakuasi No. 116 Kota Cirebon – 45153.\n\n" +
                "Tipe kelas : Swasta / C\n\n"+
                "-Buka 24 jam-\n");
        values.put(KEY_TELEPON, "0231-481165");
        values.put(KEY_GAMBAR, R.drawable.bedahmedinas);
        db.insert(TABLE_RS, null, values);

        values.put(KEY_NAMA, "RSIA Cahaya Bunda");
        values.put(KEY_INFORMASI, "Alamat : Jl. Raya Perjuangan No. 8 Kota Cirebon – 45132.\n\n" +
                "Tipe kelas : Swasta / C\n\n"+
                "Website : rsia-cahayabunda.com\n\n"+
                "-Buka 24 jam-\n");
        values.put(KEY_TELEPON, "0231-8333377/88");
        values.put(KEY_GAMBAR, R.drawable.cahayabunda);
        db.insert(TABLE_RS, null, values);

        values.put(KEY_NAMA, "RS Sumber Hurip");
        values.put(KEY_INFORMASI, "Alamat : Jl. Dewi Sartika No.15, Tukmudal, Sumber, Cirebon - 45611\n\n" +
                "Tipe kelas : Swasta / D \n\n"+
                "-Buka 24 jam-\n");
        values.put(KEY_TELEPON, "0231-8302689");
        values.put(KEY_GAMBAR, R.drawable.sumberhurip);
        db.insert(TABLE_RS, null, values);

        values.put(KEY_NAMA, "RS Pertamina");
        values.put(KEY_INFORMASI, "Alamat : Jl. Patra Raya Klayan, Klayan, Gunungjati, Jadimulya, Gunungjati,Cirebon - 45151\n\n" +
                "Tipe kelas : C\n\n"+
                "Website : rspc.co.id\n\n"+
                "-Buka 24 jam-\n");
        values.put(KEY_TELEPON, "0231-224646");
        values.put(KEY_GAMBAR, R.drawable.pertamina);
        db.insert(TABLE_RS, null, values);

        values.put(KEY_NAMA, "RS Permata");
        values.put(KEY_INFORMASI, "Alamat : Jl. Tuparev No.117, Pilangsari, Kedawung, Cirebon - 45153\n\n" +
                "Website : rspermatacirebon.com\n\n"+
                "-Buka 24 jam-\n");
        values.put(KEY_TELEPON, "0231-8338877");
        values.put(KEY_GAMBAR, R.drawable.permata);

        values.put(KEY_NAMA, "RS Mitra Plumbon");
        values.put(KEY_INFORMASI, "Alamat : Jl. Raya Plumbon KM.11, Gombang, Palimanan, Cirebon - 45122\n\n" +
                "Website : rsmitraplumbon.com\n\n"+
                "-Buka 24 jam-\n");
        values.put(KEY_TELEPON, "0231-323100");
        values.put(KEY_GAMBAR, R.drawable.mitraplumbon);
        db.insert(TABLE_RS, null, values);

        values.put(KEY_NAMA, "RSIA Khalishah");
        values.put(KEY_INFORMASI, "Alamat : Pegagan, Palimanan, Cirebon - 45161\n\n" +
                "Tipe kelas : Swasta / C\n\n"+
                "Website : rsiakhalishah.com\n\n"+
                "-Buka 24 jam-\n");
        values.put(KEY_TELEPON, "0231-342440");
        values.put(KEY_GAMBAR, R.drawable.khalishah);
        db.insert(TABLE_RS, null, values);


    }



    // Method untuk memperbaharui database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RS);

        // Create tables again
        onCreate(db);
    }
    }



