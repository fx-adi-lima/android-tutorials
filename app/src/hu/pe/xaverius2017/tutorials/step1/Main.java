package hu.pe.xaverius2017.tutorials.step1;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.widget.TextView;

public class Main extends Activity {

	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		
		/* Di sini kita membuat sebuah TextView sebagai layout
		 * sekedar untuk pemanasan, supaya kita segera mulai tutorial
		 * ini dengan penuh semangat, baik Anda maupun saya.
		 *
		 * Membuat sebuah View di dalam Android selalu membutuhkan minimal satu argumen,
		 * yaitu 'Context', dalam hal ini kita passing diri sendiri sebagai parameter.
		 */
		TextView tv = new TextView(this);
		tv.setText("Hello World...!");
		setContentView(tv);
	}
}

