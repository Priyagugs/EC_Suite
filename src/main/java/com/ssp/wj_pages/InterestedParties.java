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

public class InterestedParties extends LoadableComponent<InterestedParties> {

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";

	//Interested Parties screen objects

	
	@FindBy(css = "#C1__BUT_55E5AE0A984C2873500530")
	WebElement btnNext;
	
	@FindAll({
	@FindBy(xpath = "//*[@id='C1__row_QUE_48BDF1EEA3569326406504']//span[contains(text(),'Yes')]"),
	@FindBy(xpath = "//*[@id='C1__row_QUE_48BDF1EEA3569326406504']//span[contains(text(),'No')]")
	})
	List<WebElement> BtnLikeToAddInterestedParties;
	
	public InterestedParties(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;
		
	}	
	
	public InterestedParties(WebDriver driver, ExtentTest report) {
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
	public void LikeToAddInterestedParties(String btnLikeToAddInterestedParties, ExtentTest extentedReport) throws Exception {
		
		try{
			WaitUtils.waitForListElement(driver, BtnLikeToAddInterestedParties, 1);
			ElementLayer.clickExpectedValue(BtnLikeToAddInterestedParties, btnLikeToAddInterestedParties, extentedReport, driver);
			Log.message("Selected Interested Party : " + btnLikeToAddInterestedParties, driver, extentedReport);
			WaitUtils.waitForSpinner(driver);
		}catch (Exception e) {
			throw new Exception("Error while selecting option for LikeToAddInterestedParties detail : " + e);
		}
	}
	
	

	public Contacts Click_Next(ExtentTest extentedReport) throws Exception {
		try {
			//final long startTime = StopWatch.startTime();
			WaitUtils.waitForElement(driver, btnNext);
			//JavascriptExecutor executor = (JavascriptExecutor) driver;
			//executor.executeScript("arguments[0].click();", btnNext);
			btnNext.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Next button", driver, extentedReport);
			//Log.event("Clicked Next button", StopWatch.elapsedTime(startTime));
			return new Contacts(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking Next button: " + e);
		}
	}
	
}