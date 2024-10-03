package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class HomeTest extends Base {
	
	
	LoginPage loginPage;
	HomePage homePage;
	
	@Test
	public void verifyProfilePicture() {
		
		loginPage=new LoginPage(driver);
		homePage=new HomePage(driver);
		loginPage.login();
		String actualOutput= homePage.getImageAdmin();
		String expectedOutput="https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/user2-160x160.jpg";
		Assert.assertEquals(actualOutput, expectedOutput);
		
	}
	
	@Test
	public void verifyColorManageGift() {
		
		loginPage=new LoginPage(driver);
		homePage=new HomePage(driver);
		loginPage.login();
		String actualColor=homePage.getColorManageGift();
		System.out.println(actualColor);
		String expectedColor="rgba(0, 0, 0, 0.1)";
		Assert.assertEquals(actualColor, expectedColor);
		
	}
	

}
