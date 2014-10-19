#!/bin/bash

android_file=/usr/local/android-sdk/tools/android
project_name=tutorial
path_to_project=/<path_to_workspace>/workspace_tutorial/tutorial
project_jar=tutorial.jar
# example: com.appurify.tutorial.TestRun
package_name=<packagename>.TestRun

# number after -t will vary by computer configuration. Type
# "<path to android sdk>/tools/android list targets" in your console and look for the id assosiated with
# "android-16"
${android_file} create uitest-project -n ${project_name} -t 2 -p ${path_to_project}
cd ${path_to_project}
ant build
adb push ./bin/${project_jar} /data/local/tmp/
adb shell uiautomator runtest ${project_jar} -c ${package_name}


