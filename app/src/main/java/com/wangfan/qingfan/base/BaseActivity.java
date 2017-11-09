package com.wangfan.qingfan.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by wangfan on 2017/11/3.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        ButterKnife.bind(this);
//        EventBus.getDefault().register(this);
        initData();
    }

    protected abstract void initView();
    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }
}
