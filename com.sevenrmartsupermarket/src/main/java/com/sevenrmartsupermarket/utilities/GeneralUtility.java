package com.sevenrmartsupermarket.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility {
	
	public String getAttribute(WebElement element,String Attribute) {
		return element.getAttribute(Attribute);
	}
	public String getCssValue(WebElement element, String CssValue) {
		return element.getCssValue(CssValue);
	}
	 //to return data from list of webelements

	 public List<String>get_textofelements(List<WebElement> elements){

		 List<String> data=new ArrayList<String>();

		 for(WebElement element : elements) {

			 data.add(element.getText());		 

		 }

		 return data;
		 

	 }
	 
	 public static String getRandomFirstName() {
		 Faker faker = new Faker();
		 return faker.name().firstName();
	 }

}
