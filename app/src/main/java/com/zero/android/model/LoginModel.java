package com.zero.android.model;

import android.util.Log;

import com.zero.android.Api;
import com.zero.android.common.BaseModel;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by zengfeng on 16/7/6.
 */
public class LoginModel extends BaseModel{

    public void login(String userName, String password, OnLoginListner listner){
        Retrofit           retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        Api                api      = retrofit.create(Api.class);
        Call<ResponseBody> call     =  api.login(userName,password);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.i("wxl", "response=" + response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                listner.onSuccess();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.i("wxl", "onFailure=" + t.getMessage());
                listner.onPasswordError();
                listner.onUsernameError();
            }
        });

    }

}
