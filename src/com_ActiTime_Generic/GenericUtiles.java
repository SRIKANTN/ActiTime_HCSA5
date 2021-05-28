package com_ActiTime_Generic;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class GenericUtiles 
{
	public static void getScreenShot(WebDriver driver,String name)
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try 
		{
			Files.copy(src, new File("./ScreenShot/"+name+".png"));
		}
		catch (IOException e) {
		}
	}
	
	public static void selectByIndex(WebElement element,int index) 
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	public static void selectByValue(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	public static void selectByVisibleText(WebElement element,String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	public static void deSelectByIndex(WebElement element,int index) 
	{
		Select sel = new Select(element);
		sel.deselectByIndex(index);
	}
	public static void deSelectByValue(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.deselectByValue(value);
	}
	public static void deselectByVisibleText(WebElement element,String text)
	{
		Select sel = new Select(element);
		sel.deselectByVisibleText(text);
	}
	public void deSelectAll(WebElement element)
	{
		Select sel = new Select(element);
		sel.deselectAll();
	}
}
