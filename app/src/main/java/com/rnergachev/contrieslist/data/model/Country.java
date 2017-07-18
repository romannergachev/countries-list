package com.rnergachev.contrieslist.data.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

import com.rnergachev.contrieslist.BR;

/**
 * Country model class
 *
 * Created by rnergachev.
 */

public class Country extends BaseObservable implements Parcelable {
    private int id;
    private String title;
    private String body;
    private String userName;
    private int numberOfComments;
    private String imageUrl;

    public Country() {}

    public Country(int id, String title, String body, String userName, String imageUrl) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.userName = userName;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getUserName() {
        return userName;
    }

    @Bindable
    public int getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(int numberOfComments) {
        this.numberOfComments = numberOfComments;
        notifyPropertyChanged(BR.numberOfComments);
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.numberOfComments);
        dest.writeString(this.title);
        dest.writeString(this.body);
        dest.writeString(this.userName);
        dest.writeString(this.imageUrl);
    }

    private Country(Parcel in) {
        this.id = in.readInt();
        this.numberOfComments = in.readInt();
        this.title = in.readString();
        this.body = in.readString();
        this.userName = in.readString();
        this.imageUrl = in.readString();
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
