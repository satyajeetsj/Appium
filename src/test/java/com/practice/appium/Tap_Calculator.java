package com.practice.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;



public class Tap_Calculator {
	@Test
	public void launchCalculator() throws MalformedURLException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName", "vivo 1902");
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "9");
		dc.setCapability("UDID", "GAPBB6F68TOR4DIZ");
		dc.setCapability("appPackage", "com.android.bbkcalculator");
		dc.setCapability("appActivity", ".Calculator");
		dc.setCapability("noReset", true);
		
		URL url=new URL("http://localhost:4723/wd/hub");
		
		AndroidDriver driver=new AndroidDriver(url,dc);
		//IOSDriver
		
		WebElement five = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='5']"));
		driver.tap(1, five, 500);// create a generic lib
		WebElement plus = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='加']"));
		tapOnElement(driver, plus);
		WebElement six = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='6']"));
		tapOnElement(driver, six);
		WebElement equals = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='等于']"));
		tapOnElement(driver, equals);
		String result = driver.findElement(By.xpath("//android.widget.EditText[@content-desc='11']")).getText();
		int actual = Integer.parseInt(result);
		 int exp = 11;
		Assert.assertEquals(exp, actual);
		System.out.println(actual);
	}
	public void tapOnElement(AndroidDriver driver, WebElement element)
	{
		driver.tap(1, element, 500);
	}

}