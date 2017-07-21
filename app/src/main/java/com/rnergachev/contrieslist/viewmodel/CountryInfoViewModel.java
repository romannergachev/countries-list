package com.rnergachev.contrieslist.viewmodel;

import com.rnergachev.contrieslist.base.BaseViewModel;
import com.rnergachev.contrieslist.data.CountriesRepo;
import com.rnergachev.contrieslist.data.model.Country;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Country info view model
 *
 * Created by rnergachev.
 */

public class CountryInfoViewModel implements BaseViewModel {
    public Country countryInfo;
    private final CompositeDisposable subscriptions;

    @Inject
    public CountryInfoViewModel(CountriesRepo repo) {
        countryInfo = null;
        this.subscriptions = new CompositeDisposable();
    }

    @Override
    public void clear() {
        subscriptions.clear();
    }
}