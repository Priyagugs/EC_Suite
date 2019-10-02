package com.ssp.wj_pages;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class MonthlyPaymentDetails extends LoadableComponent<MonthlyPaymentDetails> {

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";

	//PaymentDetails screen objects
	@FindAll({
		@FindBy(xpath = "//div[@id = 'radio_C1__QUE_B7C86A0090A9962F1273009']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C1__QUE_B7C86A0090A9962F1273009']//span[contains(text(), 'No')]")
		})
	List<WebElement> BtnSameAccountName;
	
	@FindBy(css = "#C1__QUE_B7C86A0090A9962F1273015")
	WebElement TxtSortCode;
	
	@FindBy(css = "#C1__QUE_B7C86A0090A9962F1273018")
	WebElement TxtAccountNumber;
	
	@FindBy(css = "#C1__QUE_B7C86A0090A9962F1273021")
	WebElement TxtInstallmentDayOfMonth;
	
	@FindBy(css = "#C1__BUT_0DC24C42BC95DBE3725311")
	WebElement BtnNext;
	
	public MonthlyPaymentDetails(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;
		
	}	
	
	public MonthlyPaymentDetails(WebDriver driver, ExtentTest report) {
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
	
	public void SameAccountName(String btnSameAccountName, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnSameAccountName, 5);
			ElementLayer.clickExpectedValue(BtnSameAccountName, btnSameAccountName, extentedReport, driver);
			Log.message("Selected BtnSameAccountName : " + btnSameAccountName, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
			
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnSameAccountName : " + e);
		}
	}
	
	public void SortCode(String txtSortCode, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, TxtSortCode);
			TxtSortCode.clear();
			TxtSortCode.sendKeys(txtSortCode);
			Log.message("Entered TxtSortCode : " + txtSortCode, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering TxtSortCode : " + e);
		}
	}
	
	public void AccountNumber(String txtAccountNumber, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, TxtAccountNumber);
			TxtAccountNumber.clear();
			TxtAccountNumber.sendKeys(txtAccountNumber);
			Log.message("Entered TxtAccountNumber : " + txtAccountNumber, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering TxtAccountNumber; : " + e);
		}
	}
	
	public void InstallmentDayOfMonth(String txtInstallmentDayOfMonth, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, TxtInstallmentDayOfMonth);
			TxtInstallmentDayOfMonth.clear();
			TxtInstallmentDayOfMonth.sendKeys(txtInstallmentDayOfMonth);
			Log.message("Entered TxtInstallmentDayOfMonth : " + txtInstallmentDayOfMonth, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering TxtInstallmentDayOfMonth; : " + e);
		}
	}
	public PaymentInformation Click_Next(ExtentTest extentedReport) throws Exception {
		try {
			//final long startTime = StopWatch.startTime();
			WaitUtils.waitForElement(driver, BtnNext);
			//JavascriptExecutor executor = (JavascriptExecutor) driver;
			//executor.executeScript("arguments[0].click();", btnMakePayment);
			BtnNext.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked MakePayment button", driver, extentedReport);
			driver.switchTo().defaultContent();
			//Log.event("Clicked MakePayment button", StopWatch.elapsedTime(startTime));
			return new PaymentInformation(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking MakePayment button: " + e);
		}
	}
	
}