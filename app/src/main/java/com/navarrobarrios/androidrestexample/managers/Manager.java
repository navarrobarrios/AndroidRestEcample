package com.navarrobarrios.androidrestexample.managers;


import com.navarrobarrios.androidrestexample.enums.ErrorCodes;

/**
 * Created by ${Navarro} on 12/4/17.
 */

public interface Manager {

    interface OnManagerResultWasSuccess<T>{
        void onManagerResultWasSuccess(T result);
    }

    interface OnManagerResultWasFailed{
        void onManagerResultWasFailed(ErrorCodes errorCodes);
    }
}
