package com.rnergachev.contrieslist.handler;

import com.rnergachev.contrieslist.data.network.response.CountryResponse;

/**
 * List on click handler
 *
 * Created by rnergachev.
 */

public interface CountriesListAdapterHandler {
    /**
     * Performs the country selection
     *
     * @param country that has been selected
     */
    void onClick(CountryResponse country);
}
