package com.generic;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Base_Class implements AutoConstants{
	public AndroidDriver driver;
	public WebDriver_Utility wdu=new WebDriver_Utility();
	PropertyFileUtility p=new PropertyFileUtility();
	public static AndroidDriver staticdriver;
	
	AppiumDriverLocalService service= AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
			.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
			.usingPort(4723)
			.withLogFile(new File("../appium-21/Appium_LOGfile/Logs1.txt")));
	
    @BeforeSuite
	public void StartServer()
	{
		 service= AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
				.usingPort(4723)
				.withLogFile(new File("../appium-21/Appium_LOGfile/Logs1.txt")));
		service.start();
	}
	
	
	//@Parameters("BROWSER")
	@BeforeClass
	public void launchApplication() throws IOException, InterruptedException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName", p.readdata("deviceName"));
		dc.setCapability("automationName", p.readdata("automationName"));
		dc.setCapability("platformName", p.readdata("platformName"));
		dc.setCapability("platformVersion", p.readdata("platformVersion"));
		dc.setCapability("UDID", p.readdata("UDID"));
		dc.setCapability("appPackage", p.readdata("appPackage"));
		dc.setCapability("appActivity", p.readdata("appActivity"));
		dc.setCapability("noReset", p.readdata("noReset"));


		URL url=new URL("http://localhost:4723/wd/hub");
		driver=new AndroidDriver(url,dc);
		staticdriver=driver;
	
	}

	@BeforeMethod(groups={"Smoke test","Regression test"})
	public void logintoVtiger() throws IOException
	{
		String UN=p.readdata("UN");
		String PWD=p.readdata("PWD");

		//Loginpage lp=new Loginpage(driver);
		//lp.loginapp(UN, PWD);
		staticdriver=driver;
	}

	@AfterMethod(groups={"Smoke test","Regression test"})
	public void logoutVtiger() throws InterruptedException
	{
		//HomePage hp=new HomePage(driver);
		Thread.sleep(2000);
		//hp.signout(driver);
	}

	@AfterClass(groups={"Smoke test","Regression test"})
	public void closebrowser()
	{
		driver.close();
	}
	
	
	@AfterSuite
	public void StopServer()
	{
		service.stop();
	}


	public static String getscreenshot(String name) throws IOException
	{
		File srcfile=((TakesScreenshot)staticdriver).getScreenshotAs(OutputType.FILE);
		String destfile=System.getProperty("user.dir")+"/Screenshots/"+name+".png";
		File finaldest=new File(destfile);
		FileUtils.copyFile(srcfile, finaldest);
		
		return destfile;
	}
}
