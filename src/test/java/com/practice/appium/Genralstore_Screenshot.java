package com.practice.appium;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.web.Landing_page;

import io.appium.java_client.android.AndroidDriver;

public class Genralstore_Screenshot {
	public static WebDriver staticdriver;
	AndroidDriver driver;
	@Test
	public void addCart() throws InterruptedException, IOException
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
		driver=new AndroidDriver(url,dc);
		staticdriver=driver;
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Landing_page lp=new Landing_page(driver);
		Thread.sleep(2000);
		lp.logintoapp("Satyajeet");
		
		getscreenshot("Screencapture");
//		TakesScreenshot ts=(TakesScreenshot) driver;
//		File src = ts.getScreenshotAs(OutputType.FILE);
//		File dst=new File("../appium-21/Genscreenshot/capture1.png");
//		FileUtils.copyFile(src, dst);
	
		
	}
	public static String getscreenshot(String name) throws IOException
	{
		File srcfile=((TakesScreenshot)staticdriver).getScreenshotAs(OutputType.FILE);
		String destfile=System.getProperty("user.dir")+"/Screenshots/"+name+".png";
		File finaldest=new File(destfile);
		FileUtils.copyFile(srcfile, finaldest);
		
		return destfile;
	}
	
//	TakesScreenshot ts=(TakesScreenshot) driver;
//	File src = ts.getScreenshotAs(OutputType.FILE);
//	File dst=new File("E:\\Qspiders\\Selenium Screenshot\\amazon.jpeg");
//	FileUtils.copyFile(src, dst);
}
