package com.zero.android.zfandroidframework.common;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by zengfeng on 16/7/6.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Context context;


    private BasePresent present;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutInflaterView());
        initView();
    }

    public abstract int getLayoutInflaterView();

    public abstract void initView();

    public abstract void initPresenter();

    public Context getContext() {
        return this;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public BasePresent getPresent() {
        return present;
    }

    public void setPresent(BasePresent present) {
        this.present = present;
    }
}
