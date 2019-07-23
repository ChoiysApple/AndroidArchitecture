package com.marchengraffiti.architecture.androidarchitecture.model;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface CountriesApi {
    //observable just emits information
    @GET("all")
    Single<List<Country>> getCountries();
}
