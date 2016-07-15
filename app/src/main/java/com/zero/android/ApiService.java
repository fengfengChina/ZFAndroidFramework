package com.zero.android;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zengfeng on 16/7/15.
 */
public class ApiService {
    public static final String   BASE_TRC_URL = "http://120.24.240.62:8090";

    private static      Retrofit retrofit     = new Retrofit.Builder()
            .baseUrl(BASE_TRC_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private ApiService() {
    }

    public static Api createTRService() {
        return retrofit.create(Api.class);
    }
}
