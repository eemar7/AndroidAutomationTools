#!/bin/bash

# unzip apk to tmp directory
mkdir /tmp/unzipsign
cd /tmp/unzipsign/
unzip $1

# remove META-INF Folder
rm -r /tmp/unzipsign/META-INF

# rezip with out including parent directory
zip -r ./newZip ./*

# rename with .apk
mv /tmp/unzipsign/newZip.zip /tmp/unzipsign/newZip.apk

# sign apk
jarsigner -verbose -certs -keystore ~/.android/debug.keystore -sigalg SHA1withRSA -digestalg SHA1 /tmp/unzipsign/newZip.apk androiddebugkey

# verify
jarsigner -verbose -keystore ~/.android/debug.keystore -verify /tmp/unzipsign/newZip.apk

# zip align apk
zipalign -v 4 /tmp/unzipsign/newZip.apk $2

# remove temp dir
rm -r /tmp/unzipsign



