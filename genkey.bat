@echo off


keytool -genkey -v -keystore step2-debug.key -alias step2-debug -keyalg RSA -keysize 2048 -validity 10000
