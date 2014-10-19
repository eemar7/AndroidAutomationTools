Prerequisites
=============
-> Apache Ant
-> Java 1.6 or 1.7
-> Eclipse , Android SDK and Android ADT package 
(Can be installed seperately or as a package from here: https://developer.android.com/sdk/index.html?hl=i)

Getting other Android API targets
=================================
Android ADT will come with the latest Android Api. Use SDK Manager to download the target Android API you desire.
1) In Eclipse (Window-> Android SDK Manager)
2) Click Android 4.1.2 (API 16) and other desired APIs
3) Click install
UIAutomator will work on Android-16 and above so targeting Android-16 will cover the largest set of devices.


Getting Started on a new project
===============================
In Eclipse
1) Create a new java project
2) Create a new package in the project
3) Create new class in the package
4) Get the UIAutomator Skeleton (TestRun.java)
5) Paste it into your class and modify the top line (package:...) to match your chosen package name
6) Modify the parameters in startApp function to reflect your app package name and launch name.

Importing exhisting project
===========================
In Eclipse
1)File Import -> General-> Existing project from workspace
2) Select the root directory (whereever you put the folder of the project(s) to import)
3) Select the projects you want to import and click finish.

After Setup
===========

1) Configure build path for you project:
        1) Add uiautomator.jar and android.jar (from your androidsdkDIR->platforms->android-16 directory)
        2) Order and export these libraries
2) All Errors should disappear.
3) Get the UIAutomator basicBuild.sh script
4) Modify basic build to match your project and android target (examples from the skeleton project are given)
5) Plug in a phone
6) Run the script to build and run your project
7) Observe app starts
8) Use uiautomatorviewer (your-android-sdk-DIR/tools/uiautomatorviewer) to explore your app for elements to click on next
9) Modify your class in the test**** method to execute desired behavior.
10) Use script to build and run again.

Uploading and Running on Appurify
=================================

1) Upload to Appurify Platform with a .conf file (modified to your packageName.classname):

  [android_uiautomator]
  uiautomator_class = com.appurify.sears.uploadimage.TestRun

2) Run a test on any device in the pool.

Note: Platform executes :
adb -s <DEVICE UDID> shell uiautomator runtest testname.jar -c com.appurify.sears.uploadimage.TestRun
  
Additional documentation
========================
http://developer.android.com/tools/help/uiautomator/index.html
http://developer.android.com/tools/testing/testing_ui.html

