package com.zero.android.zfandroidframework.common;

/**
 * Created by zengfeng on 16/7/6.
 */
public interface Result {

    public void onError();
    public void onSuccess();
    public void onNoResponse();
}
