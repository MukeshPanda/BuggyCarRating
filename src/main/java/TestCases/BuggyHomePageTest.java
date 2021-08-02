package TestCases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageClasses.BuggyHomePage;
import PageClasses.PopularMakePage;
import PageClasses.UserLogin;
import PageClasses.UserRegistration;
import baseClasses.BaseTestClass;
import baseClasses.PageBaseClass;
import utilities.TestDataProvider;

public class BuggyHomePageTest extends BaseTestClass{
	
	BuggyHomePage buggyHomePage;
	UserRegistration userRegistration;
	UserLogin userLogin;
	PopularMakePage popularMakePage;
	
	@Test(dataProvider="verifyLoginTestData")
	public void buggyHomePageTest(Hashtable<String, String> testData) {
		
		logger = report.createTest("Launching Buggy Cars Rating");
		
		invokeBrowser("Chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		buggyHomePage = pageBase.OpenApplication();
		buggyHomePage.getTitle(testData.get("pageTitle"));
		buggyHomePage.verifyHomePageInfo();
	}
	
	@Test
	public void userRegistration() {
		
		logger = report.createTest("Register a user to Buggy Cars Rating");
		
		invokeBrowser("Chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		buggyHomePage = pageBase.OpenApplication();
		userRegistration = buggyHomePage.clickRegistrationLink();
		userRegistration.registerUser();
		
	}
	@Test(dataProvider="verifyLoginTestData")
	public void loginUser(Hashtable<String, String> testData) {
		
		logger = report.createTest("Logging in registered user to Buggy Cars Rating");
		invokeBrowser("Chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		buggyHomePage = pageBase.OpenApplication();
		userLogin = buggyHomePage.userLogin();
		userLogin.loginUser(testData.get("UserName"), testData.get("Password"));	
		userLogin.verifyProfileData();		
		
	}
	
	@Test
	public void verifyPopularMake() {
		
		logger = report.createTest("Verify Popular Make Data");
		invokeBrowser("Chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		buggyHomePage = pageBase.OpenApplication();
		popularMakePage = buggyHomePage.popularMakePage();
		popularMakePage.verifyPopularMake();
		
	}
	
	
	@DataProvider
	public Object[][] verifyLoginTestData(){
		return TestDataProvider.getTestData("BCR.xlsx", "BuggyCarRating", "verifyLogin");
	}

}
