package com.appurify.appsolo;

import java.util.ArrayList;

import junit.framework.AssertionFailedError;

import com.robotium.solo.By;
import com.robotium.solo.WebElement;

import android.app.Activity;
import android.app.Instrumentation;
import android.graphics.Point;
import android.os.SystemClock;
import android.util.Log;
import android.view.Display;
import android.view.InputDevice;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;

public class AppSolo extends com.robotium.solo.Solo {

	protected final android.app.Instrumentation instrumentation;
	protected final Activity activity;

	public AppSolo(android.app.Instrumentation inst,
			android.app.Activity callingActivity, java.lang.String className,
			java.lang.String methodName) {
		super(inst, callingActivity);
		this.instrumentation = inst;
		this.activity = callingActivity;
	}

	public AppSolo(android.app.Instrumentation inst,
			android.app.Activity callingActivity) {
		super(inst, callingActivity);
		this.instrumentation = inst;
		this.activity = callingActivity;
	}

	private void assertTrue(String message, boolean check) {
		if (!check) {
			throw new AssertionFailedError(message);
		}
	}

	
	public void checkEnabled(String id){
		getView(id).isEnabled();
	}
	
	public void clickOnButton(android.widget.Button button) {
		this.clickOnView((View) button);
	}

	public void clickOnCheckBox(android.widget.CheckBox checkBox) {
		this.clickOnView((View) checkBox);
	}

	public void clickOnEditText(android.widget.EditText editText) {
		this.clickOnView((View) editText);
	}

	public void clickOnImage(android.widget.ImageView imageView) {
		this.clickOnView((View) imageView);
	}

	public void clickOnImageButton(android.widget.ImageButton imageButton) {
		this.clickOnView((View) imageButton);
	}

	public void clickOnRadioButton(android.widget.RadioButton radioButton) {
		this.clickOnView((View) radioButton);
	}

	public void clickOnScreenRelative(float relativeX, float relativeY) {
		clickOnScreen(getNormalizedX(relativeX), getNormalizedX(relativeY));

	}

	public void clickOnScreenRelativeIgnoreMenu(float relativeX, float relativeY) {
		if (android.os.Build.MODEL.equals("Nexus 7")) {
			float clickX = (float) ((((relativeX * 1105.0) + 88) / 1193.0));
			clickOnScreenRelative(clickX, relativeY);
		} else if (android.os.Build.MODEL.equals("Nexus 5")
				|| android.os.Build.MODEL.equals("Nexus 4")
				|| android.os.Build.MODEL.equals("XT1058")
				|| android.os.Build.MODEL.equals("XT1053")
				|| android.os.Build.MODEL.equals("XT1052")
				|| android.os.Build.MODEL.equals("XT1056")
				|| android.os.Build.MODEL.equals("XT1060")
				|| android.os.Build.MODEL.equals("XT1055")
				|| android.os.Build.MODEL.equals("X1032")
				|| android.os.Build.MODEL.equals("XT1034")) {
			float clickY = (float) ((relativeY * 1798.0) / 1919.0);
			clickOnScreenRelative(relativeX, clickY);
		} else {
			clickOnScreenRelative(relativeX, relativeY);
		}
	}

	public void clickOnText(android.widget.TextView textView) {
		this.clickOnView((View) textView);
	}

	public void clickOnToggleButton(android.widget.ToggleButton toggleButton) {
		this.clickOnView((View) toggleButton);
	}

	// check if necessary to put get view
	public void clickOnViewById(String resourceId) {
		clickOnView(getView(resourceId));
	}

	public void displayHTML() {
		ArrayList<WebElement> elements = getCurrentWebElements();
		Log.d("Robotium", "************Logging HTML*************");
		for (int i = 0; i < elements.size(); i++) {
			logRobotium("Tag name:" + elements.get(i).getTagName());
			logRobotium("ID:" + elements.get(i).getId());
			logRobotium("Text:" + elements.get(i).getText());
			logRobotium(" ");
			logRobotium(" ");
		}

	}

	public void dragRelative(float fromX, float toX, float fromY, float toY,
			int stepCount) {
		drag(getNormalizedX(fromX), getNormalizedX(toX), getNormalizedY(fromY),
				getNormalizedY(toY), stepCount);
	}
	
	
	public void dragRelativeIgnoreMenu(float fromRelativeX, float toRelativeX, float fromRelativeY, float toRelativeY ,int stepCount){
	if (android.os.Build.MODEL.equals("Nexus 7")) {
			float fromX = (float) ((((fromRelativeX * 1105.0) + 88) / 1193.0));
			float toX = (float) ((((toRelativeX * 1105.0) + 88) / 1193.0));
			dragRelative( fromX, toX, fromRelativeY,  toRelativeY, stepCount);
		} else if (android.os.Build.MODEL.equals("Nexus 5")
				|| android.os.Build.MODEL.equals("Nexus 4")
				|| android.os.Build.MODEL.equals("XT1058")
				|| android.os.Build.MODEL.equals("XT1053")
				|| android.os.Build.MODEL.equals("XT1052")
				|| android.os.Build.MODEL.equals("XT1056")
				|| android.os.Build.MODEL.equals("XT1060")
				|| android.os.Build.MODEL.equals("XT1055")
				|| android.os.Build.MODEL.equals("X1032")
				|| android.os.Build.MODEL.equals("XT1034")) {
				
			float fromX = (float) ((fromRelativeX * 1798.0) / 1919.0);
			float toX = (float) ((toRelativeX * 1798.0) / 1919.0);
			dragRelative( fromX, toX, fromRelativeY,  toRelativeY, stepCount);	
		} else {
			dragRelative(fromRelativeX, toRelativeX, fromRelativeY, toRelativeY, stepCount);
		}
	}

	public float getDisplayWidth() {
		Activity ACT = activity;

		Display display = ACT.getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int width = size.x;
		return width;
	}

	public float getDisplayHeight() {
		Activity ACT = activity;

		Display display = ACT.getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int height = size.y;
		return height;
	}

	final Instrumentation getInstrumentation() {
		return instrumentation;

	}

	public float getNormalizedX(float relativeX) {
		float width = getDisplayWidth();
		float normalizedX = relativeX * width;

		return normalizedX;

	}

	public float getNormalizedY(float relativeY) {
		float height = getDisplayHeight();
		float normalizedY = relativeY * height;

		return normalizedY;

	}

	public void logDimentions() {
		Log.d("Appurify", "Width: " + getDisplayWidth());
		Log.d("Appurify", "Height: " + getDisplayHeight());
	}

	public void logRobotium(String message) {
		Log.d("Robotium", message);
	}

	public void logRobotiumFail(String message) {
		Log.d("Robotium", "Fail: " + message);
	}

	public void logRobotiumPass(String message) {
		Log.d("Robotium", "Pass: " + message);
	}
	
	/*
	 * Press delete the give number of times
	 */
	
	public void pressDelete(int count) {
		for (int i = 0; i < count; i++) {
		    sendKey(DELETE);
			sleep(50);
		}
	}

	public void signInToFBConnect(String email, String password) {
		// Type email
		assertTrue(
				"Email field not visible (If you are seeing this message in error FB Connect login"
						+ "may have changed, please update your Appurify Library or contact Appurify"
						+ "Support)", waitForWebElement(By.name("email")));
		enterTextInWebElement(By.name("email"), email);

		// Type password
		enterTextInWebElement(By.name("pass"), password);

		// Click login
		clickOnWebElement(By.name("login"));

		// click ok
		try {
			waitForWebElement(By.textContent("OK"));
			clickOnWebElement(By.textContent("OK"));
		} catch (AssertionFailedError e) {
			logRobotium("Your account has already been activated popup did not occur ");
		}
	}

	public void signInToTwitter(String email, String password) {
		assertTrue(
				"Email field not visible (If you are seeing this message in error Twitter login"
						+ "may have changed, please update your Appurify Library or contact Appurify"
						+ " Support)",
				waitForWebElement(By.id("username_or_email")));
		enterTextInWebElement(By.id("username_or_email"), email);

		sleep(2000);
		enterTextInWebElement(By.id("password"), password);

		sleep(2000);
		clickOnWebElement(By.id("allow"));
	}

	/*
	 * APPURIFY COMMENT: This function enables you to type using the soft
	 * keyboard.
	 */
	public void typeKeyboard(String toType) {
		KeyCharacterMap keyCharacterMap = KeyCharacterMap
				.load(KeyCharacterMap.VIRTUAL_KEYBOARD);
		String text = toType;
		KeyEvent[] events = keyCharacterMap.getEvents(text.toCharArray());

		if (events != null) {
			for (int i = 0; i < events.length; i++) {
				events[i].setSource(InputDevice.SOURCE_KEYBOARD);
				instrumentation.sendKeySync(KeyEvent.changeTimeRepeat(
						events[i], SystemClock.uptimeMillis(), 0));
			}
		}
	}


	// **** Button ****

	public boolean waitForButton(int index, int timeout, boolean scroll) {
		return this.waitForView(
				this.getView(android.widget.Button.class, index), timeout,
				scroll);

	}

	public boolean waitForButton(int index, int timeout) {
		return this
				.waitForView(this.getView(android.widget.Button.class, index),
						timeout, true);

	}

	public boolean waitForButton(int index) {
		return this.waitForView(
				this.getView(android.widget.Button.class, index), 20000, true);

	}

	// **** CheckBox ****

	public boolean waitForCheckBox(int index, int timeout, boolean scroll) {
		return this.waitForView(
				this.getView(android.widget.CheckBox.class, index), timeout,
				scroll);

	}

	public boolean waitForCheckBox(int index, int timeout) {
		return this.waitForView(
				this.getView(android.widget.CheckBox.class, index), timeout,
				true);

	}

	public boolean waitForCheckBox(int index) {
		return this
				.waitForView(
						this.getView(android.widget.CheckBox.class, index),
						20000, true);

	}

	// **** DatePicker ****

	public boolean waitForDatePicker(int index, int timeout, boolean scroll) {
		return this.waitForView(
				this.getView(android.widget.DatePicker.class, index), timeout,
				scroll);

	}

	public boolean waitForDatePicker(int index, int timeout) {
		return this.waitForView(
				this.getView(android.widget.DatePicker.class, index), timeout,
				true);

	}

	public boolean waitForDatePicker(int index) {
		return this.waitForView(
				this.getView(android.widget.DatePicker.class, index), 20000,
				true);

	}

	// **** EditText ****

	public boolean waitForEditText(int index, int timeout, boolean scroll) {
		return this.waitForView(
				this.getView(android.widget.EditText.class, index), timeout,
				scroll);

	}

	public boolean waitForEditText(int index, int timeout) {
		return this.waitForView(
				this.getView(android.widget.EditText.class, index), timeout,
				true);

	}

	public boolean waitForEditText(int index) {
		return this
				.waitForView(
						this.getView(android.widget.EditText.class, index),
						20000, true);

	}

	// **** ImageView ****

	public boolean waitForImageView(int index, int timeout, boolean scroll) {
		return this.waitForView(
				this.getView(android.widget.ImageView.class, index), timeout,
				scroll);

	}

	public boolean waitForImageView(int index, int timeout) {
		return this.waitForView(
				this.getView(android.widget.ImageView.class, index), timeout,
				true);

	}

	public boolean waitForImageView(int index) {
		return this.waitForView(
				this.getView(android.widget.ImageView.class, index), 20000,
				true);

	}

	// **** ImageButton ****

	public boolean waitForImageButton(int index, int timeout, boolean scroll) {
		return this.waitForView(
				this.getView(android.widget.ImageButton.class, index), timeout,
				scroll);

	}

	public boolean waitForImageButton(int index, int timeout) {
		return this.waitForView(
				this.getView(android.widget.ImageButton.class, index), timeout,
				true);

	}

	public boolean waitForImageButton(int index) {
		return this.waitForView(
				this.getView(android.widget.ImageButton.class, index), 20000,
				true);

	}

	// **** List views ****

	public boolean waitForListView(int index, int timeout, boolean scroll) {
		return this.waitForView(
				this.getView(android.widget.ListView.class, index), timeout,
				scroll);

	}

	public boolean waitForListView(int index, int timeout) {
		return this.waitForView(
				this.getView(android.widget.ListView.class, index), timeout,
				true);

	}

	public boolean waitForListView(int index) {
		return this
				.waitForView(
						this.getView(android.widget.ListView.class, index),
						20000, true);

	}

	// **** Radio buttons ****

	public boolean waitForRadioButton(int index, int timeout, boolean scroll) {
		return this.waitForView(
				this.getView(android.widget.RadioButton.class, index), timeout,
				scroll);

	}

	public boolean waitForRadioButton(int index, int timeout) {
		return this.waitForView(
				this.getView(android.widget.RadioButton.class, index), timeout,
				true);

	}

	public boolean waitForRadioButton(int index) {
		return this.waitForView(
				this.getView(android.widget.RadioButton.class, index), 20000,
				true);

	}

	public boolean waitForSpinner(int index, int timeout, boolean scroll) {
		return this.waitForView(
				this.getView(android.widget.Spinner.class, index), timeout,
				scroll);

	}

	public boolean waitForSpinner(int index, int timeout) {
		return this.waitForView(
				this.getView(android.widget.Spinner.class, index), timeout,
				true);

	}

	public boolean waitForSpinner(int index) {
		return this.waitForView(
				this.getView(android.widget.Spinner.class, index), 20000, true);

	}

	// **** TextView ***
	public boolean waitForText(String text, int timeout) {
		return this.waitForText(text, 1, timeout);
	}

	public boolean waitForTextView(int index, int timeout, boolean scroll) {
		return this.waitForView(
				this.getView(android.widget.TextView.class, index), timeout,
				scroll);

	}

	public boolean waitForTextView(int index, int timeout) {
		return this.waitForView(
				this.getView(android.widget.TextView.class, index), timeout,
				true);

	}

	public boolean waitForTextView(int index) {
		return this
				.waitForView(
						this.getView(android.widget.TextView.class, index),
						20000, true);

	}

	// **** TimePicker ****
	public boolean waitForTimePicker(int index, int timeout, boolean scroll) {
		return this.waitForView(
				this.getView(android.widget.TimePicker.class, index), timeout,
				scroll);

	}

	public boolean waitForTimePicker(int index, int timeout) {
		return this.waitForView(
				this.getView(android.widget.TimePicker.class, index), timeout,
				true);

	}

	public boolean waitForTimePicker(int index) {
		return this.waitForView(
				this.getView(android.widget.TimePicker.class, index), 20000,
				true);

	}

	// **** ToggleButton ****

	public boolean waitForToggleButton(int index, int timeout, boolean scroll) {
		return this.waitForView(
				this.getView(android.widget.ToggleButton.class, index),
				timeout, scroll);

	}

	public boolean waitForToggleButton(int index, int timeout) {
		return this.waitForView(
				this.getView(android.widget.ToggleButton.class, index),
				timeout, true);

	}

	public boolean waitForToggleButton(int index) {
		return this.waitForView(
				this.getView(android.widget.ToggleButton.class, index), 20000,
				true);

	}

	// **** View ****

	public boolean waitForViewById(String id, int timeout, Boolean scroll) {
		return waitForView(getView(id), timeout, scroll);
	}

	public boolean waitForViewById(String id, int timeout) {
		return waitForView(getView(id), timeout, true);
	}

	public boolean waitForViewById(String id) {
		return waitForView(getView(id), 20000, true);
	}

}
