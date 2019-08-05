package com.marchengraffiti.architecture.androidarchitecture.mvvm;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.marchengraffiti.architecture.androidarchitecture.model.CountriesService;
import com.marchengraffiti.architecture.androidarchitecture.model.Country;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class CountriesViewModel extends ViewModel {

    private final MutableLiveData<List<String>> countries = new MutableLiveData<>();
    private final MutableLiveData<Boolean> countryError = new MutableLiveData<>();

    private CountriesService service;

    public CountriesViewModel(){
        service = new CountriesService();
        fetchCountries();
    }

    public LiveData<List<String>> getCountries() {
        return countries;
    }

    public LiveData<Boolean> getCountryError() {
        return countryError;
    }

    private void fetchCountries(){

        service.getCountries()
                .subscribeOn(Schedulers.newThread())        //run on background Thread
                .observeOn(AndroidSchedulers.mainThread())  //observe on main Thread
                .subscribeWith(new DisposableSingleObserver<List<Country>>() {

                    @Override
                    public void onSuccess(List<Country> value) {
                        /*List<String> countryNames = new ArrayList<>();

                        for(Country country : value){
                            countryNames.add(country.countryName);
                        }*/

                        ArrayList<String> countryNames = new ArrayList<>();
                        countryNames.add("UK");
                        countryNames.add("USA");
                        countryNames.add("France");
                        countryNames.add("South Korea");
                        countryNames.add("Canada");
                        countryNames.add("Spain");
                        countryNames.add("China");
                        countryNames.add("Russia");
                        countryNames.add("Brazil");
                        countryNames.add("North Korea");
                        countryNames.add("Italy");
                        countryNames.add("Switzerland");
                        //view.onError();
                        countries.setValue(countryNames);
                        countryError.setValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        countryError.setValue(true);
                    }
                });


    }

    public void onRefresh() {
        fetchCountries();
    }

}
