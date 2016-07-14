package com.zero.android.constact;

import com.zero.android.common.BasePresent;
import com.zero.android.common.BaseView;

/**
 * Created by zengfeng on 16/7/10.
 */
public interface LoginConstact {
    public interface View extends BaseView<BasePresent>{
        void showLoginError();
        void showLoading();
        void showLoginSuccess(String userName);
        void dismissLoading();
    }

    public interface Presenter extends BasePresent{
        void loginTask(String username,String password);

    }

}
