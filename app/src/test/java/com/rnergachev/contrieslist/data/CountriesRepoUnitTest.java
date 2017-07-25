package com.rnergachev.contrieslist.data;

import android.content.Context;

import com.rnergachev.contrieslist.data.model.Country;
import com.rnergachev.contrieslist.data.network.CountriesApi;

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

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
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
    private CountriesRepo repo;
    private List<Country> countriesList;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        repo = new CountriesRepo(api);
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(__ -> Schedulers.trampoline());
        countriesList = new ArrayList<>();
        countriesList.add(new Country());
        countriesList.add(new Country());
    }

    @Test
    public void repo_should_get_countries() {
        when(api.getCountries())
            .thenReturn(Single.just(countriesList));

        TestObserver<List<Country>> testObserver = repo.getCountries().test();
        verify(api, atLeastOnce()).getCountries();
        testObserver
            .awaitTerminalEvent();
        testObserver
            .assertNoErrors()
            .assertValue(list -> list.size() == 2);
    }


    @After
    public void cleanUp() {
        RxAndroidPlugins.reset();
    }
}
