package com.navarrobarrios.androidrestexample.utils;

import android.app.Activity;

import com.afollestad.materialdialogs.MaterialDialog;
import com.navarrobarrios.androidrestexample.R;
import com.navarrobarrios.androidrestexample.enums.ErrorCodes;

import java.text.DecimalFormat;

/**
 * Created by ${Navarro} on 12/1/17.
 */

public class ViewUtils {
    public static MaterialDialog mProgressDialog;

    public static MaterialDialog showErrorMessage(final Activity activityContext, ErrorCodes errorCodes) {
        DecimalFormat format = new DecimalFormat("000");
        if (errorCodes != null){
            switch (errorCodes){
                case ERROR_E1000:
                    return new MaterialDialog.Builder(activityContext)
                            .title(errorCodes.getTitleResource())
                            .content(String.format(activityContext.getString(errorCodes.getMessageResource()), format.format(errorCodes.getErrorCode())))
                            .icon(activityContext.getResources().getDrawable(R.drawable.ic_error_black_24dp))
                            .positiveText(activityContext.getString(R.string.general_string_accept))
                            .show();
                default:
                    return new MaterialDialog.Builder(activityContext)
                            .title(errorCodes.getTitleResource())
                            .content(errorCodes.getMessageResource())
                            .icon(activityContext.getResources().getDrawable(R.drawable.ic_error_black_24dp))
                            .positiveText(activityContext.getString(R.string.general_string_accept))
                            .show();
            }
        }else{
            return new MaterialDialog.Builder(activityContext)
                    .title(activityContext.getString(R.string.error_default_title))
                    .content(activityContext.getString(R.string.error_message_E000))
                    .icon(activityContext.getResources().getDrawable(R.drawable.ic_error_black_24dp))
                    .positiveText(activityContext.getString(R.string.general_string_accept))
                    .show();
        }
    }

    public static void showProgressDialog(Activity activity, String content){
        mProgressDialog = new MaterialDialog.Builder(activity)
                .content(content)
                .progress(true, 0)
                .progressIndeterminateStyle(false)
                .canceledOnTouchOutside(false)
                .cancelable(false)
                .autoDismiss(false)
                .show();
    }

    public static void hideProgressDialog(){
        if(mProgressDialog != null && mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }
    }
}
