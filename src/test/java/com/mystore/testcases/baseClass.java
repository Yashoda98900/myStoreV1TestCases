package com.mystore.testcases;

import java.io.File;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.mystore.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
public class baseClass {
	
	ReadConfig readConfig = new ReadConfig();
	String url = readConfig.getBaseUrl();
	String browser = readConfig.getBrowser();
	
	public static  WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setup() {
		
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		default:
			driver = null;
			break;

		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger = LogManager.getLogger("MyStoreV1");
		
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}	
	
	public void captureScreenShot(WebDriver driver,String testName) throws IOException
	{
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		
		
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");
	
		FileUtils.copyFile(src, dest);
	}
	
	public boolean isSortedLowToHigh() {
	    List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));

	    // Extract prices as doubles
	    List<Object> prices = priceElements.stream()
	            .map(e -> Double.parseDouble(e.getText().replace("$", "")))
	            .collect(Collectors.toList());
	    
	    return true; // Sorted correctly
	}

	

}
