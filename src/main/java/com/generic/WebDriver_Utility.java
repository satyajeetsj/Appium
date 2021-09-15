package com.generic;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @author Satyajeet
 * This class is used to perform all webdriver methods
 */
public class WebDriver_Utility {

	/**
	 * @author Satyajeet
	 * This method selects option by visible text
	 * @param element
	 * @param text
	 */
	public void select_Dropdwn(WebElement element, String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);

	}
	/**
	 * @author Satyajeet
	 * This method selects option by index value
	 * @param element
	 * @param index
	 */

	public void select_Dropdwn(WebElement element, int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * @author Satyajeet
	 * This method selects option by value
	 * @param value
	 * @param element
	 */
	public void select_Dropdwn(String value,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}

	/**
	 * @author Satyajeet
	 * This method switches frame by using index
	 * @param driver
	 * @param index
	 */
	public void switchframe(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}

	/**
	 * @author Satyajeet
	 * This method switches frame by using name or ID
	 * @param driver
	 * @param nameorID
	 */
	public void switchframe(WebDriver driver, String nameorID)
	{
		driver.switchTo().frame(nameorID);
	}

	/**
	 * @author Satyajeet
	 * This method switches frame by using element address
	 * @param driver
	 * @param element
	 */
	public void switchframe(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}

	/**
	 * @author Satyajeet
	 * This method switches window by using title
	 * @param driver
	 * @param title
	 */
	public void switchwindow(WebDriver driver, String title)
	{
		Set<String> allwin = driver.getWindowHandles();
		Iterator<String> it= allwin.iterator();
		while(it.hasNext())
		{
			String window=it.next();
			String currenttitle=driver.switchTo().window(window).getTitle();
			if(currenttitle.contains(title))
			{
				break;
			}
		}

	}


	/**
	 * @author Satyajeet
	 * This method moves cursor to the element
	 * @param driver
	 * @param element
	 */
	public void movetoelement(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * @author Satyajeet
	 * This method right clicks on the element
	 * @param driver
	 * @param element
	 */
	public void rightclick(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}

	/**
	 * @author Satyajeet
	 * This method double clicks on the element
	 * @param driver
	 * @param element
	 */
	public void doubleclick(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * @author Satyajeet
	 * This method drag and drops the element
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void dragNdrop(WebDriver driver, WebElement source, WebElement target)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(source, target).perform();
	}

	/**
	 * @author Satyajeet
	 * This method waits until the element is found
	 * @param driver
	 */
	public void implicitwait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * @author Satyajeet
	 * This method is used for explicit wait
	 * @param driver
	 * @param title
	 */
	public void explicitwait(WebDriver driver, String title)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains(title));

	}


}
