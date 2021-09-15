package com.practice.appium;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.generic.Base_Class;

import io.appium.java_client.android.AndroidDriver;

@Listeners(com.practice.appium.Listeners.class)
public class GeneralStoreAddCartValidt extends Base_Class {

	public static AndroidDriver staticdriver;
	public AndroidDriver driver;

	@Test
	public void addCart() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		
		WebElement countryDD = driver.findElement(By.id("//android.widget.Spinner[@resource-id='com.androidsample.generalstore:id/spinnerCountry']"));
		driver.tap(1, countryDD, 500);
		List<WebElement> options = driver.findElements(By.className("android.widget.TextView"));
		

		scrollToElement(driver, "text", "India");
		driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		driver.findElement(By.className("android.widget.EditText")).sendKeys("Satyajeet");
		driver.findElement(By.className("android.widget.Button")).click();

		driver.findElement(By.xpath("//android.widget.TextView[@bounds='[360,713][664,741]']")).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		String exp = "Air Jordan 4 Retro";
		String act = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName']")).getText();
		Assert.assertEquals(exp, act);
		System.out.println("Validation PASSED");
	}

	public static void scrollToElement(AndroidDriver driver, String an, String av)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+an+"(\""+av+"\"))");
	}


}
