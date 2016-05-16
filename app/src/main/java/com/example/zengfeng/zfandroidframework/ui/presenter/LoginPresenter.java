package com.example.zengfeng.zfandroidframework.ui.presenter;

import com.example.zengfeng.zfandroidframework.base.BasePresenter;
import com.example.zengfeng.zfandroidframework.ui.model.bean.remote.Data;

import java.util.List;

/**
 * Created by zengfeng on 5/10/16.
 */
public interface LoginPresenter extends BasePresenter {

    void login(String userName , String password);

}
