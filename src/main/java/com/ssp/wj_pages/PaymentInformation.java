package com.ssp.wj_pages;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
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

public class PaymentInformation extends LoadableComponent<PaymentInformation> {

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";

	//PaymentInformation screen objects

	@FindAll({
		@FindBy(xpath = "//*[@id='C1__row_QUE_B7C86A0090A9962F1273045']//span[contains(text(),'Yes')]"),
		@FindBy(xpath =  "//*[@id='C1__row_QUE_B7C86A0090A9962F1273045']//span[contains(text(),'No')]"),
		})
		List<WebElement> btnCardBelongTo;
	
	@FindAll({
		@FindBy(xpath = "//*[@id='C1__row_QUE_B7C86A0090A9962F1273048']//span[contains(text(),'Yes')]"),
		@FindBy(xpath =  "//*[@id='C1__row_QUE_B7C86A0090A9962F1273048']//span[contains(text(),'No')]"),
		})
		List<WebElement> btnPermission;
	
	@FindBy(css = "#C1__QUE_B7C86A0090A9962F1273051")
	WebElement txtCardHolderName;
	
	@FindAll({
		@FindBy(xpath = "//*[@id='C1__row_QUE_B7C86A0090A9962F1273057']//span[contains(text(),'Yes')]"),
		@FindBy(xpath =  "//*[@id='C1__row_QUE_B7C86A0090A9962F1273057']//span[contains(text(),'No')]"),
		})
		List<WebElement> btnBilling;
	
	@FindBy(css = "#C1__BUT_E6ED2431D424349D546430")
	WebElement btnBack;
	
	@FindBy(css = "#C1__BUT_E6ED2431D424349D547825")
	WebElement btnNext;
	
	
	public PaymentInformation(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;
		
	}	
	
	public PaymentInformation(WebDriver driver, ExtentTest report) {
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
	
	public void selectCardBelongTo(String CardBelongTo, ExtentTest extentedReport) throws Exception {
		
		try{
			WaitUtils.waitForListElement(driver, btnCardBelongTo, 5);
			ElementLayer.clickExpectedValue(btnCardBelongTo, CardBelongTo, extentedReport, driver);
			Log.message("Entered CardBelongTo : " + CardBelongTo, driver, extentedReport);
		
		}catch (Exception e) {
			throw new Exception("Error while entering CardBelongTo : " + e);
		}
	}
	
	public void selectPermission(String Permission, ExtentTest extentedReport) throws Exception {
		
		try{
			WaitUtils.waitForListElement(driver, btnPermission, 10);
			ElementLayer.clickExpectedValue(btnPermission, Permission, extentedReport, driver);
			Log.message("Entered Permission : " + Permission, driver, extentedReport);
		
		}catch (Exception e) {
			throw new Exception("Error while entering Permission : " + e);
		}
	}
	
	public void selectBilling(String Billing, ExtentTest extentedReport) throws Exception {
		
		try{
			WaitUtils.waitForListElement(driver, btnBilling, 10);
			ElementLayer.clickExpectedValue(btnBilling, Billing, extentedReport, driver);
			Log.message("Entered Permission : " + Billing, driver, extentedReport);
		
		}catch (Exception e) {
			throw new Exception("Error while entering Billing : " + e);
		}
	}
	
	public void enterCardHolderName(String CardHolderName, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtCardHolderName);
			txtCardHolderName.clear();
			txtCardHolderName.sendKeys(CardHolderName);
			Log.message("Entered CardHolderName : " + CardHolderName, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering CardHolderName : " + e);
		}
	}
	
	public GeneralInformation clickBack(ExtentTest extentedReport) throws Exception {
		try {
			final long startTime = StopWatch.startTime();
			WaitUtils.waitForElement(driver, btnBack);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", btnBack);
			// btnSignIn.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Back button", driver, extentedReport);
			Log.event("Clicked Back button", StopWatch.elapsedTime(startTime));
			return new GeneralInformation(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking Back button: " + e);
		}
	}
	public PaymentDetails Click_Next(ExtentTest extentedReport) throws Exception {
		try {
			final long startTime = StopWatch.startTime();
			WaitUtils.waitForElement(driver, btnNext);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", btnNext);
			// btnSignIn.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Next button", driver, extentedReport);
			Log.event("Clicked Next button", StopWatch.elapsedTime(startTime));
			return new PaymentDetails(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking Next button: " + e);
		}
	}
	
}