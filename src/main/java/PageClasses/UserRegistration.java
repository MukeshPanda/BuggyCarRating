package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;

public class UserRegistration extends PageBaseClass{

	public UserRegistration(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	@FindBy(css="div.col-md-6 > h2")
	public WebElement registrationPageText;
	
	@FindBy(id="username")
	public WebElement loginTextBox;
	
	@FindBy(id="firstName")
	public WebElement firstNameTextBox;
	
	@FindBy(id="lastName")
	public WebElement lastNameTextBox;
	
	@FindBy(id="password")
	public WebElement passwordTextBox;
	
	@FindBy(id="confirmPassword")
	public WebElement confirmPasswordTextBox;
	
	@FindBy(css="button[type='submit']")
	public WebElement registerButton;
	
	@FindBy(css="a.btn")
	public WebElement cancelRegistrationButton;
	
	@FindBy(css="div.result.alert.alert-success")
	public WebElement registrationSuccess;
	
	public void registerUser() {
		
		verifyElementIsDisplayed(registrationPageText);
		verifyElementTextIsCorrect(registrationPageText, "Register with Buggy Cars Rating");
		loginTextBox.sendKeys("qwerty");
		firstNameTextBox.sendKeys("qwerty");
		lastNameTextBox.sendKeys("qwerty");
		passwordTextBox.sendKeys("Qwerty@123456");
		confirmPasswordTextBox.sendKeys("Qwerty@123456");
		logger.log(Status.PASS, "Entered the Login Name, FirstName, Last Name, Password, Confirm Password : ");
		System.out.println("111");
		registerButton.click();
		registerButton.click();
		System.out.println("112");
//		waitForPageLoad();
		verifyElementTextIsCorrect(registrationSuccess, "Registration is successful");
	
		
	}
	
	

	
}
