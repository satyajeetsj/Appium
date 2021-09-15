package com.practice.appium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GenericScreenshot {
	public static WebDriver staticdriver;
	
	public static String getscreenshot(String name) throws IOException
	{
		File srcfile=((TakesScreenshot)staticdriver).getScreenshotAs(OutputType.FILE);
		String destfile=System.getProperty("user.dir")+"/Screenshots/"+name+".png";
		File finaldest=new File(destfile);
		FileUtils.copyFile(srcfile, finaldest);
		
		return destfile;
	}
}
