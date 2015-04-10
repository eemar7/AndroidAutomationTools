package com.appurify.uiautomatorlib;

import java.io.IOException;

import android.view.InputDevice;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class AppUIA {

	public UiDevice myDevice;
	public UiAutomatorTestCase test;

	public AppUIA(UiDevice dev, UiAutomatorTestCase testcase) {
		myDevice = dev;
		test = testcase;
	}

	/*
	 * START APP
	 */
	public void startApp(String appPackage, String launchActivity)
			throws IOException {
		Runtime.getRuntime().exec(
				"am start -n " + appPackage + "/" + launchActivity);
	}

	/*
	 * GET BY
	 */

	// content desc
	public UiObject getByContDesc(String desc) {
		return new UiObject(new UiSelector().description(desc));
	}

	public UiObject getByPartialContDesc(String desc) {
		return new UiObject(new UiSelector().descriptionContains(desc));
	}

	public UiObject getByText(String description) {
		return new UiObject(new UiSelector().text(description));
	}

	public UiObject getByPartialText(String description) {
		return new UiObject(new UiSelector().textContains(description));
	}

	public UiObject getByClassName(String className, int ins) {
		return new UiObject(new UiSelector().className(className).instance(ins));
	}

	public UiScrollable getScrollableByClassName(String classN, int ins) {
		return new UiScrollable(new UiSelector().className(classN)
				.instance(ins));
	}

	/*
	 * DEVICE INFO
	 */
	public String getModel() {
		return android.os.Build.MODEL;
	}

	public String getManufacturer() {
		return android.os.Build.MANUFACTURER;
	}

	/*
	 * MOVEMENTS
	 */
	public void swipeRelative(float startX, float startY, float endX,
			float endY, int steps) {
		int width = myDevice.getDisplayWidth();
		int height = myDevice.getDisplayHeight();

		int normStartX = (int) (width * startX);
		int normStartY = (int) (height * startY);

		int normEndX = (int) (width * endX);
		int normEndY = (int) (height * endY);

		myDevice.swipe(normStartX, normStartY, normEndX, normEndY, steps);
	}

	/*
	 * COORDINATES
	 */

	public void clickRelative(double relX, double relY) {
		int width = myDevice.getDisplayWidth();
		int height = myDevice.getDisplayHeight();

		int relativeWidth = (int) (width * relX);
		int relativeHeight = (int) (height * relY);

		myDevice.click(relativeWidth, relativeHeight);
	}

	public void clickRelative(UiDevice myDevice, double relX, double relY,
			boolean print) {
		int width = myDevice.getDisplayWidth();
		int height = myDevice.getDisplayHeight();

		if (print) {
			System.out.println("" + width);
			System.out.println("" + height);
		}

		int relativeWidth = (int) (width * relX);
		int relativeHeight = (int) (height * relY);

		if (print) {
			System.out.println(relativeWidth);
			System.out.println(relativeHeight);
		}

		myDevice.click(relativeWidth, relativeHeight);
	}

	public int getNormX(UiDevice myDevice, double relX) {
		int width = myDevice.getDisplayWidth();
		int normWidth = (int) (width * relX);
		return normWidth;
	}

	public int getNormY(UiDevice myDevice, double relY) {
		int height = myDevice.getDisplayHeight();
		int normHeight = (int) (height * relY);
		return normHeight;
	}

	/*
	 * KEYS
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

	public void pressMultiDelete(UiDevice myDevice, int times) {
		for (int i = 0; i < times; i++) {
			myDevice.pressDelete();
		}
	}

}