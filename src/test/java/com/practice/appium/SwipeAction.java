package com.practice.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class SwipeAction {
	AndroidDriver driver;
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
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Dimension size = driver.manage().window().getSize();
		int ht=size.getHeight();
		int wd=size.getWidth();
		System.out.println(ht);
		System.out.println(wd);
		
		
		//Swipe action Horizontally
		
		driver.swipe((int)(wd*0.1), (int)(ht*0.8), (int)(wd*0.9), (int)(ht*0.8), 500);
		driver.swipe((int)(wd*0.1), (int)(ht*0.2), (int)(wd*0.9), (int)(ht*0.2), 500);
		driver.swipe((int)(wd*0.1), (int)(ht*0.5), (int)(wd*0.9), (int)(ht*0.5), 500);
		
		//Swipe action Vertically
		driver.swipe((int)(wd*0.1), (int)(ht*0.2), (int)(wd*0.1), (int)(ht*0.8), 500);
		driver.swipe((int)(wd*0.5), (int)(ht*0.2), (int)(wd*0.5), (int)(ht*0.8), 500);
		driver.swipe((int)(wd*0.9), (int)(ht*0.2), (int)(wd*0.9), (int)(ht*0.8), 500);

}

}

