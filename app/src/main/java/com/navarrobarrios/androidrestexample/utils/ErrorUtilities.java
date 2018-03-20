package com.navarrobarrios.androidrestexample.utils;


import com.navarrobarrios.androidrestexample.enums.ErrorCodes;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

/**
 * Created by ${Navarro} on 12/1/17.
 */

public class ErrorUtilities {

    public static ErrorCodes getError(int errorCode){
        switch (errorCode){
            case 0:
                return ErrorCodes.ERROR_E000;
            case 1:
                return ErrorCodes.ERROR_E001;
            case 2:
                return ErrorCodes.ERROR_E002;
            case 3:
                return ErrorCodes.ERROR_E003;
            case 4:
                return ErrorCodes.ERROR_E004;
            default:
                ErrorCodes unkowError = ErrorCodes.ERROR_E1000;
                unkowError.setErrorCode(errorCode);
                return unkowError;
        }
    }

    public static ErrorCodes getError(Throwable exception){
        if(exception instanceof SocketTimeoutException){
            return ErrorCodes.ERROR_E1002;
        }
        if(exception instanceof ConnectException){
            return ErrorCodes.ERROR_E1003;
        }
        if(exception instanceof IllegalStateException){
            return ErrorCodes.ERROR_E1004;
        }
        if(exception instanceof IOException){
            return ErrorCodes.ERROR_E1001;
        }
        return ErrorCodes.ERROR_E000;
    }
}
