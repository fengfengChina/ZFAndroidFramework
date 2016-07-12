package com.zero.android.view;

import com.zero.android.common.BaseActivity;
import com.zero.android.common.BasePresent;
import com.zero.android.constact.LoginConstact;
import com.zero.android.present.LoginPresent;

/**
 *
 * @author zf
 *
 */
public class LoginActivity extends BaseActivity implements LoginConstact.View{
    private static int RESULT_NUM = 1001;

    private LoginPresent loginPresent;

    @Override
    public int getLayoutInflaterView() {
        return 0;
    }

    @Override
    public void initView() {
        loginPresent = new LoginPresent();
    }

    @Override
    public void initPresenter() {
        setPresent(new LoginPresent());
    }


    @Override
    public void showLoginError() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showLoginSuccess() {

    }

    @Override
    public void setPresenter(BasePresent presenter) {

    }
}
