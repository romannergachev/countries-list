package com.rnergachev.contrieslist;

import android.app.Application;
import android.databinding.DataBindingUtil;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.rnergachev.contrieslist.binding.CountriesDataBindingComponent;
import com.rnergachev.contrieslist.di.ApplicationComponent;
import com.rnergachev.contrieslist.di.ApplicationModule;
import com.rnergachev.contrieslist.di.DaggerApplicationComponent;
import com.squareup.picasso.Picasso;

/**
 * Application class, used to include dagger, picasso and define default data binding component
 *
 * Created by rnergachev.
 */

public class CountriesApplication extends Application {

    public ApplicationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();

        Picasso picasso = new Picasso.Builder(this)
            .downloader(new OkHttp3Downloader(this, Integer.MAX_VALUE))
            .indicatorsEnabled(false)
            .loggingEnabled(false)
            .build();
        Picasso.setSingletonInstance(picasso);
        DataBindingUtil.setDefaultComponent(new CountriesDataBindingComponent());
    }

}