package com.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.library.TestngListners;

public class OpenReports {
	@Test
	public void openReports(){
		WebDriver driver =new FirefoxDriver();
		driver.get(TestngListners.reportDestination);
	}

}
