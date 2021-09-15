package com.practice.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class TouchScreen {

	@Test
	public void screenswipe() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName", "vivo 1902");
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "9");
		dc.setCapability("UDID", "GAPBB6F68TOR4DIZ");
		dc.setCapability("appPackage", "jp.rallwell.siriuth.touchscreentest");
		dc.setCapability("appActivity", ".TouchScreenTestActivity");
		dc.setCapability("noReset", true);


		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url,dc);
		
		driver.swipe(149, 705, 637, 511, 500);

}
//	
//	public void swipe_generic(AndroidDriver driver)
//	{
//		driver.swipe(startx, starty, endx, endy, duration);
//	}
//	
}

