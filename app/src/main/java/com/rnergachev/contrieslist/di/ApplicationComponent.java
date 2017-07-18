package com.rnergachev.contrieslist.di;

import com.rnergachev.contrieslist.activity.CountryInfoActivity;
import com.rnergachev.contrieslist.activity.CountriesListActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Application component for dagger
 *
 * Created by rnergachev.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(CountriesListActivity activity);
    void inject(CountryInfoActivity activity);
}
