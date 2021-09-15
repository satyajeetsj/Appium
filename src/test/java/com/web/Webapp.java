package com.web;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Webapp {

	@Test
	public void web_app() throws MalformedURLException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "vivo 1902");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		dc.setCapability(MobileCapabilityType.UDID, "GAPBB6F68TOR4DIZ");
		dc.setCapability(MobileCapabilityType.NO_RESET, true);
		
		//Launch browser
		dc.setCapability("browserName", "Chrome");
		
		//Appium server port No.
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url,dc);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com");
		driver.findElement(By.xpath("//input[@id='m_login_email']")).sendKeys("9481052048");
		driver.findElement(By.xpath("//input[@id='m_login_password']")).sendKeys("satya");
		driver.findElement(By.xpath("//button[@name='login']")).click();
	}
}
