package com.rnergachev.contrieslist.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;


/**
 * Country model class
 *
 * Created by rnergachev.
 */

public class Country implements Parcelable {
    private String name;
    private String alpha2Code;
    private String capital;
    private String region;
    private int population;
    private double area;
    private String nativeName;
    private String flag;
    private List<Currency> currencies;

    public Country() {}

    public Country(String name, String alpha2Code, String capital, String region, int population, double area, String nativeName, String flag, List<Currency> currencies) {
        this.name = name;
        this.alpha2Code = alpha2Code;
        this.capital = capital;
        this.region = region;
        this.population = population;
        this.area = area;
        this.nativeName = nativeName;
        this.flag = flag;
        this.currencies = currencies;
    }

    public String getName() {
        return name;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public String getCapital() {
        return capital;
    }

    public String getRegion() {
        return region;
    }

    public int getPopulation() {
        return population;
    }

    public double getArea() {
        return area;
    }

    public String getNativeName() {
        return nativeName;
    }

    public String getFlag() {
        return flag;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(currencies);
        dest.writeInt(this.population);
        dest.writeDouble(this.area);
        dest.writeString(this.name);
        dest.writeString(this.alpha2Code);
        dest.writeString(this.capital);
        dest.writeString(this.region);
        dest.writeString(this.nativeName);
        dest.writeString(this.flag);
    }

    private Country(Parcel in) {
        in.readList(this.currencies, Currency.class.getClassLoader());
        this.population = in.readInt();
        this.area = in.readDouble();
        this.name = in.readString();
        this.alpha2Code = in.readString();
        this.capital = in.readString();
        this.region = in.readString();
        this.nativeName = in.readString();
        this.flag = in.readString();
    }

    public static final Parcelable.Creator<Country> CREATOR = new Parcelable.Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel source) {
            return new Country(source);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };
}
