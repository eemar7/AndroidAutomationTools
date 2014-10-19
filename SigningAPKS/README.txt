Sign an APK
===========

USAGE: ./sign.sh /path/to/unsigned-apk.apk /path/to/desired/new/signed-apk.apk

IMPORTANT: Read script before executing. Paths may need modifying

Prerequisits:

Android sdk (Should include the following, though paths may be different)
->jarsigner
->zipalign
->adb

Your signature
==============
DEFAULT: ~/.android/debug.keystore
PASSCODE: "android" (you will be propted for the passcode during execution)

Steps
=====

1) Ensure you have the prerequisites or download them 
2) Modify script for your environment and signature
3) CD into directory of script
4) Excecute: ./sign.sh /path/to/unsigned-apk.apk /path/to/desired/new/signed-apk.apk 


