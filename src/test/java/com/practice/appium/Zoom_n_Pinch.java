package com.practice.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Zoom_n_Pinch {
	@Test
	public void Zoom_pinch() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName", "vivo 1902");
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "9");
		dc.setCapability("UDID", "GAPBB6F68TOR4DIZ");
		dc.setCapability("appPackage", "com.davemorrissey.labs.subscaleview.sample");
		dc.setCapability("appActivity", ".MainActivity");
		dc.setCapability("noReset", true);
		
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url,dc);
		
		driver.findElement(By.id("com.davemorrissey.labs.subscaleview.sample:id/basicFeatures")).click();
		WebElement img = driver.findElement(By.xpath("//android.view.View[@resource-id='com.davemorrissey.labs.subscaleview.sample:id/imageView']"));
		driver.zoom(img);
		Thread.sleep(2000);
		driver.pinch(img);

}
	
}
