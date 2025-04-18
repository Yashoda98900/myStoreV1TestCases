package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.myInventory;

public class TC_ProductFiltering extends baseClass {
	
	@Test
	public void verifyRegistrationAndLogin() {
		driver.get(url);
		logger.info("Url open");
		
	}
	
	@Test
	public void FilterProduct() throws IOException 
	{

		logger.info("***************TestCase to Verify Product Filtering *****************"); 
		myAccount myAcpg = new myAccount(driver);

		myAcpg.enterUserName("standard_user");
		logger.info("Entered UserName");

		myAcpg.enterPassword("secret_sauce");
		logger.info("Entered password");

		myAcpg.clickLogin();
		logger.info("Clicked on Login Button");	
		
	    Assert.assertTrue(isSortedLowToHigh(), "Products are not sorted by price (low to high)");

		myInventory inv = new myInventory(driver);
		String successMsg = inv.getproductName();
		
		if(successMsg.equals("Sauce Labs Onesie"))
		{
			logger.info("Products are not sorted by price (low to high)");
		}
		else
		{
			logger.info("Not Sorted");
			captureScreenShot(driver,"Not Sorted Failed");
			Assert.assertTrue(false);

		}		

	}


}
