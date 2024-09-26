package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.constants.DataProviders;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class LoginTest extends Base {
	LoginPage loginPage;
	HomePage homePage;
	ExcelReader excelReader = new ExcelReader();

	@Test(groups = "Smoke")
	public void verifyLogin() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		loginPage.login("admin", "admin");

		loginPage.login();
		
		loginPage.login("anoojk30", " admin");
		excelReader.setExcelFile("loginData", "Login_Credentials");
		loginPage.login(excelReader.getCellData(4, 0), excelReader.getCellData(4, 1));
		String value = excelReader.getCellData(1, 1);
		System.out.println(value);
		String actualProfileName = homePage.getProfileName();
		System.out.println(actualProfileName);
		String expectedProfileName = "Admin";
		Assert.assertEquals(actualProfileName, expectedProfileName);

		String name = GeneralUtility.getRandomFirstName();
		System.out.println(name);

	}
	@Test(dataProvider = "loginDetails",dataProviderClass = DataProviders.class)
	public void verifyLoginDataProvider(String userName, String password) {
		
		loginPage=new LoginPage(driver);
		loginPage.login(userName, password);
		
	}

}
