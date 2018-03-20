package com.navarrobarrios.androidrestexample.beans.unpersistible;

import com.google.gson.annotations.SerializedName;
import com.navarrobarrios.androidrestexample.enums.ErrorCodes;
import com.navarrobarrios.androidrestexample.utils.ErrorUtilities;

/**
 * Created by ${Navarro} on 12/1/17.
 */

public class ErrorEntity {
    //region Variables
    @SerializedName("error_code")
    private int errorCode;
    @SerializedName("message")
    private String errorMessage;
    private ErrorCodes error;
    //endregion

    //region Constructor's
    public ErrorEntity() {
    }

    public ErrorEntity(int errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    //endregion

    //region Setter's & Getter's

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ErrorCodes getError() {
        this.error = ErrorUtilities.getError(errorCode);
        return error;
    }
    //endregion
}
