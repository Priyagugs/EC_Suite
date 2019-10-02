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

public class ImportantStatements extends LoadableComponent<ImportantStatements> {

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";

	//Important Statements screen objects
	@FindBy(css = "#C12__BUT_IS_006AB5B0B0C7206C622756,#C13__BUT_IS_006AB5B0B0C7206C622756")
	WebElement btnNext;
	
	@FindAll({
		@FindBy(xpath = "//div[@id = 'radio_C12__QUE_DA77AAE2AA61CFD0865']//p[contains(text(), 'I agree')]"),
		@FindBy(xpath = "//div[@id = 'radio_C12__QUE_DA77AAE2AA61CFD0865']//p[contains(text(), 'I disagree')]"),
		@FindBy(xpath = "//div[@id = 'radio_C13__QUE_DA77AAE2AA61CFD0865']//p[contains(text(), 'I agree')]"),
		@FindBy(xpath = "//div[@id = 'radio_C13__QUE_DA77AAE2AA61CFD0865']//p[contains(text(), 'I disagree')]")
		})
	List<WebElement> BtnTermsandConditions;

	

	public ImportantStatements(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;
		
	}	
	
	public ImportantStatements(WebDriver driver, ExtentTest report) {
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
	
	public void TermsAndConditions(String termsandConditions, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnTermsandConditions, 2);
			ElementLayer.clickExpectedValue(BtnTermsandConditions, termsandConditions, extentedReport, driver);
			Log.message("Selected BtnTermsandConditions : " + termsandConditions, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnTermsandConditions : " + e);
		}
	}
	
	public PreviousLoss clickNext(ExtentTest extentedReport) throws Exception {
		try {
			final long startTime = StopWatch.startTime();
			WaitUtils.waitForElement(driver, btnNext);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", btnNext);
			// btnSignIn.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Message - Clicked next button", driver, extentedReport);
			Log.event("Log - Clicked next button", StopWatch.elapsedTime(startTime));
			return new PreviousLoss(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking next button: " + e);
		}
	}
}