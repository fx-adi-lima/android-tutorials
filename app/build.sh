#!/bin/sh -e
#
# create R.java
ANDROID_HOME=$HOME/android

aapt package -v -f \
             -M ./AndroidManifest.xml \
             -I $ANDROID_HOME/share/commons/android-23.jar \
             -J src \
             -S res \
             -m

mkdir -pv obj

# compile the java sources
# THIS EXAMPLE USING ecj, and we should find out which version
# If using jack then we must do like this:
#   jack --classpath $ANDROID_HOME/platforms/android-n/android.jar \
#        --import [path/to/import/lib/*.jar \
#        --output-dex bin/ \
#        src/ gen/
# And then, no more using dx to produce classes.dex

#####################################################################
#
#ecj -d ./obj -classpath $HOME/../usr/share/java/android.jar \
#	     -sourcepath ./src $(find src -type f -name "*.java")
#
#dx --dex --verbose --output=./bin/classes.dex ./obj

#jack --classpath $PREFIX/share/java/android.jar \
#	--output-dex bin/ \
#	src/ gen/

# make the apk

SOURCES=$(find src -name *.java)

javac --release 6 -d obj/ -sourcepath src/ \
-cp $ANDROID_HOME/share/commons/android-23.jar \
${SOURCES}

dx --dex --output=classes.dex obj/

aapt package -v -f \
             -M ./AndroidManifest.xml \
             -S ./res \
             -I $ANDROID_HOME/share/commons/android-23.jar \
             -F step1.apk


# add the classes.dex to the apk
aapt add -f step1.apk classes.dex

if ! [ -f personal.keystore ]; then
    keytool -genkey -v \
	-keystore personal.keystore \
	-alias personal \
	-keyalg RSA \
	-keysize 2048 \
	-validity 10000
fi

jarsigner -sigalg SHA1withRSA \
    -digestalg SHA1 \
    -keystore personal.keystore \
    step1.apk personal

ls -lh step1.apk

echo "Our Step1 app is ready to go"
echo

