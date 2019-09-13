package com.example.datamahasiswa.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String DB_NAME = "db_mahasiswa";
    private static int DB_VERSION = 1;

    private static final String TABLE_MAHASISWA = "tbl_mahasiswa";
    private static final String KEY_ID_MAHASISWA = "id_mahasiswa";
    private static final String KEY_NAMA_MAHASISWA = "nama";
    private static final String KEY_TGL_LAHIR_MAHASISWA = "tgl_lahir";
    private static final String KEY_JK_MAHASISWA = "jenkel";
    private static final String KEY_ALAMAT_MAHASISWA = "alamat";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createMahasiswaTable =
                " CREATE TABLE " + TABLE_MAHASISWA + " ( "
                + KEY_ID_MAHASISWA + " INTEGER PRIMARY KEY "
                + " , " + KEY_NAMA_MAHASISWA + " TEXT "
                + " , " + KEY_TGL_LAHIR_MAHASISWA + " TEXT "
                + " , " + KEY_JK_MAHASISWA + " TEXT "
                + " , " + KEY_ALAMAT_MAHASISWA + " TEXT " + " ) ";
        db.execSQL(createMahasiswaTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_MAHASISWA;
        db.execSQL(sql);
        onCreate(db);
    }

    public void insert(MahasiswaBean mahasiswaBean){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID_MAHASISWA, mahasiswaBean.getIdMahasiswa());
        values.put(KEY_NAMA_MAHASISWA, mahasiswaBean.getNama());
        values.put(KEY_TGL_LAHIR_MAHASISWA, mahasiswaBean.getTglLahir());
        values.put(KEY_JK_MAHASISWA, mahasiswaBean.getTglLahir());
        values.put(KEY_ALAMAT_MAHASISWA, mahasiswaBean.getAlamat());
        db.insert(TABLE_MAHASISWA,null,values);
    }

    public List<MahasiswaBean> selectUserData() {
        List<MahasiswaBean> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {KEY_ID_MAHASISWA, KEY_NAMA_MAHASISWA, KEY_TGL_LAHIR_MAHASISWA, KEY_JK_MAHASISWA, KEY_ALAMAT_MAHASISWA};
        Cursor c = db.query(TABLE_MAHASISWA, columns, null, null, null, null, null);
        while(c.moveToNext()) {
            int id = c.getInt(0);
            String nama = c.getString(1);
            String tgl_lahir = c.getString(2);
            String jenkel = c.getString(3);
            String alamat = c.getString(4);

            MahasiswaBean m = new MahasiswaBean(id, nama, tgl_lahir, jenkel, alamat);
            list.add(m);
        }
        return list;
    }

    public void update(MahasiswaBean bean) {
        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAMA_MAHASISWA, bean.getNama());
        values.put(KEY_TGL_LAHIR_MAHASISWA, bean.getTglLahir());
        values.put(KEY_JK_MAHASISWA, bean.getJenKel());
        values.put(KEY_ALAMAT_MAHASISWA, bean.getAlamat());
        String whereClause = KEY_ID_MAHASISWA + " = '" + bean.getIdMahasiswa() + "'";
        db.update(TABLE_MAHASISWA, values, whereClause, null);
    }

    public void delete(int idMahasiswa) {
        SQLiteDatabase db = getWritableDatabase();
        String whereClause = KEY_ID_MAHASISWA + " = '" + idMahasiswa + "'";
        db.delete(TABLE_MAHASISWA, whereClause, null);
    }


}
