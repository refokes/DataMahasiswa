package com.example.datamahasiswa.db;

import android.os.Parcel;
import android.os.Parcelable;

public class MahasiswaBean implements Parcelable {
    private int idMahasiswa = 0;
    private String nama = " EMPTY ";
    private String tglLahir = " EMPTY ";
    private String jenKel = " EMPTY ";
    private String alamat = " EMPTY ";
    public static final Creator<MahasiswaBean> CREATOR = new Creator<MahasiswaBean>(){
        public MahasiswaBean createFromParcel(Parcel in) {
            return new MahasiswaBean(in);
        }

        @Override
        public MahasiswaBean[] newArray(int i) {
            return new MahasiswaBean[i];
        }
    };

    public MahasiswaBean(Parcel in) {
        idMahasiswa = in.readInt();
        nama = in.readString();
        tglLahir = in.readString();
        jenKel = in.readString();
        alamat = in.readString();
    }

    public MahasiswaBean(int idMahasiswa, String nama, String tglLahir, String jenKel, String alamat) {
        this.idMahasiswa = idMahasiswa;
        this.nama = nama;
        this.tglLahir = tglLahir;
        this.jenKel = jenKel;
        this.alamat = alamat;
    }

    public int getIdMahasiswa() {
        return idMahasiswa;
    }

    public String getNama() {
        return nama;
    }

    public String getTglLahir() {
        return tglLahir;
    }

    public String getJenKel() {
        return jenKel;
    }

    public String getAlamat() {
        return alamat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(idMahasiswa);
        parcel.writeString(nama);
        parcel.writeString(tglLahir);
        parcel.writeString(jenKel);
        parcel.writeString(alamat);
    }
}
