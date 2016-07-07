package com.zero.android.zfandroidframework;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.zero.android.zfandroidframework.common.BaseActivity;

/**
 *
 * @author zf
 *
 */
public class MainActivity extends BaseActivity {

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            Toast.makeText(getContext(),"this is my handler...",Toast.LENGTH_SHORT).show();
            return false;
        }
    });

    @Override
    public int getLayoutInflaterView() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

    }


}
