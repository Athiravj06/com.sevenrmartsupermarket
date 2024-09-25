package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class AdminUserPage {
	
	WebDriver driver;
	GeneralUtility utility=new GeneralUtility();
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td")
	List<WebElement> userDetails;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void userDetails() {
		List<String>details=new ArrayList<String>();
		details=utility.get_textofelements(userDetails);
		System.out.println(details);
		
	}
	
	

}
