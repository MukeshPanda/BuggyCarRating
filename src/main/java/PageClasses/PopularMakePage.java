package PageClasses;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

import baseClasses.PageBaseClass;

public class PopularMakePage extends PageBaseClass{

	public PopularMakePage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);

	}
	
	@FindBy(xpath="//H3[@class='card-header'][text()='Lamborghini']")
	public WebElement lamborghini_header;
	
	@FindBy(xpath="//H3[@class='card-header'][text()='Lamborghini']/..//P[1]")
	public WebElement lamborghini_text1;
	
	@FindBy(xpath="//H3[@class='card-header'][text()='Lamborghini']/..//P[2]")
	public WebElement lamborghini_text2;
	
	@FindBy(xpath="//H3[@class='card-header'][text()='Lamborghini']/..//P[3]")
	public WebElement lamborghini_text3;

	@FindBy(xpath="//table[@class='cars table table-hover']")
	public WebElement lamborghini_table;
	
	@FindBy(xpath="//table[@class='cars table table-hover']//thead//tr//th")
	public WebElement lamborghini_table_header;
	
	@FindBy(xpath="//table[@class='cars table table-hover']//th[3]")
	public WebElement lamborghini_table_header_rank;
	
	@FindBy(xpath="//table[@class='cars table table-hover']//th[4]")
	public WebElement lamborghini_table_header_votes;
	
	@FindBy(xpath="//table[@class='cars table table-hover']//th[5]")
	public WebElement lamborghini_table_header_comments;
	
	public void verifyPopularMake() {
		
		//verify Lamborghini Card header and body text
		
		verifyElementTextIsCorrect(lamborghini_header, "Lamborghini");
		verifyElementTextIsCorrect(lamborghini_text1, "Automobili Lamborghini S.p.A. is an Italian brand and manufacturer of luxury sports cars and SUVs based in Sant'Agata Bolognese, Italy. The company is owned by the Volkswagen Group through its subsidiary Audi. In 2015, Lamborghini's 1,175 employees produced 3,248 vehicles.");
		verifyElementTextIsCorrect(lamborghini_text2, "Ferruccio Lamborghini, an Italian manufacturing magnate, founded Automobili Ferruccio Lamborghini S.p.A. in 1963 to compete with established marques, including Ferrari. The company gained wide acclaim in 1966 for the Miura sports coupé, which established rear mid-engine, rear wheel drive as the standard layout for high-performance cars of the era. Lamborghini grew rapidly during its first decade, but sales plunged in the wake of the 1973 worldwide financial downturn and the oil crisis. The firm's ownership changed three times after 1973, including a bankruptcy in 1978. American Chrysler Corporation took control of Lamborghini in 1987 and sold it to Malaysian investment group Mycom Setdco and Indonesian group V'Power Corporation in 1994. In 1998, Mycom Setdco and V'Power sold Lamborghini to the Volkswagen Group where it was placed under the control of the group's Audi division.");
		verifyElementTextIsCorrect(lamborghini_text3, "Lamborghini produces sports cars and V12 engines for offshore powerboat racing. Lamborghini currently produces the V12-powered Aventador and the V10-powered Huracán.");
		
		
		List <WebElement> columns = driver.findElements(By.xpath("//table[@class='cars table table-hover']//thead//tr//th"));
		int colCount = columns.size();
		
		
	}

}
