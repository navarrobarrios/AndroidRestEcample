package com.navarrobarrios.androidrestexample.web;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ${Navarro} on 12/1/17.
 */

public class RestFulManager {
    //region Variables
    private static final String BASE_URL = "http://192.168.9.22:8081/FirstSpringMVC/api/";
    private static Retrofit mRetrofit;
    //endregion

    //region getInstance
    public static RestFulManager getInstance(){
        return new RestFulManager();
    }
    //endregion

    //region Constructor
    public RestFulManager() {
        mRetrofit =
                new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(BASE_URL).build();
    }
    //endregion

    //region Operations
    public <S> S start(Class<S> classDef){
        return mRetrofit.create(classDef);
    }
    //endregion
}
