package com.sevenrmartsupermarket.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.ScreenShotCapture;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
	Properties properties = new Properties();
	ScreenShotCapture screenShotCapture= new ScreenShotCapture();

	// constructor without parameter
	public Base() {
		// to print exception
		try {
			// to load the config.properties file
			FileInputStream inputStream = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(inputStream);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** to initialize the browser **/
	public void initialize(String browser, String url) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new ChromeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));

	}

	/**For cross browser execution**/
	@Parameters("browser")
	@BeforeMethod(enabled = false)
	public void launchBrowser(String browser) {
	String url = properties.getProperty("url");
	initialize(browser, url);
	}
	
	/**Individual Test case Execution**/
	@BeforeMethod(enabled= true,alwaysRun = true)
	public void launchBrowser() {
	String browser = properties.getProperty("browser");
	String url = properties.getProperty("url");
	initialize(browser, url);
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void FailurescreenShot(ITestResult itestresult) {
		
		if(itestresult.getStatus()==ITestResult.FAILURE) {
			screenShotCapture.takeScreenShot(driver, itestresult.getName());
		}
		
	}
	
	
}
