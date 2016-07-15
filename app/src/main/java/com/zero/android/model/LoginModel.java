package com.zero.android.model;

import android.util.Log;

import com.zero.android.Api;
import com.zero.android.common.BaseModel;
import com.zero.android.entity.User;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * @author zengfeng
 * create on 16/7/6.
 */
public class LoginModel extends BaseModel{

    public void login(String userName, String password, OnLoginListner listner){
        Retrofit         retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build();
        Api              api      = retrofit.create(Api.class);
        Log.i("TAG" , "userName : " + userName);
        Log.i("TAG" , "password : " + password);
        api.login(userName,password).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<User>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                Log.i("TAG", "onFailure=" + e.getMessage());
                listner.onPasswordError();
                listner.onUsernameError();
            }

            @Override
            public void onNext(User user) {
                listner.onSuccess(user.getStatus()+":" + user.getData().getNick_name() + user.getData().getPhone() );
            }
        });
    }

}
