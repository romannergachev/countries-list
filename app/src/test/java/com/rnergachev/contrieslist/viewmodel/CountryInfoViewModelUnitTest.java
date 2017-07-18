package com.rnergachev.contrieslist.viewmodel;

import com.rnergachev.contrieslist.data.CountriesRepo;
import com.rnergachev.contrieslist.data.model.Country;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import io.reactivex.Single;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * {@link CountryInfoViewModel} unit test
 *
 * Created by rnergachev.
 */

@RunWith(MockitoJUnitRunner.class)
public class CountryInfoViewModelUnitTest {

    @Mock
    private CountriesRepo repo;
    private CountryInfoViewModel vm;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        vm = new CountryInfoViewModel(repo);
        vm.countryInfo = new Country(0, "", "", "", "");
    }
}
