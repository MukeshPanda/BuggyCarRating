package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PageClasses.BuggyHomePage;
import baseClasses.BaseTestClass;
import baseClasses.PageBaseClass;

public class BuggyHomePageTest extends BaseTestClass{
	
	BuggyHomePage buggyHomePage;
	
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

}
