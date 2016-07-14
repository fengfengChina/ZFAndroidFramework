package com.zero.android.model;

import android.os.Handler;
import android.text.TextUtils;


/**
 * Created by zengfeng on 16/7/6.
 */
public class LoginModel {

    public void login(String userName, String password, OnLoginListner listner){
        new Handler().postDelayed(()-> {
                boolean error = false;
                if (TextUtils.isEmpty(userName)){
                    listner.onUsernameError();
                    error = true;
                }
                if (TextUtils.isEmpty(password)){
                    listner.onPasswordError();
                    error = true;
                }
                if (!error) {
                    listner.onSuccess();
                }
        }, 2000);
    }

}
