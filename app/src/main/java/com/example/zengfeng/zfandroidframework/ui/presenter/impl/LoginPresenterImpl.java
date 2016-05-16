package com.example.zengfeng.zfandroidframework.ui.presenter.impl;

import com.example.zengfeng.zfandroidframework.base.BasePresenter;
import com.example.zengfeng.zfandroidframework.base.BaseView;
import com.example.zengfeng.zfandroidframework.ui.activity.LoginView;
import com.example.zengfeng.zfandroidframework.ui.model.LoginModel;
import com.example.zengfeng.zfandroidframework.ui.model.bean.User;
import com.example.zengfeng.zfandroidframework.ui.presenter.LoginPresenter;

import retrofit2.Call;

/**
 * Created by zengfeng on 5/11/16.
 */
public class LoginPresenterImpl implements LoginPresenter{
    LoginModel loginModel;
    LoginView loginView;

    @Override
    public void login(String userName , String password) {
        Call<User> user =  loginModel.login(userName, password);
    }

    @Override
    public <T extends BasePresenter, V extends BaseView> T init(V v) {
        return null;
    }
}
