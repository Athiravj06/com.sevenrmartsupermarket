package com.sevenrmartsupermarket.pages;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class SubCategoryPage {
	
	WebDriver driver;
	GeneralUtility utility=new GeneralUtility();
	PageUtility pageUtility;
	WaitUtility waitUtility;
	
	@FindBy(xpath="//h1[text()='List Sub Categories']")
	private WebElement subcategoryheader;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	private List<WebElement> subCategoryNames;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newSubCategory;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	private WebElement selectCategoryElement;
	@FindBy(xpath = "//input[@id='subcategory']")
	private WebElement enterSubCategoryElement;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement uploadImage;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successMessage;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchElement;
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement searchSubCategory;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement searchButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	private WebElement searchDisplayElement;
	@FindBy(xpath = "(//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td//a//i[@class='fas fa-edit'])[1]")
	private WebElement editElement;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement updateButton;
	@FindBy(xpath = "(//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td//a//i[@class='fas fa-trash-alt'])[1]")
	private WebElement deleteButton;


	public SubCategoryPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		pageUtility=new PageUtility(driver);
	}
	
	public String subCategoryPageHeader() {
		return subcategoryheader.getText();
		
	}

	
	public void clickOnNew() {
		
		newSubCategory.click();
		
	}

	public SubCategoryPage enterSubcategory(String subcategory) {
		enterSubCategoryElement.sendKeys(subcategory);
		return this;
	}
	
	public SubCategoryPage enterCategory(String category) {
		pageUtility.selectByVisibleText(selectCategoryElement, category);
		return this;
	}
	
	public void imageUpload() {
		
		pageUtility.imageUpload(uploadImage, "oven.jpg");	
		
	}
	public SubCategoryPage clickOnSave() {
		waitUtility= new WaitUtility(driver);
	    waitUtility.waitforElementtobeClickable(saveButton);
		pageUtility.scrollAndClick(saveButton);
		return this;
	}
	
	
	public void createSubCategory(String category, String subCategory) {
		clickOnNew();
		pageUtility.selectByVisibleText(selectCategoryElement, category);
		enterSubcategory(subCategory);
		imageUpload();
		clickOnSave();	
	}
	
	public String getAlertMessage() {
		
		return successMessage.getText();
	}
	
	public SubCategoryPage clickOnSearch() {
		searchElement.click();
		return this;
	}
	public SubCategoryPage searchBySubCategory(String subCategory) {
		searchSubCategory.sendKeys(subCategory);
		return this;
		
	}
	public SubCategoryPage clickOnSearchIcon() {
		waitUtility= new WaitUtility(driver);
	    waitUtility.waitforElementtobeClickable(searchButton);
		pageUtility.scrollAndClick(searchButton);
		return this;
	}
	public boolean searchDisplay() {
		return searchDisplayElement.isDisplayed();
	}
	public SubCategoryPage clickOnEdit() {
		editElement.click();
		return this;
	}
	public SubCategoryPage editSubcategory(String subCategory) {
		enterSubCategoryElement.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		enterSubCategoryElement.sendKeys(Keys.BACK_SPACE);
		enterSubCategoryElement.sendKeys(subCategory);
		return this;
	}
	public SubCategoryPage clickOnUpdate() {
		waitUtility= new WaitUtility(driver);
		waitUtility.waitforElementtobeClickable(updateButton);
		pageUtility.scrollAndClick(updateButton);
		return this;
		
	}
	public SubCategoryPage clickOnDelete() {
		deleteButton.click();
		return this;
	}
	
	public SubCategoryPage deleteCategory() {
		
	pageUtility.acceptAlert();
	return this;
	}
	
	public SubCategoryPage cancelDeleteCategory() {	
		pageUtility.dismissAlert();
		return this;
		}


}
