package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class AdminUserPage {

	WebDriver driver;
	GeneralUtility utility = new GeneralUtility();
	PageUtility pageUtility;
	WaitUtility waitUtility;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td")
	private List<WebElement> userDetails;
	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	private WebElement pageHeadingElement;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newAdminElement;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userName;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement userType;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successMessage;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		pageUtility = new PageUtility(driver);
	}

	public void userDetails() {
		List<String> details = new ArrayList<String>();
		details = utility.get_textofelements(userDetails);
		System.out.println(details);

	}

	public String getTextHeading() {
		return pageHeadingElement.getText();

	}

	public AdminUserPage clickOnNew() {
		newAdminElement.click();
		return this;
	}

	public AdminUserPage enterUsername(String userNameElement) {
		userName.sendKeys(userNameElement);
		return this;
	}

	public AdminUserPage enterPassword(String passwordElement) {
		password.sendKeys(passwordElement);
		return this;
	}

	public AdminUserPage selectUserType(String userTypeElement) {
		pageUtility.selectByVisibleText(userType, userTypeElement);
		return this;
	}

	public AdminUserPage clickOnSave() {
		waitUtility= new WaitUtility(driver);
	    waitUtility.waitforElementtobeClickable(saveButton);
	    pageUtility.scrollAndClick(saveButton);
		return this;
	}

	public String getAlertMessage() {

		return successMessage.getText();
	}

}
