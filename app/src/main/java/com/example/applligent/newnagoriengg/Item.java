package com.example.applligent.newnagoriengg;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
@Entity
public class Item implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String companyName;
    public String partName;
    public  String partNumber;
    public float priceRate;



    public Item(){

    }

    @Ignore
    protected Item(Parcel in) {
        id = in.readInt();
        companyName = in.readString();
        partName = in.readString();
        partNumber = in.readString();
        priceRate = in.readFloat();
    }
    @Ignore
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(companyName);
        dest.writeString(partName);
        dest.writeString(partNumber);
        dest.writeFloat(priceRate);
    }
    @Ignore
    @Override
    public int describeContents() {
        return 0;
    }
    @Ignore
    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
