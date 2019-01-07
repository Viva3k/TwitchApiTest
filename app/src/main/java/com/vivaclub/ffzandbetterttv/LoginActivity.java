package com.vivaclub.ffzandbetterttv;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        WebView webView = findViewById(R.id.loginWebView);
        webView.setWebViewClient(new MyWebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(Constant.GET_TOKEN_TWITCH_URL); // load the url on the web view



    }
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url); // load the url
            if(url.contains("http://localhost/#access_token")){
                User user = new User(url,LoginActivity.this);
                Intent refresh = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(refresh);
                finish();
                return false;
            }
            return true;
        }
    }
}
