package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PageClasses.BuggyHomePage;
import PageClasses.PopularMakePage;
import PageClasses.UserLogin;
import PageClasses.UserRegistration;
import baseClasses.BaseTestClass;
import baseClasses.PageBaseClass;

public class BuggyHomePageTest extends BaseTestClass{
	
	BuggyHomePage buggyHomePage;
	UserRegistration userRegistration;
	UserLogin userLogin;
	PopularMakePage popularMakePage;
	
	public void buggyHomePageTest() {
		
		logger = report.createTest("Launching Buggy Cars Rating");
		
		invokeBrowser("Chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		buggyHomePage = pageBase.OpenApplication();
		buggyHomePage.getTitle("Buggy Cars Rating");
		buggyHomePage.verifyHomePageInfo();
	}
	

	public void userRegistration() {
		
		logger = report.createTest("Register a user to Buggy Cars Rating");
		
		invokeBrowser("Chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		buggyHomePage = pageBase.OpenApplication();
		userRegistration = buggyHomePage.clickRegistrationLink();
		userRegistration.registerUser();
		
	}
	
	public void loginUser() {
		
		logger = report.createTest("Logging in registered user to Buggy Cars Rating");
		invokeBrowser("Chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		buggyHomePage = pageBase.OpenApplication();
		userLogin = buggyHomePage.userLogin();
		userLogin.loginUser();	
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

}
