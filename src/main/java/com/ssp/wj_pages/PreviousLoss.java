package com.ssp.wj_pages;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class PreviousLoss extends LoadableComponent<PreviousLoss> {

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";

	//Previous Loss screen objects
	@FindBy(css = "#C13__BUT_006AB5B0B0C7206C622756,#C14__BUT_006AB5B0B0C7206C622756")
	WebElement BtnGetQuote;

	@FindAll({
		@FindBy(xpath = "//div[@id = 'radio_C13__sufferedLosses']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C13__sufferedLosses']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'radio_C14__sufferedLosses']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C14__sufferedLosses']//span[contains(text(), 'No')]")
		})
	List<WebElement> BtnAnyPreviousClaims;

	public PreviousLoss(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;
		
	}	
	
	public PreviousLoss(WebDriver driver, ExtentTest report) {
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
	
	public void AnyPreviousClaims(String btnAnyPreviousClaims, ExtentTest extentedReport) throws Exception {
		
			try{
				
				WaitUtils.waitForListElement(driver, BtnAnyPreviousClaims, 20);
				ElementLayer.clickExpectedValue(BtnAnyPreviousClaims, btnAnyPreviousClaims, extentedReport, driver);
				Log.message("Selected AnyPreviousClaim : " + btnAnyPreviousClaims, driver, extentedReport);
				WaitUtils.waitForSpinner(driver);
			}catch (Exception e) {
				throw new Exception("Error while selecting AnyPreviousClaims button : " + e);
			}
			
	}
	
	public YourQuote clickGetQuote(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnGetQuote);
			Actions action = new Actions(driver);
	        action.moveToElement(BtnGetQuote).click().perform();
			WaitUtils.waitForSpinner(driver);
			Log.message("Message - Clicked GetQuote button", driver, extentedReport);
			//Log.event("Log - Clicked GetQuote button", StopWatch.elapsedTime(startTime));
			return new YourQuote(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking GetQuote button: " + e);
		}
	}
	
	public DeclinedPage clickGetQuote2(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnGetQuote);
			Actions action = new Actions(driver);
	        action.moveToElement(BtnGetQuote).click().perform();
			WaitUtils.waitForSpinner(driver);
			Log.message("Message - Clicked GetQuote button", driver, extentedReport);
			//Log.event("Log - Clicked GetQuote button", StopWatch.elapsedTime(startTime));
			return new DeclinedPage(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking GetQuote button: " + e);
		}
	}
}