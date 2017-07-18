package com.rnergachev.contrieslist.viewmodel;

import android.databinding.ObservableArrayList;
import android.util.Log;

import com.rnergachev.contrieslist.base.BaseViewModel;
import com.rnergachev.contrieslist.data.CountriesRepo;
import com.rnergachev.contrieslist.data.model.Country;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Countries list view model
 *
 * Created by rnergachev.
 */

public class CountriesListViewModel implements BaseViewModel {
    public final ObservableArrayList<Country> countriesList;
    private final CountriesRepo repo;
    private final CompositeDisposable subscriptions;

    @Inject
    public CountriesListViewModel(CountriesRepo repo) {
        countriesList = new ObservableArrayList<>();
        this.repo = repo;
        this.subscriptions = new CompositeDisposable();
    }

    /**
     * Loads countries into the list
     */
    public void loadCountries() {
        subscriptions.add(repo.getCountries().subscribe(
            list -> {
                countriesList.clear();
                countriesList.addAll(list);
            }, e -> {
                Log.e(getClass().getName(), "Update failed", e);
            }
        ));
    }


    @Override
    public void clear() {
        subscriptions.clear();
    }
}