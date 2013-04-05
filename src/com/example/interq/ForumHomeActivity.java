package com.example.interq;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class ForumHomeActivity extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forum_home_activity);
        
        WebView webView = (WebView) findViewById(R.id.forumWebView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.reddit.com");
        
    }
    
    
}
