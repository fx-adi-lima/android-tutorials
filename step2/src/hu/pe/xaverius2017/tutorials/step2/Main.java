package hu.pe.xaverius2017.tutorials.step2;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;


public class Main extends Activity {

	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		
		LinearLayout ll = new LinearLayout(this);
		ll.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		ll.setOrientation(LinearLayout.VERTICAL);
		setContentView(ll);

		TextView tv = null;
		for (int i = 0; i < 25; i++) {
			tv = new TextView(this);
			tv.setTextSize(30);
			tv.setText("TextView nomor " + i + " baru dibuat");
			ll.addView(tv);
		}
	}
}

