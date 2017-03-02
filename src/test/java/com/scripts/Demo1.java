package com.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Demo1 {
	public static void main(String[] args) {

	FirefoxProfile fp = new FirefoxProfile();
	fp.setPreference("general.useragent.override", "Mozilla/5.0 (Android; Mobile; rv:13.0) Gecko/13.0 Firefox/13.0");
	WebDriver driver = new FirefoxDriver(fp);
	driver.get("https://www.google.com");
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getTitle());
}
}
