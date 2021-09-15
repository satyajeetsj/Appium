package com.webdriverMethods;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Notifications {

	@Test
	public void notif() throws MalformedURLException, InterruptedException
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
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='App']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Notification']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='IncomingMessage']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@content-desc='Show App Notification']")).click();
		
		Thread.sleep(2000);
		driver.openNotifications();
		driver.findElement(By.xpath("//android.widget.TextView[@text='API Demos']")).click();
		
		
}
}