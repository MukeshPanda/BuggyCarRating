package baseClasses;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PageClasses.BuggyHomePage;
//import PageClasses.LandingPage;
import utilities.DateUtil;

public class PageBaseClass extends BaseTestClass {

	public ExtentTest logger;

	public PageBaseClass(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}

	/****************** OpenApplication ***********************/
	public BuggyHomePage OpenApplication() {
		logger.log(Status.INFO, "Opening the WebSite");
		driver.get("https://buggy.justtestit.org/");
		logger.log(Status.PASS, "Successfully Opened the https://buggy.justtestit.org/");
		BuggyHomePage buggyHomePage = new BuggyHomePage(driver, logger);
		PageFactory.initElements(driver, buggyHomePage);
		return buggyHomePage;
	}
	
	/****************** Get Page Title ***********************/
	public void getTitle(String expectedTitle) {
		try {
			Assert.assertEquals(driver.getTitle(), expectedTitle);
			reportPass("Actual Title : " + driver.getTitle() + " - equals to Expected Title : " + expectedTitle);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}
	
	
	/****************** Verify Element is Present ***********************/
	public void verifyElementIsDisplayed(WebElement webElement){
		try {
			if(webElement.isDisplayed()){
				reportPass("Webelement " + webElement + "is Displayed");
			}else {
				reportFail("Webelement " + webElement + "has not appeared");
			}
			
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		
	}
	
	
	/****************** Verify Element Text ***********************/
	public void verifyElementTextIsCorrect(WebElement webElement, String webElementText){
		try {
			String text = webElement.getText();
			if(text.equals(webElementText)){
				reportPass("Webelement text " + " for " + webElement.getText() + " text matches " + webElementText);
			}else {
				reportFail("Webelement text " + " for " + webElement.getText() + " text does not match " + webElementText);
			}
			
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		
	}
	

	/****************** Reporting Functions ***********************/
	public void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		takeScreenShotOnFailure();
		Assert.fail(reportString);
	}

	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}

	/****************** Capture Screen Shot ***********************/
	public void takeScreenShotOnFailure() {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);

		File destFile = new File(System.getProperty("user.dir") + "/ScreenShots/" + DateUtil.getTimeStamp() + ".png");
		try {
			FileUtils.copyFile(sourceFile, destFile);
			logger.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "/ScreenShots/" + DateUtil.getTimeStamp() + ".png");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
