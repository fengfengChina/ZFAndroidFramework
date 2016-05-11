package com.example.zengfeng.zfandroidframework.base;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by zengfeng on 5/10/16.
 */
public class BaseActivity extends AppCompatActivity {
    public final Context app = BaseActivity.this;

    public void showShortToast(CharSequence content){
        Toast.makeText(app, content, Toast.LENGTH_SHORT).show();
    }


    public void showLongToast(CharSequence content){
        Toast.makeText(app,content,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
