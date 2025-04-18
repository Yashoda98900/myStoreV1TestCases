package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class myInventory {
		WebDriver ldriver;
		
		@FindBy(xpath = "//a[@title='Products']") 
		WebElement homePageTitle;	
		
		
		@FindBy(className = "bm-burger-button")
		WebElement clickAllItems;
		
		@FindBy(linkText = "Logout")
		WebElement logOut;
		
		
		 @FindBy(className = "product_sort_container")
	     WebElement sortDropdown;
		 
		 @FindBy(id = "add-to-cart-sauce-labs-onesie")
		 WebElement addOnesieToCart;
	    

		 @FindBy(xpath = "//div[@class='inventory_item_name' and text()='Sauce Labs Onesie']/ancestor::div[@class='inventory_item']//button") 
		WebElement addToCartButton;	
		 
		 @FindBy(xpath = "//a[@title='Sauce Labs Onesie']") 
		WebElement sortedProductName;
		 
		 @FindBy(id = "shopping_cart_container")
		 WebElement shoppingCart;
		 
		 @FindBy(className = "btn_action checkout_button")
		 WebElement checkoutOn;
		 
		 @FindBy(id = "first-name")
		 WebElement enterFirstname;
			
		@FindBy(id = "last-name")
		WebElement enterlastname;
		
		@FindBy(id = "postal-code")
		WebElement enterPostalCode;	
		
		@FindBy(className = "btn_primary cart_button")
		WebElement clickOnContinue;	
		
		@FindBy(className = "btn_action cart_button")
		WebElement clickOnFinish;		
		
		@FindBy(xpath = "//a[@title='THANK YOU FOR YOUR ORDER']") 
		WebElement orderComplete;
		
		 
		//constructor
		public myInventory(WebDriver rdriver)
		{
			ldriver = rdriver;


			PageFactory.initElements(rdriver, this);
		}
		
		public String getHome()
		{
			String text = homePageTitle.getText();

			return text;
		}
		
				
		public void ClickOnAllItemsButton()
		{
			clickAllItems.click();

		}
		
		public void clickOnLogOut()
		{
			logOut.click();
		}
		
	    public void sortByLowToHigh() {
	        Select select = new Select(sortDropdown);
	        select.selectByValue("lohi");
	    }
	    
	    public void addOnesieToCart() {
			addToCartButton.click();
		}
		
		public void addOnesieToCartByName() {
			addToCartButton.click();
		}
		
		public void clickOnSoppingCart() {
			shoppingCart.click();
		}
		
		public void clickOncheckout() {
			checkoutOn.click();
		}
		
		
		public void enterTheFirstname(String firstnameAdd) {
			enterFirstname.sendKeys(firstnameAdd);
		}
		
		public void enterTheLastname(String enterlastnameAdd) {
			enterlastname.sendKeys(enterlastnameAdd);
		}
		
		public void enterCode(String pcodeAdd) {
			enterPostalCode.sendKeys(pcodeAdd);
		}
		
		public void clickContinue() {
			clickOnContinue.click();
		}
		
		public void clickFinish() {
			clickOnFinish.click();
		}
		
		public String getSuccessMsg()
		{
			String text = orderComplete.getText();

			return text;
		}
		
		public String getproductName()
		{
			String text = sortedProductName.getText();
			return text;
		}
		
	
		
		
		
}
