package com.rnergachev.contrieslist.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Currency model class
 *
 * Created by rnergachev on 18/07/2017.
 */

public class Currency implements Parcelable {
    String code;
    String name;
    String symbol;

    public Currency() {
    }

    public Currency(String code, String name, String symbol) {
        this.code = code;
        this.name = name;
        this.symbol = symbol;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.code);
        dest.writeString(this.name);
        dest.writeString(this.symbol);
    }

    private Currency(Parcel in) {
        this.code = in.readString();
        this.name = in.readString();
        this.symbol = in.readString();
    }

    public static final Parcelable.Creator<Currency> CREATOR = new Parcelable.Creator<Currency>() {
        @Override
        public Currency createFromParcel(Parcel source) {
            return new Currency(source);
        }

        @Override
        public Currency[] newArray(int size) {
            return new Currency[size];
        }
    };
}
