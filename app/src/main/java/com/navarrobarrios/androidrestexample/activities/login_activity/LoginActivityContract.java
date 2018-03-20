package com.navarrobarrios.androidrestexample.activities.login_activity;


import com.navarrobarrios.androidrestexample.enums.ErrorCodes;

/**
 * Created by ${Navarro} on 12/1/17.
 */

public interface LoginActivityContract {

    interface View{
        /**
         * This method a material progress dialog to do reference loading information
         */
        void showLoggingInDialog();

        /**
         * This method hide the loging progress dialog if this is showing
         */
        void hideLoggingInDialog();

        /**
         * This Method will be show the loging was seuccess to the user on the view
         */
        void loginInRequestWasSuccessfully(String completeName);

        /**
         * This method will be show the error catched from web
         * @param errorMessages is the code receiver from web
         */
        void showError(ErrorCodes errorMessages);
    }

    interface Presenter{
        void requestLogin(String username, String password);
    }

}
