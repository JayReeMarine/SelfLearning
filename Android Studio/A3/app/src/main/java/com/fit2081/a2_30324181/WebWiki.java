package com.fit2081.a2_30324181;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebWiki extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_wiki);
        WebView webView=findViewById(R.id.webWiki);
        webView.setWebViewClient(new WebViewClient());

        String itemName = getIntent().getStringExtra("ITEM_NAME");
        if(itemName != null && !itemName.isEmpty()) {
            webView.loadUrl("https://en.wikipedia.org/wiki/" + itemName);
        } else {
            Toast.makeText(this, "No item name provided", Toast.LENGTH_SHORT).show();
        }
    }
}