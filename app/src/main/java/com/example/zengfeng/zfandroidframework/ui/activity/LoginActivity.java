package com.example.zengfeng.zfandroidframework.ui.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.example.zengfeng.zfandroidframework.R;
import com.example.zengfeng.zfandroidframework.base.BaseActivity;
import com.example.zengfeng.zfandroidframework.base.BaseView;
import com.example.zengfeng.zfandroidframework.base.Constant;
import com.example.zengfeng.zfandroidframework.ui.presenter.LoginPresenter;
import com.example.zengfeng.zfandroidframework.ui.presenter.impl.LoginPresenterImpl;
import com.jakewharton.rxbinding.view.RxView;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.functions.Action1;

public class LoginActivity extends BaseActivity implements LoginView{
    /**
     * 使用butterKnife注入
     */
    @BindView(R.id.tv_login_pass)
    EditText  tvLoginPass;
    @BindView(R.id.tv_login_userName)
    EditText tvLoginUserName;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_login_login)
    Button btnLogin;
    String TITLE = "首页";
    ProgressDialog progressDialog;
    LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
    }

    @Override
    public void initView() {
        toolbar.setTitle(TITLE);
        RxView.clicks(toolbar)
                .throttleFirst(Constant.CLICK_INTERVAL, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        showShortToast(toolbar.getTitle());
                    }
                });
        RxView.clicks(btnLogin)
                .throttleFirst(Constant.CLICK_INTERVAL,TimeUnit.MILLISECONDS)
                .subscribe((aVoid)->{
                    showShortToast("you click login button");
                });

    }

    @Override
    public void initPresenter(BaseView baseView, Context context) {
        loginPresenter = new LoginPresenterImpl();
    }


    @Override
    public void onLoginLoading() {
        progressDialog = new ProgressDialog(this);
        if (!progressDialog.isShowing()){
            progressDialog.show();
        }
    }

    @Override
    public void onLoginSuccess() {
        showShortToast("login success");
    }

    @Override
    public void onLoadingClose() {
        if (progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }
}
