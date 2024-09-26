package com.sevenrmartsupermarket.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	

	WebDriver driver;
	WebDriverWait wait;

	
	public WaitUtility(WebDriver driver) {

		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));

	}



	public void waitforElementtobeClickable(WebElement element) {

		wait.until(ExpectedConditions.elementToBeClickable(element));

	}


	public void waitforElementtobeVisible(String xpath) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));	

	}


	
	

}
