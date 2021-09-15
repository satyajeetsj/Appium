package com.web;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Landing_page {
	
	AndroidDriver driver;
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private MobileElement countryDD;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private MobileElement nametxt;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	private MobileElement maleradiobtn;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private MobileElement femaleradiobtn;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private MobileElement letsshopbtn;

	public AndroidDriver getDriver() {
		return driver;
	}

	public MobileElement getCountryDD() {
		return countryDD;
	}

	public MobileElement getNametxt() {
		return nametxt;
	}

	public MobileElement getMaleradiobtn() {
		return maleradiobtn;
	}

	public MobileElement getFemaleradiobtn() {
		return femaleradiobtn;
	}

	public MobileElement getLetsshopbtn() {
		return letsshopbtn;
	}
	
	public Landing_page(AndroidDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); //we use appiumfieldDecorator to initilaise both iOS and Android page
	}
	
	public void loginapp()
	{
		
		getNametxt().sendKeys("Satyajeet");
		getMaleradiobtn().click();
		getLetsshopbtn().click();
	}
	
	public void logintoapp(String name)
	{
		
		getNametxt().sendKeys(name);
		getMaleradiobtn().click();
		getLetsshopbtn().click();
	}

}
