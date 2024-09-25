package com.sevenrmartsupermarket.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.sevenrmartsupermarket.constants.Constants;

public class ScreenShotCapture {
	//TakesScreenshot ist he interface to to take screenshot
	
	TakesScreenshot takeScreenshot;
	
	public void takeScreenShot(WebDriver driver, String imageName) {   
		
		try {
			takeScreenshot=(TakesScreenshot)driver;
			//captures screenshot
			File screenShot = takeScreenshot.getScreenshotAs(OutputType.FILE);
			//to get system date and time
			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
			String path=Constants.SCREENSHOT_FILE_PATH_STRING+imageName+"_"+timeStamp+".png";
			//to store the screenshot
			File destination = new File(path);
			FileHandler.copy(screenShot, destination); //to move the screenshot to folder
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
    }
	

}
