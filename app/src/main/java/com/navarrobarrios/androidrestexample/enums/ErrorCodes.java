package com.navarrobarrios.androidrestexample.enums;


import com.navarrobarrios.androidrestexample.R;

/**
 * Created by ${Navarro} on 12/1/17.
 */

public enum ErrorCodes {
    //region Error declarations
    //region Web errros
    ERROR_E001(1,R.string.error_default_title, R.string.error_message_E001),
    ERROR_E002(2,R.string.error_default_title, R.string.error_message_E002),
    ERROR_E003(3,R.string.error_default_title, R.string.error_message_E003),
    ERROR_E004(4,R.string.error_default_title, R.string.error_message_E004),
    ERROR_E000(0,R.string.error_default_title, R.string.error_message_E000),
    //endregion
    //region Local errors
    ERROR_E1001(1001,R.string.error_default_title, R.string.error_message_E1001),
    ERROR_E1002(1002,R.string.error_default_title, R.string.error_message_E1002),
    ERROR_E1003(1003,R.string.error_default_title, R.string.error_message_E1003),
    ERROR_E1004(1004,R.string.error_default_title, R.string.error_message_E1004),
    ERROR_E1000(1000,R.string.error_default_title, R.string.error_message_E1000);
    //endregion
    //endregion

    //region Global Variables
    private int errorCode;
    private int titleResource;
    private int messageResource;
    private Exception exception;
    //endregion

    ErrorCodes(int errorCode, int titleResource, int messageResource) {
        this.errorCode = errorCode;
        this.titleResource = titleResource;
        this.messageResource = messageResource;
    }
    //region Getters
    public int getErrorCode() {
        return errorCode;
    }

    public int getTitleResource() {
        return titleResource;
    }

    public int getMessageResource() {
        return messageResource;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    //endregion
}
