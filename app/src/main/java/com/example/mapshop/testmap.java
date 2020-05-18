package com.example.mapshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class testmap extends AppCompatActivity  implements View.OnClickListener{
    private ImageView logo;
    private ImageView user;
    private Button play;
    private  String liste;
    WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testmap);
        liste = getIntent().getStringExtra("liste");
        logo = (ImageView) findViewById(R.id.logo);
        user = (ImageView) findViewById(R.id.user);
        logo.setOnClickListener(this);
        user.setOnClickListener(this);
        play = (Button) findViewById(R.id.his);
        play.setOnClickListener(this);
        String myurl = "file:///android_asset/beforemap.html";
        WebView wvContent = (WebView) findViewById(R.id.web);
        WebSettings webSettings = wvContent.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wvContent.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished (WebView view, String list) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                    view.evaluateJavascript("myVar('"+liste+"')", null);
                } else {
                    view.loadUrl("javascript:myVar('ABCD')");
                }
            }
        });
        wvContent.loadUrl(myurl);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {


            case R.id.logo :back();
                break;

            case R.id.user :moncompte();
                break;
            case R.id.his :monhis();
                break;

        }
    }


    private void back() {
        Intent intent = new Intent(this,First.class);
        startActivity(intent);
        finish();
    }

    private void moncompte() {
        Intent intent = new Intent(this,Moncompte.class);
        startActivity(intent);
        finish();
    }

    private void monhis() {
        Intent intent = new Intent(this,Historique.class);
        startActivity(intent);
        finish();
    }
}
