package com.wangfan.qingfan.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.wangfan.qingfan.base.BaseActivity;

/**
 * Created by wangfan on 2017/11/9.
 */

public class EboParkingActivity extends BaseActivity {
    String url;
    private WebView mWebView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWebView.loadUrl(url);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //设置不用系统浏览器打开,直接显示在当前Webview
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

    }

    @Override
    protected void initView() {
        mWebView = new WebView(this);
        setContentView(mWebView);
    }

    @Override
    protected void initData() {
//        http://wx.ebopark.com/index.php/Home/Dedu/offset?pc=510107027&id=2&openid=oEe3kwXkYnEP8j9Al6I0L18_hSZU&timestamp=1510211419000&uid=2
        url = "http://wx.ebopark.com/index.php/Home/Dedu/offset?pc=510107027&id=2&openid=oEe3kwXkYnEP8j9Al6I0L18_hSZU&timestamp="+System.currentTimeMillis()/1000+"000&uid=2";
    }
}
