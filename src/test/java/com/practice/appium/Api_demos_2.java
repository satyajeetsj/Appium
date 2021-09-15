package com.practice.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

@Test
public class Api_demos_2 {

	public void ApiTC_2() throws MalformedURLException, InterruptedException
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
		driver.findElement(By.id("io.appium.android.apis:id/edit")).sendKeys("Appium");
		WebElement chkbox1 = driver.findElement(By.xpath("//android.widget.CheckBox[@content-desc='Checkbox 1']"));
		WebElement radiobtn1 = driver.findElement(By.xpath("//android.widget.RadioButton[@content-desc='RadioButton 1']"));
		chkbox1.click();
		Thread.sleep(2000);
		radiobtn1.click();
		boolean b1 = chkbox1.isEnabled();
		boolean b2 = chkbox1.isSelected();
		boolean r1 = radiobtn1.isEnabled();
		boolean r2 = radiobtn1.isSelected();
		if(b1)
		{
			System.out.println("Checkbox is Enabled");
		}
		else
		{
			System.out.println("Checkbox is disabled");
		}
		if(b2)
		{
			System.out.println("Checkbox is Selected");
		}
		else
		{
			System.out.println("Checkbox is not Selected");
		}
		if(r1)
		{
			System.out.println("Radiobutton is Enabled");
		}
		else
		{
			System.out.println("Radiobutton is disabled");
		}
		if(r2)
		{
			System.out.println("Radiobutton is Selected");
		}
		else
		{
			System.out.println("Radiobutton is not selected");
		}
	}
	
}
