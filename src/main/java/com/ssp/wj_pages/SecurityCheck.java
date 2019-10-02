package com.ssp.wj_pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class SecurityCheck extends LoadableComponent<SecurityCheck> {

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";

	//Security Key screen objects
	@FindBy(css = "#BUT_046FC879087B6FA0110427")
	WebElement btnProceed;

	@FindBy(css = "#QUE_046FC879087B6FA0110419")
	WebElement txtSecurityKey;

	public SecurityCheck(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;
		
	}	
	
	public SecurityCheck(WebDriver driver, ExtentTest report) {
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
	
	public void openURL(){
		driver.get(sspURL);
	}
	public BusinessDetails clickProceed(ExtentTest extentedReport) throws Exception {
		try {
			final long startTime = StopWatch.startTime();
			WaitUtils.waitForElement(driver, btnProceed);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", btnProceed);
			// btnSignIn.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Message - Clicked proceed button", driver, extentedReport);
			Log.event("Log - Clicked proceed button", StopWatch.elapsedTime(startTime));
			return new BusinessDetails(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while security key button: " + e);
		}
	}


	public void enterSecurityKey(String securityKey, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtSecurityKey);
			txtSecurityKey.clear();
			txtSecurityKey.sendKeys(securityKey);
			Log.message("Entered Security Key : " + securityKey, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering Security Key : " + e);

		}
	}
}