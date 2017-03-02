package com.library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseLib {
	public static WebDriver driver=null;

	
	@BeforeMethod
	public void setUp(){
		driver = new FirefoxDriver();
			
		// To read browser from ".properties" file
		
		/*if(GenericLib.getCongigValue(GenericLib.sConfigFile, "browserName").equalsIgnoreCase("Firefox")){
			//System.setProperty("webdriver.gecko.driver",GenericLib.sDirPath+"\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			}
		else if(GenericLib.getCongigValue(GenericLib.sConfigFile, "browserName").equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver",GenericLib.sDirPath+"\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else{
			System.setProperty("webdriver.ie.driver", GenericLib.sDirPath+"\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
			*/
		}

	@AfterMethod
	public void tearDown(){
	driver.close();
	}

	public void loadURL(String url)
	{
		// To read URL from ".properties" File
		//driver.get(GenericLib.getCongigValue(GenericLib.sConfigFile, "URL"));
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
}
