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


public class Main extends Activity {

	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		
		LinearLayout ll = new LinearLayout(this);
		ll.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		ll.setOrientation(LinearLayout.HORIZONTAL);
		setContentView(ll);

		ScrollView sv = new ScrollView(this);
		LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
		sv.setLayoutParams(params);
		ll.addView(sv);

		LinearLayout contents = new LinearLayout(this);
		contents.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 0.5f));
		contents.setOrientation(LinearLayout.VERTICAL);
		contents.setBackgroundColor(0xffffffff);
		sv.addView(contents);

		TextView tv = null;
		float fsize = 75;
		for (int i = 0; i < 25; i++) {
			tv = new TextView(this);
			tv.setTextSize(fsize);
			tv.setText("TextView nomor " + i + " baru dibuat");
			contents.addView(tv);
			fsize -= 1.1f;
		}

		EditText et = new EditText(this);
		et.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		et.setGravity(Gravity.TOP);
		ll.addView(et);
	}
}

