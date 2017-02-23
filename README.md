# android-tutorials
Tutorials for creating android apps from within android-x86

# purpose
It help me understand android programming better, just hope sharing it here will do the same for others
Simple hello world program, which has been written completely from scratch, with no XML layout files,
and build using nothing more than a Makefile, or even a shell script, from inside android itself, I guess will
lift-up our spirits as newbies.

Always use simple way to do things, if it helps me understand, I'm sure will help others too.

# Step1
I guess it's pretty straightforward, we're defining a simple bash script to automate the build, and also sign the resulting APK,
since we're using termux, this will be done in an easy way, and please done use this method to sign your productive APK.     
We can use **build.sh** all the way through, with small modifications of course.     
First, declare a short **manifest** like this:    
## AndroidManifest.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
      package="hu.pe.xaverius2017.tutorials.step1"
      android:versionCode="1"
      android:versionName="1.0">

    <uses-permission android:name="android.permisson.WRITE_INTERNAL_STORAGE"/>
    <uses-permission android:name="android.permisson.READ_INTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.INTERNET" />
    
    <supports-screens android:resizeable="true"
                      android:xlargeScreens="true"/>

    <application android:icon="@+drawable/ic_launcher"
		 android:label="Step1">
        <activity android:name="hu.pe.xaverius2017.tutorials.step1.Main"
                  android:label="Step1">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
</manifest>
```
Change the name and path to the package to reflect your own.
The build script is something like this:
```bash
#!/system/bin/sh -e
#
# create R.java
aapt package -v -f \
             -M ./AndroidManifest.xml \
             -I $PREFIX/share/aapt/android.jar \
             -J src \
             -S res \
             -m

# this example uses jack all the way, but you can use ecj if you want

jack --classpath $PREFIX/share/java/android.jar \
	--output-dex bin/ \
	src/ gen/

# make the apk

aapt package -v -f \
             -M ./AndroidManifest.xml \
             -S ./res \
             -F bin/step1.apk


# add the classes.dex to the apk
cd bin
aapt add -f step1.apk classes.dex

echo "sign the apk"
apksigner -p <your_key_store_password> ../step1-debug.key step1.apk ../step1.apk

cd ..
echo "and make it accessible to the outside world"
chmod 777 step1.apk

echo "Our Step1 app is ready to go"
echo

```
Make the build script executable using 
```bash
chmod +x build.sh
```
Notice the beginning of the script, we're calling /system/bin/sh, and not /bin/sh like usual, it's because
on android system, the script interpreter executable is located in /system/bin.
Change the path if you're using a regular Linux distro.

Last, but not least, write your hello world:
```java
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

```

# Finished Step1
This simple branch should be kept small, so I don't want to add anything else here.
We can make other things by just using the TextView, but I think we better do that in **Step2**.


