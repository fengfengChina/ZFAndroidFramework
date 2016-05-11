package com.example.zengfeng.zfandroidframework.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.zengfeng.zfandroidframework.R;
import com.example.zengfeng.zfandroidframework.base.BaseActivity;
import com.example.zengfeng.zfandroidframework.base.BaseView;
import com.example.zengfeng.zfandroidframework.base.Constant;
import com.jakewharton.rxbinding.view.RxView;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.functions.Action1;

public class MainActivity extends BaseActivity implements MainView{
    /**
     * 使用butterKnife注入
     */
    @BindView(R.id.vp_main)
    ViewPager vpMain;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    String TITLE = "首页";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
    }



    @Override
    public void initView() {
        toolbar.setTitle(TITLE);
        RxView.clicks(toolbar)
                .throttleFirst(Constant.CLICK_INTERVAL, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        showShortToast(toolbar.getTitle());
                    }
                });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
