package com.scripts;

import org.testng.annotations.Test;

import com.library.BaseLib;
import com.library.GenericLib;
import com.po.GmailLoginPo;

public class GmailLoginTest extends BaseLib{
	GmailLoginPo loginPo;
@Test(priority=1,description="Login with valid credentials")
public void Login(){
	loginPo=new GmailLoginPo(driver);
	loadURL("https://accounts.google.com/ServiceLogin?");
	loginPo.getEleEmailField().sendKeys(GenericLib.getCongigValue(GenericLib.sConfigFile, "email"));
	loginPo.getEleNextButton().click();
	loginPo.getElePasswordField().sendKeys(GenericLib.getCongigValue(GenericLib.sConfigFile, "password"));
	loginPo.getEleSignInButton().click();
}
}
