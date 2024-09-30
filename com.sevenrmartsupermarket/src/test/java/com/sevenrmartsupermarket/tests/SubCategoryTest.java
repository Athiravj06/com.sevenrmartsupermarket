package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.model.ScreenCapture;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.listeners.RetryAnalyzer;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.SubCategoryPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
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
	
	@Test
	public void verifyNewSubCategory() {
		
		loginPage = new LoginPage(driver);	
		homePage= loginPage.login();
		subCategoryPage =homePage.clickOnSubCategory();	
		String subCategoryRandom=GeneralUtility.getRandomCategory();
		subCategoryPage.createSubCategory("Appliances", subCategoryRandom);
		String message=subCategoryPage.getAlertMessage();
		String actualMessage=message.substring(9);
		String expectedMessage="Sub Category Created Successfully";
	    Assert.assertEquals(actualMessage, expectedMessage);
			
	}
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void verifySearchCategory() {
		loginPage=new LoginPage(driver);
		homePage=loginPage.login();
		subCategoryPage=homePage.clickOnSubCategory().clickOnSearch()
				.enterCategory("Appliances").searchBySubCategory("Microwave Oven")
				.clickOnSearchIcon();
		Assert.assertTrue(subCategoryPage.searchDisplay());
				
				
	}
	
	@Test
	public void verifyEditCategory() {
		loginPage=new LoginPage(driver);
		homePage=loginPage.login();
		String subCategoryRandom=GeneralUtility.getRandomCategory();
		subCategoryPage=homePage.clickOnSubCategory().clickOnEdit().enterCategory("Grocery")
				.editSubcategory(subCategoryRandom).clickOnEdit();
		String message=subCategoryPage.getAlertMessage();
		String actualMessage=message.substring(9);
		String expectedMessage="Sub Category Updated Successfully";
	    Assert.assertEquals(actualMessage, expectedMessage);
		
				
				
	}
	
	

	

	

	
	

}
