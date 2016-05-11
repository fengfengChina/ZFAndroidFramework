package com.example.zengfeng.zfandroidframework.ui.presenter;

import com.example.zengfeng.zfandroidframework.ui.model.bean.remote.Data;

import java.util.List;

/**
 * Created by zengfeng on 5/10/16.
 */
public interface MainPresenter  {

    interface View {
        void onDataReceive(List<Data> datas);
        void OnDataLoading();
    }

}
