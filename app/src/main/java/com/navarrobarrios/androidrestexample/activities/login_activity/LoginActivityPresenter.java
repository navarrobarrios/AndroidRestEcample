package com.navarrobarrios.androidrestexample.activities.login_activity;


import com.navarrobarrios.androidrestexample.managers.LoginManager;

/**
 * Created by ${Navarro} on 12/1/17.
 */

public class LoginActivityPresenter implements LoginActivityContract.Presenter {
    //region Variables
    private LoginActivityContract.View mView;
    //endregion

    //region Constructor
    public LoginActivityPresenter(LoginActivityContract.View view) {
        this.mView = view;
    }
    //endregion

    //region LoginActivityContract.View Methods
    @Override
    public void requestLogin(final String username, final String password) {
        mView.showLoggingInDialog();
        LoginManager.getInstance().requestLogin(username, password,
                result -> {
                    mView.hideLoggingInDialog();
                    mView.loginInRequestWasSuccessfully(result);
                },
                errorCodes -> {
                    mView.hideLoggingInDialog();
                    mView.showError(errorCodes);
                });
    }
    //endregion

}
