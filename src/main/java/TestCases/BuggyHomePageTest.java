package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PageClasses.BuggyHomePage;
import PageClasses.UserRegistration;
import baseClasses.BaseTestClass;
import baseClasses.PageBaseClass;

public class BuggyHomePageTest extends BaseTestClass{
	
	BuggyHomePage buggyHomePage;
	UserRegistration userRegistration;
	
	@Test
	public void buggyHomePageTest() {
		
		logger = report.createTest("Launching Buggy Cars Rating");
		
		invokeBrowser("Chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		buggyHomePage = pageBase.OpenApplication();
		buggyHomePage.getTitle("Buggy Cars Rating");
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

}
