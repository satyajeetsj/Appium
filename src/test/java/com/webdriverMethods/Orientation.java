package com.webdriverMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;



import io.appium.java_client.android.AndroidDriver;

public class Orientation {

	@Test
	public void orient() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName", "vivo 1902");
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "9");
		dc.setCapability("UDID", "GAPBB6F68TOR4DIZ");
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", ".ApiDemos");
		dc.setCapability("noReset", true);
		
		
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url,dc);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement views = driver.findElementByAccessibilityId("Views");
		views.click();
		
		ScreenOrientation currentscreenorientation = driver.getOrientation();
		System.out.println(currentscreenorientation);
		Thread.sleep(2000);
		driver.rotate(ScreenOrientation.LANDSCAPE);
		
		System.out.println(driver.getOrientation());
		Thread.sleep(2000);
		driver.rotate(ScreenOrientation.PORTRAIT);
		System.out.println(driver.getOrientation());
		
		
		
}
}