package com.rnergachev.contrieslist.handler;


import android.view.View;

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
     * @param flag
     * @param name
     */
    void onClick(Country country, View flag, View name);
}
