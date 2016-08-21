package com.zero.android.common.mvp;

/**
 * Created by zengfeng on 16/7/6.
 */
public interface BasePresent  {
    /**
     * 订阅
     */
    void subscribe();

    /**
     * 取消订阅
     */
    void unsubscribe();
}
