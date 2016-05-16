package com.example.zengfeng.zfandroidframework.base;

/**
 * Created by zengfeng on 5/10/16.
 */
public interface BasePresenter {
     <T extends BasePresenter,V extends BaseView> T init(V v);
}
