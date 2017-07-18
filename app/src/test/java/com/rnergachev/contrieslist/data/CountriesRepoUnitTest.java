package com.rnergachev.contrieslist.data;

import android.content.Context;

import com.rnergachev.contrieslist.data.network.CountriesApi;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;

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
