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

public class EmployersLiability extends LoadableComponent<EmployersLiability> {

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";

	//Previous Loss screen objects
	@FindBy(css = "#C1__BUT_55E5AE0A984C2873500515")
	WebElement BtnNext;

	@FindAll({
		@FindBy(xpath = "//div[@id ='radio_C1__QUE_48BDF1EEA3569326351437']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id ='radio_C1__QUE_48BDF1EEA3569326351437']//span[contains(text(), 'No')]")
		})
	List<WebElement> BtnSameRegisteredOfficeAddress;
	
	@FindAll({
		@FindBy(xpath = "//div[@id ='radio_C1__QUE_48BDF1EEA3569326393280']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id ='radio_C1__QUE_48BDF1EEA3569326393280']//span[contains(text(), 'No')]")
		})
	List<WebElement> BtnExemptFromHoldingCERN;

	public EmployersLiability(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;
		
	}	
	
	public EmployersLiability(WebDriver driver, ExtentTest report) {
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
	
	public void RegisteredOfficeAddress(String btnSameRegisteredOfficeAddress, ExtentTest extentedReport) throws Exception {
			try{	
				WaitUtils.waitForListElement(driver, BtnSameRegisteredOfficeAddress, 10);
				ElementLayer.clickExpectedValue(BtnSameRegisteredOfficeAddress, btnSameRegisteredOfficeAddress, extentedReport, driver);
				Log.message("Selected BtnSameRegisteredOfficeAddress : " + btnSameRegisteredOfficeAddress, driver, extentedReport);
				WaitUtils.waitForSpinner(driver);
			}catch (Exception e) {
				throw new Exception("Error while selecting BtnSameRegisteredOfficeAddress : " + e);
			}	
	}
	
	public void ExemptFromHoldingCERN(String btnExemptFromHoldingCERN, ExtentTest extentedReport) throws Exception {
		try{			
			WaitUtils.waitForListElement(driver, BtnExemptFromHoldingCERN, 3);
			ElementLayer.clickExpectedValue(BtnExemptFromHoldingCERN, btnExemptFromHoldingCERN, extentedReport, driver);
			Log.message("Selected BtnExemptFromHoldingCERN : " + btnExemptFromHoldingCERN, driver, extentedReport);
			WaitUtils.waitForSpinner(driver);
		}catch (Exception e) {
			throw new Exception("Error while selecting BtnExemptFromHoldingCERN : " + e);
		}
}
	
	public Partners clickNext(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnNext);
			Actions action = new Actions(driver);
	        action.moveToElement(BtnNext).click().perform();
			WaitUtils.waitForSpinner(driver);
			Log.message("Message - Clicked GetQuote button", driver, extentedReport);
			//Log.event("Log - Clicked GetQuote button", StopWatch.elapsedTime(startTime));
			return new Partners(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking GetQuote button: " + e);
		}
	}
}