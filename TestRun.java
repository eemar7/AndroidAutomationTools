package com.appurify.tutorial;

import java.io.IOException;

import android.view.InputDevice;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class TestRun extends UiAutomatorTestCase {

	public UiDevice myDevice;

	/*
	 * This is the main function that runs the test. It must begin with the
	 * word test, but anything after can be changed. (Ex: testRun)
	 */
	public void testDemo() throws UiObjectNotFoundException, IOException {

		myDevice = getUiDevice();
		System.out.println("Starting App");
		startApp("com.yelp.android", "com.yelp.android.ui.activities.RootActivity");

	}

	/*****************************************************************************
	 * UIAUTOMATOR HELPER FUNCTIONS
	 ****************************************************************************/

	/*
	 * This function starts the app with the given Package Name at the given Launch 
	 * Activity Name.
	 */
	private void startApp(String packageName, String launchActName) throws IOException {
		Runtime.getRuntime()
				.exec("am start -n "+ packageName +"/"+launchActName);
		sleep(1000);
	}

	/*
	 * This function clicks on the screen of the device at relative coordinates.
	 */
	public void clickRelative(double relX, double relY, boolean print) {
		int width = myDevice.getDisplayWidth();
		int height = myDevice.getDisplayHeight();

		int relativeWidth = (int) (width * relX);
		int relativeHeight = (int) (height * relY);

		myDevice.click(relativeWidth, relativeHeight);
	}

	/*
	 * Get the coordinate width of the devices
	 */
	public int getCoordinateWidth(double relX) {
		int width = myDevice.getDisplayWidth();
		int relativeWidth = (int) (width * relX);
		return relativeWidth;
	}

	/*
	 * Get the coordinate height of the devices
	 */
	public int getCoordinateHeight(double relY) {
		int height = myDevice.getDisplayHeight();
		int relativeHeight = (int) (height * relY);
		return relativeHeight;
	}

	/*
	 * Type the given string in the soft keyboard on the device. character by
	 * character
	 */
	public void typeKeyboard(String toType) {

		KeyCharacterMap keyCharacterMap = KeyCharacterMap
				.load(KeyCharacterMap.VIRTUAL_KEYBOARD);
		String text = toType;

		char[] chr = text.toCharArray();
		KeyEvent[] events = keyCharacterMap.getEvents(chr);

		if (events == null) {
			System.err.println("No events specified!");
		}

		for (KeyEvent e : events) {
			if (e.getAction() == KeyEvent.ACTION_DOWN) {
				e.setSource(InputDevice.SOURCE_KEYBOARD);
				myDevice.pressKeyCode(e.getKeyCode(), e.getMetaState());
			}
		}

	}

	/*
	 * get the given instance of an element whose class name is the given string
	 */
	public UiObject getByClassName(String className, int ins) {
		return new UiObject(new UiSelector().className(className).instance(ins));
	}

	/*
	 * get the given instance of a scrollable element whose class name is the
	 * given string
	 */
	public UiScrollable getScrollableByClassName(String className, int ins) {
		return new UiScrollable(new UiSelector().className(className).instance(
				ins));
	}

	/*
	 * get an element whose text content is the given string
	 */
	public UiObject getByText(String description) {
		return new UiObject(new UiSelector().text(description));
	}

	/*
	 * get an element whose text content contains the given string
	 */
	public UiObject getByPartialText(String description) {
		return new UiObject(new UiSelector().textContains(description));
	}

	/*
	 * get an element whose content description is the given string.
	 */
	public UiObject getByContDesc(String desc) {
		return new UiObject(new UiSelector().description(desc));
	}

	/*
	 * get an element whose content description contains the given string.
	 */
	public UiObject getByPartialContDesc(String desc) {
		return new UiObject(new UiSelector().descriptionContains(desc));
	}

	/*
	 * press delete a given amount of times
	 */
	public void pressMultiDelete(int times) {
		for (int i = 0; i < times; i++) {
			myDevice.pressDelete();
		}
	}

	/*
	 * Turns the volume up on the phone.
	 */
	public void turnVolumeUp() throws IOException {
		System.out.println("Turning volume all the way up");
		for (int i = 0; i < 10; i++) {
			Runtime.getRuntime().exec("input keyevent 24");
			sleep(500);
		}
	}

	/*
	 * Wait for a element given specified time, then click it.
	 */
	public void waitForThenClick(UiObject obj, int time)
			throws UiObjectNotFoundException {
		obj.waitForExists(time);
		obj.click();
	}
}
