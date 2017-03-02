package com.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailLoginPo {
	WebDriver driver = null;
	public GmailLoginPo(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//To identify "email" field in the sign in page
	@FindBy(id="Email")
	private WebElement emailField;
	   public WebElement getEleEmailField()
	   {
		   return emailField;
	   }
	// To identify "Next" button in the sign in page
	@FindBy(id="next")
	private WebElement nextButton;
	   public WebElement getEleNextButton()
	   {
		   return nextButton;
	   }
		
	//To identify "password" field in the sign in page
	@FindBy(id="Passwd")
	private WebElement passwordField;
	   public WebElement getElePasswordField()
	   {
		   return passwordField;
	   }
	// To identify "Sign In" button in the sign in page
	@FindBy(id="signIn")
	private WebElement signInButton;
	   public WebElement getEleSignInButton()
	   {
		   return signInButton;
	   }	   
}
