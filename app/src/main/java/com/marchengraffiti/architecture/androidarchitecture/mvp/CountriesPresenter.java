package com.marchengraffiti.architecture.androidarchitecture.mvp;

import com.marchengraffiti.architecture.androidarchitecture.model.CountriesService;
import com.marchengraffiti.architecture.androidarchitecture.model.Country;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class CountriesPresenter {
    private View view;                      //there's no strong link to view
    private CountriesService service;       //service to get the information


    public CountriesPresenter(View view){
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
                        view.setValues(countryNames);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onError();
                    }
                });


    }

    public void onRefresh() {
        fetchCountries();
    }

    public interface View{
        void setValues(List<String> countires);
        void onError();
    }
}
