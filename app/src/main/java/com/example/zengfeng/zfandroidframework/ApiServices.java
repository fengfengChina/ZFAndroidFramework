package com.example.zengfeng.zfandroidframework;

import com.example.zengfeng.zfandroidframework.ui.model.bean.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by zengfeng on 5/11/16.
 */
public interface ApiServices {

    @GET("users/{user}/repos")
    Call<List<User>> listRepos(@Path("user") String user);


}
