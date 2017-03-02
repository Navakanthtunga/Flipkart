package com.library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ParallelBaseLib {
public static WebDriver driver=null;
	
	// To do cross browser testing declare the parameter

	@Parameters("browser")
	
	@BeforeMethod
	public void setUp(String browser){

		// To read browser Name from ".properties" file
		
		if(browser.equalsIgnoreCase("Firefox")){
			//System.setProperty("webdriver.gecko.driver",GenericLib.sDirPath+"\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("FireFox browser is set");
			}
		else if(browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver",GenericLib.sDirPath+"\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Chrome browser is set");
		}
		else{
			System.setProperty("webdriver.ie.driver", GenericLib.sDirPath+"\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
			
		}
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

	public void loadURL(String url)
	{
		// To read URL from configData File
		//driver.get(GenericLib.getCongigValue(GenericLib.sConfigFile, "URL"));
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		
	}

}
