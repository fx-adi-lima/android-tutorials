@echo off

set ANDROID_HOME=C:\Users\adi\AppData\Local\Android\Sdk
set PATH=%PATH%;%ANDROID_HOME%\build-tools\25.0.2;%JAVA_HOME%\bin

aapt package -v -f -M .\AndroidManifest.xml -I %ANDROID_HOME%\platforms\android-25\android.jar -J src -S res -m

jack.jar --classpath %ANDROID_HOME%\android-25\android.jar --output-dex bin src gen

aapt package -v -f -M .\AndroidManifest.xml -I %ANDROID_HOME%\platforms\android-25\android.jar -S res -A assets -F bin\step2.apk

cd bin
aapt add -f step2.apk classes.dex

apksigner sign --ks step2-debug.key step2.apk

