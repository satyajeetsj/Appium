package com.practice.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Calendar {

	@Test
	public void launchCalendar() throws MalformedURLException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName", "vivo 1902");
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "9");
		dc.setCapability("UDID", "GAPBB6F68TOR4DIZ");
		dc.setCapability("appPackage", "com.android.bbkcalculator");
		dc.setCapability("appActivity", ".Calculator");
		
		URL url=new URL("http://localhost:4723/wd/hub");
		
		AndroidDriver driver=new AndroidDriver(url,dc);
		//IOSDriver
		
		
	}
}
