package com.marchengraffiti.architecture.androidarchitecture.mvc;

import com.marchengraffiti.architecture.androidarchitecture.model.CountriesService;
import com.marchengraffiti.architecture.androidarchitecture.model.Country;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class CountriesController {

    private MVCActivity view;
    private CountriesService service;   //service call information

    public CountriesController(MVCActivity view){
        this.view = view;
        service = new CountriesService();
        fetchCountries();
    }

    private void fetchCountries(){
        service.getCountries()                                      //return single observable
                .subscribeOn(Schedulers.newThread())                //telling the system this needs to run on background thread
                .observeOn(AndroidSchedulers.mainThread())          //observe on main thread
                .subscribeWith(new DisposableSingleObserver<List<Country>>() {
                    @Override
                    public void onSuccess(List<Country> value) {
                        List<String> countryNames = new ArrayList<>();
                        for (Country country: value){
                            countryNames.add(country.countryName);
                        }
                        view.setValues(countryNames);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

}
