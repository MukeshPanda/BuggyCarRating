package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import baseClasses.PageBaseClass;

public class BuggyHomePage extends PageBaseClass{

	public BuggyHomePage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	@FindBy(css="h2.card-header.text-xs-center")
	public WebElement popularMake;
	

	@FindBy(css="//H3[@_ngcontent-gcx-4=''])[1]")
	public WebElement popularMakeDesc;	
	
	public void verifyHomePageInfo() {
		Assert.assertEquals(true, popularMake.isDisplayed());
		popularMake.getText();
		System.out.println("The popular make is: " + popularMake.getText());
	}
	

}
