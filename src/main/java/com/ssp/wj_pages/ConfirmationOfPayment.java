package com.ssp.wj_pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentTest;
import com.ssp.support.Log;
import com.ssp.support.StopWatch;
import com.ssp.utils.ElementLayer;
import com.ssp.utils.GenericUtils;
import com.ssp.utils.WaitUtils;

public class ConfirmationOfPayment extends LoadableComponent<ConfirmationOfPayment> {

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";

	//ConfirmationOfPayment screen objects
	
	@FindBy(xpath = "//*[@id='C1__QUE_4AB6451013067184536351']")
	WebElement txtPoliycNo;
	
	public ConfirmationOfPayment(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;
	}	
	
	public ConfirmationOfPayment(WebDriver driver, ExtentTest report) {
		this.driver = driver;
		this.extentedReport = report;
		PageFactory.initElements(driver, this);
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		isPageLoaded = true;
	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		if (!isPageLoaded) {
			Assert.fail();
		}
	}
	
/*	public void openURL(){
		driver.get(sspURL);
	}
	*/
public void printPolicyNumber(ExtentTest extentedReport) throws Exception {
		
		try{
			//WaitUtils.waitForElementPresent(driver, seconds, elementTocheck, msg);
			WebDriverWait some_element = new WebDriverWait(driver,100); 
			String TextIS=some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='C1__QUE_4AB6451013067184536351']"))).getText();
		//	JavascriptExecutor executor = (JavascriptExecutor) driver;
			//executor.executeScript("arguments[0].text",txtPoliycNo);
			Thread.sleep(5000);
		//	String TextIs=txtPoliycNo.getText();
			Log.message("Policy urn : " +TextIS , driver, extentedReport);
			
		//	Log.message("Policy urn : " + executor.executeScript("arguments[0].text",txtPoliycNo), driver, extentedReport);
		
		}catch (Exception e) {
			throw new Exception("Error while capturing Policy urn : " + e);
		}
	}

public void VerifyPolicyNumberDisplayed(ExtentTest extentedReport) throws Exception {
	
	try {
		
		WaitUtils.waitForElement(driver, txtPoliycNo);
		if(!txtPoliycNo.isDisplayed())
		{
			Log.message("Payment is still getting completed if credit card details are wrong", driver, extentedReport);
		
			
		
		}
		else{
			
			Log.message("Verified payment is not completing if credit card details are wrong", driver, extentedReport);
			throw new Exception("Failed");
		
			}
		 }
		
	catch (Exception e) {
		
		throw new Exception("Error while verifying Payment if credit card details are wrong  : " + e);
	}

}
	
}