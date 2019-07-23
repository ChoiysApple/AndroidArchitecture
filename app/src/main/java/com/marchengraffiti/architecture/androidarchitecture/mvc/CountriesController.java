package com.marchengraffiti.architecture.androidarchitecture.mvc;

import com.marchengraffiti.architecture.androidarchitecture.model.CountriesService;
import com.marchengraffiti.architecture.androidarchitecture.model.Country;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class CountriesController {

    private MVCActivity view;               //this is view of MVC
    private CountriesService service;       //service to get the information


    public CountriesController(MVCActivity view){
        this.view = view;
        service = new CountriesService();
        fetchCountries();

    }

    private void fetchCountries(){
        service.getCountries()
                .subscribeOn(Schedulers.newThread())        //run on background Thread
                .observeOn(AndroidSchedulers.mainThread())  //observe on main Thread
                .subscribeWith(new DisposableSingleObserver<List<Country>>() {

                    @Override
                    public void onSuccess(List<Country> value) {
                        List<String> countryNames = new ArrayList<>();
                        for(Country country: value){
                            countryNames.add(country.countryName);
                        }

                        view.setValues(countryNames);       //update view
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

}
