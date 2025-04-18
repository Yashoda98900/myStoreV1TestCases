package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.myInventory;

public class TC_OrderProduct extends baseClass {
	
	@Test
	public void verifyRegistrationAndLogin() {
		driver.get(url);
		logger.info("Url open");
		
	}
	
	@Test
	public void OrderProduct() throws IOException 
	{

		logger.info("******TestCase to Verify Cart functionality and Checkout Process******"); 
		myAccount myAcpg = new myAccount(driver);

		myAcpg.enterUserName("standard_user");
		logger.info("Entered UserName");

		myAcpg.enterPassword("secret_sauce");
		logger.info("Entered password");

		myAcpg.clickLogin();
		logger.info("Clicked on Login Button");	
		
		

		myInventory inv = new myInventory(driver);
		

	    Assert.assertTrue(isSortedLowToHigh(), "Products are not sorted by price (low to high)");

	    inv.addOnesieToCart();
	    logger.info("Add Product in Cart..");	
	    
	    inv.clickOnSoppingCart();
	    logger.info("Clicked on Shopping cart");	
		
	    inv.clickOncheckout();
	    logger.info("Clicked on Check Out");
	    
	    inv.enterTheFirstname("ABC");
	    logger.info("First Name is Enter");	
	    
	    inv.enterTheLastname("XYZ");
	    logger.info("Last name is Enter");
	    
	    inv.enterCode("12 45 78");
	    logger.info("Postal Code is Enter");
	    
	    inv.clickContinue();
	    logger.info("Click On Continue..");
	    
	    inv.clickFinish();
	    logger.info("Click On Finish..");
	    
		String successMsg = inv.getSuccessMsg();

		if(successMsg.equals("THANK YOU FOR YOUR ORDER"))
		{
			logger.info("Order is Completed Successfully");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Order is Failed");
			captureScreenShot(driver,"Order Failed");
			Assert.assertTrue(false);

		}
	    logger.info("Order is Completed");
	}


}
