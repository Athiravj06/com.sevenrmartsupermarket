package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class HomePage {
	WebDriver driver;
	GeneralUtility utility=new GeneralUtility();
	
	@FindBy(xpath = "//a[@class='d-block']")
	private WebElement profileName;
	@FindBy(xpath = "//div[@class='inner']//p[(text()='Sub Category')]//following::a[1]")
	private WebElement subCategory;
	@FindBy(xpath = "//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/user2-160x160.jpg']")
	private WebElement profilePicture;
	@FindBy(xpath = "//div[@class='inner']//p[(text()='Sub Category')]//following::a[3]")
	private WebElement manageGiftCards;
	@FindBy(xpath = "//div[@class='inner']//p[(text()='Admin Users')]//following::a[1]")
	private WebElement adminUser;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getProfileName() {
		return profileName.getText();
	}
	public SubCategoryPage clickOnSubCategory() {
		subCategory.click();
		return new SubCategoryPage(driver);
	}
	
	public String getColorManageGift() {
		return utility.getCssValue(manageGiftCards, "background-color");
	}

	public String getImageAdmin() {
		return utility.getAttribute(profilePicture, "src");
	}

	
	public AdminUserPage clickOnAdminUser() {
		adminUser.click();
		return new AdminUserPage(driver);
	}

}
