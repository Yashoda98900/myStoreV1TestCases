package com.mystore.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.myInventory;

import junit.framework.Assert;

public class TC_MyAccountPage extends baseClass {
	
	@Test
	public void verifyRegistrationAndLogin() {
		driver.get(url);
		logger.info("Url open");
		
	}
	
	@Test
	public void VerifyLogin() throws IOException 
	{

		logger.info("***************TestCase Verify Login starts*****************"); 
		myAccount myAcpg = new myAccount(driver);

		myAcpg.enterUserName("standard_user");
		logger.info("Entered UserName");

		myAcpg.enterPassword("secret_sauce");
		logger.info("Entered password");

		myAcpg.clickLogin();
		logger.info("Clicked on LoginButton");	
		
		

		myInventory inv = new myInventory(driver);
		String inHome = inv.getHome();	
		

		if(inHome.equals("Products"))
		{			
			logger.info("VerifyLogin - Passed");
			inv.clickOnLogOut();
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("VerifyLogin - Failed");
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);

		}

		logger.info("***************TestCase Verify Login ends*****************"); 


	}


}
