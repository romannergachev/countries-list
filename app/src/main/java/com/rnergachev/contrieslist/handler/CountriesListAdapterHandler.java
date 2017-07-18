package com.rnergachev.contrieslist.handler;


import com.rnergachev.contrieslist.data.model.Country;

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
    void onClick(Country country);
}
