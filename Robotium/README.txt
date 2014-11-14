Prerequisites
=============
-> Java 1.6 or 1.7
-> Eclipse , Android SDK and Android ADT package 
(Can be installed seperately or as a package from here: https://developer.android.com/sdk/index.html?hl=i)

Getting other Android API targets
=================================
Android ADT will come with the latest Android Api. Use SDK Manager to download the target Android API you desire.
1) In Eclipse (Window-> Android SDK Manager)
2) Click Android 4.1.2 (API 16) and other desired APIs
3) Click install


Getting Started on a new project
===============================
In Eclipse
1) Create a new Android Test project 
    a) File-> New -> Other -> Android -> Android Test Project
    b) Select "This Project" as Target App and latest SDK as Target SDK
    c) ** If you get a null pointer exception, exit exlipse and repeat step 1
4) Create new class inside the package
5) Get the Robotium Skeleton (TestRun.java)
6) Paste it into your class replacing everything but the first line (your package name)
7) Modify TARGET_PACKAGE_ID and LAUNCHER_ACTIVITY_FULL_CLASSNAME to reflect the app you wish to tests package name and launch name.

After Setup
===========

1) Configure build path for you project:
        1) Add original Robotium Solo Library (or the Appurify-robotium-extention library)
        2) Order and export these libraries
2) All Errors should disappear. (if you chose the Appurify-robotium-extention you will need to change Solo to AppSolo)
3) Plug in a phone
4) Sign your app with the signing script (sign.sh) 
    NOTE: be sure to modify signing script to your environment before running)
6) Install the signed app on the phone
7) Click Run -> Run
9) Modify your class in the test**** method to execute desired behavior.
10) Run again.

Uploading and Running on Appurify
=================================

1) Upload to Appurify Platform

2) Run a test on any device in the pool.

Additional documentation
========================

