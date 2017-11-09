package com.wangfan.qingfan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wangfan.qingfan.R;
import com.wangfan.qingfan.base.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.btn_ebo)
    Button mButtonEbo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mButtonEbo.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initData() {

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ebo:
                Intent intent = new Intent(this, EboParkingActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
