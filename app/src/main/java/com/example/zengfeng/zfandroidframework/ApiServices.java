package com.example.zengfeng.zfandroidframework;

import com.example.zengfeng.zfandroidframework.ui.model.bean.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by zengfeng on 5/11/16.
 */
public interface ApiServices {

    @GET("users/{user}/repos")
    Call<User> login(@Query("userName")String user,@Query("password") String password);


}
