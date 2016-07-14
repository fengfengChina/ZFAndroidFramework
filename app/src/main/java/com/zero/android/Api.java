package com.zero.android;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by zengfeng on 16/7/13.
 */
public interface Api {
    @FormUrlEncoded
    @POST("api/user/login")
    Call<ResponseBody> login(@Field(value = "mobilePhone") String userName , @Field(value = "password") String password);

}
