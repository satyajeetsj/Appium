package com.practice.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Api_demos_3 {

	@Test
	public void ApiTC_3() throws MalformedURLException, InterruptedException
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
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Controls']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='2. Dark Theme']")).click();
		driver.hideKeyboard();
		Thread.sleep(1000);
		driver.findElement(By.id("io.appium.android.apis:id/spinner1")).click();
		List<WebElement> options = driver.findElements(By.xpath("//android.widget.CheckedTextView[@package='io.appium.android.apis']"));
		for (int i = 0; i < options.size(); i++) {
			String text = options.get(i).getText();
			System.out.println(text);
			
			if(text.contains("Earth"))
			{
				driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Earth']")).click();
			}
			
		}
	}
}
