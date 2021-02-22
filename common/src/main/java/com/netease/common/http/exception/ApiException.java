package com.seewo.libaccount.net.exception;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.seewo.libaccount.AccountConfig;
import com.seewo.libaccount.R;
import com.seewo.libcommons.utils.ResourceUtil;

public class ApiException extends Exception {

    private static final String TAG = "ApiException";
    public static final String CODE_NFC_NO_BIND = "4700001";
    public static final String CODE_DEVICE_NO_BIND_CLUB = "4000003";
    public static final String CODE_CLUB_EXISTED = "4500010";
    private final String mErrorCode;
    private final String mErrorMsg;

    public ApiException(String errorCode) {
        Log.d(TAG, "error:" + errorCode);
        mErrorCode = errorCode;
        mErrorMsg = getErrorMessage(errorCode);
    }

    public String getErrorCode() {
        return mErrorCode;
    }

    @Override
    public String getMessage() {
        return mErrorMsg;
    }

    @Override
    public String toString() {
        return "error code: " + mErrorCode + " message: " + mErrorMsg;
    }

    private String getErrorMessage(String errorCode) {
        Context context = AccountConfig.getInstance().getContext();
        Resources res = context.getResources();
        int stringResId = ResourceUtil.getStringId(context, "error_msg_" + errorCode);
        return stringResId != 0 ? res.getString(stringResId) : res.getString(R.string.error_default);
    }
}
