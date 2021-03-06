package com.example.eaabuttons;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button english = (Button) findViewById(R.id.button1);
		Button international = (Button) findViewById(R.id.button2);
		final WebView webview = (WebView) findViewById(R.id.webView1);
		english.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				webview.setWebViewClient(new WebViewClient() {
					@Override
					public boolean shouldOverrideUrlLoading(WebView view,
							String url) {
						return false;
					}
				});
				webview.getSettings().setLoadWithOverviewMode(true);
				webview.getSettings().setUseWideViewPort(true);
				webview.getSettings().setBuiltInZoomControls(true);

				webview.loadUrl("http://www.eaaa.dk/");
			}

		});
		international.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				webview.setWebViewClient(new WebViewClient() {
					@Override
					public boolean shouldOverrideUrlLoading(WebView view,
							String url) {
						return false;
					}
				});
				webview.getSettings().setLoadWithOverviewMode(true);
				webview.getSettings().setUseWideViewPort(true);
				webview.getSettings().setBuiltInZoomControls(true);

				webview.loadUrl("http://www.baaa.dk/subsites/international/home");
			
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
