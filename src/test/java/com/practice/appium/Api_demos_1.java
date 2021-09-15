package com.practice.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Api_demos_1 {

	@Test
	public void ApiTC_1() throws MalformedURLException
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
		List<WebElement> ele = driver.findElements(By.xpath("//android.widget.TextView[@package='io.appium.android.apis']"));
		for(int i=0;i<ele.size();i++)
		{
			String list = ele.get(i).getText();
			System.out.println(list);
			
		}
		System.out.println(ele.size());
	}
}
