package com.wangfan.qingfan.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.wangfan.baseapplication.R;
import com.wangfan.qingfan.base.BaseActivity;

import butterknife.BindView;

public class CouponActivity extends BaseActivity {


    @BindView(R.id.et_number)
    EditText mEtNumber;
    @BindView(R.id.btn_update)
    Button mBtnUpdate;
    @BindView(R.id.lv_coupons)
    ListView mLvCoupons;

    String[] mCouponsLink;
    int flag = 30;
    int mCouponNumber = 845887;


    private RequestQueue mQueue;
    private void initReqQue() {
        mQueue = Volley.newRequestQueue(this);
    }
    private Response.ErrorListener RsErrorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.d("Volley", "onErrorResponse1: " + error.getMessage());
            Log.d("Volley", "onErrorResponse2: " + error.getLocalizedMessage());
            Log.d("Volley", "onErrorResponse3: " + error.getNetworkTimeMs());
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_coupon);
    }

    @Override
    protected void initData() {
        initReqQue();
        mCouponsLink = new String[0];
    }
}
