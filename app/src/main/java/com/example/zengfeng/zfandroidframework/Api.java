package com.example.zengfeng.zfandroidframework;

import retrofit2.Retrofit;

/**
 * Created by zengfeng on 5/16/16.
 */
public class Api {

    private static final String BASE_URL = "localhost:8080/";
    static Retrofit retrofit;


    private Api() throws InstantiationException {
        throw new InstantiationException("fuck code,this is singleton");
    }

    /**
     * 双重校验锁 产生实例
     * Call<List<Repo>> repos = service.listRepos("octocat");
     * @return
     */
    public static synchronized ApiServices getApiServiceInstance() {
        if (retrofit == null) {
            synchronized (Api.class) {
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder().baseUrl(BASE_URL).build();
                }
            }
        }
        return retrofit.create(ApiServices.class);
    }
}
