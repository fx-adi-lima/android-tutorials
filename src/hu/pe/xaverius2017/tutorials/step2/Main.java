package hu.pe.xaverius2017.tutorials.step2;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.view.ViewGroup;
import android.widget.EditText;
import android.view.Gravity;
import android.webkit.WebView;
import android.webkit.WebSettings;


public class Main extends Activity {

	WebView webView;

	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		
		LinearLayout ll = new LinearLayout(this);
		ll.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		ll.setOrientation(LinearLayout.HORIZONTAL);
		setContentView(ll);

		EditText et = new EditText(this);
		et.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		et.setGravity(Gravity.TOP);

		webView = new WebView(this);
		webView.setLayoutParams(new LayoutParams(500, LayoutParams.MATCH_PARENT));
		WebSettings ws = webView.getSettings();
		ws.setJavaScriptEnabled(true);
		webView.loadUrl("file:///android_asset/index.html");
		ll.addView(webView);
		ll.addView(et);
	}
}

