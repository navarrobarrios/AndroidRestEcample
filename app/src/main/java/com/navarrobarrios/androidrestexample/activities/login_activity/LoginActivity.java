package com.navarrobarrios.androidrestexample.activities.login_activity;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.afollestad.materialdialogs.MaterialDialog;
import com.navarrobarrios.androidrestexample.R;
import com.navarrobarrios.androidrestexample.activities.MainActivity;
import com.navarrobarrios.androidrestexample.enums.ErrorCodes;
import com.navarrobarrios.androidrestexample.utils.ViewUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class LoginActivity extends AppCompatActivity implements LoginActivityContract.View{

    //region Variables
    //region Variables
    LoginActivityContract.Presenter mPresenter;
    //endregion
    //region Views
    @BindView(R.id.activity_login_login)
    Button mRequestLoginButton;
    @BindView(R.id.activity_login_username_edittext)
    EditText mUsernameEditText;
    @BindView(R.id.activity_login_username_layout)
    TextInputLayout mUsernameLayout;
    @BindView(R.id.activity_login_password_edittext)
    EditText mPasswordEditText;
    @BindView(R.id.activity_login_password_layout)
    TextInputLayout mPasswordLayout;
    //endregion
    //region Listeners
    @OnClick(R.id.activity_login_login)
    void onRequestLoginWasClicked(){
        if(allFieldsAreFine()){
            mPresenter.requestLogin(mUsernameEditText.getText().toString(), mPasswordEditText.getText().toString());
        }
    }

    @OnTextChanged(R.id.activity_login_username_edittext)
    void onUsernameChange(){
        mUsernameLayout.setError(null);
        mUsernameLayout.setErrorEnabled(false);
    }

    @OnTextChanged(R.id.activity_login_password_edittext)
    void onPasswordChange(){
        mPasswordLayout.setError(null);
        mPasswordLayout.setErrorEnabled(false);
    }
    //endregion
    //endregion

    //region Activity Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mPresenter = new LoginActivityPresenter(this);
    }
    //endregion

    //region Local Methods
    public boolean allFieldsAreFine(){
        boolean allFieldsAreFine = true;
        if(mPasswordEditText.getText().toString().isEmpty()){
            mPasswordLayout.setError(getString(R.string.general_string_required_field));
            allFieldsAreFine = false;
        }
        if(mUsernameEditText.getText().toString().isEmpty()){
            mUsernameLayout.setError(getString(R.string.general_string_required_field));
            allFieldsAreFine = false;
        }
        return allFieldsAreFine;
    }
    //endregion

    //region LoginActvityContract.Presenter
    @Override
    public void showLoggingInDialog() {
        ViewUtils.showProgressDialog(this, getString(R.string.loging_in_txt));
    }

    @Override
    public void hideLoggingInDialog() {
        ViewUtils.hideProgressDialog();
    }

    @Override
    public void loginInRequestWasSuccessfully(String completeName) {
        new MaterialDialog.Builder(this)
                .title("Welcome back!")
                .content(completeName)
                .positiveText("Continue")
                .onPositive((dialog, which) -> {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                    LoginActivity.this.finish();
                })
                .cancelable(false)
                .canceledOnTouchOutside(false)
                .autoDismiss(true)
                .show();
    }

    @Override
    public void showError(ErrorCodes errorCodes) {
        ViewUtils.showErrorMessage(this, errorCodes);
    }
    //endregion
}
