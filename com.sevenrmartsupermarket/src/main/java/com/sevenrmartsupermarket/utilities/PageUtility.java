package com.sevenrmartsupermarket.utilities;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.sevenrmartsupermarket.constants.Constants;

public class PageUtility {

	WebDriver driver;
	JavascriptExecutor js;

	public PageUtility(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}

	// for dropdown

	public void selectByIndex(WebElement element, int index) {

		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);

	}

	public void mouseClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.click(element).build().perform();
	}
	// js executor

	public void jsClick(WebElement element) {

		js.executeScript("arguments[0].click();", element);

	}

	public void scrollToElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void scrollAndClick(WebElement element) {
		int index = 0;

		while (!isClicked(element)) {
			js.executeScript("window.scrollBy(0," + index + ")");
			index = index + 5;

		}

	}

	public boolean isClicked(WebElement element) {

		try {
			element.click();
			return true;

		} catch (Exception e) {
			return false;

		}

	}

	public void imageUpload(WebElement element) {
		File file = new File(Constants.IMAGE_FILE_PATH);
		element.sendKeys(file.getAbsolutePath());
	}
	
	

}
