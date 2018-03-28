package com.wangfan.qingfan.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.wangfan.qingfan.R;
import com.wangfan.qingfan.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by wangfan on 2018/3/28.
 */

class CouponsActivity extends BaseActivity {

    @BindView(R.id.tv_all_message)
    TextView mTextViewAllMessage;
    @BindView(R.id.tv_parking)
    TextView mTextViewParking;
    @BindView(R.id.et_num)
    EditText mEditTextNum;
    @BindView(R.id.btn_calculate)
    Button mButtonCalculate;

    private String text = "H停车券";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_coupons);
    }

    @Override
    protected void initData() {

    }
}
