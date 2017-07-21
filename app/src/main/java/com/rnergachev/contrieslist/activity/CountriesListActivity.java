package com.rnergachev.contrieslist.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rnergachev.contrieslist.CountriesApplication;
import com.rnergachev.contrieslist.R;
import com.rnergachev.contrieslist.adapter.CountriesListAdapter;
import com.rnergachev.contrieslist.base.BaseActivity;
import com.rnergachev.contrieslist.data.model.Country;
import com.rnergachev.contrieslist.handler.CountriesListAdapterHandler;
import com.rnergachev.contrieslist.viewmodel.CountriesListViewModel;

/**
 * Country List activity
 *
 * Created by rnergachev.
 */

public class CountriesListActivity extends BaseActivity<CountriesListViewModel> implements CountriesListAdapterHandler {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecyclerView view = (RecyclerView) findViewById(R.id.countriesList);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(new CountriesListAdapter(getViewModel(), this));
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getViewModel().loadCountries();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.countries_activity;
    }

    @Override
    public void onClick(Country country, View flag, View name) {
        Intent intent = new Intent(this, CountryInfoActivity.class);
        intent.putExtra(getString(R.string.detailed_country), country);
        Pair<View, String> p1 = Pair.create(flag, getString(R.string.transition_flag));
        Pair<View, String> p2 = Pair.create(name, getString(R.string.transition_name));
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, p1, p2);
        startActivity(intent, options.toBundle());
    }

    @Override
    protected void injectDependencies() {
        ((CountriesApplication) getApplication()).appComponent.inject(this);
    }
}
