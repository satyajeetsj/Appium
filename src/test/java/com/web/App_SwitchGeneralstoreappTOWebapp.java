package com.web;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class App_SwitchGeneralstoreappTOWebapp {

	@Test
	public void login() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName", "vivo 1902");
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "9");
		dc.setCapability("UDID", "GAPBB6F68TOR4DIZ");
		dc.setCapability("appPackage", "com.androidsample.generalstore");
		dc.setCapability("appActivity", ".SplashActivity");
		dc.setCapability("noReset", true);
		
		
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url,dc);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Landing_page lp=new Landing_page(driver);
		Thread.sleep(2000);
		lp.logintoapp("Satyajeet");
		
		driver.findElement(By.xpath("//android.widget.TextView[@bounds='[360,713][664,741]']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@bounds='[360,1305][664,1333]']")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		Thread.sleep(2000);
		Set<String> windows = driver.getContextHandles();
		for(String window:windows)
		{
			System.out.println("Active Applications :"+ window);
		}
		Thread.sleep(2000);
		driver.context("WEBVIEW_com.androidsample.generalstore");
		
		
}
}