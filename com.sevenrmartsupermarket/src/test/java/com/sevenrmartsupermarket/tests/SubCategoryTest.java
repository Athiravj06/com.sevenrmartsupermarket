package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.model.ScreenCapture;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.listeners.RetryAnalyzer;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.SubCategoryPage;
import com.sevenrmartsupermarket.utilities.ScreenShotCapture;

public class SubCategoryTest extends Base {
	
	LoginPage loginPage;
	HomePage homePage;
	SubCategoryPage subCategoryPage;
	
	@Test
	public void verifySubCategoryHeader() {
		
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		subCategoryPage = new SubCategoryPage(driver);	
		
		loginPage.login();
		homePage.clickOnSubCategory();
		String actualHeader=subCategoryPage.subCategoryPageHeader();
		String expectedHeader="List Sub Categories";
		Assert.assertEquals(actualHeader, expectedHeader);
	}
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void verifyAllSubCategorynames() {
		
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		subCategoryPage = new SubCategoryPage(driver);	
		loginPage.login();
		homePage.clickOnSubCategory();
		subCategoryPage.getAllSubCategoryName();
		
	}
	
	@Test
	public void verifyNewSubCategory() {
		
		loginPage = new LoginPage(driver);	
		homePage= loginPage.login();
		subCategoryPage =homePage.clickOnSubCategory();	
		subCategoryPage.createSubCategory("Appliances", "Microwave Oven");
		String message=subCategoryPage.getAlertMessage();
		String actualMessage=message.substring(9);
		String expectedMessage="Sub Category Created Successfully";
	    Assert.assertEquals(actualMessage, expectedMessage);
			
	}
	
	

	

	
	

}
