package com.rnergachev.contrieslist.viewmodel;

import com.rnergachev.contrieslist.data.CountriesRepo;
import com.rnergachev.contrieslist.data.model.Country;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import io.reactivex.Single;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * {@link CountriesListViewModel} unit test
 *
 * Created by rnergachev.
 */

@RunWith(MockitoJUnitRunner.class)
public class CountriesListViewModelUnitTest {
    @Mock
    private CountriesRepo repo;
    private CountriesListViewModel vm;
    private ArrayList<Country> data;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        vm = new CountriesListViewModel(repo);
        data = new ArrayList<>();
        data.add(new Country());
        data.add(new Country());
    }
}
