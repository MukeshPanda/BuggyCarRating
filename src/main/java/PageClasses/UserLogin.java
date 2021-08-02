package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

import baseClasses.PageBaseClass;

public class UserLogin extends PageBaseClass{

	public UserLogin(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	@FindBy(css="input[name=login]")
	public WebElement loginTextBox;
	
	@FindBy(css="input[name=password]")
	public WebElement passwordTextBox;
	
	@FindBy(css="button.btn.btn-success")
	public WebElement loginButton;
	
	@FindBy(xpath="//a[text()='Profile']")
	public WebElement profileLink;

	@FindBy(xpath="//a[text()='Logout']")
	public WebElement logoutLink;
	
	@FindBy(css="#username")
	public WebElement userName;

	@FindBy(css="#firstName")
	public WebElement firstName;
	
	@FindBy(css="#lastName")
	public WebElement lastName;
	
	@FindBy(css="select.form-control.ng-valid.ng-touched.ng-dirty")
	public WebElement hobby;
		
	
	public void loginUser(String userName, String password) {
		
		loginTextBox.sendKeys(userName);
		passwordTextBox.sendKeys(password);
		loginButton.click();
		profileLink.click();	
		
	}
	
	public void verifyProfileData() {
		try {
			verifyElementIsDisplayed(userName);
			verifyElementIsDisplayed(firstName);
			verifyElementIsDisplayed(lastName);
			reportPass("Successfully logged in, currently in Buggy Car Rating Profile page.");

		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		
	}

}
