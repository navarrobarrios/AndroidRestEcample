package com.navarrobarrios.androidrestexample.web;


import com.navarrobarrios.androidrestexample.beans.unpersistible.LoginEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ${Navarro} on 12/1/17.
 */

public interface LoginCore {

    @GET("login/requestLogin")
    Call<GeneralResponse<LoginEntity>> requestLogin(@Query("username") String username, @Query("password") String password);
}
