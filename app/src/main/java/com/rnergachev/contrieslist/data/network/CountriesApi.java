package com.rnergachev.contrieslist.data.network;

import com.rnergachev.contrieslist.data.model.Country;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Retrofit api definition
 *
 * Created by rnergachev.
 */

public interface CountriesApi {
    /**
     * Returns all countries
     *
     * @return {@link Single<ArrayList< Country >>}
     */
    @GET("all")
    Single<List<Country>> getCountries();
}
