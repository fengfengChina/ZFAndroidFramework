package com.zero.android.model;

import com.zero.android.Api;
import com.zero.android.common.BaseModel;
import com.zero.android.entity.User;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by zengfeng on 16/7/6.
 */
public class LoginModel extends BaseModel{

    public void login(String userName, String password, OnLoginListner listner){
        Retrofit         retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        Api              api      = retrofit.create(Api.class);
        api.login(userName,password).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<User>() {
            @Override
            public void onCompleted() {
                listner.onSuccess();
            }

            @Override
            public void onError(Throwable e) {
//                Log.i( "onFailure=" + e.getMessage());
                listner.onPasswordError();
                listner.onUsernameError();
            }

            @Override
            public void onNext(User user) {

            }
        });
    }

}
