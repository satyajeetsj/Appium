package com.webdriverMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Logs1 {
	public static AndroidDriver driver;
	@Test
	public void cam() throws MalformedURLException, InterruptedException
	{
		AppiumDriverLocalService service= AppiumDriverLocalService.buildDefaultService();
		service.start();
		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName", "vivo 1902");
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "9");
		dc.setCapability("UDID", "GAPBB6F68TOR4DIZ");
		dc.setCapability("appPackage", "com.android.camera");
		dc.setCapability("appActivity", ".Camera");
		dc.setCapability("noReset", true);
		
		
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url,dc);
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_CAMERA);
		Thread.sleep(2000);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_DOWN);
		Thread.sleep(2000);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_UP);
		Thread.sleep(2000);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BACK);
		Thread.sleep(2000);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BRIGHTNESS_UP);
		Thread.sleep(2000);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BRIGHTNESS_DOWN);
		Thread.sleep(2000);
		
		System.out.println(AndroidKeyCode.KEYCODE_CAMERA);
		System.out.println(AndroidKeyCode.KEYCODE_VOLUME_UP);
		System.out.println(AndroidKeyCode.KEYCODE_VOLUME_DOWN);
		System.out.println(AndroidKeyCode.KEYCODE_BACK);
		System.out.println(AndroidKeyCode.KEYCODE_BRIGHTNESS_UP);
		System.out.println(AndroidKeyCode.KEYCODE_BRIGHTNESS_DOWN);
		
		service.stop();
		
}
}
