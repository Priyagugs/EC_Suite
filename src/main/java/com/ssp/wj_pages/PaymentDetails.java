package com.ssp.wj_pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

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
import com.ssp.utils.GenericUtils;
import com.ssp.utils.WaitUtils;

public class PaymentDetails extends LoadableComponent<PaymentDetails> {

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";

	//PaymentDetails screen objects
	
	
	@FindBy(css = "#cardNumber")
	WebElement txtCardNo;
	
	@FindBy(css = "#expiryMonth")
	WebElement txtExpiryMonth;
	
	@FindBy(css = "#expiryYear")
	WebElement txtExpiryYear;
	
	@FindBy(css = "#securityCode")
	WebElement txtSecurityCode;
	
	@FindBy(css = "#submitButton")
	WebElement btnMakePayment;
	
	@FindBy(css = "#wp-cl-custom-html-iframe")
	WebElement iframe;
	
	
	
	public PaymentDetails(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;
		
	}	
	
	public PaymentDetails(WebDriver driver, ExtentTest report) {
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
	public void enterCardNo(String CardNo, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, iframe);
			driver.switchTo().frame(iframe);
			//WaitUtils.waitForElement(driver, txtCardNo);
			Thread.sleep(2000);
			Actions actions = new Actions(driver);
			actions.moveToElement(txtCardNo).sendKeys(CardNo).perform();
			//txtCardNo.clear();
			//txtCardNo.sendKeys(CardNo);
			Log.message("Entered CardNo : " + CardNo, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering CardNo : " + e);
		}
	}
	
	public void enterExpiryMonth(String ExpiryMonth, ExtentTest extentedReport) throws Exception {
		try {

			WaitUtils.waitForElement(driver, txtExpiryMonth);
			txtExpiryMonth.clear();
			txtExpiryMonth.sendKeys(ExpiryMonth);
		//	new Select(txtExpiryMonth).selectByVisibleText(ExpiryMonth);
			Log.message("Entered ExpiryMonth : " + ExpiryMonth, driver, extentedReport);

			//WaitUtils.waitForElement(driver, txtExpiryMonth);
			txtExpiryMonth.clear();
			txtExpiryMonth.sendKeys(ExpiryMonth);
			Log.message("Entered txtExpiryMonth : " + ExpiryMonth, driver, extentedReport);

		} catch (Exception e) {
			throw new Exception("Error while entering txtExpiryMonth; : " + e);
		}
	}
	
	public void enterExpiryYear(String ExpiryYear, ExtentTest extentedReport) throws Exception {
		try {

			WaitUtils.waitForElement(driver, txtExpiryYear);
			txtExpiryYear.clear();
			txtExpiryYear.sendKeys(ExpiryYear);
		//	new Select(txtExpiryYear).selectByVisibleText(ExpiryYear);
			Log.message("Entered ExpiryYear : " + ExpiryYear, driver, extentedReport);
			

			//WaitUtils.waitForElement(driver, txtExpiryYear);
			txtExpiryYear.clear();
			txtExpiryYear.sendKeys(ExpiryYear);
			Log.message("Entered txtExpiryYear : " + ExpiryYear, driver, extentedReport);

		} catch (Exception e) {
			throw new Exception("Error while entering txtExpiryYear; : " + e);
		}
	}
	
	public void enterSecurityCode(String SecurityCode, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtSecurityCode);
			txtSecurityCode.clear();
			txtSecurityCode.sendKeys(SecurityCode);
			Log.message("Entered SecurityCode : " + SecurityCode, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering SecurityCode; : " + e);
		}
	}
	public ConfirmationOfPayment Click_MakePayment(ExtentTest extentedReport) throws Exception {
		try {
			//final long startTime = StopWatch.startTime();
			WaitUtils.waitForElement(driver, btnMakePayment);
			//JavascriptExecutor executor = (JavascriptExecutor) driver;
			//executor.executeScript("arguments[0].click();", btnMakePayment);
			btnMakePayment.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked MakePayment button", driver, extentedReport);
			driver.switchTo().defaultContent();
			//Log.event("Clicked MakePayment button", StopWatch.elapsedTime(startTime));
			return new ConfirmationOfPayment(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking MakePayment button: " + e);
		}
	}
	
}