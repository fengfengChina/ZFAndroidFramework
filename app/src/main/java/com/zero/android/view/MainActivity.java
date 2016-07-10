package com.zero.android.view;

import com.zero.android.common.BaseActivity;
import com.zero.android.present.MainPresent;

/**
 *
 * @author zf
 *
 */
public class MainActivity extends BaseActivity {
    private static int RESULT_NUM = 1001;

    private MainPresent mainPresent;

    @Override
    public int getLayoutInflaterView() {
        return 0;
    }

    @Override
    public void initView() {
        mainPresent = new MainPresent();
    }

    @Override
    public void initPresenter() {
        setPresent(new MainPresent());
    }


}
