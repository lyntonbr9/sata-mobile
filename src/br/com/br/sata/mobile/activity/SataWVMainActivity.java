package br.com.br.sata.mobile.activity;


import br.com.br.sata.mobile.R;
import br.com.br.sata.mobile.R.layout;
import br.com.br.sata.mobile.R.menu;
import br.com.br.sata.mobile.interfaces.MainJavaScriptInterface;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class SataWVMainActivity extends Activity {

	private WebView webView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		if (savedInstanceState == null) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_wvmain);

			this.webView = (WebView) findViewById(R.id.wvMain);
			this.webView.setWebChromeClient(new WebChromeClient());
			this.webView.getSettings().setJavaScriptEnabled(true);
			this.webView.getSettings()
					.setJavaScriptCanOpenWindowsAutomatically(true);
			MainJavaScriptInterface jsMain = new MainJavaScriptInterface(this);
			this.webView.addJavascriptInterface(jsMain, "JSInterface");
			this.webView.loadUrl("file:///android_asset/line.html");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sata_wvmain, menu);
		return true;
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		this.webView.saveState(outState);
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		this.webView.restoreState(savedInstanceState);
	}

}
