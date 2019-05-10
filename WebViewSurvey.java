package com.csns.indiastory;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewSurvey extends Activity {
    WebView wb;
    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            if (url.contains("formResponse")) {
                finish();  // close activity
            }
        }

    }
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("survey");
        setContentView(R.layout.web_view);
        wb=(WebView)findViewById(R.id.webView1);
        wb.getSettings().setJavaScriptEnabled(true);
        wb.getSettings().setLoadWithOverviewMode(true);
        wb.getSettings().setUseWideViewPort(true);
        wb.getSettings().setBuiltInZoomControls(true);
        wb.getSettings().setPluginState(WebSettings.PluginState.ON);
        wb.setWebViewClient(new HelloWebViewClient());
        wb.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSdDLE6OpmQJS9dbANCTFh50_0L0YsypEx3uc9Rr5NVf6GZ54A/viewform?usp=sf_link");
    }
}
