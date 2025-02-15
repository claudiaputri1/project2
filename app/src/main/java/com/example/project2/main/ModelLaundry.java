package com.example.project2.main;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_laundry")
public class ModelLaundry implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "nama_jasa")
    public String nama_jasa;

    @ColumnInfo(name = "items")
    public int items;

    @ColumnInfo(name = "alamat")
    public String alamat;

    @ColumnInfo(name = "harga")
    public int harga;

    public ModelLaundry() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getNama_jasa() {
        return nama_jasa;
    }

    public void setNama_jasa(String nama_jasa) {
        this.nama_jasa = nama_jasa;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.uid);
        dest.writeString(this.nama_jasa);
        dest.writeInt(this.items);
        dest.writeString(this.alamat);
        dest.writeInt(this.harga);
    }

    protected ModelLaundry(Parcel in) {
        this.uid = in.readInt();
        this.nama_jasa = in.readString();
        this.items = in.readInt();
        this.alamat = in.readString();
        this.harga = in.readInt();
    }

    public static final Creator<ModelLaundry> CREATOR =new Creator<ModelLaundry>() {
        @Override
        public ModelLaundry createFromParcel(Parcel source) {
            return new ModelLaundry(source);
        }

        @Override
        public ModelLaundry[] newArray(int size) {
            return new ModelLaundry[size];
        }
    };
}
