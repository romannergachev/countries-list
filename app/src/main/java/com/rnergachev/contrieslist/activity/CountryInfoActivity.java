package com.rnergachev.contrieslist.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.rnergachev.contrieslist.CountriesApplication;
import com.rnergachev.contrieslist.R;
import com.rnergachev.contrieslist.base.BaseActivity;
import com.rnergachev.contrieslist.data.model.Country;
import com.rnergachev.contrieslist.viewmodel.CountryInfoViewModel;

/**
 * Country Info Activity
 *
 * Created by rnergachev.
 */

public class CountryInfoActivity extends BaseActivity<CountryInfoViewModel> {
    @Override
    protected int getLayoutId() {
        return R.layout.country_info_activity;
    }

    @Override
    protected CountryInfoViewModel createViewModel() {
        Country country = getIntent().getParcelableExtra(getString(R.string.detailed_country));
        CountryInfoViewModel vm = viewModelProvider.get();
        vm.countryInfo = country;
        return vm;
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void injectDependencies() {
        ((CountriesApplication) getApplication()).appComponent.inject(this);
    }
}
