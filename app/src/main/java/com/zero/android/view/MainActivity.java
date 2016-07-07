package com.zero.android.view;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.zero.android.common.BaseActivity;
import com.zero.android.common.Result;
import com.zero.android.present.MainPresent;
import com.zero.android.zfandroidframework.R;

/**
 *
 * @author zf
 *
 */
public class MainActivity extends BaseActivity {
    private static int RESULT_NUM = 1001;

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            Toast.makeText(getContext(),"this is my handler...",Toast.LENGTH_SHORT).show();
            return false;
        }
    });
    private MainPresent mainPresent;

    @Override
    public int getLayoutInflaterView() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mainPresent = new MainPresent();
        mainPresent.getLoginData(new Result(){

            @Override
            public void onError() {
                handler.sendEmptyMessage(RESULT_NUM);
            }

            @Override
            public void onSuccess() {
                handler.sendEmptyMessage(RESULT_NUM);
            }

            @Override
            public void onNoResponse() {
                handler.sendEmptyMessage(RESULT_NUM);
            }
        });
    }

    @Override
    public void initPresenter() {
        setPresent(new MainPresent());
    }


}
