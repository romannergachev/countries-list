package com.rnergachev.contrieslist.data;

import android.content.Context;

import com.rnergachev.contrieslist.R;
import com.rnergachev.contrieslist.data.network.CountriesApi;
import com.rnergachev.contrieslist.data.network.response.CountryResponse;

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
    private Context context;

    @Inject
    public CountriesRepo(CountriesApi api, Context context) {
        this.api = api;
        this.context = context;
    }

    /**
     * Load countries
     * @return {@link Single} list of countries
     */
    public Single<List<CountryResponse>> getCountries() {
        return api.getCountries()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    private String getImageUrl(String email) {
        return context.getString(R.string.country_url, email);
    }
}
