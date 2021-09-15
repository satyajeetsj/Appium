package com.practice.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class GeneralStoreAddCartValidt2 {

	@Test
	public void addCart2() throws MalformedURLException, InterruptedException
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
		
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		List<WebElement> options = driver.findElements(By.className("android.widget.TextView"));
//		for(int i=0;i<options.size();i++)
//		{
//			String text = options.get(i).getText();
//			System.out.println(text);
//		}
//		System.out.println(options.size());
		
		scrollToElement(driver, "text", "India");
		driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		driver.findElement(By.className("android.widget.EditText")).sendKeys("Satyajeet");
		driver.findElement(By.className("android.widget.Button")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@bounds='[360,713][664,741]']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@bounds='[360,1305][664,1333]']")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		String prod1 = driver.findElement(By.xpath("//android.widget.TextView[@text='$160.97']")).getText();
		String prod2 = driver.findElement(By.xpath("//android.widget.TextView[@text='$120.0']")).getText();
		
//		StringBuffer str=new StringBuffer(prod1);
//		str.deleteCharAt(prod1.length()-4);
//		System.out.println(str);
//		
//		String priceint=new String(str);
		
		String exp = "$ 280.97";
		String act = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/totalAmountLbl']")).getText();
		Assert.assertEquals(exp, act);
		System.out.println("Validation PASSED");
}
	
	public static void scrollToElement(AndroidDriver driver, String an, String av)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+an+"(\""+av+"\"))");
	}
}
