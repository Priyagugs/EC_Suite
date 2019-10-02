package com.ssp.wj_pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class PublicLiability extends LoadableComponent<PublicLiability> {

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";

	//Your Public Liability Cover screen objects
	@FindBy(css = "#C4__BUT_5847B0D83AF0F962260745")
	WebElement btnNext;

	@FindBy(css = "#C4__QUE_5847B0D83AF0F962260731")
	WebElement PublicLiabilityCoverAmount;
	
	@FindBy(css = "#C4__QUE_5847B0D83AF0F962260734")
	WebElement SellProductOutsideUK;

	public PublicLiability(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;
		
	}	
	
	public PublicLiability(WebDriver driver, ExtentTest report) {
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
	
	/*public void openURL(){
		driver.get(sspURL);
	}*/
	
	public void PublicLiabilityCoverAmount(String publicLiabilityCoverAmount, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, PublicLiabilityCoverAmount);
			new Select(PublicLiabilityCoverAmount).selectByVisibleText(publicLiabilityCoverAmount);
			Log.message("Selected PublicLiabilityCoverAmount : " + publicLiabilityCoverAmount, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting PublicLiabilityCoverAmount detail : " + e);
		}
	}
			
	public void SellProductOutsideUK(String sellProductOutsideUK, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, SellProductOutsideUK);
			new Select(SellProductOutsideUK).selectByVisibleText(sellProductOutsideUK);
			Log.message("Selected sellProductOutsideUK : " + sellProductOutsideUK, driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while selecting SellProductOutsideUK detail : " + e);
		}
	}
	
	public ImportantStatements clickNext(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnNext);
			btnNext.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Message - Clicked next button", driver, extentedReport);
			return new ImportantStatements(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking next button: " + e);
		}
	}

	
	public BusinessPremises clickNext2(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnNext);
			btnNext.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Message - Clicked next button", driver, extentedReport);
			return new BusinessPremises(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking next button: " + e);
		}
	}
public TreatmentsProvidedByYourBusiness clickNext_TreatmentsPage(ExtentTest extentedReport) throws Exception {
		try {
			final long startTime = StopWatch.startTime();
			WaitUtils.waitForElement(driver, btnNext);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", btnNext);
			// btnSignIn.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Message - Clicked next button", driver, extentedReport);
			Log.event("Log - Clicked next button", StopWatch.elapsedTime(startTime));
			return new TreatmentsProvidedByYourBusiness(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking next button: " + e);
		}
	}

}