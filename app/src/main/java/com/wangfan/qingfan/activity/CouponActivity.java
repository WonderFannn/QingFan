package com.wangfan.qingfan.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.wangfan.baseapplication.R;
import com.wangfan.qingfan.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CouponActivity extends BaseActivity {


    private static final String TAG = "CouponActivity";
    @BindView(R.id.et_number)
    EditText mEtNumber;
    @BindView(R.id.btn_update)
    Button mBtnUpdate;
    @BindView(R.id.lv_coupons)
    ListView mLvCoupons;

    List<String> mCouponsLink;
    int flag = 30;
    int mCouponNumber = 845887;
    String mCouponUrl = "";


    private RequestQueue mQueue;
    private void initReqQue() {
        mQueue = Volley.newRequestQueue(this);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_coupon);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {

        mEtNumber.setText(mCouponNumber+"");

        mBtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCoupon();
            }
        });
    }

    @Override
    protected void initData() {
        initReqQue();


        mCouponsLink = new ArrayList<>();
    }

    private void getCoupon() {
        mCouponNumber = Integer.parseInt(mEtNumber.getText().toString());
        mCouponUrl = "https://m.honglingjin.cn/user/coupon/info/"+mCouponNumber+"_0.html?coupon_source=offline";
        StringRequest stringRequest = new StringRequest(mCouponUrl, RsGetCouponsListener, RsErrorListener);
        stringRequest.setRetryPolicy(
                new DefaultRetryPolicy(
                        20 * 1000,//默认超时时间，应设置一个稍微大点儿的
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,//默认最大尝试次数
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
                )
        );
        mQueue.add(stringRequest);

    }
    private Response.Listener<String> RsGetCouponsListener = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Log.d(TAG, "onResponse: " + response);
            String title = response.substring(response.indexOf("<title>")+7,response.indexOf("</title>"));
            Log.d(TAG, "title: "+title);
        }
    };
    private Response.ErrorListener RsErrorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.d("Volley", "onErrorResponse1: " + error.getMessage());
            Log.d("Volley", "onErrorResponse2: " + error.getLocalizedMessage());
            Log.d("Volley", "onErrorResponse3: " + error.getNetworkTimeMs());
        }
    };
}
