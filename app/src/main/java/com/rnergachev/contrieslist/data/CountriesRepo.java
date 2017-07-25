package com.rnergachev.contrieslist.data;

import com.rnergachev.contrieslist.data.model.Country;
import com.rnergachev.contrieslist.data.network.CountriesApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Main repo
 *
 * Created by rnergachev.
 */

public class CountriesRepo {
    private CountriesApi api;

    @Inject
    public CountriesRepo(CountriesApi api) {
        this.api = api;
    }

    /**
     * Load countries
     * @return {@link Single} list of countries
     */
    public Single<List<Country>> getCountries() {
        return api.getCountries()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }
}
