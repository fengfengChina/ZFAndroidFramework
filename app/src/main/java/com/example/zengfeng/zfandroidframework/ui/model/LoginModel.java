package com.example.zengfeng.zfandroidframework.ui.model;

import com.example.zengfeng.zfandroidframework.Api;
import com.example.zengfeng.zfandroidframework.ui.model.bean.User;

import java.util.List;

import retrofit2.Call;

/**
 * Created by zengfeng on 5/10/16.
 */
public class LoginModel {
    public Call<User> login(String userName, String password) {
        return Api.getApiServiceInstance().login(userName , password);
    }
}
