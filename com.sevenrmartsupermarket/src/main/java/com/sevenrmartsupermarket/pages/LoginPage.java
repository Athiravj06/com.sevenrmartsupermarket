package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class LoginPage {

	WebDriver driver;
	PageUtility pageUtility;
	Properties properties = new Properties();
	GeneralUtility utility=new GeneralUtility();

	@FindBy(xpath = "//input[@type='text']")
	private WebElement userNameField;
	@CacheLookup 
	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	private WebElement signInButton;
	@FindBy(xpath = "//label[contains(text(),'Remember Me')]")
	private WebElement rememberMe;
	@FindBy(xpath = "//label[contains(text(),'Remember Me')]")
	private WebElement rememberMeBox;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		pageUtility=new PageUtility(driver);
		try {
			/** to load the config.properties file**/
			FileInputStream inputStream = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(inputStream);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);

	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);

	}

	public boolean rememberMeBox() {
		return pageUtility.isClicked(rememberMeBox);
	}

	public void clickOnSiginButton() {
		signInButton.click();
	}

	public HomePage login(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickOnSiginButton();
		return new HomePage(driver);
	}
	
	public HomePage login() {
		String userName=properties.getProperty("userName");
		String password=properties.getProperty("password");
		enterUserName(userName);
		enterPassword(password);
		clickOnSiginButton();
		return new HomePage(driver);	
	}
	
	


}
