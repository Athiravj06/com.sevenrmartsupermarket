package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUserPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;

public class AdminUserTest extends Base {
	
	LoginPage loginPage;
	HomePage homePage;
	AdminUserPage adminUserPage;
	ExcelReader excelReader=new ExcelReader(); 
	
	@Test
	public void verifyUserDetails() {
		loginPage=new LoginPage(driver);
		homePage=new HomePage(driver);
		adminUserPage=new AdminUserPage(driver);
		loginPage.login();
		homePage.clickOnAdminUser();
		adminUserPage.userDetails();
		String actualOutput=adminUserPage.getTextHeading();
		String expectedOutput="Admin Users";
		Assert.assertEquals(actualOutput, expectedOutput);
		
	}
	
	@Test
	public void verifyNewUser() {
		loginPage=new LoginPage(driver);
		homePage=loginPage.login();
		excelReader.setExcelFile("loginData", "Admin_User_New");
		adminUserPage=homePage.clickOnAdminUser().clickOnNew().enterUsername(excelReader.getCellData(0, 0)).enterPassword(excelReader.getCellData(0, 1))
				.selectUserType(excelReader.getCellData(0, 2)).clickOnSave();
		String message=adminUserPage.getAlertMessage();
		String actualMessage=message.substring(9);
		String expectedMessage="User Created Successfully";
	    Assert.assertEquals(actualMessage, expectedMessage);
		
	}
	
	

}
