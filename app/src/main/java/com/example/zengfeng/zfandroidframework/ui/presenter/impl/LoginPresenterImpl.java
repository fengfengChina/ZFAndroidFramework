package com.example.zengfeng.zfandroidframework.ui.presenter.impl;

import com.example.zengfeng.zfandroidframework.base.BasePresenter;
import com.example.zengfeng.zfandroidframework.base.BaseView;
import com.example.zengfeng.zfandroidframework.ui.activity.LoginView;
import com.example.zengfeng.zfandroidframework.ui.model.LoginModel;
import com.example.zengfeng.zfandroidframework.ui.presenter.LoginPresenter;

/**
 * Created by zengfeng on 5/11/16.
 */
public class LoginPresenterImpl implements LoginPresenter{
    LoginModel loginModel;
    LoginView loginView;




    @Override
    public void login() {

    }

    @Override
    public <T extends BasePresenter, V extends BaseView> T init(V v) {
        return null;
    }
}
