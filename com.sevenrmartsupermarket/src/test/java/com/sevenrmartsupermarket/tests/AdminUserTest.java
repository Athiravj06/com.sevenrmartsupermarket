package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUserPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class AdminUserTest extends Base {
	
	LoginPage loginPage;
	HomePage homePage;
	AdminUserPage adminUserPage;
	
	@Test
	public void verifyUserDetails() {
		loginPage=new LoginPage(driver);
		homePage=new HomePage(driver);
		adminUserPage=new AdminUserPage(driver);
		loginPage.login();
		homePage.clickOnAdminUser();
		adminUserPage.userDetails();
		
	}

}
