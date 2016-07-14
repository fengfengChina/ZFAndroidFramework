package com.zero.android.model;

/**
 * Created by zengfeng on 16/7/13.
 */
public interface OnLoginListner {
    public void onUsernameError();

    public void onPasswordError();

    public void onSuccess();
}
