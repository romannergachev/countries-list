package com.rnergachev.contrieslist.data;

import android.content.Context;

import com.rnergachev.contrieslist.data.model.Country;
import com.rnergachev.contrieslist.data.network.CountriesApi;
import com.rnergachev.contrieslist.data.network.response.CountryResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.Mockito.when;

/**
 * {@link CountriesRepo} unit test
 *
 * Created by rnergachev.
 */

@RunWith(MockitoJUnitRunner.class)
public class CountriesRepoUnitTest {
    @Mock
    private CountriesApi api;
    @Mock
    Context context;
    private CountriesRepo repo;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        repo = new CountriesRepo(api, context);
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(__ -> Schedulers.trampoline());
    }


    @After
    public void cleanUp() {
        RxAndroidPlugins.reset();
    }
}
