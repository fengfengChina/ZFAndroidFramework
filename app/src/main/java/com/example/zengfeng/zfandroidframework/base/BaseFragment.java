package com.example.zengfeng.zfandroidframework.base;

import android.support.v4.app.Fragment;

import rx.Subscription;

/**
 * Created by zengfeng on 5/10/16.
 */
public class BaseFragment extends Fragment{
    protected Subscription subscription;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unsubscribe();
    }

    private void unsubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }
    }
}
