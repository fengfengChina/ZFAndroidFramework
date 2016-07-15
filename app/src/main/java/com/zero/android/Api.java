package com.zero.android;

import com.zero.android.entity.User;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by zengfeng on 16/7/13.
 */
public interface Api {
    @FormUrlEncoded
    @POST("api/user/login")
    Observable<User> login(@Field(value = "mobilePhone") String userName , @Field(value = "password") String password);

}
