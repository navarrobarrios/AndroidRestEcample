package com.navarrobarrios.androidrestexample.managers;


import com.navarrobarrios.androidrestexample.beans.unpersistible.LoginEntity;
import com.navarrobarrios.androidrestexample.utils.ErrorUtilities;
import com.navarrobarrios.androidrestexample.web.GeneralResponse;
import com.navarrobarrios.androidrestexample.web.LoginCore;
import com.navarrobarrios.androidrestexample.web.RestFulManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ${Navarro} on 12/4/17.
 */

public class LoginManager{

    //region getInstance
    public static LoginManager getInstance(){
        return new LoginManager();
    }
    //endregion

    //region Operations

    //region RequestLogin Method
    /**
     *
     * @param username is the username of the user request login
     * @param password  is the password to the user
     * @param mOnManagerResultWasSuccess is the callback where the result success will be returned
     * @param mOnManagerResultWasFailed is the callback where in cause error will be returned
     */
    public void requestLogin(String username, String password,
                             final Manager.OnManagerResultWasSuccess<String> mOnManagerResultWasSuccess,
                             final Manager.OnManagerResultWasFailed mOnManagerResultWasFailed){

        Call<GeneralResponse<LoginEntity>> rLogin = RestFulManager.getInstance()
                                                        .start(LoginCore.class)
                                                        .requestLogin(username, password);

        rLogin.enqueue(new Callback<GeneralResponse<LoginEntity>>() {
            @Override
            public void onResponse(Call<GeneralResponse<LoginEntity>> call,
                                   Response<GeneralResponse<LoginEntity>> response) {
                if(response.body().isSuccess()){
                    mOnManagerResultWasSuccess.onManagerResultWasSuccess(
                            response.body().getResponse().getName()
                            + " " +
                            response.body().getResponse().getLastname());
                }else{
                    mOnManagerResultWasFailed.onManagerResultWasFailed(
                            response.body().getResponse().getError());
                }
            }

            @Override
            public void onFailure(Call<GeneralResponse<LoginEntity>> call, Throwable t) {
                mOnManagerResultWasFailed.onManagerResultWasFailed(ErrorUtilities.getError(t));
            }
        });
    }
    //endregion
    //endregion
}
