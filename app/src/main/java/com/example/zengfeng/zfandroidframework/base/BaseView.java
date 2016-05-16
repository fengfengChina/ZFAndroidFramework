package com.example.zengfeng.zfandroidframework.base;

import android.content.Context;

import butterknife.BindView;

/**
 * Created by zengfeng on 5/10/16.
 */
public interface BaseView {
    void initView();

    void initPresenter(BaseView baseView, Context context);
}
