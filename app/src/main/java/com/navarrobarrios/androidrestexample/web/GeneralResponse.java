package com.navarrobarrios.androidrestexample.web;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ${Navarro} on 12/1/17.
 */

public class GeneralResponse<T> {
    //region Variables
    @SerializedName("success")
    private boolean success;
    @SerializedName("response")
    private T response;
    //endregion

    //region Constructor's
    public GeneralResponse(){

    }

    public GeneralResponse(boolean success, T response) {
        super();
        this.success = success;
        this.response = response;
    }
    //endregion

    //region Setter's & Getter's
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
    //endregion
}
