package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;

public class BuggyHomePage extends PageBaseClass{
	
	

	public BuggyHomePage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	@FindBy(css="div:nth-child(1) > div > h2.card-header.text-xs-center")
	public WebElement popularMake;

	@FindBy(css="div:nth-child(2) > div > h2.card-header.text-xs-center")
	public WebElement popularModel;
	
	@FindBy(css="div:nth-child(3) > div > h2.card-header.text-xs-center")
	public WebElement overallRating;
	
	@FindBy(css="div:nth-child(1) > div > div.card-block")
	public WebElement popularModelDesc;	
	
	@FindBy(css="div:nth-child(1) > div > div.card-block")
	public WebElement popularMakeDesc;
	
	@FindBy(css="div:nth-child(1) > div > div.card-block")
	public WebElement overallRatingDesc;
	
	@FindBy(css="a.btn.btn-success-outline")
	public WebElement userRegistrationLink;
	
	@FindBy(css="a.navbar-brand")
	public WebElement buggyHomeLink;
	
	@FindBy(css="img.img-fluid.center-block")
	public WebElement popularMake_LamorghiniImg;


	
	public void verifyHomePageInfo() {
		try {
			verifyElementIsDisplayed(popularMake);
			verifyElementIsDisplayed(popularModel);
			verifyElementIsDisplayed(overallRating);
			verifyElementTextIsCorrect(popularMake, "Popular Make");
			verifyElementTextIsCorrect(popularModel, "Popular Model");
			verifyElementTextIsCorrect(overallRating, "Overall Rating");
			reportPass("All assertions Pass for Popular Make, Popular Model, Overall Rating");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}
	
	
	public UserRegistration clickRegistrationLink() {
		
		logger.log(Status.INFO, "Clicking the Register Link, Present in Header");
		userRegistrationLink.click();
		logger.log(Status.PASS, "Clicked the Register Link");
		UserRegistration userRegistration = new UserRegistration(driver, logger);
		PageFactory.initElements(driver, userRegistration);
		return userRegistration;
		
	}
	
	public UserLogin userLogin() {
		
		logger.log(Status.INFO, "Logging in registered user");
		buggyHomeLink.click();
		logger.log(Status.PASS, "Clicked the Buggy Home Link to navigate to home screen");
		UserLogin userLogin = new UserLogin(driver, logger);
		PageFactory.initElements(driver, userLogin);
		return userLogin;
		
	}
	
	public PopularMakePage popularMakePage() {
		logger.log(Status.INFO, "Verifying Popular make page");
		popularMake_LamorghiniImg.click();
		logger.log(Status.PASS, "Clicked Lamborghini Image to navigate to Popular Make screen");
		PopularMakePage popularMakePage = new PopularMakePage(driver, logger);
		PageFactory.initElements(driver, popularMakePage);
		return popularMakePage;
	}
	
	

}
