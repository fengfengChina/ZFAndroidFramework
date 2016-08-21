package com.zero.android.present;

import com.zero.android.constact.LoginConstact;
import com.zero.android.model.LoginModel;
import com.zero.android.model.OnLoginListner;

/**
 * Created by zengfeng on 16/7/6.
 */
public class LoginPresent implements LoginConstact.Presenter ,OnLoginListner{
    LoginConstact.View view;
    LoginModel loginModel;
    public LoginPresent(LoginConstact.View view){
        this.view = view;
        loginModel = new LoginModel();
    }




    @Override
    public void loginTask(String username, String password) {
        view.showLoading();
        loginModel.login(username,password,this);
    }


    @Override
    public void onUsernameError() {
        view.dismissLoading();
        view.showLoginError();
    }

    @Override
    public void onPasswordError() {
        view.dismissLoading();
        view.showLoginError();
    }

    @Override
    public void onSuccess(String username) {
        view.dismissLoading();
        view.showLoginSuccess(username);
    }
}
