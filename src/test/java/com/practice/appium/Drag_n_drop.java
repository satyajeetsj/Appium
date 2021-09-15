package com.practice.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Drag_n_drop {

	@Test
	public void DnD() throws MalformedURLException
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
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Drag and Drop']")).click();
		
		WebElement src = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		WebElement dest = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_3"));
		
		TouchAction ta=new TouchAction(driver);
		ta.longPress(src).waitAction(2000).moveTo(dest).release().perform();
		
		
}
	
}
